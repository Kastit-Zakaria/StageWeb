package com.example.stageWeb.repository;

import com.example.stageWeb.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kasti
 */
@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {

}
