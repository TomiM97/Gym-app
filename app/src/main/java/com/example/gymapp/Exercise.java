package com.example.gymapp;

import java.util.ArrayList;

public class Exercise {
    public ArrayList<Float> workoutWeights;
    public int sets;
    public ArrayList<Integer> reps;
    public String workoutName;
    private static Exercise shoppingListInstance = null;

    public Exercise(ArrayList<Float> workoutWeights, int sets, ArrayList<Integer> reps, String workoutName) {
        this.workoutWeights = workoutWeights;
        this.sets = sets;
        this.reps = reps;
        this.workoutName = workoutName;
    }

    public Exercise() {}

    public static Exercise getInstance() {
        if (shoppingListInstance == null) {
            shoppingListInstance = new Exercise();
        }
        return shoppingListInstance;
    }

}
