package com.example.gymapp;

import android.content.Context;
import android.os.Build;

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
    public int age;
    public Date birthDay;
    private Date dateNow;
    private static User user = null;

    public User() {}
    public User(float weight, float height, Date birthDay) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dateNow = new Date();
        }
        this.weight = new Weight(weight, dateNow);
        addWeight(this.weight);
        this.height = height;
        this.birthDay = birthDay;
        this.bmi = weight/(height*height);
        //TODO this.age =
    }

    public static User getInstance() {
        if(user == null) {
            user = new User();
        }
        return user;
    }


    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
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

    public void loadWorkoutData(Context context) {
        try {
            ObjectInputStream groceryReader = new ObjectInputStream(context.openFileInput("workouts.data"));
            workouts = (ArrayList<Workout>) groceryReader.readObject();
            groceryReader.close();
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

    public void saveWorkoutData(Context context) {
        try {
            ObjectOutputStream groceriesWriter = new ObjectOutputStream(context.openFileOutput("workouts.data", Context.MODE_PRIVATE));
            groceriesWriter.writeObject(workouts);
            groceriesWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Treenien tallentaminen epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Treenien tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void saveWeightData(Context context) {
        try {
            ObjectOutputStream groceriesWriter = new ObjectOutputStream(context.openFileOutput("weight.data", Context.MODE_PRIVATE));
            groceriesWriter.writeObject(weightList);
            groceriesWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ostosten tallentaminen epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ostosten tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }
}
