package com.example.gymapp.rv_holders_and_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.Exercise;
import com.example.gymapp.R;
import com.example.gymapp.Workout;
import com.example.gymapp.fragments.FragmentGraphs;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Objects;

public class oneExerciseAdapter extends RecyclerView.Adapter<oneExerciseHolder> {

    private Context context;
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private String exercise;

    public oneExerciseAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }


    @NonNull
    @Override
    public oneExerciseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new oneExerciseHolder(LayoutInflater.from(context).inflate(R.layout.rv_one_exercise, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull oneExerciseHolder holder, int position) {
        holder.exerciseName.setText(exercises.get(position).exerciseName);
        holder.rvChoose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                GraphView graphView = view.findViewById(R.id.progressgraph);
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                int pos = holder.getAdapterPosition();
                exercise = Workout.getInstance().getExercises().get(pos).getExerciseName();
                System.out.println(exercise + " " + pos);
                double y;
                for (int x = 0; x < Workout.getInstance().getExercises().size(); ++x) {
                    if (Objects.equals(exercise, Workout.getInstance().getExercises().get(x).getExerciseName())) {
                        y = Workout.getInstance().exercises.get(x).getMaxWeight();
                        series.appendData(new DataPoint(x, y), true, 90);
                    }
                }
            }
        });

    }

    public int getItemCount() {
        return exercises.size();
    }
}
