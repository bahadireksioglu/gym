package com.pinsoft.gym.dto;

import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.model.Nutrition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdMealListResponse {
    private Integer id;
    private String mealName;
    private String nutritionName;
    private Double weight;
    private LocalDateTime createdDate;
}
