package vn.edu.fit.nlu.uicomponents_registryform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText_Name,editText_PhoneNumber, editText_Email, editText_Address, editText_Group;
    Button btn_Male, btn_Female, btn_Birthday, btn_Done;
    CheckBox cb_Android, cb_Web, cb_IC3;
    RadioButton rdo_Male, rdo_Female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_Name = findViewById(R.id.editText_Name);
        btn_Done = findViewById(R.id.btn_Done);
        btn_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp(v);
            }
        });
    }
    public void signUp(View v){
        Bundle b = new Bundle();
        b.putString("name", editText_Name.getText().toString());
        Intent i  = new Intent(this, InforStudent.class);
        i.putExtra("data", b);
        startActivity(i);
    }

}