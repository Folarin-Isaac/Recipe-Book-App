package com.example.recipebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Recipe extends AppCompatActivity {
    ImageView image1;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        textView1 = findViewById(R.id.textView2);
        image1 =(ImageView)findViewById(R.id.image1);

        //set Image1 to open the home activity
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Recipe.this, Home.class);
                startActivity(intent);
            }
        });

        String text = "Recipe by Collins Damawa";
        Spannable spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(Color.GRAY),0,8,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.GREEN),9,24,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView1.setText(spannable);
    }
}
