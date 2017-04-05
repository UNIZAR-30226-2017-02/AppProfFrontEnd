package com.example.ivansantamaria.appproffrontend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class Ver_Profesor extends AppCompatActivity {

    private TextView user;
    private TextView ciudad;
    private TextView experiencia;
    private TextView email;
    private TextView telefono;
    private TextView modalidad;
    private TextView valoracionMedia;
    private EditText valoracion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil__profesor);

        populateFields();

    }

    private void populateFields() {
        user = (TextView) findViewById(R.id.nombreProfesorPerfil);
        user.setText("Luis Fueris Martín");
        ciudad = (TextView) findViewById(R.id.ciudadProfesorPerfil);
        ciudad.setText("Kuala Lumpur (Malasia)");
        experiencia = (TextView) findViewById(R.id.ciudadProfesorPerfil);
        experiencia.setText("matemáticas y física");
        email = (TextView) findViewById(R.id.emailProfesorPerfil);
        email.setText("lfueris@gmail.com");
        telefono = (TextView) findViewById(R.id.tlfnoProfesorPerfil);
        telefono.setText("656626425");
        modalidad = (TextView) findViewById(R.id.modalidadProfesorPerfil);
        modalidad.setText("on-line");
        valoracionMedia = (TextView) findViewById(R.id.valoracionesProfesorPerfil);
        valoracionMedia.setText("4,75");
        valoracion = (EditText) findViewById(R.id.valoracionProfesorPerfil);
        valoracion.setText("");
    }
}
