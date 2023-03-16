package com.pinsoft.gym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","nutrition"})
@Table(name="meal_list",schema = "public")
public class MealList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="meal_id")
    private Meal meal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="nutrition_id")
    private Nutrition nutrition;

    @Column(name = "weight")
    private Double weight;
    @Column(name = "create_date")
    private LocalDateTime createdDate;
}
