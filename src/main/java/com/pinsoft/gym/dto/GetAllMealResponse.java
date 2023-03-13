package com.pinsoft.gym.dto;

import com.pinsoft.gym.model.MealList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMealResponse {
    private Integer id;
    private String name;
    //private Set<MealList> mealList;
}
