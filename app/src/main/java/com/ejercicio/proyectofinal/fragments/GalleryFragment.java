package com.ejercicio.proyectofinal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.ejercicio.proyectofinal.R;
import com.ejercicio.proyectofinal.usingclasses.GalleryAdapter;
import com.ejercicio.proyectofinal.usingclasses.Images;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private ViewPager2 viewPager2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery_layout, container, false);
        viewPager2 = v.findViewById(R.id.viewpager2);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Images> listaimagenes = new ArrayList<>();
        listaimagenes.add(new Images(R.drawable.a, "Guitar"));
        listaimagenes.add(new Images(R.drawable.b, "Guitar2"));
        listaimagenes.add(new Images(R.drawable.d, "Guitar3"));
        listaimagenes.add(new Images(R.drawable.f, "Guitar4"));

        // Llamamos al adapter

        GalleryAdapter adapter = new GalleryAdapter(listaimagenes, getActivity());
        viewPager2.setAdapter(adapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                String titulo = listaimagenes.get(position).getTitle();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });




    }
}
