package com.wk.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wk.teste.model.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{

	@Query(value="SELECT * FROM roles WHERE role_nome LIKE %?1%",nativeQuery = true)
	Roles findByNome(String nome);
}
