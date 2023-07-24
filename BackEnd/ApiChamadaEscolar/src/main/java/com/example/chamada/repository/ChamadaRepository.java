package com.example.chamada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chamada.model.chamada.Chamada;

@Repository
public interface ChamadaRepository extends JpaRepository<Chamada, Long>{

}
