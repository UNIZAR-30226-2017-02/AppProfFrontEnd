package com.example.ivansantamaria.appproffrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Perfil_Profesor extends AppCompatActivity {

    private TextView user;
    private TextView valoracion;
    private EditText telefono;
    private EditText email;
    private EditText ciudad;
    private EditText experiencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil__profesor);

        populateFields();

    }

    private void populateFields() {
        user = (TextView) findViewById(R.id.usuarioProfesor);
        user.setText("Isak");
        valoracion = (TextView) findViewById(R.id.valoracionProfesor);
        valoracion.setText("4.72");
        telefono = (EditText) findViewById(R.id.tlfnoProfesor);
        telefono.setText("637 485 130");
        email = (EditText) findViewById(R.id.emailProfesor);
        email.setText("isakedo@gmail.com");
        ciudad = (EditText) findViewById(R.id.ciudadProfesor);
        ciudad.setText("Barcelona");
        experiencia = (EditText) findViewById(R.id.experienciaProfesor);
        experiencia.setText("10 años como profesor");
    }
}
