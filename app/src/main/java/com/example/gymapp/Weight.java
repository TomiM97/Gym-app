package com.example.gymapp;

import java.util.ArrayList;
import java.util.Date;

public class Weight {

    public ArrayList<Float> weightList = new ArrayList<>();;
    public ArrayList<Date> weightDates = new ArrayList<>();
    private Float weightFloat;
    private Date date;
    private static Weight weight = null;

    public Weight() {}

    public Weight(Float weight, Date date) {
        this.weightFloat = weight;
        this.date = date;
    }

    public static Weight getInstance() {
        if (weight == null) {
            weight = new Weight();
        }
        return weight;
    }

    public void addWeight(Weight weight) {
        this.weightList.add(weight.weightFloat);
        this.weightDates.add(weight.date);
    }

}
