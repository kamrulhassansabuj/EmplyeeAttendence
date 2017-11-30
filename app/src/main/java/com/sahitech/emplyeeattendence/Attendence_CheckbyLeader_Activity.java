package com.sahitech.emplyeeattendence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Attendence_CheckbyLeader_Activity extends AppCompatActivity {

    private EditText nameET, attendenceET, permissionET;
    private EmployeeDatabaseSource employeeDatabaseSource;
    private Employee employee;
    private Button saveBtn;
    private TextView msgTV;

    private static final String Present = "P";
    private static final String Absent = "A";
    private static final String Late = "L";
    private static final String Holiday = "H";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbyleader_attendence);

        saveBtn =findViewById(R.id.saveBtn);


        employeeDatabaseSource = new EmployeeDatabaseSource(this);
        nameET = findViewById(R.id.employeeNameET);
        attendenceET =  findViewById(R.id.employeeAttendenceET);
        permissionET = findViewById(R.id.employeePermissionET);
        msgTV = findViewById(R.id.msgtv);

        employee = (Employee) getIntent().getSerializableExtra("employee");
        if (employee !=null){


            nameET.setText(employee.getemployeeName());
            attendenceET.setText(employee.getattendence());
            permissionET.setText(String.valueOf(employee.getpermission()));


        }

    }

    
    public void show(View view) {
        startActivity(new Intent(Attendence_CheckbyLeader_Activity.this,EmployeeListActivity.class));
    }

    public void updateEmploye(View view) {


         do {
            String name = nameET.getText().toString();
            String att = attendenceET.getText().toString();
            String per = permissionET.getText().toString();


            Employee employee = new Employee(name, att, per);
            boolean status = employeeDatabaseSource.updateEmployee(employee);

            if (status) {
                Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "could not updated", Toast.LENGTH_SHORT).show();
            }
        }while (employee != null);



    }

    public void deleteEmploye(View view) {
    }
}
