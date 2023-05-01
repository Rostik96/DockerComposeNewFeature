package dev.rost.dc.service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.rost.dc.model.Person;
import dev.rost.dc.repository.PersonRepository;
import dev.rost.dc.util.PersonNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PeopleService {
    private final PersonRepository repository;

    @Transactional(readOnly = true)
    public List<Person> index() {
        return repository.findAll();
    }


    @Transactional(readOnly = true)
    public Person getPerson(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }


    public UUID create(Person person) {
        return repository.save(person).getId();
    }


    public List<UUID> create(Collection<Person> person) {
        return repository.saveAll(person).stream()
                .map(Person::getId)
                .toList();
    }
}
