package dev.rost.dc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@JsonIgnoreProperties({"id"})
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    UUID id;
    String name;
    int age;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    List<Book> books;

    public Person(String name, int age, Book book) {
        this.name = name;
        this.age = age;
        this.books = new ArrayList<>() {{
            add(book);
        }};
    }

    public Person(String name, int age, List<Book> books) {
        this.name = name;
        this.age = age;
        this.books = new ArrayList<>(books);
    }
}
