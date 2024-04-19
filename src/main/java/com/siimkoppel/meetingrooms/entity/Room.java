package com.siimkoppel.meetingrooms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "room_number")
    private int roomNumber;
    @Column(name = "booked")
    private boolean booked;
    @Column(name = "booked_from")
    private LocalDateTime bookedFrom;
    @Column(name = "booked_to")
    private LocalDateTime bookedTo;
}