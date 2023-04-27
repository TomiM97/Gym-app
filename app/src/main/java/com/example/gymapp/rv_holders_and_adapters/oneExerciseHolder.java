package com.example.gymapp.rv_holders_and_adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.R;

public class oneExerciseHolder extends RecyclerView.ViewHolder {

    public TextView exerciseName;

    public oneExerciseHolder(@NonNull View itemView) {
        super(itemView);
        exerciseName = itemView.findViewById(R.id.exerciseName);
    }
}

