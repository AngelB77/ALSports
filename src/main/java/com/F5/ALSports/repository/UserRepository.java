package com.F5.ALSports.repository;

import com.F5.ALSports.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
