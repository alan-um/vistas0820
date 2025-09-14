package com.example.vistas0820;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.vistas0820.databinding.ActivityMainBinding;
import com.example.vistas0820.databinding.ActivityVerUsuarioBinding;

import ViewModel.VerUsuarioViewModel;

public class VerUsuario extends AppCompatActivity {

    private ActivityVerUsuarioBinding verUsuarioBindind;
    private VerUsuarioViewModel verUsuarioViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        verUsuarioBindind = ActivityVerUsuarioBinding.inflate(getLayoutInflater());
        verUsuarioViewModel = new ViewModelProvider(this).get(VerUsuarioViewModel.class);

        EdgeToEdge.enable(this);
        setContentView(verUsuarioBindind.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        verUsuarioViewModel.getMutableUsuario().observe(this, usuario -> {
            //verUsuarioBindind.etDNI.setText(Integer.toString(usuario.getDni()));
            verUsuarioBindind.etDNI.setText(String.valueOf(usuario.getDni()));
            verUsuarioBindind.etNombre.setText(usuario.getNombre());
            verUsuarioBindind.etApellido.setText("Hardcode");
            verUsuarioBindind.etUsuario.setText(usuario.getUsuario());
        });

        verUsuarioViewModel.recuperaIntent(getIntent());
    }
}