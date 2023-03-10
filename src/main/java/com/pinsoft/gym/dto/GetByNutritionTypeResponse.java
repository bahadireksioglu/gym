package com.pinsoft.gym.dto;

import lombok.Data;

@Data
public class GetByNutritionTypeResponse {
    private String name;
    private Double kcal;
    private Double protein;
    private Double carbohydrate;
    private Double fat;
    private Double baseWeight;
    private Integer healthScore;
}
