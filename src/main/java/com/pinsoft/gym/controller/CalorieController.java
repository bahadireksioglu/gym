package com.pinsoft.gym.controller;

import com.pinsoft.gym.dto.CalorieRequest;
import com.pinsoft.gym.dto.MacroResponse;
import com.pinsoft.gym.service.app.CalorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Calorie")
public class CalorieController {

    private CalorieService calorieService;
 @Autowired
    public CalorieController(CalorieService calorieService) {
        this.calorieService = calorieService;
    }
    @PostMapping("/dailyCalorie")
    public Double DailyCalorie(@RequestBody CalorieRequest calorieRequest) {
     return  calorieService.dailyCalorie(calorieRequest);
    }

    @PostMapping("/weeklyCalorie")
    public Double WeeklyCalorie(@RequestBody CalorieRequest calorieRequest) {
        return  calorieService.WeeklyCalorie(calorieRequest);
    }

    @PostMapping("/monthlyCalorie")
    public Double MonthlyCalorie(@RequestBody CalorieRequest calorieRequest) {
        return  calorieService.MonthlyCalorie(calorieRequest);
    }

    @PostMapping("/weeklyMacro")
    public MacroResponse WeeklyMacro(@RequestBody CalorieRequest calorieRequest) {
        return  calorieService.WeeklyMacro(calorieRequest);
    }

    @PostMapping("/monthlyMacro")
    public MacroResponse MonthlyMacro(@RequestBody CalorieRequest calorieRequest) {
        return  calorieService.MonthlyMacro(calorieRequest);
    }


}
