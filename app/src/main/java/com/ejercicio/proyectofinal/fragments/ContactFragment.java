package com.ejercicio.proyectofinal.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ejercicio.proyectofinal.LoginActivity;
import com.ejercicio.proyectofinal.MainActivity;
import com.ejercicio.proyectofinal.R;
import com.google.android.material.textfield.TextInputEditText;

public class ContactFragment extends Fragment {
    CardView cardmapa;
    CardView cardemail1;
    CardView cardemail2;
    CardView cardtel;
    CardView cardwhats;
    Button buttonform;
    CheckBox checkaccept;
    TextInputEditText nombre;
    TextInputEditText correo;
    TextInputEditText telefono;
    TextInputEditText subject;
    String nombresend;
    String correosend;
    String telefonosend;
    String subjectsend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact_layout, container, false);
         cardmapa = v.findViewById(R.id.cardmap);
         cardemail1 = v.findViewById(R.id.cardmail);
         cardemail2 = v.findViewById(R.id.cardmail2);
         cardtel = v.findViewById(R.id.cardcall);
         cardwhats = v.findViewById(R.id.cardwhatsapp);
         buttonform = v.findViewById(R.id.buttonsend);
         checkaccept = v.findViewById(R.id.checkBox);
         nombre = v.findViewById(R.id.textname);
         correo = v.findViewById(R.id.textemail);
         telefono = v.findViewById(R.id.textphone);
         subject = v.findViewById(R.id.textsubject);

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

        cardemail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent correosend= new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","contact@bestguitarlessons.es",null));
                startActivity(correosend);
            }
        });
        cardtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:953602560"));
                startActivity(intent);
            }
        });
        cardwhats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = "Hola, probando";
                String tel = "+34622858184";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String uri = "whatsapp://send?phone=" + tel + "&text=" + texto;
                intent.setData(Uri.parse(uri));
                startActivity(intent);


            }
        });

        buttonform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               nombresend = nombre.getText().toString();
               correosend = correo.getText().toString();
               telefonosend = telefono.getText().toString();
               subjectsend = subject.getText().toString();


                if(checkaccept.isChecked()){
                   if (!nombresend.isEmpty()){
                       if(!correosend.isEmpty()){
                           if(!telefonosend.isEmpty()){
                               if(!subjectsend.isEmpty()){
                                   dialogNormal();
                               } else subject.setError("Introduce un mensaje");
                           } else telefono.setError("Introduce un teléfono");
                       } else correo.setError("Introduce un correo");
                   } else nombre.setError("Introduce un nombre");
                }else Toast.makeText(getContext(), "Acepta las condiciones", Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void dialogNormal() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("¿Estás seguro de que quieres mandar el correo?");


        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String [] correoenviar = { "info@bestguitarlessons.es", "contact@bestguitarlessons.es"};

                Intent correosend= new Intent();
                correosend.setAction(Intent.ACTION_SEND);
                correosend.putExtra(Intent.EXTRA_EMAIL, correoenviar);
                correosend.putExtra(Intent.EXTRA_SUBJECT, "Mensaje de contacto");
                correosend.setType("*/*");
                correosend.putExtra(Intent.EXTRA_TEXT, "DATOS DE CONTACTO " + " \r\n \r\n " +"Nombre :" + nombresend + " \r\n \r\n " + "Email: " + correo.getText().toString() + " \r\n \r\n " + "Telefono :" + telefonosend + " \r\n \r\n " + "Mensaje :" + subjectsend);
                startActivity(correosend);
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                // BORRAR DATOS DEL FORMULARIO EN CASO DE NO MANDAR EMAIL
                nombre.setText("");
                correo.setText("");
                telefono.setText("");
                subject.setText("");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
