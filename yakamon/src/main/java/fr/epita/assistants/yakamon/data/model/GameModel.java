package fr.epita.assistants.yakamon.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import lombok.With;

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
