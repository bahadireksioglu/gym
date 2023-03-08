package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.CalorieRequest;
import com.pinsoft.gym.dto.MacroResponse;
import org.springframework.stereotype.Service;

@Service
public class CalorieServiceImpl implements CalorieService {

    public MacroResponse helper(Double totalCalorie) {
        Double protein = ((totalCalorie) * 45 / 100) / 4.0;
        Double fat =  ((totalCalorie) * 27.5 / 100) / 9.0;
        Double carbonhydrate = ((totalCalorie) * 32.5 / 100) / 4.0;

        MacroResponse macroResponse = new MacroResponse();
        macroResponse.setCarbonhydrate(carbonhydrate);
        macroResponse.setProtein(protein);
        macroResponse.setFat(fat);
        return macroResponse;
    }

    @Override
    public Double dailyCalorie(CalorieRequest calorieRequest) {
        Double result =0.0;

        if(calorieRequest.getGender().equals("Male")) {
          result = 10 * (calorieRequest.getWeight()) + 6.25 * (calorieRequest.getSize()) - 5 * (calorieRequest.getAge()) + 5;
        }
        else {
            result = 10 * (calorieRequest.getWeight()) + 6.25 * (calorieRequest.getSize()) - 5 * (calorieRequest.getAge()) - 161 ;
        }

        return result * 1.55;
    }

    @Override
    public Double WeeklyCalorie(CalorieRequest calorieRequest) {
        return  dailyCalorie(calorieRequest) * 7  ;

    }

    @Override
    public Double MonthlyCalorie(CalorieRequest calorieRequest) {

        return WeeklyCalorie(calorieRequest) * 4 ;
    }

    @Override
    public MacroResponse WeeklyMacro( CalorieRequest calorieRequest ) {
        Double totalCalorie = WeeklyCalorie(calorieRequest);

    return helper(totalCalorie);

    }

    @Override
    public MacroResponse MonthlyMacro( CalorieRequest calorieRequest) {


        Double totalCalorie = MonthlyCalorie(calorieRequest);

        return helper(totalCalorie);

    }
}
