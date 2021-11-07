package com.example.bloodpressureapp.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Bloodpressure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int upper;
	private int lower;
	private int pulse;	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	public Bloodpressure() {
	}

	public Bloodpressure(int upper, int lower, int pulse, LocalDate date) {
		super();
		this.upper = upper;
		this.lower = lower;
		this.pulse = pulse;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}