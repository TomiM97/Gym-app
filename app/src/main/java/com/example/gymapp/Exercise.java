package com.example.gymapp;

import java.util.ArrayList;
import java.util.Date;

public class Exercise {
    public ArrayList<Float> workoutWeights;
    public int sets;
    public Date date;
    public ArrayList<Integer> reps;
    public String exerciseName;
    private static Exercise exerciseListInsanse = null;

    public Exercise(ArrayList<Float> workoutWeights, int sets, ArrayList<Integer> reps, String exerciseName, Date date) {
        this.workoutWeights = workoutWeights;
        this.sets = sets;
        this.reps = reps;
        this.exerciseName = exerciseName;
        this.date = date;
    }

    public Exercise() {}

    public static Exercise getInstance() {
        if (exerciseListInsanse == null) {
            exerciseListInsanse = new Exercise();
        }
        return exerciseListInsanse;
    }

    public String getExerciseName() { return exerciseName; }
    public int getSets() { return sets; }
    public ArrayList<Integer> getReps() { return reps; }
    public ArrayList<Float> getWorkoutWeights() { return workoutWeights; }
}
