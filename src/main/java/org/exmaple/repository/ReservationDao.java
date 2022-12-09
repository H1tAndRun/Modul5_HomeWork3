package org.exmaple.repository;

import org.exmaple.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation, Integer> {

    List<Reservation> findReservationsByNameBuyer(String name);

    Reservation getReservationByReservationNumber(Integer reservationNumber);

    List<Reservation> findReservationsByBeginDateAndEndDate(Date start, Date end);
}
