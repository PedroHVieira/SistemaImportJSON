package com.wk.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wk.teste.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value="SELECT * FROM pessoa WHERE pess_email = ?1",nativeQuery = true)
	Pessoa findByEmail(String email);
}
