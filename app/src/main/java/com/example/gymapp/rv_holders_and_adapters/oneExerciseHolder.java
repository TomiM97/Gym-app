package com.example.gymapp.rv_holders_and_adapters;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.R;
import com.example.gymapp.fragments.ListExercisesActivity;
import com.jjoe64.graphview.GraphView;

public class oneExerciseHolder extends RecyclerView.ViewHolder {

    public TextView exerciseName;
    public Button rvChoose;
    private int listener;

    public oneExerciseHolder(@NonNull View itemView) {
        super(itemView);
        exerciseName = itemView.findViewById(R.id.exerciseName);
        rvChoose = itemView.findViewById(R.id.rvChoose);
        GraphView graphView = itemView.findViewById(R.id.progressgraph);
    }

    public void DataPoints(int x, float y){
        ListExercisesActivity.getDatapointX(x);
        ListExercisesActivity.getDatapointY(y);
    }
    public int setListener(int listener){
        return ListExercisesActivity.Listener(listener);}


}


