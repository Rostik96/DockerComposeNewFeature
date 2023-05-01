package dev.rost.dc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString(exclude = {"id", "owner"})
@JsonIgnoreProperties({"id", "owner"})
@Entity
public class Book {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Author> authors;

    @ManyToOne //owning side
    private Person owner;

    public Book(String name, Author author) {
        this.name = name;
        this.authors = new ArrayList<>() {{
            add(author);
        }};
    }

    public Book(String name, List<Author> authors) {
        this.name = name;
        this.authors = new ArrayList<>(authors);
    }
}
