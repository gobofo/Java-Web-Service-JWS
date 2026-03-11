package fr.epita.assistants.yakamon.domain.entity;

import fr.epita.assistants.yakamon.utils.tile.TileType;
import lombok.Value;

import java.util.List;

@Value
public class GameEntity {

    List<List<TileType>> map;

    Integer id;

}
