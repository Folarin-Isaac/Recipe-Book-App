package com.example.recipebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    String firstData[], secondData[];
    int images[];
    Context context;

    public HomeAdapter(Context ct, String name[], String message[], int img[]){
        context = ct;
        firstData = name;
        secondData = message;
        images = img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(firstData[position]);
        holder.textView2.setText(secondData[position]);
        holder.image1.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;
        ImageView image1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView1 = itemView.findViewById(R.id.textView1);
            image1 = itemView.findViewById(R.id.image1);
        }
    }
}
