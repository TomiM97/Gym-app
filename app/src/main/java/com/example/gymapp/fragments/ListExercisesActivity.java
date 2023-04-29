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
        double y = Workout.getInstance().getExercises().get(pos).getMaxWeight();
                    Log.d(TAG, "onClick: lisätään pisteet (x,y) " + pos + "," + y + ")");
                    xYplotValuearray.add(new XYplotValues(pos,y));
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

    private ArrayList<XYplotValues> sortArray(ArrayList<XYplotValues> array) {
        int factor = Integer.parseInt(String.valueOf(Math.round((Math.pow(array.size(),2)))));
        int m = array.size() - 1;
        int count = 0;
        Log.d(TAG,"Järjestetään lista");
            while(true) {
                m--;
                if (m <= 0) {
                    m = array.size() - 1;
                }
                try {
                    double tempY = array.get(m - 1).getY();
                    double tempX = array.get(m - 1).getX();
                    if (tempX > array.get(m).getX()) {
                        array.get(m - 1).setY(array.get(m).getY());
                        array.get(m).setY(tempY);
                        array.get(m - 1).setX(array.get(m).getX());
                        array.get(m).setX(tempX);
                    } else if (tempX == array.get(m).getX()) {
                        count++;
                        Log.d(TAG, "sortArray" + count);
                    } else if (array.get(m).getX() > array.get(m - 1).getX()) {
                        count++;
                        Log.d(TAG, "sortArray" + count);
                    }
                    if (count == factor) {
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    Log.e(TAG, "sortArray: ArrayIndexOutOfBoundsException, tarvitaan enemmän kuin yksi datapiste" + e.getMessage());
                }
            }
            return array;
   }
}




