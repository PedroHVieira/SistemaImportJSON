package com.wk.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wk.teste.model.Candidatos;

public interface CandidatosRepository extends JpaRepository<Candidatos, Long>{

	@Query(value = "SELECT * FROM candidatos where cand_sexo = ?1", nativeQuery = true)
	List<Candidatos> findBySexo(String sexo);
	
	@Query(value = "SELECT * FROM candidatos where cand_peso > 50", nativeQuery = true)
	List<Candidatos> findByPesoMaior50();
	
	@Query(value = "SELECT * FROM candidatos GROUP BY cand_estado", nativeQuery = true)
	List<Candidatos> findGroupByUf();
	
	@Query(value = "SELECT * FROM candidatos where cand_estado = ?1", nativeQuery = true)
	List<Candidatos> findByUf(String uf);
}
