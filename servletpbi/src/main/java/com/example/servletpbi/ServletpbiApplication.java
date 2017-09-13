package com.example.servletpbi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServletpbiApplication implements CommandLineRunner{
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
    private UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(ServletpbiApplication.class, args);
	}
	
	@Override
	public void run(String... strings) throws Exception {
		for (int i = 0; i < 5; i++) {
			scheduleRepository.save(new Schedule ("Topic #" + (i+1), "2017-05-12"));
		}
		userRepo.save(new User("Taufiq", "taufiq@mitrais.com", "JP"));
		userRepo.save(new User("Ibnu", "Ibnu@mitrais.com", "JP"));
		userRepo.save(new User("Sopyan", "Sopyan@mitrais.com", "JP"));
		userRepo.save(new User("Yuliawan", "Yuliawan@mitrais.com", "JP"));
		userRepo.save(new User("Deny", "Deny@mitrais.com", "JP"));
		userRepo.save(new User("Daniel", "Daniel@mitrais.com", "JP"));
		userRepo.save(new User("Wisesa", "Wisesa@mitrais.com", "JP"));
		userRepo.save(new User("Wimba", "Wimba@mitrais.com", "JP"));
		userRepo.save(new User("Billy", "Billy@mitrais.com", "JP"));
		userRepo.save(new User("Inez", "Inez@mitrais.com", "JP"));
    }
	
}
