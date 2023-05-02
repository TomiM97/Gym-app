package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymapp.R;

public class BmiActivity extends AppCompatActivity {
    EditText editBmiWeight, editBmiHeight;
    TextView textBmiOut;
    ImageView tonyHalmeImg, boyImg, puuroImg;
    Button btnCalcBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        editBmiHeight = findViewById(R.id.editHeightBmi);
        editBmiWeight = findViewById(R.id.editWeightBmi);
        textBmiOut = findViewById(R.id.textBmiOut);
        tonyHalmeImg = findViewById(R.id.tonyHalmeImg);
        boyImg = findViewById(R.id.boyImg);
        puuroImg = findViewById(R.id.puuroImg);
        btnCalcBmi = findViewById(R.id.btnCalcBmi);


        btnCalcBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tonyHalmeImg.setVisibility(View.GONE);
                boyImg.setVisibility(View.GONE);
                puuroImg.setVisibility(View.GONE);
                String editWeightString = editBmiWeight.getText().toString();
                String editHeightString = editBmiHeight.getText().toString();
                editHeightString.replace(".", ",");
                editWeightString.replace(".", ",");
                Float editWeight;
                Float editHeight;
                if(editHeightString.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Lisää pituus", Toast.LENGTH_SHORT).show();
                } else {
                    if(editWeightString.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Lisää paino", Toast.LENGTH_SHORT).show();
                    } else {
                        editWeight = Float.parseFloat(editWeightString);
                        editHeight = Float.parseFloat(editHeightString);
                        double bmi = editWeight / Math.pow(2, editHeight);

                        if (bmi<(double) 18.5) {
                            textBmiOut.setText("Painoindeksisi on liian alhainen eli puuroa lisää!");
                            puuroImg.setVisibility(View.VISIBLE);
                        } else if(bmi<(double) 25 && bmi>(double) 18.5) {
                            textBmiOut.setText("Painoindeksisi on normaali. Muista kuitenkin että ylipaino on ylivoimaa!");
                            boyImg.setVisibility(View.VISIBLE);
                        }else if(bmi>(double) 25) {
                            textBmiOut.setText("Painoindeksisi on mukamas ylipainoinen, mutta ei hätää koska ylipaino on ylivoimaa!");
                            tonyHalmeImg.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });



    }
}