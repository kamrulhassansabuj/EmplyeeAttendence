package com.sahitech.emplyeeattendence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sabujsahi on 10/13/17.
 */

public class EmployeeDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "employee_db";
    public static final int DATABASE_VERSION= 1;

    public static final String TABLE_EMPLOYEE = "tbl_employee";

    public static final String EMPLOYEE_COL_ID = "_id";
    public static final String EMPLOYEE_COL_NAME = "_name";
    public static final String EMPLOYEE_COL_ATTENDENCE = "_attendence";
    public static final String EMPLOYEE_COL_PERMISSION = "_permission";

    public static final String CREATE_TABLE_EMPLOYEE ="create table "+TABLE_EMPLOYEE+" ("+
            EMPLOYEE_COL_ID+" interger primary key, "+
            EMPLOYEE_COL_NAME+" text, "+
            EMPLOYEE_COL_ATTENDENCE+" text, "+
            EMPLOYEE_COL_PERMISSION+" text);";



    public EmployeeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_EMPLOYEE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_EMPLOYEE);
        onCreate(sqLiteDatabase);

    }
}
