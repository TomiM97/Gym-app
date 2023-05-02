package com.example.gymapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Exercise implements Serializable {
    public ArrayList<Float> workoutWeights;
    public int sets;
    public ArrayList<Integer> reps;
    public Date date;
    public String exerciseName;

    public Exercise(ArrayList<Float> workoutWeights, int sets, ArrayList<Integer> reps, String exerciseName, Date date) {
        this.workoutWeights = workoutWeights;
        this.sets = sets;
        this.reps = reps;
        this.exerciseName = exerciseName;
        this.date = date;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public ArrayList<Integer> getReps() {
        return reps;
    }

    public ArrayList<Float> getWorkoutWeights() {
        return workoutWeights;
    }


    public Date getDate() {
        return date;
    }
}



