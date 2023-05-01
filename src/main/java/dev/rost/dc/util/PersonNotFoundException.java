package dev.rost.dc.util;

import java.util.UUID;

import lombok.Getter;
import lombok.experimental.StandardException;

@Getter
@StandardException
public class PersonNotFoundException extends RuntimeException {
    private UUID id;

    public PersonNotFoundException(UUID id) {
        this.id = id;
    }
}