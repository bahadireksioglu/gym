package com.pinsoft.gym.controller;

import com.pinsoft.gym.dto.*;
import com.pinsoft.gym.service.app.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping("/getAll")
    List<GetAllMealResponse> getAll(){
        return mealService.getAll();
    }

    @GetMapping("/getById/{id}")
    GetByIdMealResponse getById(@PathVariable Integer id){
        return mealService.getById(id);
    }

    @GetMapping("/getByName/{name}")
    GetByNameMealResponse getByName(@PathVariable String name){
        return mealService.getByName(name);
    }

    @PostMapping("/add")
    void createMeal(@RequestBody CreateMealRequest createMealRequest){
        mealService.createMeal(createMealRequest);
    }

    @PutMapping("/update/{id}")
    void updateMeal(@PathVariable Integer id,@RequestBody UpdateMealRequest updateMealRequest){
        mealService.updateMeal(id, updateMealRequest);
    }

    @DeleteMapping("/delete/{id}")
    void deleteMeal(@PathVariable Integer id){
        mealService.deleteMeal(id);
    }
}
