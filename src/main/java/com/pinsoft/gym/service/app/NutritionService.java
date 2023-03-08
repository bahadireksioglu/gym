package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.*;
import com.pinsoft.gym.model.Nutrition;

import java.util.List;

public interface NutritionService {
    Nutrition getById(Integer id);
    Nutrition getByCarbonhydrateValue(Double val);
    List<GetByNutritionTypeResponse> getByNutritionTypeId(Integer id);
    void save(CreateNutritionRequest createNutritionRequest);
    void delete(Integer id);
    void update(Integer id, UpdateNutritionRequest updateNutritionRequest);
    void updateHealthScore(Integer id, UpdateNutritionHealthScoreRequest updateNutritionHealthScoreRequest);
    List<GetAllNutritionResponse> getAllNutrition();
}
