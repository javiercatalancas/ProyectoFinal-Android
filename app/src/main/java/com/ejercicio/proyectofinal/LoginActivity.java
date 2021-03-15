package com.ejercicio.proyectofinal;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText sendmail;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        sendmail = findViewById(R.id.emailkk);
        TextInputEditText usuario = findViewById(R.id.textuser);
        TextInputEditText contra = findViewById(R.id.textpass);
        TextView restoremail = findViewById(R.id.restore);
        Button login = findViewById(R.id.login);
        TextView borrar = findViewById(R.id.delete);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = usuario.getText().toString();
                String userpass = contra.getText().toString();

                if(username.isEmpty()){
                    usuario.setError("Introduce un nombre de usuario válido");
                }

                if(userpass.isEmpty()){
                    contra.setError("Introduce una contraseña");
                }

                if ((username.contentEquals("invitado") && userpass.contentEquals("estech1234"))||(username.contentEquals("alumno") && userpass.contentEquals("alumno1234")||(username.contentEquals("profesor") && userpass.contentEquals("profesor1234"))))
                {
                    dialogNormal();
                   // Toast.makeText(LoginActivity.this, "credenciales correctas", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(LoginActivity.this, "username incorrecto", Toast.LENGTH_SHORT).show();

            }
        });

        restoremail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog();
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setText("");
                contra.setText("");
            }
        });


    }

    // SALIR DE LA APP CON DIALOG
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Mensaje del sistema");
        builder.setMessage("¿Desea salir de la aplicación?");

        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    // DIALOG
    public void dialogNormal() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Mensaje del Sistema");
        builder.setMessage("Login Successful");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                // AQUÍ HACEMOS UN INTENT PARA PASAR A LA SIGUIENTE ACTIVIDAD
              //  finish();
            }
        });
/*
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
*/
        AlertDialog dialog = builder.create();
        dialog.show();
}

    // DIALOG PARA REESTABLECER CONTRA
    public void customDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View v = getLayoutInflater().inflate(R.layout.custom_dialog, null);

        builder.setView(v);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String restoremail = sendmail.getText().toString();
                if (restoremail.isEmpty()) {
                    sendmail.setError("Introduce un email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(sendmail.getText().toString()).matches()) {
                    sendmail.setError("Introduce un email correcto");
                } else dialog.dismiss();
                Toast.makeText(LoginActivity.this, "Mensaje enviado con éxito", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.show();
/*
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sendmail = findViewById(R.id.sendemail);
                String mail = sendmail.getText().toString();

                if(mail.isEmpty()){
                    sendmail.setError("Introduce un email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    sendmail.setError("Introduce un email correcto");
                } else dialog.dismiss();
                Toast.makeText(LoginActivity.this, "Mensaje enviado con éxito", Toast.LENGTH_SHORT).show();

            }
        });
        */

    }}
