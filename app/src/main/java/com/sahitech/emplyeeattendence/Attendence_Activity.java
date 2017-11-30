package com.sahitech.emplyeeattendence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Attendence_Activity extends AppCompatActivity {

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
        setContentView(R.layout.activity_attendence);

        saveBtn =findViewById(R.id.saveBtn);


        employeeDatabaseSource = new EmployeeDatabaseSource(this);
        nameET = findViewById(R.id.employeeNameET);
        attendenceET =  findViewById(R.id.employeeAttendenceET);
        permissionET = findViewById(R.id.employeePermissionET);
        msgTV = findViewById(R.id.msgtv);

        employee = (Employee) getIntent().getSerializableExtra("employee");
        if (employee !=null){

            saveBtn.setText("Update Employee");
            nameET.setText(employee.getemployeeName());
            attendenceET.setText(employee.getattendence());
            permissionET.setText(String.valueOf(employee.getpermission()));


        }

    }

    public void saveEmployee(View view) {

        if (employee != null) {
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

        } else {
            String name = nameET.getText().toString();
            String att = attendenceET.getText().toString();
            String per = permissionET.getText().toString();

            Employee employee = new Employee(name, att, per);


            if (name != null && att != null && att.equals(Present) || att.equals(Absent) || att.equals(Late) || att.equals(Holiday)) {


                boolean status = employeeDatabaseSource.addEmployee(employee);
                if (status == true) {
                    Toast.makeText(Attendence_Activity.this, "Date Sent to Group Leader", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(Attendence_Activity.this, "Date Not Sent to Group Leader", Toast.LENGTH_SHORT).show();
            } else
                msgTV.setText("Please Check Your Input");


        }
    }

}
