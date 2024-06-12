package com.demo.lms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.lms.model.Borrower;

/**
 * @author sankar patra
 */
@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
