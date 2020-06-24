package com.example.recipebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {
    CardView card_view1;
    CardView card_view2;
    CardView card_view3;
    CardView card_view4;
    CardView card_view5;
    CardView card_view6;
    RecyclerView recyclerView1;

    String s1[], s2[];
    int images[] = {R.drawable.dot, R.drawable.dot, R.drawable.dot, R.drawable.dot, R.drawable.dot, R.drawable.dot};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        card_view1 = (CardView)findViewById(R.id.card_view1);
        card_view2 = (CardView)findViewById(R.id.card_view2);
        card_view3 = (CardView)findViewById(R.id.card_view3);
        card_view4 = (CardView)findViewById(R.id.card_view4);
        card_view5 = (CardView)findViewById(R.id.card_view5);
        card_view6 = (CardView)findViewById(R.id.card_view6);
        recyclerView1 = findViewById(R.id.recyclerView1);


//Home Adapter class to fetch the string array
        s1 = getResources().getStringArray(R.array.home_interface);
        s2 = getResources().getStringArray(R.array.home_description);

        HomeAdapter homeAdapter = new HomeAdapter( this, s1, s2, images);
        recyclerView1.setAdapter(homeAdapter);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));


// CardView to open another activity when clicked
        card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Faved_Recipe.class);
                startActivity(intent);

                card_view2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent(Home.this, Chats.class);
                        startActivity(intent1);

                        card_view3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent2 = new Intent(Home.this, Networks.class);
                                startActivity(intent2);

                                card_view4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent3 = new Intent(Home.this, Friends.class);
                                        startActivity(intent3);

                                        card_view5.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent4 = new Intent(Home.this, favourites.class);
                                                startActivity(intent4);

                                                card_view6.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intent5 = new Intent(Home.this, Profile.class);
                                                        startActivity(intent5);
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });


    }
}
