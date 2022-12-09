package org.exmaple.dto;

import lombok.Builder;
import lombok.Data;
import org.exmaple.entities.Room;
import org.exmaple.utils.RoomClass;
import java.util.Date;

@Data
@Builder
public class ReservationDtoRq {

    private String nameRoom;

    private Integer numberReservation;

    private RoomClass roomClass;

    private String nameBuyer;

    private Date beginDate;

    private Date endDate;

    private Room room;

}
