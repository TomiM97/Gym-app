package com.example.gymapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class User {
    public ArrayList<Workout> workouts = new ArrayList<>();
    public float bmi;
    public Weight weight;
    public ArrayList<Weight> weightList = new ArrayList<>();
    public float height;
    private static User user = null;

    public User() {}

    public static User getInstance() {
        if(user == null) {
            user = new User();
        }
        return user;
    }


    public void addWorkoutsToList(Workout workout) {workouts.add(workout);}

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }



    public float getBmi() {
        return bmi;
    }

    public void addWeight(Weight weight) {
        weightList.add(weight);
    }

    public ArrayList<Weight> getWeightList() {
        return this.weightList;
    }


    public void loadWeightData(Context context) {
        try {
            ObjectInputStream weightReader = new ObjectInputStream(context.openFileInput("weight.data"));
            weightList = (ArrayList<Weight>) weightReader.readObject();
            weightReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Kehonpainojen lataaminen epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Kehonpainojen lataaminen epäonnistui");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Kehonpainojen lataaminen epäonnistui");
            e.printStackTrace();
        }
    }


    public void saveWeightData(Context context) {
        try {
            ObjectOutputStream weightWriter = new ObjectOutputStream(context.openFileOutput("weight.data", Context.MODE_PRIVATE));
            weightWriter.writeObject(weightList);
            weightWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Kehonpainojen tallentaminen epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Kehonpainojen tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }
}
