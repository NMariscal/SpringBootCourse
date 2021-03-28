package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

// Bean
@Configuration
public class StudentConfig {



    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository  ){
        return args -> {
            Student mariam = new Student( "Mariam",
                    LocalDate.of(2000, Month.JANUARY, 5), "mariam@gmal.com");
            Student alex = new Student( "Alex",
                    LocalDate.of(1970, Month.MARCH, 5), "alex@gmal.com");
            Student anne = new Student( "Anne",
                    LocalDate.of(1999, Month.AUGUST, 7), "anne@gmal.com");

            repository.saveAll(Arrays.asList(mariam, alex, anne));

        };
    }
}
