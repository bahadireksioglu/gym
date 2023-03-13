package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.*;
import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.repository.MealRepository;
import com.pinsoft.gym.utils.ModelMapperImpl;
import com.pinsoft.gym.utils.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService{
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    @Autowired
    private ModelMapper modelMapper;

    //create
    @Override
    public void createMeal(CreateMealRequest createMealRequest) {
        Meal createdMeal = this.modelMapperService.forRequest().map(createMealRequest, Meal.class);
         this.mealRepository.save(createdMeal);
    }


    // get all
    @Override
    public List<GetAllMealResponse> getAll() {
        List<Meal> meals = mealRepository.findAll();

        List<GetAllMealResponse> mealsResponse = meals.stream().map(
                meal -> this.modelMapperService.forResponse().map(
                        meal, GetAllMealResponse.class
                )
        ).collect(Collectors.toList());

        return mealsResponse;
    }


    //get by id
    @Override
    public GetByIdMealResponse getById(Integer id) {
        Meal meal = this.mealRepository.findById(id).orElseThrow();

        GetByIdMealResponse response = this.modelMapperService.forResponse().map(
                meal, GetByIdMealResponse.class
        );
        return response;
    }


    //get by name
    @Override
    public GetByNameMealResponse getByName(String name) {
        Meal meal = this.mealRepository.findByName(name).orElseThrow();

        GetByNameMealResponse response = this.modelMapperService.forResponse().map(
                meal, GetByNameMealResponse.class
        );
        return response;
    }


    //update
    @Override
    public void updateMeal(Integer id, UpdateMealRequest updateMealRequest) {
        Optional<Meal> meal = mealRepository.findById(id);
        if(meal.isPresent()){
            meal.get().setName(updateMealRequest.getName());
          //  meal.get().setMealList(updateMealRequest.getMealList());

              modelMapper.map(mealRepository.save(meal.get()), UpdateMealRequest.class);

        } else{
            this.mealRepository.findAll();
        }
    }


    //delete
    @Override
    public void deleteMeal(Integer id) {
        this.mealRepository.deleteById(id);
    }


}
