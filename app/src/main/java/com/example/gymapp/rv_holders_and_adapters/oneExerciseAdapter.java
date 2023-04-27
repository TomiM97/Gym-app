package com.example.gymapp.rv_holders_and_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.Exercise;
import com.example.gymapp.R;

import java.util.ArrayList;

public class oneExerciseAdapter extends RecyclerView.Adapter<oneExerciseHolder> {

    private Context context;
    private ArrayList<Exercise> exercises = new ArrayList<>();

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
    }

    @Override
    public int getItemCount() {
            return exercises.size();
    }

}
