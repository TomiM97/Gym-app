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
    public ArrayList<Weight> weightList = new ArrayList<>();
    private static User user = null;

    public User() {}

    public static User getInstance() {
        if(user == null) {
            user = new User();
        }
        return user;
    }


    public void addWorkoutsToList(Workout workout) {workouts.add(workout);}


    public void addWeight(Weight weight) {
        weightList.add(weight);
    }

    public ArrayList<Weight> getWeightList() {
        return this.weightList;
    }

    public void loadWeightData(Context context) {
        try {
            ObjectInputStream groceryReader = new ObjectInputStream(context.openFileInput("weight.data"));
            weightList = (ArrayList<Weight>) groceryReader.readObject();
            groceryReader.close();
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
            ObjectOutputStream groceriesWriter = new ObjectOutputStream(context.openFileOutput("weight.data", Context.MODE_PRIVATE));
            groceriesWriter.writeObject(weightList);
            groceriesWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Kehonpainojen tallentaminen epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Kehonpainojen tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }
}
