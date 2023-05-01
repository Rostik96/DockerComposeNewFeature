package dev.rost.dc.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue
    UUID id;
    String name;
    int age;
    @ManyToMany
    @JoinTable(name = "book_person",
    joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> books;
}
