package org.exmaple.mapper;

import org.exmaple.dto.ReservationDtoRq;
import org.exmaple.entities.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public Reservation castReservationDto(ReservationDtoRq reservationDtoRq) {
        Reservation reservation = new Reservation(reservationDtoRq.getNumberReservation()
                , reservationDtoRq.getRoom()
                , reservationDtoRq.getBeginDate()
                , reservationDtoRq.getEndDate()
                , reservationDtoRq.getNameBuyer());
        return reservation;
    }
}
