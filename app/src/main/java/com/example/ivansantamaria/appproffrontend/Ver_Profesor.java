package com.example.ivansantamaria.appproffrontend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

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

    private RatingBar barraValoracion;
    private TextView txtValoracionPerfil;
    private Button btnEnviarValoracionPerfil;
    //private TextView txtRatingValue;
    //private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_profesor);

        addListenerOnRatingBar();
        addListenerOnButtonValoracion();

        populateFields();

    }

    public void addListenerOnRatingBar() {

        barraValoracion = (RatingBar) findViewById(R.id.ratingBarVerProfesor);
        txtValoracionPerfil = (TextView) findViewById(R.id.txtValoracionPerfilProfesor);

        barraValoracion.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                txtValoracionPerfil.setText(String.valueOf(rating));

            }
        });
    }

    public void addListenerOnButtonValoracion() {

        barraValoracion = (RatingBar) findViewById(R.id.ratingBarVerProfesor);
        btnEnviarValoracionPerfil = (Button) findViewById(R.id.btnEnviarValoracion);

        btnEnviarValoracionPerfil.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(Ver_Profesor.this,
                        String.valueOf("Valoración enviada " + barraValoracion.getRating()),
                        Toast.LENGTH_SHORT).show();

            }

        });

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

        //valoracion = (EditText) findViewById(R.id.valoracionProfesorPerfil);

    }

}
