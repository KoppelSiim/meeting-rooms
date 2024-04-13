package com.siimkoppel.meetingrooms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    private Long id;
}
