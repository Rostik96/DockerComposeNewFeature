package dev.rost.dc;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.rost.dc.model.Author;
import dev.rost.dc.model.Book;
import dev.rost.dc.model.Person;
import dev.rost.dc.service.PeopleService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DockerFeatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerFeatureApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PeopleService service) {
        return args -> {
            var authors = new ArrayList<Author>() {{
                add(new Author( "Илья", "Арнольдович", "Ильф"));
                add(new Author("Евгений", "Петрович", "Петров"));
            }};
            var book = new Book("12 стульев", authors);
            var owner = new Person("Rostik", 26, book);
            book.setOwner(owner);
            var uuid = service.create(owner);
            log.info("Created person id={}", uuid);
        };
    }
}
