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
	private Date date;
	
	public Schedule() {
		
	}
	
	public Schedule (String topic, Date date) {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
