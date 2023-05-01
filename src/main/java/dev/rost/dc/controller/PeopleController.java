package dev.rost.dc.controller;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.rost.dc.model.Person;
import dev.rost.dc.service.PeopleService;
import dev.rost.dc.util.PersonErrorResponse;
import dev.rost.dc.util.PersonNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/people")
public class PeopleController {
    private final PeopleService service;

    @GetMapping
    public List<Person> index() {
        return service.index();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") UUID id) {
        return service.getPerson(id);
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private PersonErrorResponse exceptionHandler(PersonNotFoundException e) {
        return new PersonErrorResponse(
                String.format("Person with this ID=%s wasn't found", e.getId()),
                Instant.now());

    }
}
