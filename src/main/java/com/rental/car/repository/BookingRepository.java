package com.rental.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rental.car.model.Booking;

@Repository("bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {

}
