package com.CN.FitFusion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.*;
@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String name;

	String description;

	int sets;

	int reps;

	// (ManyToOne)
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exercise(Long id, String name, String description, int sets, int reps, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.sets = sets;
		this.reps = reps;
		this.user = user;
	}
	public Exercise() {
		
	}

}
