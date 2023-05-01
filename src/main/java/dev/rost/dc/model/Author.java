package dev.rost.dc.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue
    UUID id;
    String firstName;
    String lastName;
    String patronymic;

    @OneToMany(mappedBy = "author")
    List<Book> books;

    public Author(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }
}
