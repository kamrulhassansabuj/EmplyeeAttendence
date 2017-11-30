package com.sahitech.emplyeeattendence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button EmployeeBTN;
    Button LeaderBTN;
    Button hrBTN;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeeBTN = findViewById(R.id.EmplyeeBtn);
        LeaderBTN = findViewById(R.id.GroupLeaderBtn);
        hrBTN = findViewById(R.id.HRBtn);




        EmployeeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Employee_Login.class);
                startActivity(intent);
            }
        });

        LeaderBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LeaderLogin_Activity.class);
                startActivity(intent);

            }
        });

        hrBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Employee_Login.class);
                startActivity(intent);

            }
        });

    }


}
