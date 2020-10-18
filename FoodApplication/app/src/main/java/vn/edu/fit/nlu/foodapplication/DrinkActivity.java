package vn.edu.fit.nlu.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DrinkActivity extends AppCompatActivity {
    CheckBox cbTiger, cbPessi, cbHeniken, cbSaiGonDo;
    Button btnDatMon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        cbTiger = findViewById(R.id.cb_Tiger);
        cbPessi = findViewById(R.id.cb_Pessi);
        cbHeniken = findViewById(R.id.cb_Heniken);
        cbSaiGonDo = findViewById(R.id.cb_SaiGonDo);

        btnDatMon = findViewById(R.id.btn_DatMon);

        btnDatMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                String value = "";
                if (cbTiger.isChecked()) {
                    value += cbTiger.getText().toString();
                } else if (cbPessi.isChecked()) {
                    value += cbPessi.getText().toString();
                } else if (cbHeniken.isChecked()) {
                    value += cbHeniken.getText().toString();
                } else {
                    value += cbSaiGonDo.getText().toString();
                }
                i.putExtra("data_drink", value);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}