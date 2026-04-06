package fr.epita.assistants.yakamon.domain.service;

import fr.epita.assistants.yakamon.data.model.YakamonModel;
import fr.epita.assistants.yakamon.data.repository.GameRepository;
import fr.epita.assistants.yakamon.data.repository.YakamonRepository;
import fr.epita.assistants.yakamon.utils.ErrorCode;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@Transactional
@ApplicationScoped
public class RenameService {

    @Inject
    GameRepository gameRepository;

    @Inject
    YakamonRepository yakamonRepository;

    public YakamonModel rename(UUID uuid, String newNickname) {
        if (gameRepository.findAll().count() == 0)
            ErrorCode.BAD_REQUEST.throwException("Game is not running");

        if (newNickname == null || newNickname.isBlank() || newNickname.length() > 20)
            ErrorCode.BAD_REQUEST.throwException("Invalid nickname");

        var results = yakamonRepository.list("uuid", uuid);
        if (results.isEmpty())
            ErrorCode.NOT_FOUND.throwException("Yakamon not found");

        YakamonModel yakamon = results.getFirst();
        yakamon.nickname = newNickname;
        yakamonRepository.persist(yakamon);

        return yakamon;
    }
}
