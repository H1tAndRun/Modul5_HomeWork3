package org.exmaple.service;

import org.exmaple.dto.ReservationDtoRq;
import org.exmaple.entities.Reservation;
import org.exmaple.entities.Room;
import org.exmaple.repository.ReservationDao;
import org.exmaple.mapper.ReservationMapper;
import org.exmaple.repository.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final ReservationDao reservationDao;
    private final RoomDao roomDao;
    private final ReservationMapper reservationMapper;
    private Integer numberReservation = 0;

    @Autowired
    public HotelService(ReservationDao reservationDao, RoomDao roomDao, ReservationMapper reservationMapper) {
        this.reservationDao = reservationDao;
        this.roomDao = roomDao;
        this.reservationMapper = reservationMapper;
    }

    public void FillTableRooms(List<Room> rooms) {
        roomDao.saveAll(rooms);
    }

    public List<Room> getAllRoom() {
        return roomDao.findAll();
    }

    public Integer reservationRoom(ReservationDtoRq reservationDtoRq) {
        Room room = roomDao.getRoomByNameRoom(reservationDtoRq.getNameRoom());
        reservationDtoRq.setRoom(room);
        reservationDtoRq.setNumberReservation(++numberReservation);
        Reservation reservation = reservationMapper.castReservationDto(reservationDtoRq);
        if (checkReservationNumber(reservationDtoRq)) {
            return 0;
        }
        reservationDao.save(reservation);
        return numberReservation;
    }

    public List<Reservation> getAllReservationByName(String buyerName) {
        List<Reservation> reservations = reservationDao.findReservationsByNameBuyer(buyerName);
        return reservations;
    }

    public Reservation getReservationByNumber(Integer number) {
        return reservationDao.getReservationByReservationNumber(number);
    }

    public Boolean removeReservationByNumber(Integer number) {
        Reservation reservation = reservationDao.getReservationByReservationNumber(number);
        if (reservation == null) {
            return false;
        }
        reservationDao.delete(reservation);
        return true;
    }

    private Boolean checkReservationNumber(ReservationDtoRq reservationDtoRq) {
        List<Reservation> reservations = reservationDao
                .findReservationsByBeginDateAndEndDate(reservationDtoRq.getBeginDate()
                        , reservationDtoRq.getEndDate());
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().getNameRoom().equals(reservationDtoRq.getNameRoom())) {
                return true;
            }
        }
        return false;
    }
}

