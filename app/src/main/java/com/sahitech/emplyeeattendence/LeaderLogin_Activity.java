package com.sahitech.emplyeeattendence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LeaderLogin_Activity extends AppCompatActivity {
    EditText EmailET;
    EditText PassET;
    Button loginBtn;
    TextView errorTV;
    String useremail;
    String userpassword;

    private static final String leaderEmail = "l";
    private static final String leaderPassword = "l";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderlogin);

        EmailET = findViewById(R.id.email);
        PassET = findViewById(R.id.password);
        loginBtn = findViewById(R.id.submitlogin);


        errorTV = findViewById(R.id.error);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                useremail =EmailET.getText().toString();

                userpassword = PassET.getText().toString();

                if (leaderEmail.equals(useremail)  && leaderPassword.equals(userpassword)){
                    Toast.makeText(LeaderLogin_Activity.this, "Login Successfull", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),Attendence_CheckbyLeader_Activity.class);
                    startActivity(intent);


                }else
                    errorTV.setText("Wrong Email or Password");
            }
        });

    }


}
