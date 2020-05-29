package com.example.recipebook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.WindowManager;
import android.widget.TextView;

public class Faved_Recipe extends AppCompatActivity {
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faved__recipe);
        textView1 = findViewById(R.id.textView2);
        String text = "Recipe by Collins Damawa";
        Spannable spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(Color.GRAY),0,8,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.GREEN),9,24,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView1.setText(spannable);
    }
}
