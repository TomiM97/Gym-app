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

public class ListExercisesActivity extends AppCompatActivity implements MyListener{

    private MyListener myListener;
    private static final String TAG = "MainActivity";
    PointsGraphSeries<DataPoint> xySeries;
    private Button btnRvchoose;
    GraphView ScatterPlot;
    private ArrayList<XYplotValues> xYplotValuearray;
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


    private void init(int pos){
        xySeries = new PointsGraphSeries<>();
        Log.d(TAG, "tullaanko tänne nro4");

        for (int i=0; i < Workout.getInstance().exercises.get(pos).sets; i++) {
            double x = i;
            double y = Workout.getInstance().getExercises().get(pos).workoutWeights.get(i);
                    Log.d(TAG, "onClick: lisätään pisteet (x,y) " + pos + ", " + y + ")");
                    xYplotValuearray.add(new XYplotValues(x, y));
        }
            if (xYplotValuearray.size() != 0) {
                createScatterplot();
            } else {
                Log.d(TAG, "Ei dataa kuvaan");
            }
                }

    private void createScatterplot() {
        Log.d(TAG, "Tehdään kuva!");
        //järjestetään lista...
        //sortArray(xYplotValuearray);
        for(int i = 0; i < xYplotValuearray.size(); i++) {
            try {
                double x = xYplotValuearray.get(i).getX();
                double y = xYplotValuearray.get(i).getY();
                xySeries.appendData(new DataPoint(x,y),true,1000);
            } catch (IllegalArgumentException e){
                Log.e(TAG, "Tehdään kuvaa: IllegalArgumentException" + e.getMessage());
            }
        }
        xySeries.setShape(PointsGraphSeries.Shape.TRIANGLE);
        xySeries.setColor(Color.BLACK);


        ScatterPlot.addSeries(xySeries);

    }

}




