package dev.paie;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaieAppApplication {

	
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
    
    
	public static void main(String[] args) {
		SpringApplication.run(PaieAppApplication.class, args);
	}

}
