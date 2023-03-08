package com.pinsoft.gym.dto;

import lombok.Data;

@Data
public class UpdateNutritionRequest {
    private String name;
    private Double kcal;
    private Double protein;
    private Double carbohydrate;
    private Double fat;
}
