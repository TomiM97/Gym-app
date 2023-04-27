package com.example.gymapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gymapp.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGraphs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGraphs extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentGraphs() {
        // Required empty public constructor
    }

    public static FragmentGraphs newInstance(String param1, String param2) {
        FragmentGraphs fragment = new FragmentGraphs();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graphs, container, false);
        GraphView graphExercise = view.findViewById(R.id.progressgraph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        double y;
        for (int x=0; x<90; x++){
            y = Math.sin(2*x*0.2)-Math.sin(x*0.2);
            series.appendData(new DataPoint(x,y), true,90);
        }
        graphExercise.addSeries(series);

        Button chooseExercise = view.findViewById(R.id.btnshowExercise);
        chooseExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),ListExercisesActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
