package com.example.gymapp;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Workout {
    public ArrayList<Exercise> exercises;
    public String workoutType;
    public Time workoutTime;
    public Date workoutDate;

    public Workout(String workoutType, Time workoutTime, Date workoutDate) {
        this.workoutType = workoutType;
        this.workoutTime = workoutTime;
        this.workoutDate = workoutDate;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
