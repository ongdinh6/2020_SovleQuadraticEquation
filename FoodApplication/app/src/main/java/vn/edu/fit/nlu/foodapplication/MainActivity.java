package vn.edu.fit.nlu.foodapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnFood, btnDrink, btnExit;
    TextView tvAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFood = findViewById(R.id.btn_ChooseFood);
        btnDrink = findViewById(R.id.btn_ChooseDrink);
        btnExit = findViewById(R.id.btn_Exit);
        tvAns = findViewById(R.id.txt_Ans);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FoodActivity.class);
                startActivityForResult(i, 1);
            }
        });

        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DrinkActivity.class);
                startActivityForResult(i, 2);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String str = tvAns.getText().toString();
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                tvAns.setText(str + "" + data.getStringExtra("data_food")+"-");
            }else{
                tvAns.setText(str);
            }
        } else {
            if (resultCode == RESULT_OK) {
                tvAns.setText(str + "" + data.getStringExtra("data_drink")+"-");
            }else{
                tvAns.setText(str);
            }
        }
    }

}