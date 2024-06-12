package com.demo.lms.service;

import com.demo.lms.dto.BorrowerDTO;
import com.demo.lms.exception.CustomInternalServerException;
import com.demo.lms.model.Borrower;
import com.demo.lms.respository.BorrowerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author sankar patra
 */
@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    public BorrowerDTO registerBorrower(BorrowerDTO borrowerDTO) {
        try {
            Borrower savedBorrower = borrowerRepository.save(new Borrower(borrowerDTO.getName(), borrowerDTO.getEmail()));
            return new BorrowerDTO(savedBorrower.getId(), savedBorrower.getName(), savedBorrower.getEmail());
        } catch (DataAccessException e) {
            throw new CustomInternalServerException("Failed to register borrower", e);
        }
    }
}
