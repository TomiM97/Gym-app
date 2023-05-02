package com.example.gymapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Weight implements Serializable {
    public Float weightFloat;
    public Date date;

    public Weight(Float weight, Date date) {
        this.weightFloat = weight;
        this.date = date;
    }

}
