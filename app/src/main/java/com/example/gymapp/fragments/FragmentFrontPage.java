package com.example.gymapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gymapp.R;
import com.example.gymapp.Workout;
import com.example.gymapp.rv_holders_and_adapters.NewWorkoutRVAdapter;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentFrontPage extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_front_page, container, false);

        // RecyclerView needs start:
        RecyclerView recyclerView = view.findViewById(R.id.rvFrontPageExercises);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        NewWorkoutRVAdapter newWorkoutRVAdapter = new NewWorkoutRVAdapter(getContext(), Workout.getInstance().getExercises());
        recyclerView.setAdapter(newWorkoutRVAdapter);
        // RecyclerView needs stop.

        return view;
    }
}