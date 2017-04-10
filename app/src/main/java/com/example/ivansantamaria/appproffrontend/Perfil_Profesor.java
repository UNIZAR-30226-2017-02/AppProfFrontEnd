package com.example.ivansantamaria.appproffrontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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
    private Button modificarButton = null;
    private Button pagarButton = null;
    private Spinner horarios = null;
    private Spinner cursos = null;
    private Spinner asignaturas = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil__profesor);

        final com.example.ivansantamaria.appproffrontend.Perfil_Profesor local = this;
        modificarButton = (Button) findViewById(R.id.modifyProfesor);
        pagarButton = (Button) findViewById(R.id.pagarProfesor);

        /*
        modificarButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(local, Pagar_Profesor.class);
                startActivityForResult(i, 0);
            }
        });*/

        pagarButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(local, Pagar_Profesor.class);
                startActivityForResult(i, 0);
            }
        });

        facade = new Facade();
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

        if(!profesor.getHorarios().isEmpty()) {
            horarios = (Spinner) findViewById(R.id.horarioProfesor);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_spinner_dropdown_item, profesor.getHorarios());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            horarios.setAdapter(adapter);
            horarios.setSelection(0);
        }

        if(!profesor.getCursos().isEmpty()) {
            cursos = (Spinner) findViewById(R.id.cursosProfesor);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    R.layout.row_spinner, profesor.getCursos());
            cursos.setAdapter(adapter);
            cursos.setSelection(0);
        }

        if(!profesor.getAsignaturas().isEmpty()) {
            asignaturas = (Spinner) findViewById(R.id.asignaturasProfesor);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    R.layout.row_spinner, profesor.getAsignaturas());
            asignaturas.setAdapter(adapter);
            asignaturas.setSelection(0);
        }
    }
}
