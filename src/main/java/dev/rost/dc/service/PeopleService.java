package dev.rost.dc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.rost.dc.model.Person;
import dev.rost.dc.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PeopleService {
    private final PersonRepository repository;

    @Transactional(readOnly = true)
    public List<Person> index() {
        return repository.findAll();
    }
}
