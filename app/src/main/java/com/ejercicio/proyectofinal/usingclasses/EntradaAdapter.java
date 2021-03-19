package com.ejercicio.proyectofinal.usingclasses;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.ejercicio.proyectofinal.EntryBlogActivity;
import com.ejercicio.proyectofinal.MainActivity;
import com.ejercicio.proyectofinal.R;
import com.ejercicio.proyectofinal.fragments.BlogFragment;
import com.ejercicio.proyectofinal.fragments.EntryBlogFragment;

import java.util.ArrayList;

public class EntradaAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<Entrada> datos;
    private final Context context;

    // Constructor
    public EntradaAdapter(ArrayList<Entrada> datos, Context context) {
        this.datos = datos;
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.blog_holder, parent, false);
        return new EntradaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EntradaHolder eholder = (EntradaHolder) holder;
        final Entrada entrada = datos.get(position);
        String descrip = entrada.getTitulo();
        String imagen = entrada.getImagenprinc();
        String level = entrada.getText1();
        eholder.setText(descrip, imagen, level);

        eholder.buttontransp.bringToFront();

        eholder.buttontransp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // HACER CON INTENTS
                Intent intent = new Intent(context, EntryBlogActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("objeto", entrada);
                intent.putExtra("extra", bundle);
                context.startActivity(intent);
                Toast.makeText(context, "CLICK", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    class EntradaHolder extends RecyclerView.ViewHolder{
        private final TextView descripcion;
        private final ImageView image;
        private final TextView nivel;
        private final Button buttontransp;

        public EntradaHolder(@NonNull View view) {
            super(view);
            descripcion = view.findViewById(R.id.textdescripcion);
            image = view.findViewById(R.id.imageholder);
            nivel = view.findViewById(R.id.textnivel);
            buttontransp =view.findViewById(R.id.buttontrans);

        }

        public void setText(String descrip, String imagen, String level) {
            descripcion.setText(descrip);
            int url = context.getResources().getIdentifier(imagen, "drawable", context.getPackageName());
            image.setImageResource(url);
            nivel.setText(level);
        }
    }
}
