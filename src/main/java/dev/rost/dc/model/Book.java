package dev.rost.dc.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    UUID id;
    String name;
    @ManyToOne
    Author author;

    @ManyToMany(mappedBy = "books")
    List<Person> owners;
}
