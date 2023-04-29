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

public class oneExerciseAdapter extends RecyclerView.Adapter<oneExerciseHolder> implements MyListener {


    private MyListener myListener;
    private final Context context;
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private String exercise;

    public oneExerciseAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }
    public void setMyListener(MyListener myListener) {
        this.myListener = myListener;
    }


    @NonNull
    @Override
    public oneExerciseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new oneExerciseHolder(LayoutInflater.from(context).inflate(R.layout.rv_one_exercise, parent, false));
    }

    public void onBindViewHolder(@NonNull oneExerciseHolder holder, int position) {
        holder.exerciseName.setText(exercises.get(position).exerciseName);
        holder.rvChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                System.out.println(position);
                myListener.onButtonClick(position);
            }
        });
    }

    public int getItemCount() {
        return exercises.size();
    }

    @Override
    public int onButtonClick(int position) {
    return position;}

    @Override
    public void setMyListener() {

    }
}
