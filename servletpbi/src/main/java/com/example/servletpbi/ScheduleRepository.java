package com.example.servletpbi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
	
	List<Schedule> findByTopicIgnoreCaseContaining(String topic);
	
}
