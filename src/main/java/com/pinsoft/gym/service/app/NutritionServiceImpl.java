package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.*;
import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.model.NutritionType;
import com.pinsoft.gym.repository.NutritionRepository;
import com.pinsoft.gym.service.app.NutritionService;
import org.apache.commons.collections4.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NutritionServiceImpl implements NutritionService {

    @Autowired
    private NutritionRepository nutritionRepository;
    @Override
    public Nutrition getById(Integer id) {
        return nutritionRepository.getById(id);
    }
    @Override
    public Nutrition getByCarbonhydrateValue(Double val) {
        return nutritionRepository.getByCarbonhydrateValue(val);
    }

    @Override
    public List<GetByNutritionTypeResponse> getByNutritionTypeId(Integer id) {
        List<Nutrition> nutritions=nutritionRepository.getByNutritionTypeId(id);
        List<GetByNutritionTypeResponse> responses=new ArrayList<GetByNutritionTypeResponse>();
        for (Nutrition nutrition:nutritions) {
            GetByNutritionTypeResponse getByNutritionTypeResponse=new GetByNutritionTypeResponse();
            getByNutritionTypeResponse.setName(nutrition.getName());
            getByNutritionTypeResponse.setKcal(nutrition.getKcal());
            getByNutritionTypeResponse.setProtein(nutrition.getProtein());
            getByNutritionTypeResponse.setCarbohydrate(nutrition.getCarbohydrate());
            getByNutritionTypeResponse.setFat(nutrition.getFat());
            getByNutritionTypeResponse.setBaseWeight(nutrition.getBaseWeight());
            getByNutritionTypeResponse.setHealthScore(nutrition.getHealthScore());
            responses.add(getByNutritionTypeResponse);
        }
        return responses;
    }

    @Override
    public void save(CreateNutritionRequest createNutritionRequest) {
        Nutrition nutrition=new Nutrition();
        nutrition.setName(createNutritionRequest.getName());
        nutrition.setKcal(createNutritionRequest.getKcal());
        nutrition.setCarbohydrate(createNutritionRequest.getCarbohydrate());
        nutrition.setProtein(createNutritionRequest.getProtein());
        nutrition.setFat(createNutritionRequest.getFat());
        nutrition.setBaseWeight(createNutritionRequest.getBaseWeight());
        NutritionType nutritionType=new NutritionType();
        nutritionType.setId(createNutritionRequest.getNutritionTypeId());
        nutrition.setNutritionType(nutritionType);
        nutritionRepository.save(nutrition);
    }

    @Override
    public void delete(Integer id) {
        nutritionRepository.deleteById(id);
    }

    @Override
    public void update(Integer id,UpdateNutritionRequest updateNutritionRequest) {
        Nutrition nutritioninDB=nutritionRepository.getById(id);
        nutritioninDB.setName(updateNutritionRequest.getName());
        nutritioninDB.setKcal(updateNutritionRequest.getKcal());
        nutritioninDB.setCarbohydrate(updateNutritionRequest.getCarbohydrate());
        nutritioninDB.setProtein(updateNutritionRequest.getProtein());
        nutritioninDB.setFat(updateNutritionRequest.getFat());
        nutritionRepository.save(nutritioninDB);
    }

    @Override
    public void updateHealthScore(Integer id, UpdateNutritionHealthScoreRequest updateNutritionHealthScoreRequest) {
        Nutrition nutritioninDB=nutritionRepository.getById(id);
        nutritioninDB.setHealthScore(updateNutritionHealthScoreRequest.getHealthScore());
        nutritionRepository.save(nutritioninDB);
    }

    @Override
    public List<GetAllNutritionResponse> getAllNutrition() {
        List<Nutrition> nutritions=nutritionRepository.findAll();
        List<GetAllNutritionResponse> responses=new ArrayList<GetAllNutritionResponse>();
        for (Nutrition nutrition:nutritions) {
            GetAllNutritionResponse getAllNutritionResponse=new GetAllNutritionResponse();
            getAllNutritionResponse.setName(nutrition.getName());
            getAllNutritionResponse.setKcal(nutrition.getKcal());
            getAllNutritionResponse.setProtein(nutrition.getProtein());
            getAllNutritionResponse.setCarbohydrate(nutrition.getCarbohydrate());
            getAllNutritionResponse.setFat(nutrition.getFat());
            getAllNutritionResponse.setBaseWeight(nutrition.getBaseWeight());
            NutritionType nutritionType=new NutritionType();
            nutritionType=nutrition.getNutritionType();
            getAllNutritionResponse.setNutritionTypeId(nutritionType.getId());
            getAllNutritionResponse.setHealthScore(nutrition.getHealthScore());
            responses.add(getAllNutritionResponse);
        }
        return responses;
    }
}
