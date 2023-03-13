package com.pinsoft.gym.repository;

import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.model.MealList;
import com.pinsoft.gym.model.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface MealRepository extends JpaRepository<Meal, Integer> {
    Optional<Meal> findByName(String name);


}
