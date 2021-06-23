package com.wk.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wk.teste.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "select U.* from user U LEFT JOIN pessoa P ON P.pess_id = U.PESS_ID where P.pess_email = ?1", nativeQuery = true)
	User findByUserName(String userName);
	
}
