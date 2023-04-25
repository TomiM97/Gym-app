package com.example.gymapp.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gymapp.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class fragmentNewWorkout extends Fragment {

    private Button btnAddExercise, btnSaveWorkout;
    private AlertDialog dialog;
    private EditText newExercise, repsInteger, weightsFloat, repsInteger2, weightsFloat2,
            repsInteger3, weightsFloat3, repsInteger4, weightsFloat4, repsInteger5, weightsFloat5,
            repsInteger6, weightsFloat6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_workout, container, false);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
        final View addExercisePopupView = getLayoutInflater().inflate(R.layout.popup_add_exercise, null);
        newExercise = addExercisePopupView.findViewById(R.id.txtExerciseName);
        repsInteger = addExercisePopupView.findViewById(R.id.txtRepInteger);
        weightsFloat = addExercisePopupView.findViewById(R.id.txtWeightsFloat);
        repsInteger2 = addExercisePopupView.findViewById(R.id.txtRepInteger2);
        weightsFloat2 = addExercisePopupView.findViewById(R.id.txtWeightsFloat2);
        repsInteger3 = addExercisePopupView.findViewById(R.id.txtRepInteger3);
        weightsFloat3 = addExercisePopupView.findViewById(R.id.txtWeightsFloat3);
        repsInteger4 = addExercisePopupView.findViewById(R.id.txtRepInteger4);
        weightsFloat4 = addExercisePopupView.findViewById(R.id.txtWeightsFloat4);
        repsInteger5 = addExercisePopupView.findViewById(R.id.txtRepInteger5);
        weightsFloat5 = addExercisePopupView.findViewById(R.id.txtWeightsFloat5);
        repsInteger6 = addExercisePopupView.findViewById(R.id.txtRepInteger6);
        weightsFloat6 = addExercisePopupView.findViewById(R.id.txtWeightsFloat6);

        Button popupAddExercise = addExercisePopupView.findViewById(R.id.btnAddExercisePopup);
        Button popupCancel = addExercisePopupView.findViewById(R.id.btnCancelPopup);

        dialogBuilder.setView(addExercisePopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        popupAddExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO tässä lisätään Workout-olion exercises listaan yksi Exercise olio
            }
        });

        popupCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { dialog.dismiss(); }
        });


        return view;
    }
}