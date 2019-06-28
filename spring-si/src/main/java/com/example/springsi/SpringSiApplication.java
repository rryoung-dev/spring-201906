package com.example.springsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringSiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSiApplication.class, args);
		
	}

}
