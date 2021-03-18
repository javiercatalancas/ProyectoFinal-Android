package com.ejercicio.proyectofinal;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ejercicio.proyectofinal.usingclasses.Entrada;

public class EntryBlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_activity_layout);
        Bundle bundle = getIntent().getBundleExtra("extra");
        Entrada entrada = bundle.getParcelable("objeto");
        ImageView imghead = findViewById(R.id.imagehead);
        ImageView img2 = findViewById(R.id.imageblog2);
        TextView text1 = findViewById(R.id.textblog1);
        TextView text2 = findViewById(R.id.textblog2);
        TextView text3 = findViewById(R.id.textblog3);
        TextView textfechaid = findViewById(R.id.textfecha);

        setTitle(entrada.getTitulo());
        text1.setText(entrada.getText1());
        text2.setText(entrada.getText2());
        text3.setText(entrada.getText3());
        textfechaid.setText(entrada.getFecha());

        int url = getResources().getIdentifier(entrada.getImagenprinc(), "drawable", getPackageName());
        imghead.setImageResource(url);
        int url2 = getResources().getIdentifier(entrada.getImg1(), "drawable", getPackageName());
        img2.setImageResource(url2);



    }
}
