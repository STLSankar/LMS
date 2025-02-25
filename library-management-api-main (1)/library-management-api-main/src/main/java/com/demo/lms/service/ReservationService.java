package com.demo.lms.service;

import com.demo.lms.dto.ReservationDTO;
import com.demo.lms.exception.CustomBadRequestException;
import com.demo.lms.model.Book;
import com.demo.lms.model.Borrower;
import com.demo.lms.model.Reservation;
import com.demo.lms.respository.BookRepository;
import com.demo.lms.respository.BorrowerRepository;
import com.demo.lms.respository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author sankar patra
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;

    public Long reserveBook(ReservationDTO reservationDTO) {
        Borrower borrower = borrowerRepository.findById(reservationDTO.getBorrowerId())
                .orElseThrow(() -> new CustomBadRequestException("Invalid borrower id."));
        Book book = bookRepository.findById(reservationDTO.getBookId())
                .orElseThrow(() -> new CustomBadRequestException("Invalid book id."));

        int availableCopies = book.getAvailableCopies();
        if (availableCopies <= 0) {
            throw new CustomBadRequestException("No available copies to reserve.");
        }
        book.setAvailableCopies(availableCopies - 1);
        return reservationRepository.save(new Reservation(borrower, book, new Date(), null, false)).getId();
    }

    public Long returnBook(Long reservationId) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        if (reservationOptional.isEmpty()) {
            throw new CustomBadRequestException("Reservation not found or invalid id.");
        } else {
            Reservation reservation = reservationOptional.get();
            if (Boolean.TRUE.equals(reservation.isReturned())) {
                throw new CustomBadRequestException("Borrower already returned the book.");
            }
        }
        Reservation reservation = reservationOptional.get();
        reservation.setReturned(true);
        reservation.setReturnedDate(new Date());

        Book book = reservation.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        reservation = reservationRepository.save(reservation);
        return reservation.getId();
    }
}
