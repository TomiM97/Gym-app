package com.example.gymapp.rv_holders_and_adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.R;
import com.example.gymapp.Weight;
import com.example.gymapp.Workout;

public class NewWorkoutRVHolder extends RecyclerView.ViewHolder {
    public TextView txtRVExerciseName, dynamicTxtRVSets, dynamicTxtRVRep, dynamicTxtRVWeight;
    public View rootView;

    public NewWorkoutRVHolder(@NonNull View itemView) {
        super(itemView);
        txtRVExerciseName = itemView.findViewById(R.id.txtRVWorkoutType);
        dynamicTxtRVSets = itemView.findViewById(R.id.dynamicTxtRVSets);
        dynamicTxtRVRep = itemView.findViewById(R.id.dynamicTxtRVRep);
        dynamicTxtRVWeight = itemView.findViewById(R.id.dynamicTxtRVWeight);
        
        // remove or edit option
        rootView = itemView;
        NewWorkoutRVAdapter newWorkoutRVAdapter = new NewWorkoutRVAdapter(itemView.getContext(), Workout.getInstance().getTempExercises());
        final OnItemLongClickListener listener = newWorkoutRVAdapter.getOnItemLongClickListener();
        rootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onItemLongClick(position);
                    return true;
                }
                return false;
            }
        });
    }
}