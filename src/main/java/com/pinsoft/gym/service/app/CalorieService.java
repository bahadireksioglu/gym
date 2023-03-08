package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.CalorieRequest;
import com.pinsoft.gym.dto.MacroResponse;


public interface CalorieService {

        Double dailyCalorie(CalorieRequest calorieRequest);

        Double WeeklyCalorie(CalorieRequest calorieRequest);

        Double  MonthlyCalorie(CalorieRequest calorieRequest);

        MacroResponse WeeklyMacro( CalorieRequest calorieRequest);

        MacroResponse MonthlyMacro( CalorieRequest calorieRequest);



    }
