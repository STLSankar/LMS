package com.demo.lms.controller;

import com.demo.lms.dto.ReservationDTO;
import com.demo.lms.handler.ResponseHandler;
import com.demo.lms.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author sankar patra
 */
@RestController
@RequestMapping("/v1/reservations")
public class ReservationController extends ResponseHandler {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reserve")
    public ResponseEntity<?> reserveBook(@RequestBody ReservationDTO reservationDTO) {
        return successResponseDataSaving(reservationService.reserveBook(reservationDTO));
    }

    @PostMapping("return")
    public ResponseEntity<?> reserveBook(@RequestParam Long reservationId) {
        return successResponseDataSaving(reservationService.returnBook(reservationId));
    }
}
