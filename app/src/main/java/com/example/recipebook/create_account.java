package com.example.recipebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class create_account extends AppCompatActivity {

    EditText fullName, Email, password, phoneNumber;
    Button create_button;
    FirebaseAuth fAuth;
    ProgressBar progress_bar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Email = findViewById(R.id.Email);
        fullName = findViewById(R.id.fullName);
        password = findViewById(R.id.password);
        phoneNumber = findViewById(R.id.phoneNumber);
        create_button = findViewById(R.id.create_button);
        progress_bar = findViewById(R.id.progress_bar);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),login_notification.class));
            finish();
        }





        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String Password = password.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Email.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    password.setError("Password is required!");
                    return;
                }
                if (Password.length() <6){
                    password.setError("Password must be >= 6 characters!");
                    return;
                }
                progress_bar.setVisibility(View.VISIBLE);

                //register the user in fireBase
                fAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(create_account.this, "User has been created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),login_notification.class));
                        }else {
                            Toast.makeText(create_account.this, "Error has occurred"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            
                        }

                    }
                });

            }
        });

    }
}
