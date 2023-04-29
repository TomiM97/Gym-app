package com.example.gymapp.rv_holders_and_adapters;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.R;
import com.example.gymapp.fragments.ListExercisesActivity;
import com.jjoe64.graphview.GraphView;

public class oneExerciseHolder extends RecyclerView.ViewHolder {

    public TextView exerciseName;
    public Button rvChoose;

    public oneExerciseHolder(@NonNull View itemView) {
        super(itemView);
        exerciseName = itemView.findViewById(R.id.exerciseName);
        rvChoose = itemView.findViewById(R.id.rvChoose);
        rvChoose.setTag(getAdapterPosition());
        rvChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
            }
        });
    }


}


