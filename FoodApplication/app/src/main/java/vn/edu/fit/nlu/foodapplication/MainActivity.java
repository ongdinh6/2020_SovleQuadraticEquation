package vn.edu.fit.nlu.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFood(v);
            }
        });
    }
    public void chooseFood(View v){
        Intent i = new Intent(this, FoodActivity.class);
        startActivity(i);
    }
    public void getFood(){
        Intent i = getIntent();


    }
}