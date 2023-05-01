package dev.rost.dc.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Entity
@NoArgsConstructor
@Jacksonized
public class Book {
    @Id
    @GeneratedValue
    UUID id;
    String name;
//    @ManyToOne
//    Author author;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    List<Person> owners;

    public Book(String name) {
        this.name = name;
    }
}
