package com.ejercicio.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import com.ejercicio.proyectofinal.fragments.BlogFragment;
import com.ejercicio.proyectofinal.fragments.ContactFragment;
import com.ejercicio.proyectofinal.fragments.GalleryFragment;
import com.ejercicio.proyectofinal.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.ejercicio.proyectofinal.R.drawable.ic_baseline_exit_to_app_24;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FRAGMENT INICIAL ( HOME )

        BottomNavigationView navigationbottom = findViewById(R.id.bottomNavigationView);
        navigationbottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navigateToFragment(item.getItemId());
                return true;
            }
        });

        navigationbottom.setSelectedItemId(R.id.nav_home);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle(" Best Online Guitar Lessons");
       // toolbar.setCollapseIcon(ic_baseline_exit_to_app_24);

    }
    // SALIR DE LA APP
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

    // BOTÓN ATRÁS TOOLBAR
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            setResult(RESULT_CANCELED);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // SWITCH PARA NAVEGAR POR LOS FRAGMENTS
    private void navigateToFragment (int itemId){
        Fragment fragment;
        String title;

        switch (itemId) {
            default:
                fragment = new HomeFragment();
                title= "Home";
                break;

            case R.id.nav_home:
                fragment = new HomeFragment();
                title = "Home";
                break;

            case R.id.nav_blog:
                fragment = new BlogFragment();
                title = "Blog";
                break;

            case R.id.nav_gallery:
                fragment = new GalleryFragment();
                title = "Gallery";
                break;

            case R.id.nav_contact:
                fragment = new ContactFragment();
                title = "Contact";
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_fragment, fragment);
        transaction.commit();
        setTitle(title);

    }

    // ON CREATE OPTIONS MENU para el icono de salir (apuntes actionbar)

}