package com.CN.FitFusion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.CN.FitFusion.model.*;
@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {
    // You can define additional methods specific to Diet entity here if needed
	//@Query("Select * from diet where user_id =: id")
	@Query("SELECT d FROM Diet d WHERE d.user.id = :id")
	Diet findByUserId(Long id);
}

