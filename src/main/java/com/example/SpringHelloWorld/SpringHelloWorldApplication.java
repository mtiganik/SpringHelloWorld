package com.example.SpringHelloWorld;

import io.github.cdimascio.dotenv.Dotenv;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class SpringHelloWorldApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		Connection conn = DatabaseUtils.createConnection("com.mysql.cj.jdbc.Driver", dotenv.get("DB_URL"),dotenv.get("DB_USER"),
				dotenv.get("DB_PASS"));

		SpringApplication.run(SpringHelloWorldApplication.class, args);
	}

}
