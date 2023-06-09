package com.example.gymapp.rv_holders_and_adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapp.Exercise;
import com.example.gymapp.R;
import com.example.gymapp.Workout;

import java.util.ArrayList;

public class FrontPageRVAdapter extends RecyclerView.Adapter<FrontPageRVHolder> {

    private final Context context;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    public FrontPageRVAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public FrontPageRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FrontPageRVHolder(LayoutInflater.from(context).inflate(R.layout.rv_workout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FrontPageRVHolder holder, int position) {
        holder.txtRVExerciseName.setText(exercises.get(position).getExerciseName());
        // Sets shown dynamically
        String dynamicTxtRVSets = "Setit:\n";
        for (int i = 0; i < exercises.get(position).getSets(); i++ ) {
            dynamicTxtRVSets = dynamicTxtRVSets.concat(i+1 + "\n");
        }
        holder.dynamicTxtRVSets.setText(dynamicTxtRVSets);
        // Reps shown dynamically
        String dynamicTxtRVRep = "Toistot:\n";
        for (int i = 0; i < exercises.get(position).getSets(); i++ ) {
            dynamicTxtRVRep = dynamicTxtRVRep.concat(exercises.get(position).getReps().get(i) + "\n");
        }
        holder.dynamicTxtRVRep.setText(dynamicTxtRVRep);
        // Weights shown dynamically
        String dynamicTxtRVWeight = "Paino:\n";
        for (int i = 0; i < exercises.get(position).getSets(); i++ ) {
            dynamicTxtRVWeight = dynamicTxtRVWeight.concat(exercises.get(position).getWorkoutWeights().get(i) + "kg\n");
        }
        holder.dynamicTxtRVWeight.setText(dynamicTxtRVWeight);

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
