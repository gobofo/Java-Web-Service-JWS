package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.data.model.PlayerModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.PlayerRepository;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PlayerService {

    @Inject
    GameRepository gameRepository;

    @Inject
    PlayerRepository playerRepository;

    public PlayerModel getPlayer() {
        if (gameRepository.findAll().count() == 0)
            ErrorCode.BAD_REQUEST.throwException("Game is not running");

        return playerRepository.findAll().firstResult();
    }
}
