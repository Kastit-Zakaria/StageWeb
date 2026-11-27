package com.example.stageWeb.repository;

import com.example.stageWeb.entity.Stage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kasti
 */
@Repository
public interface StageRepository extends JpaRepository<Stage, Integer> {
    
    List<Stage> findByDenomContaining(String denom);
}
