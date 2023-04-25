package com.example.gymapp;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Workout {
    private static Workout workoutInstance = null;
    public ArrayList<Exercise> exercises;
    public String workoutType;
    public Time workoutTime;
    public Date workoutDate;

    public Workout() {}

    public Workout(String workoutType, Time workoutTime, Date workoutDate) {
        this.workoutType = workoutType;
        this.workoutTime = workoutTime;
        this.workoutDate = workoutDate;
    }

    public static Workout getInstance() {
        if (workoutInstance == null) {
            workoutInstance = new Workout();
        }
        return workoutInstance;
    }
    public void addExercise(Exercise exercise) { exercises.add(exercise); }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
