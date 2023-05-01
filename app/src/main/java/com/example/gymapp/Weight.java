package com.example.gymapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Weight implements Serializable {
    public ArrayList<Date> dates = new ArrayList<>();
    public ArrayList<Float> weightFloats = new ArrayList<>();
    public Float weightFloat;
    public Date date;

    public Weight(Float weight, Date date) {
        this.weightFloat = weight;
        this.date = date;
    }

    public Float getWeightFloat() {
        return this.weightFloat;
    }

    public Date getDate() {
        return this.date;
    }

    public ArrayList<Date> getDates() {return dates;}

    public ArrayList<Float> getWeightFloats() {return weightFloats;}

}
