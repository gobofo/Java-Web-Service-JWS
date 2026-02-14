package fr.epita.assistants.yakamon.data.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Value;

@Data
@Entity
@Table(name = "game")
public class GameModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(columnDefinition = "text", nullable = false)
    public String map;
}
