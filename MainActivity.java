package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btLogin;

    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        btLogin=findViewById(R.id.bt_login);

        login=new Login(getApplicationContext());

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUsername=etUsername.getText().toString().trim();
                String sPassword=etPassword.getText().toString().trim();

                if(sPassword.equals("")){
                    etPassword.setError("Please Enter the Password");
                }
                if(sPassword.equals("xcodeemulators")){
                    login.setLogin(true);
                    login.setUsername(sUsername);
                    startActivity(new Intent(getApplicationContext(),
                            MainActivity2.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext()
                    ,"Wrong Password",Toast.LENGTH_SHORT).show();
                }

            }
        });

        if(login.getLogin()){
            startActivity(new Intent(getApplicationContext()
            ,MainActivity2.class));
        }

    }
}