package com.example.gymapp;

import java.util.ArrayList;
import java.util.Date;

public class User {
    public ArrayList<Workout> workouts;
    public float bmi;
    public float weight;
    public float height;
    public int age;
    public Date birthDay;

    public User(float weight, float height, Date birthDay) {
        this.weight = weight;
        this.height = height;
        this.birthDay = birthDay;
        this.bmi = weight/(height*height);
        //TODO this.age =
    }


    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
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
