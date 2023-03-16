package com.pinsoft.gym.controller;

import com.pinsoft.gym.dto.CreateMealListRequest;
import com.pinsoft.gym.dto.GetAllMealListResponse;
import com.pinsoft.gym.dto.GetByIdMealListResponse;
import com.pinsoft.gym.dto.UpdateMealListRequest;
import com.pinsoft.gym.model.MealList;
import com.pinsoft.gym.service.app.MealListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mealList")
public class MealListController {

    @Autowired
    private MealListService mealListService;

    @GetMapping("/getAll")
    public List<GetAllMealListResponse> getAll(){
        return mealListService.getAll();
    }

    @GetMapping("/getById/{id}")
    public GetByIdMealListResponse getById(@PathVariable Integer id){
        return mealListService.getById(id);
    }

    @PostMapping("/add")
    public void createMealList(@RequestBody CreateMealListRequest createMealListRequest){
         mealListService.createMealList(createMealListRequest);
    }

    @PutMapping("/update/{id}")
    public void updateMealList(@PathVariable Integer id, @RequestBody UpdateMealListRequest updateMealListRequest){
        mealListService.updateMealList(id, updateMealListRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMealList(@PathVariable Integer id){
        mealListService.deleteMealList(id);
    }

    @GetMapping("/getFat/{id}")
    public Double getFat(@PathVariable Integer id, @RequestBody MealList mealList){
        return mealListService.getFat(id,mealList);
    }

    @GetMapping("/getProtein/{id}")
    public Double getProtein(@PathVariable Integer id, @RequestBody MealList mealList){
        return mealListService.getProtein(id,mealList);
    }

    @GetMapping("/getCarbonhydrate/{id}")
    public Double getCarbonhydrate(@PathVariable Integer id, @RequestBody MealList mealList){
        return mealListService.getCarbonhydrate(id,mealList);
    }
}
