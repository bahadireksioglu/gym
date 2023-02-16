package com.pinsoft.gym.controller;

import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.service.app.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/app/nutrition")
public class NutritionController {
    @Autowired
    private NutritionService nutritionService;
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    Nutrition getNutrition(@PathVariable Integer id){
        return nutritionService.getById(id);
    }
    @GetMapping("/{val}")
    Nutrition getNutrition(@PathVariable Double val){
        return nutritionService.getByCarbonhydrateValue(val);
    }
}
