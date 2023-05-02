package com.example.gymapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.R;
import com.example.gymapp.Workout;
import com.example.gymapp.rv_holders_and_adapters.MyListener;
import com.example.gymapp.rv_holders_and_adapters.oneExerciseAdapter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListExercisesActivity extends AppCompatActivity implements MyListener{

    private MyListener myListener;
    private static final String TAG = "MainActivity";
    PointsGraphSeries<DataPoint> xySeries;
    private Button btnRvchoose;
    GraphView ScatterPlot;
    private ArrayList<XYplotValues> xYplotValuearray = new ArrayList<>();
    private RecyclerView view;

    int pos;
    public int onButtonClick(int position) {
        pos = position;
        return pos;
    }

    @Override
    public void setMyListener() {

    }

    public ListExercisesActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_all_exerciseslist);
        Workout workout = Workout.getInstance();

        ScatterPlot = (GraphView) findViewById(R.id.progressgraph);
        view = findViewById(R.id.rvExerciselist);
        btnRvchoose = view.findViewById(R.id.rvChoose);

        xYplotValuearray = new ArrayList<>();
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new oneExerciseAdapter(getApplicationContext(),workout.getExercises()));
        oneExerciseAdapter adapter = new oneExerciseAdapter(getApplicationContext(),workout.getExercises());

        adapter.setMyListener(new MyListener() {
            @Override
            public int onButtonClick(int position) {
                pos = position;
                init(pos);
                return pos;
            }

            @Override
            public void setMyListener() {
            }

        });

        view.setAdapter(adapter);
    }
    //in the method init(), datapoints are collected from the exercises sets&reps to arraylist
    private void init(int pos){
        xYplotValuearray.clear();

        ScatterPlot.removeAllSeries();
        xySeries = new PointsGraphSeries<>();

        for (int i=0; i < Workout.getInstance().exercises.size(); i++) {
                if (Workout.getInstance().exercises.get(pos).exerciseName.equals(Workout.getInstance().exercises.get(i).getExerciseName())){
                    int i2 = Workout.getInstance().exercises.get(i).sets;
                    for(int d=0; d < i2; d++){
                        double y = Workout.getInstance().getExercises().get(pos).workoutWeights.get(d);
                        Log.d(TAG, "onClick: adding points (x,y) " + d + ", " + y + ")");
                        xYplotValuearray.add(new XYplotValues(d, y));
                        if(i != pos) {
                            double y2 = Workout.getInstance().getExercises().get(i).workoutWeights.get(d);
                            Log.d(TAG, "onClick: adding another points (x,y) " + (d+i2) + ", " + y2 + ")");
                            xYplotValuearray.add(new XYplotValues((d+i2), y2));
                        }
                    }
                }
        }
            if (xYplotValuearray.size() != 0) {
                createScatterplot();
            } else {
                Log.d(TAG, "no data for graph");
            }
                }

    private void createScatterplot() {
        Log.d(TAG, "Creating the graph");

        for(int i = 0; i < xYplotValuearray.size(); i++) {
            try {
                double x = xYplotValuearray.get(i).getX();
                double y = xYplotValuearray.get(i).getY();
                xySeries.appendData(new DataPoint(x,y),true,1000);
            } catch (IllegalArgumentException e){
                Log.e(TAG, "exception log: IllegalArgumentException" + e.getMessage());
            }
        }
        xySeries.setShape(PointsGraphSeries.Shape.TRIANGLE);
        xySeries.setColor(Color.BLACK);
        ScatterPlot.getViewport().setScalable(true);
        ScatterPlot.getViewport().setScalableY(true);
        ScatterPlot.getViewport().setXAxisBoundsManual(true);
        ScatterPlot.getViewport().setMaxX(20);
        ScatterPlot.getViewport().setMinX(0);

        ScatterPlot.getViewport().setYAxisBoundsManual(true);
        ScatterPlot.getViewport().setMaxY(300);
        ScatterPlot.getViewport().setMinY(0);
        ScatterPlot.addSeries(xySeries);

    }

}




