package fr.epita.assistants.yakamon.data.model;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class gameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(columnDefinition = "text")
    String map;
}
