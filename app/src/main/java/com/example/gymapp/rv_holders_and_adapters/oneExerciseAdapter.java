package com.example.gymapp.rv_holders_and_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.Exercise;
import com.example.gymapp.R;
import com.example.gymapp.Workout;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

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
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                int position = holder.getAdapterPosition();
                System.out.println(position + " " + series);
                GraphView graphView = holder.itemView.findViewById(R.id.progressgraph);
                double y = Workout.getInstance().exercises.get(position).getMaxWeight();
                int x = 5;
                System.out.println(y + " on " + x);
                    new DataPoint(x, y);
                graphView.addSeries(series);
            }
        });
    }

    public int getItemCount() {
        return exercises.size();
    }

}
