package com.ejercicio.proyectofinal.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ejercicio.proyectofinal.LoginActivity;
import com.ejercicio.proyectofinal.R;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.home_fragment_layout, container, false);
            TextView textobienvenida = view.findViewById(R.id.textbienvenida);
            SharedPreferences preferences = getActivity().getSharedPreferences("myprefs", Context.MODE_PRIVATE);
            String user = preferences.getString("usuario", "");
            textobienvenida.setText("Bienvenido, "+ user);
            return view;
    }



}
