package com.sahitech.emplyeeattendence;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sabujsahi on 10/13/17.
 */

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context context;
    private ArrayList<Employee>Employees;
    public EmployeeAdapter(@NonNull Context context, ArrayList<Employee>Employees) {
        super(context, R.layout.employee_single_row, Employees);

        this.context =context;
        this.Employees =Employees;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.employee_single_row,parent,false);

        TextView name = convertView.findViewById(R.id.listEmplyeeName);
        TextView att = convertView.findViewById(R.id.listEmployeeAttendence);
        TextView permi = convertView.findViewById(R.id.listEmployeePermission);


        name.setText(Employees.get(position).getemployeeName());
        att.setText(Employees.get(position).getattendence());
        permi.setText(Employees.get(position).getpermission());
        return convertView;
    }
}
