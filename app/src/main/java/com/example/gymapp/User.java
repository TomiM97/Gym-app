package com.example.gymapp;

import android.os.Build;

import java.util.ArrayList;
import java.util.Date;

public class User {
    public ArrayList<Workout> workouts = new ArrayList<>();
    public float bmi;
    public Weight weight;
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
        Weight.getInstance().addWeight(this.weight);
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
}
