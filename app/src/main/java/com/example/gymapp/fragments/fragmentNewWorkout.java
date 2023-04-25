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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class fragmentNewWorkout extends Fragment {

    private Button btnAddExercise, btnSaveWorkout;
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

        Button addExercise = view.findViewById(R.id.btnAddExercise);
        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View addExercisePopupView = getLayoutInflater().inflate(R.layout.popup_add_exercise, null);

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

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                Button popupAddExercise = addExercisePopupView.findViewById(R.id.btnAddExercisePopup);
                Button popupCancel = addExercisePopupView.findViewById(R.id.btnCancelPopup);
                dialogBuilder.setView(addExercisePopupView);
                final AlertDialog dialog = dialogBuilder.create();
                dialog.show();

                popupAddExercise.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String txtNewExercise = newExercise.getText().toString();
                        if(repsInteger != null) {
                            int intRepsInteger = Integer.parseInt(repsInteger.getText().toString());
                        }
                        if(weightsFloat != null) {
                            float floatWeightsFloat = Float.parseFloat(weightsFloat.getText().toString());
                        }
                        if(repsInteger2 != null) {
                            int intRepsInteger2 = Integer.parseInt(repsInteger2.getText().toString());
                        }
                        if(weightsFloat2 != null) {
                            float floatWeightsFloat2 = Float.parseFloat(weightsFloat2.getText().toString());
                        }
                        if(repsInteger3 != null) {
                            int intRepsInteger3 = Integer.parseInt(repsInteger3.getText().toString());
                        }
                        if(weightsFloat3 != null) {
                            float floatWeightsFloat3 = Float.parseFloat(weightsFloat3.getText().toString());
                        }
                        if(repsInteger4 != null) {
                            int intRepsInteger4 = Integer.parseInt(repsInteger4.getText().toString());
                        }
                        if(weightsFloat4 != null) {
                            float floatWeightsFloat4 = Float.parseFloat(weightsFloat4.getText().toString());
                        }
                        if(repsInteger5 != null) {
                            int intRepsInteger5 = Integer.parseInt(repsInteger5.getText().toString());
                        }
                        if(weightsFloat5 != null) {
                            float floatWeightsFloat5 = Float.parseFloat(weightsFloat5.getText().toString());
                        }
                        if(repsInteger6 != null) {
                            int intRepsInteger6 = Integer.parseInt(repsInteger6.getText().toString());
                        }
                        if(weightsFloat6 != null) {
                            float floatWeightsFloat6 = Float.parseFloat(weightsFloat6.getText().toString());
                        }
                        ArrayList<Integer> repsList = new ArrayList<>();
                        ArrayList<Float> weightsList = new ArrayList<>();

                    }
                });

                popupCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();

                    }
                });
            }
        });
        return view;
    }
}