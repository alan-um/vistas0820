package com.example.vistas0820;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.vistas0820.databinding.ActivityMainBinding;

import ViewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding; //Declara en MainBinding
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater()); //Inicializa el MainBinding
        mainViewModel=new ViewModelProvider(this).get(MainViewModel.class); //Inicializa el MainViewModel

        EdgeToEdge.enable(this);
        setContentView(mainBinding.getRoot()); //Ahora usamos el MainBindig para cargar la vista.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //---------------CARGAMOS LOS OBSERVE DE LA ACTIVITY!!---------------------
        //Observe de forma larga
        /*mainViewModel.getMutableMsg().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mainBinding.tvMsg.setText(s);
            }
        });*/
        //Observe con funciones lamda.
        mainViewModel.getMutableMsg().observe(this, msg->{
            mainBinding.tvMsg.setText(msg);
        });

        mainViewModel.getMutableUsuario().observe(this, usuario->{
            //mainBinding.tvMsg.setText(msg);
            Intent intent = new Intent(this, VerUsuario.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        });


        //---------------CARGAMOS LOS LISTENER DE LA ACTIVITY!!---------------------
        //Listener de forma larga
        /*mainBinding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.login(mainBinding.etUsuario.getText().toString(),mainBinding.etPassword.getText().toString());
            }
        });*/
        //Listener con funciones lamda.
        mainBinding.btLogin.setOnClickListener(v -> {
            mainViewModel.login(mainBinding.etUsuarioLogin.getText().toString(),mainBinding.etPasswordLogin.getText().toString());
        });

        mainBinding.tvMsg.setText("");
    }
}