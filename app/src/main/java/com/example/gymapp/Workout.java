package com.example.gymapp;

import android.content.Context;

import com.example.gymapp.rv_holders_and_adapters.NewWorkoutRVAdapter;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Workout implements Serializable {
    private static Workout workoutInstance = null;
    public ArrayList<Exercise> exercises;
    public ArrayList<Exercise> tempExercises;
    public String workoutType;
    public Time workoutTime;
    public Date workoutDate;
    public Context context;

    public Workout() {
        exercises = new ArrayList<Exercise>();
        tempExercises = new ArrayList<Exercise>();
    }

    public Workout(String workoutType, Date workoutDate, ArrayList<Exercise> exercises) {
        this.workoutDate = workoutDate;
        this.workoutType = workoutType;
        this.exercises = exercises;
    }

    public static Workout getInstance() {
        if (workoutInstance == null) {
            workoutInstance = new Workout();
        }
        return workoutInstance;
    }
    public void addTempExercise(Exercise exercise) {
        tempExercises.add(exercise);
    }
    public void clearTempExercises() {
        tempExercises.clear();
    }
    public void addExercise(ArrayList<Exercise> tempExercises) {
        exercises.addAll(tempExercises);
    }

    public ArrayList<Exercise> getExercises() { return exercises; }
    public ArrayList<Exercise> getTempExercises() { return tempExercises; }

    public String getWorkoutType() { return workoutType; }
    public ArrayList<String> getExerciseNamesForDropDownMenu(ArrayList<Exercise> exercises) {
        ArrayList<String> exerciseNames = new ArrayList<>();
        for(int i = 0; i < exercises.size(); i++ ) {
            Boolean addToList = true;
            for(int i2 = 0; i2 < exerciseNames.size(); i2++)  {
                if (exerciseNames.get(i2).equals(exercises.get(i).getExerciseName())) {
                    addToList = false;
                }
            }
            if(addToList) {
                exerciseNames.add(exercises.get(i).getExerciseName());
            }
        }
        return exerciseNames;
    }

}
