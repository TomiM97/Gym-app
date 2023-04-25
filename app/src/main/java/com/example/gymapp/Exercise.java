package com.example.gymapp;

public class Exercise {
    public float workoutWeights;
    public int sets;
    public int reps;
    public String workoutName;
    private static Exercise shoppingListInstance = null;

    public Exercise(float workoutWeights, int sets, int reps, String workoutName) {
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
