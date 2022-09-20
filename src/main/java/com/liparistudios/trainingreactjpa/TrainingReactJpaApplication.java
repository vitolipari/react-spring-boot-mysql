package com.liparistudios.trainingreactjpa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingReactJpaApplication {



	public static void main(String[] args) {
		System.out.println("start");
		SpringApplication.run(TrainingReactJpaApplication.class, args);
		System.out.println("end");

	}

}
