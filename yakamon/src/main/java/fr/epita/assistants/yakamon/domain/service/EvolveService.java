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
public class EvolveService {

    @Inject
    GameRepository gameRepository;

    @Inject
    YakamonRepository yakamonRepository;

    public YakamonModel evolve(UUID uuid) {
        if (gameRepository.findAll().count() == 0)
            ErrorCode.BAD_REQUEST.throwException("Game is not running");

        var results = yakamonRepository.list("uuid", uuid);
        if (results.isEmpty())
            ErrorCode.NOT_FOUND.throwException("Yakamon not found");

        YakamonModel yakamon = results.getFirst();

        if (yakamon.yakadexEntry.evolution == null)
            ErrorCode.NOT_FOUND.throwException("Yakamon has reached its maximum evolution tier");

        if (yakamon.energyPoints < yakamon.yakadexEntry.evolveThreshold)
            ErrorCode.BAD_REQUEST.throwException("Not enough energy points to evolve");

        yakamon.yakadexEntry = yakamon.yakadexEntry.evolution;
        yakamon.energyPoints = 0;
        yakamonRepository.persist(yakamon);

        return yakamon;
    }
}
