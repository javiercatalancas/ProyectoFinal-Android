package com.ejercicio.proyectofinal.usingclasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ejercicio.proyectofinal.R;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<Images> arrayimages;
    private final Context context;

    public GalleryAdapter(ArrayList<Images> arrayimages, Context context){
        this.arrayimages=arrayimages;
        this.context=context;
    }

    static class MyHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;

        public MyHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imagegallery);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false);
        MyHolder myHolder = new MyHolder(v);
        return myHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Images image = arrayimages.get(position);
        int image_res = image.getImage();
        MyHolder myHolder =(MyHolder) holder;
        myHolder.imageView.setImageResource(image_res);

    }

    @Override
    public int getItemCount() {
        return arrayimages.size();
    }
}
