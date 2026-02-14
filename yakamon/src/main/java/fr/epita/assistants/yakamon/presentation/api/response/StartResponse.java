package fr.epita.assistants.yakamon.presentation.api.response;

import fr.epita.assistants.yakamon.utils.tile.TileType;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
public class StartResponse {

     List<List<TileType>> tiles;

}
