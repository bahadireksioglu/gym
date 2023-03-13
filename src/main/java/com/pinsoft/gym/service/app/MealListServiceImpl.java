package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.*;
import com.pinsoft.gym.model.Meal;
import com.pinsoft.gym.model.MealList;
import com.pinsoft.gym.model.Nutrition;
import com.pinsoft.gym.repository.MealListRepository;
import com.pinsoft.gym.utils.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MealListServiceImpl implements MealListService{

    @Autowired
    private MealListRepository mealListRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Autowired
    private ModelMapper modelMapper;


    //create
    @Override
    public void createMealList(CreateMealListRequest createMealListRequest) {
        Set<Nutrition> nutritions = new HashSet<>();
        MealList createdMealList = this.modelMapperService.forRequest().map(createMealListRequest, MealList.class );
        nutritions.add(createdMealList.getNutrition());
        this.mealListRepository.save(createdMealList);

    }


    //get all
    @Override
    public List<GetAllMealListResponse> getAll() {
        List<MealList> mealLists = mealListRepository.findAll();
        List<GetAllMealListResponse> mealListResponses = mealLists.stream().map(
                mealList -> this.modelMapperService.forResponse().map(
                        mealList, GetAllMealListResponse.class
                )
        ).collect(Collectors.toList());
        return mealListResponses;
    }

    //get by id
    @Override
    public GetByIdMealListResponse getById(Integer id) {
        MealList mealList = mealListRepository.findById(id).orElseThrow();
        GetByIdMealListResponse response = modelMapperService.forResponse().map(
                mealList, GetByIdMealListResponse.class
        );
        return response;
    }

    @Override
    public void updateMealList(Integer id, UpdateMealListRequest updateMealListRequest) {
        Optional<MealList> mealList = mealListRepository.findById(id);
        if(mealList.isPresent()){
            mealList.get().setWeight(updateMealListRequest.getWeight());

            modelMapper.map(mealListRepository.save(mealList.get()), UpdateMealListRequest.class);

        } else{
            mealListRepository.findAll();
        }
    }


    @Override
    public void deleteMealList(Integer id) {
        mealListRepository.deleteById(id);
    }

    @Override
    public Double getFat(Integer id, MealList mealList) {
        return mealListRepository.findById(id).get().getNutrition().getFat();
    }

    @Override
    public Double getProtein(Integer id, MealList mealList) {
        return mealListRepository.findById(id).get().getNutrition().getProtein();
    }

    @Override
    public Double getCarbonhydrate(Integer id, MealList mealList) {
        return mealListRepository.findById(id).get().getNutrition().getCarbohydrate();
    }



}
