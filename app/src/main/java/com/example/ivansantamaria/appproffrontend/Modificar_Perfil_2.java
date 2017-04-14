package com.example.ivansantamaria.appproffrontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Modificar_Perfil_2 extends AppCompatActivity implements MultiSpinner.MultiSpinnerListener {

    private Facade facade = null;
    private ProfesorVO profesor = null;

    private TextView user;
    private EditText experiencia;
    private MultiSpinner cursos = null;
    private Spinner modalidad = null;
    private Button confirmarButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar__perfil_2);

        final com.example.ivansantamaria.appproffrontend.Modificar_Perfil_2 local = this;
        confirmarButton = (Button) findViewById(R.id.confirmarMod);

        facade = new Facade();
        profesor = facade.perfilProfesor("Isak");
        populateFields();

        confirmarButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String experienciaProf = experiencia.getText().toString();
                String modalidaProf = modalidad.getSelectedItem().toString();
                ArrayList<String> cursosProf = cursos.getValues();

                //ACTUALIZAR BASE DE DATOS
                Intent i = new Intent(local, Perfil_Profesor.class);
                startActivityForResult(i, 0);

            }
        });

    }

    private void populateFields() {

        experiencia = (EditText) findViewById(R.id.experienciaProfesorMod);
        experiencia.setText(profesor.getExperiencia());

        user = (TextView) findViewById(R.id.usuarioProfesorMod);
        user.setText(profesor.getNombreUsuario());

        cursos = (MultiSpinner) findViewById(R.id.cursosProfesorMod);
        cursos.setItems(facade.getCursosDisponibles(),facade.getCursosDisponibles(),
                profesor.getCursos(),"", this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.row_spinner, facade.getModalidadesDisponibles());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modalidad = (Spinner) findViewById(R.id.modalidadProfesorMod);
        modalidad.setAdapter(adapter);
        if(profesor.getModalidad().equals("Presencial"))
            modalidad.setSelection(1);
        else if(profesor.getModalidad().equals("On-line"))
            modalidad.setSelection(2);
    }

    public void onItemsSelected(boolean[] selected) {
        //Esto hay que ponerlo pero a saber para que... seguiremos investigando
    }
}
