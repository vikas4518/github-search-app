package com.vikas.github.proj;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.vikas.github.proj")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
