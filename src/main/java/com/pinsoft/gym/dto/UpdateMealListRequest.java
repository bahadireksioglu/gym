package com.pinsoft.gym.dto;

import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.model.Nutrition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMealListRequest {
   // private String mealName;
  //  private String nutritionName;
    private Double weight;
}
