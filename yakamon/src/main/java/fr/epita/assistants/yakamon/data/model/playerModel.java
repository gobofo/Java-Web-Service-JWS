package fr.epita.assistants.yakamon.data.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "player")
public class playerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;

    @Column(length = 20)
    String name;

    @Column(name = "pos_x")
    Integer posX;

    @Column(name = "pos_y")
    Integer posY;

    @Column(name = "last_move")
    LocalDateTime lastMove;

    @Column(name = "last_catch")
    LocalDateTime lastCatch;

    @Column(name = "last_collect")
    LocalDateTime lastCollect;

    @Column(name = "last_feed")
    LocalDateTime lastFeed;
}
