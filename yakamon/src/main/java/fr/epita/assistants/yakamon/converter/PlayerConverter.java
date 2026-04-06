package fr.epita.assistants.yakamon.converter;

import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.presentation.api.response.PlayerResponse;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerConverter {

    public PlayerResponse playerConverter(PlayerModel playerModel) {
        return new PlayerResponse(
                playerModel.uuid,
                playerModel.name,
                playerModel.posX,
                playerModel.posY,
                playerModel.lastMove,
                playerModel.lastCollect,
                playerModel.lastCatch,
                playerModel.lastFeed
        );
    }
}
