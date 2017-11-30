package com.sahitech.emplyeeattendence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EmployeeListActivity extends AppCompatActivity {
    private ListView employeeLV;
    private ArrayList<Employee>employeeList;
    private EmployeeDatabaseSource employeeDatabaseSource;

    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        employeeLV = findViewById(R.id.employeeListView);

        employeeDatabaseSource = new EmployeeDatabaseSource(this);
        employeeList = employeeDatabaseSource.getAllEmployees();

        employeeAdapter = new EmployeeAdapter(this,employeeList);

        employeeLV.setAdapter(employeeAdapter);

        employeeLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Employee employee = employeeList.get(i);
                startActivity(new Intent(EmployeeListActivity.this,Attendence_CheckbyLeader_Activity.class).putExtra("employee",employee));
            }
        });
    }
}
