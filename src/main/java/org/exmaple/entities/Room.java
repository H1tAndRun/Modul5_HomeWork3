package org.exmaple.entities;

import lombok.*;
import org.exmaple.utils.RoomClass;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Room {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NonNull
    private String nameRoom;

    @Column(nullable = false)
    @NonNull
    private RoomClass roomClass;

    @OneToMany(mappedBy = "room")
    private List<Reservation> reservationList;

    public void addReservation(Reservation reservation){
        if (reservationList==null){
            reservationList= new ArrayList<>();
        }else {
            reservationList.add(reservation);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public RoomClass getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(RoomClass roomClass) {
        this.roomClass = roomClass;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", nameRoom='" + nameRoom + '\'' +
                ", roomClass=" + roomClass +
                '}';
    }
}
