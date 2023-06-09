package com.example.gymapp;

import android.content.Context;

import com.example.gymapp.rv_holders_and_adapters.NewWorkoutRVAdapter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Workout implements Serializable {
    private static Workout workoutInstance = null;
    public ArrayList<Exercise> exercises;
    public ArrayList<Exercise> tempExercises;
    public String workoutType;
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
    public void removeOneTempExercise(int position) {
        tempExercises.remove(position);
    }
    public void addExercise(ArrayList<Exercise> tempExercises) {
        exercises.addAll(tempExercises);
    }

    public ArrayList<Exercise> getExercises() { return exercises; }
    public ArrayList<Exercise> getTempExercises() { return tempExercises; }

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
    public void saveWorkoutData(Context context) {
        try {
            ObjectOutputStream workoutWriter = new ObjectOutputStream(context.openFileOutput("workouts.data", Context.MODE_PRIVATE));
            workoutWriter.writeObject(exercises);
            workoutWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Treenien tallentaminen epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Treenien tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void loadWorkoutData(Context context) {
        try {
            ObjectInputStream workoutReader = new ObjectInputStream(context.openFileInput("workouts.data"));
            exercises = (ArrayList<Exercise>) workoutReader.readObject();
            workoutReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Treenien lataaminen epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Treenien lataaminen epäonnistui");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Treenien lataaminen epäonnistui");
            e.printStackTrace();
        }
    }

}
