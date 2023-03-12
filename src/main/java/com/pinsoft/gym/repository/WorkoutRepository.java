package com.pinsoft.gym.repository;

import com.pinsoft.gym.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkoutRepository extends JpaRepository <Workout, Integer> {


}
