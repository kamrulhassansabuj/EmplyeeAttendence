package com.sahitech.emplyeeattendence;

import java.io.Serializable;

/**
 * Created by sabujsahi on 10/13/17.
 */

public class Employee implements Serializable{

    private int employeeId;
    private String employeeName;
    private String attendence;
    private String permission;

    public Employee(int employeeId, String employeeName, String attendence, String permission) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.attendence = attendence;
        this.permission = permission;
    }

    public int getemployeeId() {
        return employeeId;
    }

    public void setemployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(String employeeName, String attendence, String permission) {
        this.employeeName = employeeName;
        this.attendence = attendence;
        this.permission = permission;
    }

    public String getemployeeName() {
        return employeeName;
    }

    public void setemployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getattendence() {
        return attendence;
    }

    public void setattendence(String attendence) {
        this.attendence = attendence;
    }

    public String getpermission() {
        return permission;
    }

    public void setpermission(String permission) {
        this.permission = permission;
    }
}
