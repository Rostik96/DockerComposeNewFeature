package dev.rost.dc.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue
    UUID id;
    String firstName;
    String lastName;
    String patronymic;

    @OneToMany(mappedBy = "author")
    List<Book> books;
}
