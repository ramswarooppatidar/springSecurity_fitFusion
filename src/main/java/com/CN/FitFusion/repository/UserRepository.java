package com.CN.FitFusion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CN.FitFusion.model.*;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can define additional methods specific to User entity here if needed
}

