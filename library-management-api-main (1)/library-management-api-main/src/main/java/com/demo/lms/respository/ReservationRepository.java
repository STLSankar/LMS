package com.demo.lms.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.lms.model.Reservation;

/**
 * @author sankar patra
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
