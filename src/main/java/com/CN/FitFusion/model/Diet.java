package com.CN.FitFusion.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.*;
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
public class Diet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String name;

	String description;

//     (ManyToOne)
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Diet(Long id, String name, String description, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.user = user;
	}

	public Diet() {

	}
}
