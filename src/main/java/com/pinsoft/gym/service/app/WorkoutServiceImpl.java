package com.pinsoft.gym.service.app;

import com.pinsoft.gym.dto.workoutDto.requests.CreateWorkoutRequest;
import com.pinsoft.gym.dto.workoutDto.requests.UpdateWorkoutRequest;
import com.pinsoft.gym.dto.workoutDto.responses.GetAllWorkoutResponse;
import com.pinsoft.gym.dto.workoutDto.responses.GetByIdWorkoutResponse;
import com.pinsoft.gym.model.Workout;
import com.pinsoft.gym.repository.WorkoutRepository;
import com.pinsoft.gym.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class WorkoutServiceImpl implements WorkoutService{

    private WorkoutRepository workoutRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllWorkoutResponse> getAll() {

        List<Workout> workouts = workoutRepository.findAll();

        List<GetAllWorkoutResponse> workoutResponse = workouts.stream()
                .map(workout -> this.modelMapperService.forResponse().map(workout,GetAllWorkoutResponse.class)).collect(Collectors.toList());
        return workoutResponse;
    }

    @Override
    public GetByIdWorkoutResponse getById(int id) {
        Workout workout = this.workoutRepository.findById(id).orElseThrow();

        GetByIdWorkoutResponse response = this.modelMapperService.forResponse().map(workout, GetByIdWorkoutResponse.class);
        return response;
    }

    @Override
    public void add(CreateWorkoutRequest createWorkoutRequest) {

         Workout workout = this.modelMapperService.forRequest().map(createWorkoutRequest, Workout.class);
         this.workoutRepository.save(workout);
    }

    @Override
    public void update(UpdateWorkoutRequest updateWorkoutRequest) {
         Workout workout = this.modelMapperService.forRequest().map(updateWorkoutRequest, Workout.class);
         this.workoutRepository.save(workout);
    }

    @Override
    public void delete(int id) {
    this.workoutRepository.deleteById(id);
    }
}
