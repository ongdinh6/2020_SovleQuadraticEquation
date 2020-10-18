package vn.edu.fit.nlu.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class FoodActivity extends AppCompatActivity {
    CheckBox cbPho, cbHuTieu, cbMiQuang, cbBun;
    Button btnBack, btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        cbPho = findViewById(R.id.cb_Pho);
        cbMiQuang = findViewById(R.id.cb_MiQuang);
        cbHuTieu = findViewById(R.id.cb_HuTieu);
        cbBun = findViewById(R.id.cb_Bun);
        btnBack = findViewById(R.id.btn_Back);
        btnOk = findViewById(R.id.btn_Ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                String value = "";
                if (cbPho.isChecked()) {
                    value += String.valueOf(cbPho.getText());
                } else if (cbBun.isChecked()) {
                    value += String.valueOf(cbBun.getText());
                } else if (cbHuTieu.isChecked()) {
                    value += String.valueOf(cbHuTieu.getText());
                } else {
                    value += String.valueOf(cbMiQuang.getText());
                }
                i.putExtra("data_food", value);
                setResult(RESULT_OK, i);
                finish();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
