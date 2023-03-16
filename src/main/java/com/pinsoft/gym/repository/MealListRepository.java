package com.pinsoft.gym.repository;

import com.pinsoft.gym.model.MealList;
import com.pinsoft.gym.model.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MealListRepository extends JpaRepository<MealList, Integer> {

 //   Set<MealList> add(Nutrition nutrition);

}
