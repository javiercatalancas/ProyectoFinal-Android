package com.ejercicio.proyectofinal.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ejercicio.proyectofinal.R;

public class ContactFragment extends Fragment {
    CardView cardmapa;
    CardView cardemail1;
    


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact_layout, container, false);
         cardmapa = v.findViewById(R.id.cardmap);
         cardemail1 = v.findViewById(R.id.cardmail);
        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        cardmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ESTA FÓRMULA NO ME FUNCIONA (developers.android)
//                Uri geoLocation = ("38.095009570458494, -3.6329260645501487");
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(geoLocation);
//                startActivity(intent);
                // ESTA SI
                Uri geo = Uri.parse("https://www.google.es/maps/place/Calle+Joaqu%C3%ADn+Ruano,+29,+23700+Linares,+Ja%C3%A9n/@38.0949579,-3.6334679,19z/data=!4m5!3m4!1s0xd6e9b32666e28db:0x91dacbc7f4dcee67!8m2!3d38.0949568!4d-3.6329207");
                Intent intent = new Intent(Intent.ACTION_VIEW, geo);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);

            }
        });

        cardemail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = "info@bestguitarlessons.es";
                String subject = "contactar";
                String text = "texto";

                Intent intent = new Intent((Intent.ACTION_SENDTO));
                intent.setType("*/*");
                intent.setData(Uri.parse("mailto:" + mail));
                intent.putExtra(Intent.EXTRA_EMAIL, "info@bestguitarlessons.es");
                intent.putExtra(Intent.EXTRA_SUBJECT, "contactar");
                intent.putExtra(Intent.EXTRA_TEXT, "texto");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
            } else startActivity(intent);
// OTRA FORMA
//                Intent correosend= new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","info@bestguitarlessons.es",null));
//                startActivity(correosend);
            }
        });



    }

}
