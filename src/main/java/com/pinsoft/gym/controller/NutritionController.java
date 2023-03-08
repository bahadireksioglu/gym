package com.pinsoft.gym.controller;

import com.pinsoft.gym.dto.*;
import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.service.app.NutritionService;
import com.pinsoft.gym.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/app/nutrition")
public class NutritionController {
    @Autowired
    private NutritionService nutritionService;
    @GetMapping("getById/{id}")
    @PreAuthorize("hasRole('USER')")
    Nutrition getNutrition(@PathVariable Integer id){
        return nutritionService.getById(id);
    }
    @GetMapping("/{val}")
    Nutrition getNutrition(@PathVariable Double val){
        return nutritionService.getByCarbonhydrateValue(val);
    }
    @GetMapping("/getByNutritionType")
    List<GetByNutritionTypeResponse> getNutritionByNutritionType(@RequestParam Integer id){
        return nutritionService.getByNutritionTypeId(id);
    }
    @PostMapping("/save")
    GenericResponse save(@RequestBody CreateNutritionRequest createNutritionRequest){
        nutritionService.save(createNutritionRequest);
        return new GenericResponse("Besin Eklendi");
    }
    @PutMapping("/{id}/update")
    GenericResponse update(@PathVariable Integer id, @RequestBody UpdateNutritionRequest updateNutritionRequest) {
        nutritionService.update(id,updateNutritionRequest);
        return new GenericResponse("Besin Güncellendi");
    }
    @DeleteMapping("/delete")
    GenericResponse delete(@RequestParam Integer id){
        nutritionService.delete(id);
        return new GenericResponse("Besin Silindi");
    }
    @PutMapping("/{id}/updateHealthScore")
    GenericResponse updateHealthScore(@PathVariable Integer id,
                                      @RequestBody UpdateNutritionHealthScoreRequest updateNutritionHealthScoreRequest){
        nutritionService.updateHealthScore(id, updateNutritionHealthScoreRequest);
        return new GenericResponse("Sağlık Skoru Güncellendi");
    }
    @GetMapping("/getAllNutritions")
    List<GetAllNutritionResponse> getAllNutritionResponses(){
        return nutritionService.getAllNutrition();
    }
}
