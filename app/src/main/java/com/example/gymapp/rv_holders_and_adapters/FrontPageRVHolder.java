package com.example.gymapp.rv_holders_and_adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.R;

public class FrontPageRVHolder extends RecyclerView.ViewHolder {
    public TextView txtRVExerciseName, dynamicTxtRVSets, dynamicTxtRVRep, dynamicTxtRVWeight;

    public FrontPageRVHolder(@NonNull View itemView) {
        super(itemView);
        txtRVExerciseName = itemView.findViewById(R.id.txtRVWorkoutType);
        dynamicTxtRVSets = itemView.findViewById(R.id.dynamicTxtRVSets);
        dynamicTxtRVRep = itemView.findViewById(R.id.dynamicTxtRVRep);
        dynamicTxtRVWeight = itemView.findViewById(R.id.dynamicTxtRVWeight);
    }
}
