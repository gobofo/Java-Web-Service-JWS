package fr.epita.assistants.yakamon.data.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "yakamon")
public class yakamonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID uuid;

    @Column(length = 20)
    String nickname;

    @Column(name="energy_points")
    Integer energyPoints;

    @OneToOne
    @JoinColumn(name = "yakadex_entry_id", referencedColumnName = "id")
    yakadexEntryModel yakadexEntry;
}
