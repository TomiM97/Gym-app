package com.example.gymapp;

import java.util.ArrayList;
import java.util.Date;

public class Exercise {
    public ArrayList<Float> workoutWeights;
    public int sets;
    public Date date;
    public ArrayList<Integer> reps;
    public String exerciseName;
    private static Exercise exerciseListInstance = null;

    public Exercise(ArrayList<Float> workoutWeights, int sets, ArrayList<Integer> reps, String exerciseName, Date date) {
        this.workoutWeights = workoutWeights;
        this.sets = sets;
        this.reps = reps;
        this.exerciseName = exerciseName;
        this.date = date;
    }

    public Exercise() {}

    public static Exercise getInstance() {
        if (exerciseListInstance == null) {
            exerciseListInstance = new Exercise();
        }
        return exerciseListInstance;
    }

    public String getExerciseName() { return exerciseName; }
    public int getSets() { return sets; }
    public ArrayList<Integer> getReps() { return reps; }
    public ArrayList<Float> getWorkoutWeights() { return workoutWeights; }
    public float getMaxWeight(){
        float weightMax = 0;
        for (int x=0;x<getWorkoutWeights().size();x++){
            if (weightMax > getWorkoutWeights().get(x)){
                weightMax = workoutWeights.get(0);
            } else{
                    weightMax = getWorkoutWeights().get(x);
                }
            }
        return weightMax;
        }
    }

