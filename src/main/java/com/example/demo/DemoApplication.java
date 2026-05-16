package com.example.demo;

import com.example.demo.repositories.iCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private iCatRepository iCatRepository;
	CommandLineRunner innit(){
		return args -> {
			iCatRepository.findAll().forEach(cat -> {
				System.out.println(cat.getName());
			});
		};
	}
}
