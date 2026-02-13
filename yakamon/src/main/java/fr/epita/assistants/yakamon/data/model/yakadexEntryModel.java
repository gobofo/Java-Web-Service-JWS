package fr.epita.assistants.yakamon.data.model;

import fr.epita.assistants.yakamon.utils.ElementType;
import jakarta.persistence.*;

@Entity
@Table(name = "yakadex_entry")
public class yakadexEntryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(length = 20)
    String name;

    @Column
    Boolean caught;

    @Enumerated(EnumType.STRING)
    @Column(name = "first_type")
    ElementType firstType;

    @Enumerated(EnumType.STRING)
    @Column(name = "second_type")
    ElementType secondType;

    @Column()
    String description;

    @OneToOne
    @JoinColumn(name = "evolution_id", referencedColumnName = "id")
    yakadexEntryModel evolution;

    @Column(name = "evolve_threshold")
    Integer evolveThreshold;
}
