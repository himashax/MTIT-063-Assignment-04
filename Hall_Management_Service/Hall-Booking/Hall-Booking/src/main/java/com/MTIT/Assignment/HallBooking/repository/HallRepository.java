package com.MTIT.Assignment.HallBooking.repository;

import com.MTIT.Assignment.HallBooking.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface HallRepository extends JpaRepository<Hall, Long> {
   // Optional<Hall> findByHallLocation(String location);
    //All crud db methods

}
