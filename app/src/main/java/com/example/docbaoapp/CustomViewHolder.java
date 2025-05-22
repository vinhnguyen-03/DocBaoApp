package com.example.docbaoapp;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import  android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView txt_title, txt_source, txt_date;
    ImageView img_headline;
    CardView cardView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_title = itemView.findViewById(R.id.txt_title);
        txt_source = itemView.findViewById(R.id.txt_source);
        img_headline = itemView.findViewById(R.id.img_headline);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
