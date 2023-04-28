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
import com.jjoe64.graphview.series.PointsGraphSeries;

public class ListExercisesActivity extends AppCompatActivity {

    int x = 0;
    float y = 0;
    private GraphView graphView;

    private RecyclerView view;

    public ListExercisesActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_all_exerciseslist);
        Workout workout = Workout.getInstance();
        int z = getDatapointX(x);
        float i = getDatapointY(y);
        view = findViewById(R.id.rvExerciselist);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new oneExerciseAdapter(getApplicationContext(), workout.getExercises()));
        GraphView graphView = findViewById(R.id.progressgraph);
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>();
        series.appendData(new DataPoint(z,i),true,90);
        graphView.addSeries(series);
    }
    public static int getDatapointX(int x){return x;}
    public static float getDatapointY(float y){return y;}

}






