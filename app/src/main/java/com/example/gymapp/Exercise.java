package com.example.gymapp;

public class Exercise {
    public float workoutWeights;
    public int sets;
    public int reps;
    public String workoutName;

    public Exercise(float workoutWeights, int sets, int reps, String workoutName) {
        this.workoutWeights = workoutWeights;
        this.sets = sets;
        this.reps = reps;
        this.workoutName = workoutName;
    }

}
