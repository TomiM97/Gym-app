package com.example.gymapp.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gymapp.R;
import com.example.gymapp.Weight;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FragmentWeight extends Fragment {

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

        btnAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float inputWeight = Float.parseFloat(editWeight.getText().toString());
                Date date;
                try {
                    date = new SimpleDateFormat("dd.MM.yyyy").parse(editDate.getText().toString());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Weight weight = new Weight(inputWeight, date);
                Weight.getInstance().addWeight(weight);

                editWeight.setText("");
                editDate.setText("");

            }
        });

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        Float weight1;
        Date date1;
        for(int i = 0; i < Weight.getInstance().getWeights().size(); i++) {
            weight1 = Weight.getInstance().getWeights().get(i);
            date1 = Weight.getInstance().getWeightDates().get(i);
            series.appendData(new DataPoint(date1, weight1), true, 90);
        }
        weightGraph.addSeries(series);



        return view;
    }
}