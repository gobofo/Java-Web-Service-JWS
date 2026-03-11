package fr.epita.assistants.yakamon.presentation.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Value
public class YakadexEntryResponse {

    Integer id;
    String name;
    String firstType;
    String secondType;
    Integer evolveThreshold;
    Integer evolutionId;
    Boolean caught;
    String description;

}

