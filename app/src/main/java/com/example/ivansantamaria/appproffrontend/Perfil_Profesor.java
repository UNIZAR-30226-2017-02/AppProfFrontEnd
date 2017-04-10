package com.example.ivansantamaria.appproffrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Perfil_Profesor extends AppCompatActivity {

    private Facade facade = null;
    private ProfesorVO profesor = null;
    private TextView user;
    private TextView valoracion;
    private TextView telefono;
    private TextView email;
    private TextView ciudad;
    private TextView experiencia;
    private TextView modalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil__profesor);

        profesor = facade.perfilProfesor("Isak");
        populateFields();

    }

    private void populateFields() {
        user = (TextView) findViewById(R.id.usuarioProfesor);
        user.setText(profesor.getNombreUsuario());

        valoracion = (TextView) findViewById(R.id.valoracionProfesor);
        valoracion.setText(profesor.getValoracion().toString());

        telefono = (TextView) findViewById(R.id.tlfnoProfesor);
        telefono.setText(profesor.getTelefono());

        email = (TextView) findViewById(R.id.emailProfesor);
        email.setText(profesor.getTelefono());

        ciudad = (TextView) findViewById(R.id.ciudadProfesor);
        ciudad.setText(profesor.getTelefono());

        experiencia = (TextView) findViewById(R.id.experienciaProfesor);
        experiencia.setText(profesor.getExperiencia());

        modalidad = (TextView) findViewById(R.id.modalidadProfesor);
        modalidad.setText(profesor.getModalidad());
    }
}
