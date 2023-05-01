package dev.rost.dc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            var book = new Book("Преступление и наказание");
            var person = new Person("Rostik", 26, book);
            var uuid = service.create(person);
            log.info("Create person id={}", uuid);
        };
    }
}
