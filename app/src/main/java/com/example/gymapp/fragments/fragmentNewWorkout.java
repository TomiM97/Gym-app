package com.example.gymapp.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymapp.Exercise;
import com.example.gymapp.R;
import com.example.gymapp.User;
import com.example.gymapp.Workout;
import com.example.gymapp.rv_holders_and_adapters.NewWorkoutRVAdapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class fragmentNewWorkout extends Fragment {
    private Button btnSaveWorkout, addExercise;
    private int sets;
    private EditText textWorkoutType, repsInteger, weightsFloat, repsInteger2, weightsFloat2,
            repsInteger3, weightsFloat3, repsInteger4, weightsFloat4, repsInteger5, weightsFloat5,
            repsInteger6, weightsFloat6;
    private AutoCompleteTextView newExercise;
    private Calendar calendar;
    private TextView newWorkoutDate;


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

        addExercise = view.findViewById(R.id.btnAddExercise);
        newWorkoutDate = view.findViewById(R.id.txtNewWorkoutDate);
        textWorkoutType = view.findViewById(R.id.textWorkoutType);
        btnSaveWorkout = view.findViewById(R.id.btnSaveWorkout);

        // automatic date fill
        calendar = Calendar.getInstance();
        String dateString = DateFormat.getDateInstance().format(calendar.getTime());
        newWorkoutDate.setText(dateString);

        newWorkoutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, month);
                                calendar.set(Calendar.DAY_OF_MONTH, day);
                                String dateString = DateFormat.getDateInstance().format(calendar.getTime());
                                newWorkoutDate.setText(dateString);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        // RecyclerView needs start:
        RecyclerView recyclerView = view.findViewById(R.id.rvNewWorkoutExercises);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        NewWorkoutRVAdapter newWorkoutRVAdapter = new NewWorkoutRVAdapter(getContext(), Workout.getInstance().getTempExercises());
        recyclerView.setAdapter(newWorkoutRVAdapter);
        // RecyclerView needs stop.

        // Save workout function
        btnSaveWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textWorkoutType != null) {
                    String workoutType = textWorkoutType.getText().toString();
                    Date workoutDate;
                    try {
                        workoutDate = new SimpleDateFormat("dd.MM.yyyy").parse(
                                String.format(Locale.getDefault(), "%02d.%02d.%04d",
                                        calendar.get(Calendar.DAY_OF_MONTH),
                                        calendar.get(Calendar.MONTH) + 1,
                                        calendar.get(Calendar.YEAR)
                                )
                        );
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    Workout workout = new Workout(workoutType, workoutDate, Workout.getInstance().getExercises());
                    User.getInstance().addWorkoutsToList(workout);
                    // Empty the RV list
                    ArrayList <Exercise> exercisesToBeDeleted = Workout.getInstance().tempExercises;
                    Workout.getInstance().addExercise(exercisesToBeDeleted);
                    Workout.getInstance().clearTempExercises();
                    recyclerView.getAdapter().notifyDataSetChanged();
                    textWorkoutType.setText("");

                }
            }
        });
        // Add exercise function

        NewWorkoutRVAdapter finalNewWorkoutRVAdapter = newWorkoutRVAdapter;
        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View addExercisePopupView = getLayoutInflater().inflate(R.layout.popup_add_exercise, null);

                newExercise = addExercisePopupView.findViewById(R.id.txtExerciseName);
                // Dropdown menu
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line,
                        Workout.getInstance().getExerciseNamesForDropDownMenu(Workout.getInstance().getExercises()));
                newExercise.setAdapter(adapter);
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
                        ArrayList<Integer> repsList = new ArrayList<>();
                        ArrayList<Float> weightsList = new ArrayList<>();

                        String txtNewExercise = newExercise.getText().toString();
                        sets = 0;

                        if (!TextUtils.isEmpty(repsInteger.getText().toString())) {
                            int intRepsInteger = Integer.parseInt(repsInteger.getText().toString());
                            repsList.add(intRepsInteger);
                            sets++;
                        }
                        if (!TextUtils.isEmpty(weightsFloat.getText().toString())) {
                            float floatWeightsFloat = Float.parseFloat(weightsFloat.getText().toString());
                            weightsList.add(floatWeightsFloat);
                        }
                        if (!TextUtils.isEmpty(repsInteger2.getText().toString())) {
                            int intRepsInteger2 = Integer.parseInt(repsInteger2.getText().toString());
                            repsList.add(intRepsInteger2);
                            sets++;
                        }
                        if (!TextUtils.isEmpty(weightsFloat2.getText().toString())) {
                            float floatWeightsFloat2 = Float.parseFloat(weightsFloat2.getText().toString());
                            weightsList.add(floatWeightsFloat2);
                        }
                        if (!TextUtils.isEmpty(repsInteger3.getText().toString())) {
                            int intRepsInteger3 = Integer.parseInt(repsInteger3.getText().toString());
                            repsList.add(intRepsInteger3);
                            sets++;
                        }
                        if (!TextUtils.isEmpty(weightsFloat3.getText().toString())) {
                            float floatWeightsFloat3 = Float.parseFloat(weightsFloat3.getText().toString());
                            weightsList.add(floatWeightsFloat3);
                        }
                        if (!TextUtils.isEmpty(repsInteger4.getText().toString())) {
                            int intRepsInteger4 = Integer.parseInt(repsInteger4.getText().toString());
                            repsList.add(intRepsInteger4);
                            sets++;
                        }
                        if (!TextUtils.isEmpty(weightsFloat4.getText().toString())) {
                            float floatWeightsFloat4 = Float.parseFloat(weightsFloat4.getText().toString());
                            weightsList.add(floatWeightsFloat4);
                        }
                        if (!TextUtils.isEmpty(repsInteger5.getText().toString())) {
                            int intRepsInteger5 = Integer.parseInt(repsInteger5.getText().toString());
                            repsList.add(intRepsInteger5);
                            sets++;
                        }
                        if (!TextUtils.isEmpty(weightsFloat5.getText().toString())) {
                            float floatWeightsFloat5 = Float.parseFloat(weightsFloat5.getText().toString());
                            weightsList.add(floatWeightsFloat5);
                        }
                        if (!TextUtils.isEmpty(repsInteger6.getText().toString())) {
                            int intRepsInteger6 = Integer.parseInt(repsInteger6.getText().toString());
                            repsList.add(intRepsInteger6);
                            sets++;
                        }
                        if (!TextUtils.isEmpty(weightsFloat6.getText().toString())) {
                            float floatWeightsFloat6 = Float.parseFloat(weightsFloat6.getText().toString());
                            weightsList.add(floatWeightsFloat6);
                        }
                        try {
                            Date workoutDate = new SimpleDateFormat("dd.MM.yyyy").parse(
                                    String.format(Locale.getDefault(), "%02d.%02d.%04d",
                                            calendar.get(Calendar.DAY_OF_MONTH),
                                            calendar.get(Calendar.MONTH) + 1,
                                            calendar.get(Calendar.YEAR)
                                    )
                            );
                            if(weightsList.size()==repsList.size()) {
                                Workout.getInstance().addTempExercise(new Exercise(weightsList, sets, repsList, txtNewExercise, workoutDate));
                                finalNewWorkoutRVAdapter.notifyDataSetChanged();
                                dialog.dismiss();
                            } else {
                                Toast.makeText(getContext(), "Laita joka sarjalle paino", Toast.LENGTH_SHORT).show();
                            }
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
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