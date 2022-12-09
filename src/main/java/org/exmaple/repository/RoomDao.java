package org.exmaple.repository;

import org.exmaple.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room,Integer> {

    Room getRoomByNameRoom(String name);
}
