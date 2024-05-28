package com.CN.FitFusion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CN.FitFusion.model.*;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    // You can define additional methods specific to Exercise entity here if needed
	
	@Query("SELECT d FROM Exercise d WHERE d.user.id = :id")
	Exercise findByUserId(Long id);
}

