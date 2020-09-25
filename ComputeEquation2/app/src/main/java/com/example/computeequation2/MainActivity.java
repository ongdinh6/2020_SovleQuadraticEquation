package com.example.computeequation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText_numberA, editText_numberB, editText_numberC;
    TextView txt_result;
    Button btn_calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_numberA = findViewById(R.id.editText_numberA);
        editText_numberB = findViewById(R.id.editText_numberB);
        editText_numberC = findViewById(R.id.editText_numberC);
        btn_calculate = findViewById(R.id.button_calculate);
        txt_result = findViewById(R.id.textView_result);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double noA = Double.parseDouble(String.valueOf(editText_numberA.getText()));
                double noB = Double.parseDouble(String.valueOf(editText_numberB.getText()));
                double noC = Double.parseDouble(String.valueOf(editText_numberC.getText()));
                String rs = SolveQuadraticEquation.solve(noA, noB, noC);

                txt_result.setText(rs);
            }
        });
    }
}