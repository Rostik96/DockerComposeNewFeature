package dev.rost.dc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rost.dc.model.Person;
import dev.rost.dc.service.PeopleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class PeopleController {
    private final PeopleService service;

    @GetMapping
    public List<Person> index() {
        return service.index();
    }
}
