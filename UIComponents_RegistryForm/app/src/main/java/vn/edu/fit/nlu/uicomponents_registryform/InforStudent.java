package vn.edu.fit.nlu.uicomponents_registryform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InforStudent extends AppCompatActivity {
    TextView tv_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_student);
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("data");
        tv_name = findViewById(R.id.tw_name);
        tv_name.setText(b.getString("name"));
    }
}