package fr.epita.assistants.yakamon.presentation.api.response;

import fr.epita.assistants.yakamon.data.model.YakadexEntryModel;
import fr.epita.assistants.yakamon.data.repository.YakadexEntryRepository;
import lombok.Value;

import java.util.List;

@Value
public class YakadexResponse {
    List<YakadexEntryResponse> entries;
}
