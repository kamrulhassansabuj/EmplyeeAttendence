package com.sahitech.emplyeeattendence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by sabujsahi on 10/13/17.
 */

public class EmployeeDatabaseSource {
    private EmployeeDatabaseHelper employeeDatabaseHelper;
    private SQLiteDatabase db;
    private Employee employee;


    public EmployeeDatabaseSource(Context context) {

        employeeDatabaseHelper = new EmployeeDatabaseHelper(context);


    }

    public void open(){
        db = employeeDatabaseHelper.getWritableDatabase();
    }

    public void closed(){

        db.close();

    }

    public boolean addEmployee(Employee employee){
        this.open();
        ContentValues values = new ContentValues();
        values.put(EmployeeDatabaseHelper.EMPLOYEE_COL_NAME,employee.getemployeeName());
        values.put(EmployeeDatabaseHelper.EMPLOYEE_COL_ATTENDENCE,employee.getattendence());
        values.put(EmployeeDatabaseHelper.EMPLOYEE_COL_PERMISSION,employee.getpermission());

        long insertedRow = db.insert(EmployeeDatabaseHelper.TABLE_EMPLOYEE,null,values);
        this.closed();
        if (insertedRow > 0){
            return true;
        }else {
            return false;
        }


    }

    public boolean updateEmployee(Employee employee){


        this.open();

        ContentValues values = new ContentValues();
        values.put(EmployeeDatabaseHelper.EMPLOYEE_COL_ID,employee.getemployeeId());
        values.put(EmployeeDatabaseHelper.EMPLOYEE_COL_NAME,employee.getemployeeName());
        values.put(EmployeeDatabaseHelper.EMPLOYEE_COL_ATTENDENCE,employee.getattendence());
        values.put(EmployeeDatabaseHelper.EMPLOYEE_COL_PERMISSION,employee.getpermission());


        int updatedValue =db.update(EmployeeDatabaseHelper.TABLE_EMPLOYEE,values,EmployeeDatabaseHelper.EMPLOYEE_COL_ID+" =? ",new String[] {String.valueOf(employee.getemployeeId())});

        //update dosen't work

        //int updatedValue = db.update(EmployeeDatabaseHelper.TABLE_EMPLOYEE,values,"_id = ?",new String[] { EmployeeDatabaseHelper.EMPLOYEE_COL_ID });



        if (updatedValue > 0){

            return true;
        }else
            return false;
    }

    public ArrayList<Employee> getAllEmployees(){
        this.open();

        ArrayList<Employee>employees = new ArrayList<>();
       Cursor cursor = db.query(EmployeeDatabaseHelper.TABLE_EMPLOYEE,null,null,null,null,null,null);

        if (cursor != null && cursor.getCount() > 0){

            cursor.moveToFirst();
            for (int i =0; i< cursor.getCount(); i++){


                int id = cursor.getInt(cursor.getColumnIndex(EmployeeDatabaseHelper.EMPLOYEE_COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMPLOYEE_COL_NAME));
                String manu = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMPLOYEE_COL_ATTENDENCE));
                String price = cursor.getString(cursor.getColumnIndex(EmployeeDatabaseHelper.EMPLOYEE_COL_PERMISSION));

                Employee employee = new Employee(id,name,manu,price);
                employees.add(employee);
                cursor.moveToNext();
            }

        }

        this.closed();
        cursor.close();
        return employees;

    }

    public boolean deleteEmployee(int employeeID){
        this.open();
        int deletedRow = db.delete(EmployeeDatabaseHelper.TABLE_EMPLOYEE,EmployeeDatabaseHelper.EMPLOYEE_COL_ID+" = "+employeeID,null);
        if (deletedRow > 0){
            return true;

        }else {
            return false;
        }




    }

}
