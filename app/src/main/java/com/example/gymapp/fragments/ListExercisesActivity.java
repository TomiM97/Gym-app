package com.example.gymapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.R;
import com.example.gymapp.Workout;
import com.example.gymapp.rv_holders_and_adapters.oneExerciseAdapter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class ListExercisesActivity extends AppCompatActivity {


    private Workout workout;
    private RecyclerView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_all_exerciseslist);
        workout = Workout.getInstance();

        view = findViewById(R.id.rvExerciselist);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new oneExerciseAdapter(getApplicationContext(), workout.getExercises()));

    };
    }


