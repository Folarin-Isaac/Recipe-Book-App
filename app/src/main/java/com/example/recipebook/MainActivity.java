package com.example.recipebook;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button button_login;
    EditText Email, password;
    Button button;
    FirebaseAuth fAuth;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_login = (Button)findViewById(R.id.button_login);
        button = (Button)findViewById(R.id.button);
        Email = findViewById(R.id.Email);
        password = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();

        //button to open a new activity when clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,create_account.class);
                startActivity(intent1);
            }
        });

        //button to open an new activity when clicked
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String Password = password.getText().toString().trim();

                //email authentication for users
                if (TextUtils.isEmpty(email)){
                    Email.setError("Email is required.");
                    return;
                }
                //password authentication for users
                if (TextUtils.isEmpty(Password)){
                    password.setError("Password is required!");
                    return;
                }
                if (Password.length() <6){
                    password.setError("Password must be >= 6 characters!");
                    return;
                }
                //authenticate the user from firebase
                fAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "User has been successfully logged in!.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Home.class));
                        }else {
                            Toast.makeText(MainActivity.this, "User not recognised"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}
