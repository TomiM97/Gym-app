package com.example.gymapp.fragments;

import android.os.Bundle;

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

    private GraphView graphView;

    private RecyclerView view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_all_exerciseslist);
        Workout workout = Workout.getInstance();
        view = findViewById(R.id.rvExerciselist);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new oneExerciseAdapter(getApplicationContext(), workout.getExercises()));
        GraphView graphView = findViewById(R.id.progressgraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        double y;
        for (int x=0;x<90; x++){
            y = Math.sin(2*x*0.2)-2*Math.sin(x*0.2);
            series.appendData(new DataPoint(x,y),true,90);
        }
        graphView.addSeries(series);
    }

}






