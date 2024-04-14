package com.siimkoppel.meetingrooms.repository;

import com.siimkoppel.meetingrooms.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
