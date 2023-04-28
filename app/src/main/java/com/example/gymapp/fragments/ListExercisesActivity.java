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



    private GraphView graphView;

    private RecyclerView view;

    public ListExercisesActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_all_exerciseslist);
        Workout workout = Workout.getInstance();

        
        view = findViewById(R.id.rvExerciselist);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new oneExerciseAdapter(getApplicationContext(), workout.getExercises()));
        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>();
        int listening = 0;
        for (int x=0;x<10; x++) {
            series.appendData(new DataPoint(x, workout.exercises.get(Listener(listening)).getMaxWeight()), true, 90);
        }
        GraphView graphView = findViewById(R.id.progressgraph);
        graphView.addSeries(series);
    }
    public static int getDatapointX(int x){return x;}
    public static float getDatapointY(float y){return y;}

    public static int Listener(int listening) {return listening;
    }
}






