package com.jbdl63.session8JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Session8JdbcApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args)
	{
		SpringApplication.run(Session8JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		jdbcTemplate.update("CREATE TABLE IF NOT EXISTS Student(" +
				"studId int PRIMARY KEY AUTO_INCREMENT," +
						"studName varchar(200),"+
						"department varchar(200),"+
						"marks double"+
						")"
		);
	}
}
