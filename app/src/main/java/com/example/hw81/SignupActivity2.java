package com.example.hw81;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity2 extends AppCompatActivity {
    public static final String EXTERA_NAMES_PASS = "names&pass";
    public static final String CURRENTNUMBER = "currentnumber";
    private EditText signUpName;
    private EditText signUppPass;
    private Button SignUp;
    private User user;
    private int current=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        signUpName=findViewById(R.id.signUp_name);
        signUppPass=findViewById(R.id.signUp_pass);
        SignUp=findViewById(R.id.signup);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (signUpName!=null&&signUppPass!=null){


                    user = new User(signUpName.getText().toString(),signUppPass.getText().toString());
//                    nameAndPass[current]= signUpName.getText().toString();
//                    nameAndPass[++current]=signUppPass.getText().toString();
                }
                current++;
                Intent intent=new Intent();
               /* Intent intent1=new Intent();
                intent1.putExtra(CURRENTNUMBER,current);
                setResult(RESULT_OK,intent1);*/
               /* intent.putExtra(EXTERA_NAMES_PASS,nameAndPass);*/
                intent.putExtra(EXTERA_NAMES_PASS,user);
                setResult(RESULT_OK,intent);
                finish();


            }
        });
    }
}