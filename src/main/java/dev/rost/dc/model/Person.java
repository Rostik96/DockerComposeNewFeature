package dev.rost.dc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue

    UUID id;
    String name;
    int age;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "person_book",
    joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> books;

    public Person(String name, int age, Book book) {
        this.name = name;
        this.age = age;
        this.books = new ArrayList<>(){{
            add(book);
        }};
    }
}
