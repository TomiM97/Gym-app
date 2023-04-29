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

public class NewWorkoutRVAdapter extends RecyclerView.Adapter<NewWorkoutRVHolder> implements OnItemLongClickListener {
    private OnItemLongClickListener onItemLongClickListener;
    private final Context context;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    public NewWorkoutRVAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }
    public OnItemLongClickListener getOnItemLongClickListener() { return onItemLongClickListener; }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @Override
    public int onItemLongClick(int position) {
        return position;
    }
    @Override
    public void setOnItemLongClickListener() {};

    @NonNull
    @Override
    public NewWorkoutRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.rv_new_workout, parent, false);
        return new NewWorkoutRVHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewWorkoutRVHolder holder, int position) {
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

        // edit or remove option
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(position);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

}
