package com.pinsoft.gym.dto.workoutDto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkoutRequest {
    private String exerciseName;

    private String exerciseDescription;

    private String exerciseType;

    private String exerciseDifficulty;

    private int burnedCalorie;
}
