/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.stageWeb.repository;

import com.example.stageWeb.entity.Enfant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kasti
 */
@Repository
public interface EnfantRepository extends JpaRepository<Enfant, Integer> {
    
    List<Enfant> findByNomContaining(String nom);
}
