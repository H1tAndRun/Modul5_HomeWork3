package org.exmaple.controller;

import org.exmaple.dto.ReservationDtoRq;
import org.exmaple.entities.Reservation;
import org.exmaple.entities.Room;
import org.exmaple.exeption.NoReservationException;
import org.exmaple.exeption.NoSuchNumberHasReservationException;
import org.exmaple.exeption.NoSuchPersonHasReservationException;
import org.exmaple.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/fill_table_room")
    public void FillTableRooms(@RequestBody List<Room> room) {
        hotelService.FillTableRooms(room);
    }

    @GetMapping("/get_all_room")
    public List<Room> getAllRecordRooms() {
        return hotelService.getAllRoom();
    }

    @PostMapping("/reservation")
    public Integer reservationRoom(@RequestBody ReservationDtoRq reservationDtoRq) {
        Integer result = hotelService.reservationRoom(reservationDtoRq);
        if (result == 0) {
            throw new NoReservationException("Нельзя забронировать номер на выбранную дату");
        }
        return result;
    }

    @GetMapping("/find_reservation/{name}")
    public List<Reservation> findAllReservationByBuyerName(@PathVariable String name) {
        List<Reservation> listReservation = hotelService.getAllReservationByName(name);
        if (listReservation.size() == 0) {
            throw new NoSuchPersonHasReservationException("Этот человек не бронировал номер");
        }
        return listReservation;
    }

    @GetMapping("/reservation/{number}")
    public Reservation getReservationByNumber(@PathVariable Integer number) {
        Reservation reservation = hotelService.getReservationByNumber(number);
        if (reservation == null) {
            throw new NoSuchNumberHasReservationException("Нет брони с таким номером");
        }
        return reservation;
    }

    @DeleteMapping("/delete_reservation/{number}")
    public Boolean removeReservationByNumber(@PathVariable Integer number) {
        return hotelService.removeReservationByNumber(number);
    }
}
