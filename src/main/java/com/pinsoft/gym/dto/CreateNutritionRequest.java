package com.pinsoft.gym.dto;

import com.pinsoft.gym.model.NutritionType;
import lombok.Data;

import java.util.List;

@Data
public class CreateNutritionRequest {
    private String name;
    private Double kcal;
    private Double protein;
    private Double carbohydrate;
    private Double fat;
    private Double baseWeight;
    private Integer nutritionTypeId;
}
