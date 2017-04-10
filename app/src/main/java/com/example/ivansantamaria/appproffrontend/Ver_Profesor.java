package com.example.ivansantamaria.appproffrontend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ver_Profesor extends AppCompatActivity {

    private TextView user;
    private TextView ciudad;
    private TextView experiencia;
    private Spinner asignaturas;
    private Spinner cursos;
    private Spinner horario;
    private TextView email;
    private TextView telefono;
    private TextView modalidad;
    private TextView valoracionMedia;
    private EditText valoracion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_profesor);

        populateFields();

    }

    private void populateAsignaturasSpinner() {

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Sistemas II");
        spinnerArray.add("FAE");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asignaturas = (Spinner) findViewById(R.id.asignaturasProfesorPerfil);
        asignaturas.setAdapter(adapter);

    }

    private void populateFields() {

        user = (TextView) findViewById(R.id.nombreProfesorPerfil);
        user.setText(" Luis Fueris");

        ciudad = (TextView) findViewById(R.id.ciudadProfesorPerfil);
        ciudad.setText(" Kuala Lumpur (Malasia)");

        experiencia = (TextView) findViewById(R.id.experienciaProfesorPerfil);
        experiencia.setText(" matemáticas y física");

        populateAsignaturasSpinner();
        //populateCursosSpinner();

        email = (TextView) findViewById(R.id.emailProfesorPerfil);
        email.setText(" lfueris@gmail.com");

        telefono = (TextView) findViewById(R.id.tlfnoProfesorPerfil);
        telefono.setText(" 656626425");

        modalidad = (TextView) findViewById(R.id.modalidadProfesorPerfil);
        modalidad.setText(" on-line");

        valoracionMedia = (TextView) findViewById(R.id.valoracionesProfesorPerfil);
        valoracionMedia.setText(" 4,75");

        valoracion = (EditText) findViewById(R.id.valoracionProfesorPerfil);

    }

}
