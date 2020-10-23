package vn.edu.fit.nlu.quanlynhanvien;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.fit.nlu.quanlynhanvien.controller.EmployeeAdapter;
import vn.edu.fit.nlu.quanlynhanvien.model.Employee;

public class MainActivity extends AppCompatActivity {
    ListView lvEmployee;
    ArrayList<Employee> listEmployee;
    EmployeeAdapter employeeAdapter;
    EditText edtIDEmployee, edtNameEmployee, edtDayNum;
    RadioButton rdoFullTime, rdoPartTime;
    Button btnAddEmployee;
    RadioGroup radioGroup;
    boolean isPartTime = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtIDEmployee = findViewById(R.id.edt_IDEmployee);
        edtNameEmployee = findViewById(R.id.edt_NameEmployee);
        edtDayNum = findViewById(R.id.edt_DayNum);

        //event of radioButton
        radioGroup = findViewById(R.id.rg_TypeOfEmployee);
        rdoFullTime = findViewById(R.id.rdo_FullTime);
        rdoPartTime = findViewById(R.id.rdo_PartTime);

        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View v = radioGroup.findViewById(checkedId);
                int i = radioGroup.indexOfChild(v);
                if (i == 0) {
                    isPartTime = false;
                } else {
                    isPartTime = true;
                }
            }
        });

        //setListView
        lvEmployee = findViewById(R.id.listView_EmployeeInfor);
        //action for btnAdd
        btnAddEmployee = findViewById(R.id.btn_AddEmployee);
        listEmployee = new ArrayList<>();
        btnAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtIDEmployee.getText().toString().equals("") || edtNameEmployee.getText().toString().equals("") || edtDayNum.getText().toString().equals("")) {
                    String str ="";
                    if(edtIDEmployee.getText().toString().equals("")){
                        str = "id";
                    }
                    if(edtNameEmployee.getText().toString().equals("")){
                        str = "name";
                    }
                    if(edtDayNum.getText().toString().equals("")){
                        str = "day num";
                    }
                    Toast.makeText(getApplicationContext(), "Please input "+ str+ " values!", Toast.LENGTH_SHORT).show();
                } else {
                    Employee e = new Employee();
                    e.setId(edtIDEmployee.getText().toString());
                    e.setName(edtNameEmployee.getText().toString());
                    e.setDayNum(Integer.parseInt(edtDayNum.getText().toString()));
                    e.setPartTime(isPartTime);
                    listEmployee.add(e);
                    employeeAdapter = new EmployeeAdapter(MainActivity.this, R.layout.activity_employee_layout, listEmployee);
                    lvEmployee.setAdapter(employeeAdapter);
                }
            }
        });
    }
}