package com.example.gymapp.fragments;

public class XYplotValues {
    private double x;
    private double y;
    public XYplotValues(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public <T> Comparable getItem() {
        return null;
    }
}
