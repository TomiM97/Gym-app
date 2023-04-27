package com.example.gymapp.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.gymapp.Exercise;
import com.example.gymapp.R;
import com.example.gymapp.Workout;
import com.example.gymapp.rv_holders_and_adapters.NewWorkoutRVAdapter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

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
        Button addExercise = view.findViewById(R.id.btnshowExercise);
        // RecyclerView needs start:
        RecyclerView recyclerView = view.findViewById(R.id.rvExerciselist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        NewWorkoutRVAdapter newWorkoutRVAdapter = new NewWorkoutRVAdapter(getContext(), Workout.getInstance().getExercises());
        recyclerView.setAdapter(newWorkoutRVAdapter);
        // RecyclerView needs stop.
        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View addExercisePopupView = getLayoutInflater().inflate(R.layout.popup_add_exercise, null);

                exercise = addExercisePopupView.findViewById(R.id.txtExerciseName);
                // Dropdown menu
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line,
                        Workout.getInstance().getExerciseNames(Workout.getInstance().getExercises()));

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                Button popupShowExercise = addExercisePopupView.findViewById(R.id.btnshowExercise);
                Button popupCancel = addExercisePopupView.findViewById(R.id.btnCancelPopup);
                dialogBuilder.setView(addExercisePopupView);
                final AlertDialog dialog = dialogBuilder.create();
                dialog.show();
                popupShowExercise.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ArrayList<Integer> repsList = new ArrayList<>();
                        ArrayList<Float> weightsList = new ArrayList<>();

                        String txtNewExercise = newExercise.getText().toString();

                        Workout.getInstance().addExercise(new Exercise(weightsList, sets, repsList, txtNewExercise));
                        newWorkoutRVAdapter.notifyDataSetChanged();
                        dialog.dismiss();}});
                popupCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
        return view;
    }
}
