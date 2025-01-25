package com.F5.ALSports.repository;

import com.F5.ALSports.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}