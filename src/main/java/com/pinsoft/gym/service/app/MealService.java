package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.*;
import com.pinsoft.gym.model.Meal;

import java.util.List;

public interface MealService {

    //Create
    void createMeal(CreateMealRequest createMealRequest);

    //Get All
    List<GetAllMealResponse> getAll();

    //Get By Id
    GetByIdMealResponse getById(Integer id);

    //Get By Name
    GetByNameMealResponse getByName(String name);

    //update
    void updateMeal(Integer id, UpdateMealRequest updateMealRequest);

    //delete
    void deleteMeal(Integer id);


}
