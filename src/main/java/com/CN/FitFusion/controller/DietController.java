package com.CN.FitFusion.controller;

import org.springframework.web.bind.annotation.*;
import com.CN.FitFusion.dto.*;
import com.CN.FitFusion.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import java.util.*;
import com.CN.FitFusion.service.*;
@RestController
@RequestMapping("/diet")
public class DietController {
	/*
	 * 
	 * • GET “/diet/all”: This API lets a trainer fetch all diets. It returns an OK
	 * response status.
	 * 
	 * • GET “/diet/{id}” (@PathVariable Long id): This API allows a trainer to
	 * fetch a diet by its ID. It returns an OK response status.
	 * 
	 * • POST “/diet/create/{userId}” (@RequestBody DietDto dietDto, @PathVariable
	 * Long userId): This API allows a trainer to create a diet for a user using the
	 * user’s ID. It returns a CREATED response status.
	 * 
	 * • PUT “/diet/{id}” (@RequestBody DietDto dietDto, @PathVariable Long id):
	 * This API allows a trainer to update a diet by its ID. It returns an OK
	 * response status.
	 * 
	 * • DELETE “/diet/{id}” (@PathVariable Long id): This API allows a trainer to
	 * delete a diet by its ID. It returns an OK response status.
	 */
	@Autowired
	DietService dietService;

	@GetMapping("/all")
	public List<Diet> fetchAllDiets() {
		return dietService.fetchAllDiets();
	}

	@GetMapping("/{id}")
	public Diet fetchDietById(@PathVariable Long id) {
		return dietService.fetchDietById(id);
	}

	@PostMapping("/create/{userId}")
	public ResponseEntity<Void> createDietByUserId(@RequestBody DietDto dietDto, @PathVariable Long userId) {
		dietService.createDietByUserId(dietDto, userId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public void updateDietByUserId(@RequestBody DietDto dietDto, @PathVariable Long userId) {
		dietService.updateDietByUserId(dietDto, userId);
	}

	@DeleteMapping("/{id}")
	public void deleteDietById(@PathVariable Long id) {
		dietService.deleteDietById(id);
	}
}
