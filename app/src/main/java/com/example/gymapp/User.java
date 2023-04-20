package com.example.gymapp;

import java.util.ArrayList;
import java.util.Date;

public class User {
    public ArrayList<Workout> workouts;
    public float bmi;
    public float weight;
    public float height;
    public int age;
    public Date birthDay;

    public User(float weight, float height, Date birthDay) {
        this.weight = weight;
        this.height = height;
        this.birthDay = birthDay;
        this.bmi = weight/(height*height);
        //TODO this.age =
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public float getBmi() {
        return bmi;
    }
}
