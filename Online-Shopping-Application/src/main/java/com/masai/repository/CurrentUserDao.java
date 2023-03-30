package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CurrentSession;

public interface CurrentUserDao extends JpaRepository<CurrentSession, Integer> {
	
	public CurrentSession findByUuid(String key);

}
