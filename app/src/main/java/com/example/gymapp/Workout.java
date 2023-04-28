package com.example.gymapp;

import android.content.Context;

import com.example.gymapp.rv_holders_and_adapters.NewWorkoutRVAdapter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Workout {
    private static Workout workoutInstance = null;
    public ArrayList<Exercise> exercises;
    public String workoutType;
    public Time workoutTime;
    public Date workoutDate;
    private Context context;

    public Workout() {
        exercises = new ArrayList<Exercise>();
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
    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        NewWorkoutRVAdapter newWorkoutRVAdapter = new NewWorkoutRVAdapter(context, exercises);
        newWorkoutRVAdapter.notifyDataSetChanged();
    }

    public ArrayList<Exercise> getExercises() { return exercises; }

    public String getWorkoutType() { return workoutType; }
    public ArrayList<String> getExerciseNames(ArrayList<Exercise> exercises) {
        ArrayList<String> exerciseNames = new ArrayList<>();
        for(int i = 0; i < exercises.size(); i++ ) {
            exerciseNames.add(exercises.get(i).getExerciseName());
        }
        return exerciseNames;
    }
}
