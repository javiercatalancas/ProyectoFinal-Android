package com.ejercicio.proyectofinal.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ejercicio.proyectofinal.R;
import com.ejercicio.proyectofinal.usingclasses.Entrada;
import com.ejercicio.proyectofinal.usingclasses.EntradaAdapter;

import java.util.ArrayList;

public class BlogFragment extends Fragment {

    RecyclerView recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blog_fragment_layout, container, false);
        recycler = view.findViewById(R.id.recyclergrid);
        SharedPreferences preferences = getActivity().getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        String user = preferences.getString("usuario", "");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Entrada> entrada_array = new ArrayList<>();

        entrada_array.add(new Entrada("VIRTUOSO", "a", "16/03/2021", "Conviértete em un virtuoso de la guitarra", "Nivel Avanzado", "Orelar", "a", "a"));
        entrada_array.add(new Entrada("VIRTUOSO", "a", "16/03/2021", "Conviértete em un virtuoso de la guitarra", "Nivel Avanzado", "Orelar", "a", "a"));
        recycler.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        recycler.setLayoutManager(glm);
        EntradaAdapter adapter = new EntradaAdapter(entrada_array, getActivity());
        recycler.setAdapter(adapter);


    }



}
