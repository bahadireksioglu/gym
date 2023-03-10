package com.pinsoft.gym.dto;

import com.pinsoft.gym.model.NutritionType;
import lombok.Data;

@Data
public class GetAllNutritionResponse {
    private String name;
    private Double kcal;
    private Double protein;
    private Double carbohydrate;
    private Double fat;
    private Double baseWeight;
    private Integer nutritionTypeId;
    private Integer healthScore;
}
