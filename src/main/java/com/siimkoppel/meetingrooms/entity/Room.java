package com.siimkoppel.meetingrooms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Please enter booking start time")
    @Column(name = "booked_from")
    private LocalDateTime bookedFrom;
    @NotNull(message = "Please enter booking end time")
    @Column(name = "booked_to")
    private LocalDateTime bookedTo;
}