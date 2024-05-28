package com.CN.FitFusion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExerciseDto {

	  String name;

      String description;

      int sets;

      int reps;

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

	public ExerciseDto(String name, String description, int sets, int reps) {
		super();
		this.name = name;
		this.description = description;
		this.sets = sets;
		this.reps = reps;
	}
      
	public ExerciseDto() {
		
	}

}
