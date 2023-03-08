package com.pinsoft.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalorieRequest {

    private int age;
    private int size;
    private int weight;

    private String gender;
}
