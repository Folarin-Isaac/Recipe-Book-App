package com.example.recipebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Chats extends AppCompatActivity {
    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.david_opeyemi, R.drawable.david_opeyemi, R.drawable.david_opeyemi, R.drawable.david_opeyemi, R.drawable.david_opeyemi,
            R.drawable.adebayo, R.drawable.adedunni};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(divider);


        s1 = getResources().getStringArray(R.array.chats_interface);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
