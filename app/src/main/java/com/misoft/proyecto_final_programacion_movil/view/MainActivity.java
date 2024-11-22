package com.misoft.proyecto_final_programacion_movil.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        TextView tvRegistrarse = findViewById(R.id.tvRegistrarse);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Configurar click listener para registro
        tvRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrerActivity.class);
                startActivity(intent);
            }
        });

        // Configurar listener para el BottomNavigationView
        bottomNavigationView1.setOnNavigationItemSelectedListener(
                new BottomNavigationView1.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        // Aquí debes manejar la selección de items del menú
                        // Por ejemplo:
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.menu_profile:
                                selectedFragment = new ProfileFragment();
                                break;
                            // Agregar más casos según tus necesidades
                        }

                        if (selectedFragment != null) {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.container, selectedFragment)
                                    .commit();
                        }

                        return true;
                    }
                });

        // Cargar el fragmento inicial
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.menu_home); // Selecciona el item inicial
        }
    }
}