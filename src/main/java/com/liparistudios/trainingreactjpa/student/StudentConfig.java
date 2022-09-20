package com.liparistudios.trainingreactjpa.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner( StudentRepository repo ) {
        return args -> {

            //  Operazione all'avvio
            Student Vito = new Student(
                    "Vito",
                    "vito@mail.com",
                    LocalDate.of(1981, Month.APRIL, 25)
            );

            repo.save( Vito );

        };
    }
}
