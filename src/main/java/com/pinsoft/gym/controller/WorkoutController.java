package com.pinsoft.gym.controller;

import com.pinsoft.gym.dto.workoutDto.requests.CreateWorkoutRequest;
import com.pinsoft.gym.dto.workoutDto.requests.UpdateWorkoutRequest;
import com.pinsoft.gym.dto.workoutDto.responses.GetAllWorkoutResponse;
import com.pinsoft.gym.dto.workoutDto.responses.GetByIdWorkoutResponse;
import com.pinsoft.gym.service.app.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
@AllArgsConstructor
@PreAuthorize("hasRole('USER')")
public class WorkoutController {
    private WorkoutService workoutService;

    @GetMapping("/getAll")
   public List<GetAllWorkoutResponse> getAll(){
       return workoutService.getAll();
   }
    @GetMapping()
    public GetByIdWorkoutResponse getById(@PathVariable int id){
        return workoutService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() CreateWorkoutRequest createWorkoutRequest){
        this.workoutService.add(createWorkoutRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateWorkoutRequest updateWorkoutRequest){
        this.workoutService.update(updateWorkoutRequest);
    }
    @DeleteMapping()
    public void delete(@PathVariable int id){
        this.workoutService.delete(id);
    }
}
