package com.example.servletpbi;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServletpbiApplication implements CommandLineRunner{

	@Autowired
	private ScheduleRepository scheduleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServletpbiApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		for (int i = 0; i < 5; i++) {
			scheduleRepository.save(new Schedule ("Topic #" + (i+1), "2017-05-12"));
			
		}
	}
}
