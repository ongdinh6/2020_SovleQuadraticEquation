package vn.edu.fit.nlu.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class FoodActivity extends AppCompatActivity {
    CheckBox cbPho, cbHuTieu, cbMiQuang, cbBun;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        cbPho = findViewById(R.id.cb_Pho);
        cbMiQuang = findViewById(R.id.cb_MiQuang);
        cbHuTieu = findViewById(R.id.cb_HuTieu);
        cbBun = findViewById(R.id.cb_Bun);
        btnBack = findViewById(R.id.btn_Back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOption(v);
            }
        });
    }


    public void sendOption(View v){
        Bundle b = new Bundle();
        b.putString("pho", String.valueOf(cbPho.getText()));
        b.putString("hutieu", String.valueOf(cbHuTieu.getText()));
        b.putString("mi", String.valueOf(cbMiQuang.getText()));
        b.putString("bun", String.valueOf(cbBun.getText()));
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("sendFood", b);
        startActivity(i);
    }
}