package com.example.gymapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.gymapp.Exercise;
import com.example.gymapp.R;
import com.example.gymapp.Workout;
import com.example.gymapp.rv_holders_and_adapters.FrontPageRVAdapter;
import com.example.gymapp.rv_holders_and_adapters.NewWorkoutRVAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentFrontPage extends Fragment {
    CalendarView calendarView;

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
        // RecyclerView needs stop.

        // Calendar
        calendarView = (CalendarView) view.findViewById(R.id.cvCalendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "." + (i1 + 1) + "." + i;
                ArrayList<Exercise> allExercises = Workout.getInstance().getExercises();
                ArrayList<String> exercisesForThisDay = new ArrayList<>();
                for(int x = 0; x < allExercises.size(); x++ ) {
                    if (allExercises.get(x).getDate().toString().equals(date)) {
                        System.out.println(allExercises.get(x).getDate().toString() + " " + date);
                        exercisesForThisDay.add(allExercises.get(x).getExerciseName());
                    }

                }
                FrontPageRVAdapter frontPageRVAdapter = new FrontPageRVAdapter(getContext(), Workout.getInstance().getExercises());
                recyclerView.setAdapter(frontPageRVAdapter);
            }
        });

        return view;
    }
}