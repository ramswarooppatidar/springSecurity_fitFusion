package com.CN.FitFusion.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.CN.FitFusion.repository.*;
import com.CN.FitFusion.model.*;
import com.CN.FitFusion.dto.*;
@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Exercise> fetchAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise fetchExerciseById(Long id) {
        Optional<Exercise> exerciseOptional = exerciseRepository.findById(id);
        return exerciseOptional.orElse(null);
    }

    public void createExerciseByUserId(ExerciseDto exerciseDto, Long userId) {
        // Assuming you have a method to convert ExerciseDto to Exercise entity
        Exercise exercise = convertDtoToExercise(exerciseDto);
        
        // Assuming you have a method to fetch the user by userId
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        exercise.setUser(user); // Set the user for the exercise
        user.getExerciseList().add(exercise);
        userRepository.save(user);
        //exerciseRepository.save(exercise);
    }

    public void updateExerciseByUserId(ExerciseDto exerciseDto, Long userId) {
        // Assuming you have a method to convert ExerciseDto to Exercise entity
        Exercise exercise = convertDtoToExercise(exerciseDto);

        // Assuming you have a method to fetch the user by userId
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        exercise.setUser(user); // Set the user for the exercise
        user.getExerciseList().add(exercise);
        userRepository.save(user);
    }

    public void deleteExerciseById(Long id) {
        exerciseRepository.deleteById(id);
    }

    // Method to convert ExerciseDto to Exercise entity - implement according to your requirements
    private Exercise convertDtoToExercise(ExerciseDto exerciseDto) {
        // Implement conversion logic here
    	Exercise exercise = new Exercise();
    	exercise.setDescription(exerciseDto.getDescription());
    	exercise.setName(exerciseDto.getName());
    	exercise.setSets(exerciseDto.getSets());
    	exercise.setReps(exerciseDto.getReps());
    	return exercise;
    }
}

