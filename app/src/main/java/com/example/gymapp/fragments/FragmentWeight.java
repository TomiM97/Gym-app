package com.example.gymapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gymapp.MainActivity;
import com.example.gymapp.R;
import com.example.gymapp.Weight;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class FragmentWeight extends Fragment {
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight, container, false);
        EditText editWeight = view.findViewById(R.id.editWeight);
        EditText editDate = view.findViewById(R.id.editDate);
        Button btnAddWeight = view.findViewById(R.id.btnAddWeight);
        GraphView weightGraph = view.findViewById(R.id.weightGraph);
        weightGraph.getGridLabelRenderer().setHorizontalLabelsAngle(45);
        weightGraph.getGridLabelRenderer().setVerticalAxisTitle("Paino (kg)");
        weightGraph.getGridLabelRenderer().setHorizontalAxisTitle("Päivämäärä");



        btnAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float inputWeight = Float.parseFloat(editWeight.getText().toString());
                String inputDate = editDate.getText().toString();
                Date date1;
                try {
                    date1=new SimpleDateFormat("dd.MM.yyyy").parse(inputDate);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Weight weight = new Weight(inputWeight, date1);
                Weight.getInstance().addWeight(weight);

                editWeight.setText("");
                editDate.setText("");

                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
                Float weight1;
                Date date2;
                ArrayList<Float> weightFloats = Weight.getInstance().getWeightFloats();
                ArrayList<Date> dates = Weight.getInstance().getDates();
                Collections.sort(dates);
                for(int i = 0; i<weightFloats.size(); i++) {
                    weight1 = weightFloats.get(i);
                    date2 = dates.get(i);
                    series.appendData(new DataPoint(date2, weight1), true, 90);
                }
                weightGraph.addSeries(series);
                weightGraph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(context));


            }
        });

        return view;
    }

}