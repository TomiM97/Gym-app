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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
                try {
                    Date selectedDate = new SimpleDateFormat("dd.MM.yyyy").parse(i2 +"."+ (i1+1) +"."+ i);
                    ArrayList<Exercise> allExercises = Workout.getInstance().getExercises();
                    ArrayList<Exercise> exercisesForThisDay = new ArrayList<>();
                    for(int x = 0; x < allExercises.size(); x++ ) {
                        System.out.println(allExercises.get(x).getDate().toString() + " " + selectedDate);
                        assert selectedDate != null;
                        if (allExercises.get(x).getDate().toString().equals(selectedDate.toString())) {
                            exercisesForThisDay.add(allExercises.get(x));
                        }
                        FrontPageRVAdapter frontPageRVAdapter = new FrontPageRVAdapter(getContext(), exercisesForThisDay);
                        recyclerView.setAdapter(frontPageRVAdapter);
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }



            }
        });

        return view;
    }
}