package com.CN.FitFusion.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.CN.FitFusion.repository.*;
import com.CN.FitFusion.model.*;
import com.CN.FitFusion.dto.*;
@Service
public class DietService {

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private UserRepository userRepository;
    
    public List<Diet> fetchAllDiets() {
        return dietRepository.findAll();
    }

    public Diet fetchDietById(Long id) {
        Optional<Diet> dietOptional = dietRepository.findById(id);
        return dietOptional.orElse(null);
    }

    public void createDietByUserId(DietDto dietDto, Long userId) {
        // Assuming you have a method to convert DietDto to Diet entity
        Diet diet = convertDtoToDiet(dietDto);
        
        // Assuming you have a method to fetch the user by userId
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        diet.setUser(user); // Set the user for the diet
        dietRepository.save(diet);
    }

    public void updateDietByUserId(DietDto dietDto, Long userId) {
        // Assuming you have a method to convert DietDto to Diet entity
        Diet diet = convertDtoToDiet(dietDto);

        // Assuming you have a method to fetch the user by userId
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        diet.setUser(user); // Set the user for the diet
        dietRepository.save(diet);
    }

    public void deleteDietById(Long id) {
        dietRepository.deleteById(id);
    }

    // Method to convert DietDto to Diet entity - implement according to your requirements
    private Diet convertDtoToDiet(DietDto dietDto) {
        // Implement conversion logic here
    	Diet diet = new Diet();
    	diet.setDescription(dietDto.getDescription());
    	diet.setName(dietDto.getName());
    	return diet;
    }
}

