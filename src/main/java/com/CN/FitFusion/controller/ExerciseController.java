package com.CN.FitFusion.controller;
import org.springframework.web.bind.annotation.*;
import com.CN.FitFusion.dto.*;
import com.CN.FitFusion.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import java.util.*;
import com.CN.FitFusion.service.*;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
	/*
	 * 
	 * • GET “/exercise/all”: This API lets a trainer fetch all exercises. It
	 * returns an OK response status.
	 * 
	 * • GET “/exercise/{id}” (@PathVariable Long id): This API lets a trainer fetch
	 * an exercise by its ID. It returns an OK response status.
	 * 
	 * • POST “/exercise/create/{userId}” (@RequestBody ExerciseDto
	 * exerciseDto, @PathVariable Long userId): This API allows a trainer to create
	 * an exercise for a user by using the user’s ID. It returns a CREATED response
	 * status.
	 * 
	 * • PUT “/exercise/{id}” (@RequestBody ExerciseDto exerciseDto, @PathVariable
	 * Long id): This API allows a trainer to update an exercise by its ID. It
	 * returns an OK response status.
	 * 
	 * • DELETE “/exercise/{id}” (@PathVariable Long id): This API allows a trainer
	 * to delete an exercise by its ID. It returns an OK
	 */
	@Autowired
	ExerciseService exerciseService;

	@GetMapping("/all")
	public List<Exercise> fetchAllExercise() {
		return exerciseService.fetchAllExercises();
	}

	@GetMapping("/{id}")
	public Exercise fetchExerciseById(@PathVariable Long id) {
		return exerciseService.fetchExerciseById(id);
	}

	@PostMapping("/create/{userId}")
	public ResponseEntity<Void> createExerciseByUserId(@RequestBody ExerciseDto ExerciseDto, @PathVariable Long userId) {
		exerciseService.createExerciseByUserId(ExerciseDto, userId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public void updateExerciseByUserId(@RequestBody ExerciseDto ExerciseDto, @PathVariable Long userId) {
		exerciseService.updateExerciseByUserId(ExerciseDto, userId);
	}

	@DeleteMapping("/{id}")
	public void deleteExerciseById(@PathVariable Long id) {
		exerciseService.deleteExerciseById(id);
	}
}
