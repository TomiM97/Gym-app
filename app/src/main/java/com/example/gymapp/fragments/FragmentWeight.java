package com.example.gymapp.fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymapp.R;
import com.example.gymapp.User;
import com.example.gymapp.Weight;
import com.example.gymapp.BmiActivity;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

public class FragmentWeight extends Fragment {
    private Calendar calendar;

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
        TextView editDate = view.findViewById(R.id.editDate);
        Button btnAddWeight = view.findViewById(R.id.btnAddWeight);
        GraphView weightGraph = view.findViewById(R.id.weightGraph);
        weightGraph.getGridLabelRenderer().setHorizontalLabelsAngle(45);
        weightGraph.getGridLabelRenderer().setVerticalAxisTitle("Paino (kg)");
        weightGraph.getGridLabelRenderer().setHorizontalAxisTitle("Päivämäärä");
        Button btnToBMI = view.findViewById(R.id.btnToBmi);


        // automatic date fill
        calendar = Calendar.getInstance();
        String dateString = DateFormat.getDateInstance().format(calendar.getTime());
        editDate.setText(dateString);

        // constructing graphView
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        // constructing weights ArrayList
        ArrayList<Float> weights = new ArrayList<>();
        for(Weight loopWeight : User.getInstance().getWeightList()) {
            weights.add(loopWeight.weightFloat);
        }
        // constructing dates ArrayList
        ArrayList<Date> dates = new ArrayList<>();
        for(Weight loopWeight : User.getInstance().getWeightList()) {
            dates.add(loopWeight.date);
        }
        Collections.sort(dates);
        Float weight1;
        Date date2;
        for(int i = 0; i<weights.size(); i++) {
            weight1 = weights.get(i);
            date2 = dates.get(i);
            series.appendData(new DataPoint(date2, weight1), true, 90);
        }
        weightGraph.addSeries(series);
        weightGraph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getContext()));
        weightGraph.getGridLabelRenderer().setGridStyle( GridLabelRenderer.GridStyle.NONE );

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, month);
                                calendar.set(Calendar.DAY_OF_MONTH, day);
                                String dateString = DateFormat.getDateInstance().format(calendar.getTime());
                                editDate.setText(dateString);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        btnAddWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float inputWeight = null;
                String out = editWeight.getText().toString();
                if(out.isEmpty()) {
                    Toast.makeText(getContext(), "Lisää paino", Toast.LENGTH_SHORT).show();
                } else {
                    inputWeight = Float.parseFloat(out);
                    Date date1;
                    try {
                        date1=new SimpleDateFormat("dd.MM.yyyy").parse(
                                String.format(Locale.getDefault(), "%02d.%02d.%04d",
                                        calendar.get(Calendar.DAY_OF_MONTH),
                                        calendar.get(Calendar.MONTH) + 1,
                                        calendar.get(Calendar.YEAR)
                                )
                        );
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    Weight weight = new Weight(inputWeight, date1);
                    User.getInstance().addWeight(weight);

                    // saving the weight data
                    User.getInstance().saveWeightData(getContext());

                    editWeight.setText("");
                    editDate.setText(dateString);

                    weightGraph.removeSeries(weightGraph.getSeries().get(0));
                    // constructing graphView
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
                    // constructing weights ArrayList
                    ArrayList<Float> weights = new ArrayList<>();
                    for(Weight loopWeight : User.getInstance().getWeightList()) {
                        weights.add(loopWeight.weightFloat);
                    }
                    // constructing dates ArrayList
                    ArrayList<Date> dates = new ArrayList<>();
                    for(Weight loopWeight : User.getInstance().getWeightList()) {
                        dates.add(loopWeight.date);
                    }
                    Collections.sort(dates);
                    Float weight1;
                    Date date2;
                    for(int i = 0; i<weights.size(); i++) {
                        weight1 = weights.get(i);
                        date2 = dates.get(i);
                        series.appendData(new DataPoint(date2, weight1), true, 90);
                    }
                    weightGraph.addSeries(series);
                }
                }

        });

        btnToBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BmiActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}