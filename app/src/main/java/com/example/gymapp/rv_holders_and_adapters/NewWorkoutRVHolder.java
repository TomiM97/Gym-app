package com.example.gymapp.rv_holders_and_adapters;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.R;
import com.example.gymapp.Weight;
import com.example.gymapp.Workout;

public class NewWorkoutRVHolder extends RecyclerView.ViewHolder {
    public TextView txtRVExerciseName, dynamicTxtRVSets, dynamicTxtRVRep, dynamicTxtRVWeight;
    public Button btnDelete;

    public NewWorkoutRVHolder(@NonNull View itemView) {
        super(itemView);
        txtRVExerciseName = itemView.findViewById(R.id.txtRVWorkoutType);
        dynamicTxtRVSets = itemView.findViewById(R.id.dynamicTxtRVSets);
        dynamicTxtRVRep = itemView.findViewById(R.id.dynamicTxtRVRep);
        dynamicTxtRVWeight = itemView.findViewById(R.id.dynamicTxtRVWeight);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }
}