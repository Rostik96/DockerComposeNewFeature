package dev.rost.dc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    UUID id;
    String name;
//    @ManyToOne
//    Author author;

    @ManyToMany(mappedBy = "books")
    List<Person> owners;

    public Book(String name) {
        this.name = name;
    }
}
