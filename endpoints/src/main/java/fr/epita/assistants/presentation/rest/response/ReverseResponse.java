package fr.epita.assistants.presentation.rest.response;


import lombok.Value;

@Value
public class ReverseResponse {
    String original;
    String reversed;
}
