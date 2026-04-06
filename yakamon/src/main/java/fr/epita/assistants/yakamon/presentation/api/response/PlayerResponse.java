package fr.epita.assistants.yakamon.presentation.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Value
public class PlayerResponse {

    UUID uuid;
    String name;
    Integer posX;
    Integer posY;
    LocalDateTime lastMove;
    LocalDateTime lastCollect;
    LocalDateTime lastCatch;
    LocalDateTime lastFeed;

}
