package fr.epita.assistants.yakamon.presentation.rest;

import fr.epita.assistants.yakamon.converter.PlayerConverter;
import fr.epita.assistants.yakamon.domain.service.PlayerService;
import fr.epita.assistants.yakamon.presentation.api.response.PlayerResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerResource {

    @Inject
    PlayerService playerService;

    @Inject
    PlayerConverter playerConverter;

    @GET
    @Path("/")
    public PlayerResponse getPlayer() {
        return playerConverter.playerConverter(playerService.getPlayer());
    }
}
