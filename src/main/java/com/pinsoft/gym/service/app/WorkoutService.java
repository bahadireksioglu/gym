package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.workoutDto.requests.CreateWorkoutRequest;
import com.pinsoft.gym.dto.workoutDto.requests.UpdateWorkoutRequest;
import com.pinsoft.gym.dto.workoutDto.responses.GetAllWorkoutResponse;
import com.pinsoft.gym.dto.workoutDto.responses.GetByIdWorkoutResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkoutService {
    List<GetAllWorkoutResponse> getAll();
    GetByIdWorkoutResponse getById(int id);
    void add(CreateWorkoutRequest createWorkoutRequest);
    void update(UpdateWorkoutRequest updateWorkoutRequest);
    void delete(int id);



}
