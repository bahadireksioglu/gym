package com.pinsoft.gym.repository;

import com.pinsoft.gym.model.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NutritionRepository extends JpaRepository<Nutrition, Integer> {
    public Nutrition getById(Integer id);
    @Query("SELECT n FROM Nutrition n WHERE n.carbohydrate = :carbohydrate")
    public Nutrition getByCarbonhydrateValue(@Param("carbohydrate") Double val);
}
