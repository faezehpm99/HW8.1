package com.example.hw81;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_SignUp = 0;
    private EditText logInName;
    private EditText logInPass;
    private Button loginBtn;
    private Button signUpBtn;
    // private user[] users =new user[1];
    private List<User> Users = new ArrayList<>();

    int current;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK || data == null)
            return;
        if (requestCode == REQUEST_CODE_SignUp) {
            Users.add((User) data.getParcelableExtra(SignupActivity2.EXTERA_NAMES_PASS));
            /* current=data.getIntExtra(SignupActivity2.CURRENTNUMBER,0);*/

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findValues();
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hello ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SignupActivity2.class);
                startActivityForResult(intent, REQUEST_CODE_SignUp);
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                for (User user : Users) {

                    if (user.getName().equalsIgnoreCase(logInName.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Hello ", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(MainActivity.this, "wedont have this user ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }

    private void findValues() {
        setContentView(R.layout.activity_main);
        logInName = findViewById(R.id.logIn_name);
        logInPass = findViewById(R.id.logIn_pass);
        loginBtn = findViewById(R.id.loginBtn);
        signUpBtn = findViewById(R.id.signinBtn);
    }
}