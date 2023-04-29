package com.example.gymapp.rv_holders_and_adapters;

import android.view.View;
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
    public LinearLayout rvExercise;

    public NewWorkoutRVHolder(@NonNull View itemView) {
        super(itemView);
        txtRVExerciseName = itemView.findViewById(R.id.txtRVWorkoutType);
        dynamicTxtRVSets = itemView.findViewById(R.id.dynamicTxtRVSets);
        dynamicTxtRVRep = itemView.findViewById(R.id.dynamicTxtRVRep);
        dynamicTxtRVWeight = itemView.findViewById(R.id.dynamicTxtRVWeight);

        // remove or edit option
        rvExercise = itemView.findViewById(R.id.rvExercise);
        NewWorkoutRVAdapter newWorkoutRVAdapter = new NewWorkoutRVAdapter(itemView.getContext(), Workout.getInstance().getTempExercises());
        final OnItemLongClickListener listener = newWorkoutRVAdapter.getOnItemLongClickListener();
        rvExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("jee");
            }
        });
    }
}