package com.cieep.a01_introduccinaandroidc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cieep.a01_introduccinaandroidc.modelos.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    // Variables de tipo Vista
    private TextView lblContador;
    private Button btnClick;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnRegistar;

    // Variables para la lógica
    private int contador;
    private ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = 0;
        listaUsuarios = new ArrayList<>();
        inicializaVistas();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Has Pulsado el botón", Toast.LENGTH_SHORT).show();
                contador++;
                lblContador.setText(contador+" veces");
            }
        });

        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                Usuario user = new Usuario(email, password);
                listaUsuarios.add(user);
                Toast.makeText(MainActivity.this, user.toString(), Toast.LENGTH_SHORT).show();
                txtPassword.setText("");
                txtEmail.setText("");
            }
        });

    }

    private void inicializaVistas() {
        lblContador = findViewById(R.id.lblContadorMain);
        btnClick = findViewById(R.id.btnClickMain);
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnRegistar = findViewById(R.id.btnRegisterMain);
    }

    public void btnClickContador(View vista){
        contador++;
        lblContador.setText(contador+" veces");
    }
}