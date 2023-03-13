package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.CreateMealListRequest;
import com.pinsoft.gym.dto.CreateNutritionDto;
import com.pinsoft.gym.dto.GetAllMealListResponse;
import com.pinsoft.gym.dto.GetByIdMealListResponse;
import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.model.MealList;
import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.dto.UpdateMealListRequest;


import java.util.List;
import java.util.Set;

public interface MealListService {

    void createMealList(CreateMealListRequest createMealListRequest);

    List<GetAllMealListResponse> getAll();

    GetByIdMealListResponse getById(Integer id);

    void updateMealList(Integer id, UpdateMealListRequest updateMealListRequest);

    void deleteMealList(Integer id);

    Double getFat(Integer id,MealList mealList);

    Double getProtein(Integer id,MealList mealList);

    Double getCarbonhydrate(Integer id, MealList mealList);



}
