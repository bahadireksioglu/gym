package com.pinsoft.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","nutritionType"})
@Table(name = "nutrition", schema = "public")
public class Nutrition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "kcal")
    private Double kcal;
    @Column(name = "protein")
    private Double protein;
    @Column(name = "carbohydrate")
    private Double carbohydrate;
    @Column(name = "fat")
    private Double fat;
    @Column(name = "base_weight")
    private Double baseWeight;
    @Column(name="health_score")
    private Integer healthScore;
    @ManyToOne
    @JoinColumn(name="nutrition_type_id")
    private NutritionType nutritionType;
    @OneToMany(mappedBy = "nutrition")
    private Set<MealList> mealList;
}
