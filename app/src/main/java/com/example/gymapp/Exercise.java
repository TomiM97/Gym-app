package com.example.gymapp;

import java.util.ArrayList;

public class Exercise {
    public ArrayList<Float> workoutWeights;
    public int sets;
    public ArrayList<Integer> reps;
    public String exerciseName;
    private static Exercise shoppingListInstance = null;

    public Exercise(ArrayList<Float> workoutWeights, int sets, ArrayList<Integer> reps, String exerciseName) {
        this.workoutWeights = workoutWeights;
        this.sets = sets;
        this.reps = reps;
        this.exerciseName = exerciseName;
    }

    public Exercise() {}

    public static Exercise getInstance() {
        if (shoppingListInstance == null) {
            shoppingListInstance = new Exercise();
        }
        return shoppingListInstance;
    }

    public String getExerciseName() { return exerciseName; }
    public int getSets() { return sets; }
    public ArrayList<Integer> getReps() { return reps; }
    public ArrayList<Float> getWorkoutWeights() { return workoutWeights; }
}
