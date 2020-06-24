package com.example.recipebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class login_notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_notification);

    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity( new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}
