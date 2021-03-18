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

        entrada_array.add(new Entrada("VIRTUOSO", "a", "16/03/2021", "Nivel Avanzado", "Conviértete en un fabuloso guitarrista gracias a nuestro fabuloso método basado en los mejores clickbaits de Youtube. \n" +
                "Conocerás todos los secretos de la técnica de los mejores \"Room-guitarist\" de Youtube. Tocarás como nadie sin salir de tu habitación.\n" +
                "Olvídate del miedo escénico y de salir de tediosas giras donde no comerás bien y dormirás en un catre.\n" +
                "Tus vértebras lo agradecerán! Todo ello por un módico precio de 55 €/mes.", "¿Imaginas dedicarte profesionalmente a la música? Mejor cambia de idea...\n" +
                "Si todavía sigues leyendo esto es que eres un verdadero apasionado. Cómprate una guitarra y comienza a aprender todo lo necesario para ser un gran profesional en el futuro.\n" +
                "Tenemos una gran biblioteca de recursos, métodos, programaciones y demás material necesario para que aprendas de la forma más cómoda y personalizada posible.\n" +
                "Soñar es gratis, pero cuantas más vueltas le des, peor. Lánzate ya a través de BEST ONLINE GUITAR LESSONS y antes de que te quieras dar cuenta, estarás tocando un gran concierto en tu garito favorito.", "j", "j"));
        entrada_array.add(new Entrada("GUITARRISTA", "c", "16/03/2021", "Nivel Básico", "Conviértete en un fabuloso guitarrista gracias a nuestro fabuloso método basado en los mejores clickbaits de Youtube. \n" +
                "Conocerás todos los secretos de la técnica de los mejores \"Room-guitarist\" de Youtube. Tocarás como nadie sin salir de tu habitación. \n" +
                "Olvídate del miedo escénico y de salir de tediosas giras donde no comerás bien y dormirás en un catre.\n" +
                "Tus vértebras lo agradecerán! Todo ello por un módico precio de 55 €/mes.", "¿Imaginas dedicarte profesionalmente a la música? Mejor cambia de idea...\n" +
                "Si todavía sigues leyendo esto es que eres un verdadero apasionado. Cómprate una guitarra y comienza a aprender todo lo necesario para ser un gran profesional en el futuro.\n" +
                "Tenemos una gran biblioteca de recursos, métodos, programaciones y demás material necesario para que aprendas de la forma más cómoda y personalizada posible.\n" +
                "Soñar es gratis, pero cuantas más vueltas le des, peor. Lánzate ya a través de BEST ONLINE GUITAR LESSONS y antes de que te quieras dar cuenta, estarás tocando un gran concierto en tu garito favorito.", "a", "c"));
        entrada_array.add(new Entrada("PROFESIONAL", "e", "16/03/2021", "Nivel Intermedio", "Conviértete en un fabuloso guitarrista gracias a nuestro fabuloso método basado en los mejores clickbaits de Youtube. \n" +
                "Conocerás todos los secretos de la técnica de los mejores \"Room-guitarist\" de Youtube. Tocarás como nadie sin salir de tu habitación.\n" +
                "Olvídate del miedo escénico y de salir de tediosas giras donde no comerás bien y dormirás en un catre.\n" +
                "Tus vértebras lo agradecerán! Todo ello por un módico precio de 55 €/mes.", "¿Imaginas dedicarte profesionalmente a la música? Mejor cambia de idea...\n" +
                "Si todavía sigues leyendo esto es que eres un verdadero apasionado. Cómprate una guitarra y comienza a aprender todo lo necesario para ser un gran profesional en el futuro.\n" +
                "Tenemos una gran biblioteca de recursos, métodos, programaciones y demás material necesario para que aprendas de la forma más cómoda y personalizada posible.\n" +
                "Soñar es gratis, pero cuantas más vueltas le des, peor. Lánzate ya a través de BEST ONLINE GUITAR LESSONS y antes de que te quieras dar cuenta, estarás tocando un gran concierto en tu garito favorito.", "n", "n"));
        entrada_array.add(new Entrada("NIÑOS", "f", "16/03/2021", "Nivel Básico", "Conviértete en un fabuloso guitarrista gracias a nuestro fabuloso método basado en los mejores clickbaits de Youtube. Conocerás todos los secretos de la técnica de los mejores \\\"Room-guitarist\\\" de Youtube. Tocarás como nadie sin salir de tu habitación. \n" +
                "Olvídate del miedo escénico y de salir de tediosas giras donde no comerás bien y dormirás en un catre. Tus vértebras lo agradecerán! Todo ello por un módico precio de 55 €/mes.", "¿Imaginas dedicarte profesionalmente a la música? Mejor cambia de idea...\n" +
                "Si todavía sigues leyendo esto es que eres un verdadero apasionado. Cómprate una guitarra y comienza a aprender todo lo necesario para ser un gran profesional en el futuro.\n" +
                "Tenemos una gran biblioteca de recursos, métodos, programaciones y demás material necesario para que aprendas de la forma más cómoda y personalizada posible.\n" +
                "Soñar es gratis, pero cuantas más vueltas le des, peor. Lánzate ya a través de BEST ONLINE GUITAR LESSONS y antes de que te quieras dar cuenta, estarás tocando un gran concierto en tu garito favorito.", "d", "d"));
        entrada_array.add(new Entrada("SUPER PACK", "d", "16/03/2021", "Nivel Intermedio", "Conviértete en un fabuloso guitarrista gracias a nuestro fabuloso método basado en los mejores clickbaits de Youtube. Conocerás todos los secretos de la técnica de los mejores \\\"Room-guitarist\\\" de Youtube. Tocarás como nadie sin salir de tu habitación. \n" +
                "Olvídate del miedo escénico y de salir de tediosas giras donde no comerás bien y dormirás en un catre. Tus vértebras lo agradecerán! Todo ello por un módico precio de 55 €/mes.", "¿Imaginas dedicarte profesionalmente a la música? Mejor cambia de idea...\n" +
                "Si todavía sigues leyendo esto es que eres un verdadero apasionado. Cómprate una guitarra y comienza a aprender todo lo necesario para ser un gran profesional en el futuro.\n" +
                "Tenemos una gran biblioteca de recursos, métodos, programaciones y demás material necesario para que aprendas de la forma más cómoda y personalizada posible.\n" +
                "Soñar es gratis, pero cuantas más vueltas le des, peor. Lánzate ya a través de BEST ONLINE GUITAR LESSONS y antes de que te quieras dar cuenta, estarás tocando un gran concierto en tu garito favorito.", "g", "g"));
        entrada_array.add(new Entrada("SESSION MUSICIAN", "b", "16/03/2021", "Nivel Avanzado", "Conviértete en un fabuloso guitarrista gracias a nuestro fabuloso método basado en los mejores clickbaits de Youtube. Conocerás todos los secretos de la técnica de los mejores \\\"Room-guitarist\\\" de Youtube. Tocarás como nadie sin salir de tu habitación. \n" +
                "Olvídate del miedo escénico y de salir de tediosas giras donde no comerás bien y dormirás en un catre. Tus vértebras lo agradecerán! Todo ello por un módico precio de 55 €/mes.", "¿Imaginas dedicarte profesionalmente a la música? Mejor cambia de idea...\n" +
                "Si todavía sigues leyendo esto es que eres un verdadero apasionado. Cómprate una guitarra y comienza a aprender todo lo necesario para ser un gran profesional en el futuro.\n" +
                "Tenemos una gran biblioteca de recursos, métodos, programaciones y demás material necesario para que aprendas de la forma más cómoda y personalizada posible.\n" +
                "Soñar es gratis, pero cuantas más vueltas le des, peor. Lánzate ya a través de BEST ONLINE GUITAR LESSONS y antes de que te quieras dar cuenta, estarás tocando un gran concierto en tu garito favorito.", "k", "k"));
        entrada_array.add(new Entrada("BASS PLAYER", "k", "16/03/2021", "Nivel Básico", "Conviértete en un fabuloso guitarrista gracias a nuestro fabuloso método basado en los mejores clickbaits de Youtube. Conocerás todos los secretos de la técnica de los mejores \\\"Room-guitarist\\\" de Youtube. Tocarás como nadie sin salir de tu habitación. \n" +
                "Olvídate del miedo escénico y de salir de tediosas giras donde no comerás bien y dormirás en un catre. Tus vértebras lo agradecerán! Todo ello por un módico precio de 55 €/mes.", "¿Imaginas dedicarte profesionalmente a la música? Mejor cambia de idea...\n" +
                "Si todavía sigues leyendo esto es que eres un verdadero apasionado. Cómprate una guitarra y comienza a aprender todo lo necesario para ser un gran profesional en el futuro.\n" +
                "Tenemos una gran biblioteca de recursos, métodos, programaciones y demás material necesario para que aprendas de la forma más cómoda y personalizada posible.\n" +
                "Soñar es gratis, pero cuantas más vueltas le des, peor. Lánzate ya a través de BEST ONLINE GUITAR LESSONS y antes de que te quieras dar cuenta, estarás tocando un gran concierto en tu garito favorito.", "l", "l"));
        entrada_array.add(new Entrada("GUITARRA ACÚSTICA", "n", "16/03/2021", "Nivel Básico", "Conviértete en un fabuloso guitarrista gracias a nuestro fabuloso método basado en los mejores clickbaits de Youtube. Conocerás todos los secretos de la técnica de los mejores \\\"Room-guitarist\\\" de Youtube. Tocarás como nadie sin salir de tu habitación. \n" +
                "Olvídate del miedo escénico y de salir de tediosas giras donde no comerás bien y dormirás en un catre. Tus vértebras lo agradecerán! Todo ello por un módico precio de 55 €/mes.", "¿Imaginas dedicarte profesionalmente a la música? Mejor cambia de idea...\n" +
                "Si todavía sigues leyendo esto es que eres un verdadero apasionado. Cómprate una guitarra y comienza a aprender todo lo necesario para ser un gran profesional en el futuro.\n" +
                "Tenemos una gran biblioteca de recursos, métodos, programaciones y demás material necesario para que aprendas de la forma más cómoda y personalizada posible.\n" +
                "Soñar es gratis, pero cuantas más vueltas le des, peor. Lánzate ya a través de BEST ONLINE GUITAR LESSONS y antes de que te quieras dar cuenta, estarás tocando un gran concierto en tu garito favorito.", "b", "b"));

        recycler.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        recycler.setLayoutManager(glm);
        EntradaAdapter adapter = new EntradaAdapter(entrada_array, getActivity());
        recycler.setAdapter(adapter);

    }



}
