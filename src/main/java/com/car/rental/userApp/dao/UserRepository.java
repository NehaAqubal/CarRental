package com.car.rental.userApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.car.rental.userApp.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByfullName(String username);
}

