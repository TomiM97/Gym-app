package com.example.gymapp;

import java.util.ArrayList;
import java.util.Date;

public class Weight {

    public ArrayList<Weight> weights = new ArrayList<>();
    public ArrayList<Date> dates = new ArrayList<>();
    public ArrayList<Float> weightFloats = new ArrayList<>();
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
        weights.add(weight);
        dates.add(weight.date);
        weightFloats.add(weight.weightFloat);
    }

    public ArrayList<Weight> getWeights() {return weights;}

    public Float getWeightFloat() {
        return this.weightFloat;
    }

    public Date getDate() {
        return this.date;
    }

    public ArrayList<Date> getDates() {return dates;}

    public ArrayList<Float> getWeightFloats() {return weightFloats;}

}
