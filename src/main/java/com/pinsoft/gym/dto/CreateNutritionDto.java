package com.pinsoft.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNutritionDto {
    private String name;
    private Double kcal;
    private Double protein;
    private Double carbohydrate;
    private Double fat;
    private Double baseWeight;
}


