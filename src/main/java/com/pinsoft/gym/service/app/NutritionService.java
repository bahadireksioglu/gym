package com.pinsoft.gym.service.app;

import com.pinsoft.gym.model.Nutrition;

public interface NutritionService {
    Nutrition getById(Integer id);
    Nutrition getByCarbonhydrateValue(Double val);
}
