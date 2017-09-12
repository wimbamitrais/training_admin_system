package com.example.servletpbi;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Schedule {
	
	@Id
	@GeneratedValue
	
	private long id;
	private String topic;
	private String date;
	
	public Schedule() {
		
	}
	
	public Schedule(String topic, String date) {
		setTopic(topic);
		setDate(date);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
