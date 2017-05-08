package com.example.ivansantamaria.appproffrontend;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import static java.lang.System.exit;


public class Ver_Profesor extends AppCompatActivity {

    private TextView user;
    private TextView ciudad;
    private TextView experiencia;
    private Spinner asignaturas;
    private Spinner cursos;
    private Spinner horarios;
    private TextView email;
    private TextView telefono;
    private TextView modalidad;
    private TextView valoracionMedia;

    private RatingBar barraValoracion;
    // Quitar texto que sale después de la valoración
    private TextView txtValoracionPerfil;
    private Button btnEnviarValoracionPerfil;

    // Falta ListenerOnButton para anyadir profesor a favoritos
    private Button btnAnyadirProfesorFav;

    // Profesor de prueba para poblar los distintos campos
    private Facade facade = null;
    private ProfesorVO profesor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_profesor);

        facade = new Facade();
        profesor = facade.perfilProfesor(" Isak");
        populateFields();

        // Prueba mongo
        pruebaMongo();

        // Listeners barra de Rating y botón de enviar la valoración
        addListenerOnRatingBar();
        addListenerOnButtonValoracion();
        // Listener botón de profesor favorito
        addListenerOnButtonProfFavorito();

    }

    public void pruebaMongo() {
/*
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        API api = new API("http://10.0.2.2:8080");
        String peticion = "{\n \"userName\" : \"hola\" \n}";
        try {
            JSONObject o = api.post("/api/perfil/get", peticion);
            //JSONObject o = api.get("/api/perfil/get");
            System.out.println(o.toString());
        } catch(Exception e) {
            System.out.println("Salida");
            System.out.println(e);
            exit(1);
        }*/
    }

    /*
    * Método para añadir el Listener al botón de añadir a favoritos al profesor en cuestión
    *
    */
    public void addListenerOnButtonProfFavorito() {

        btnAnyadirProfesorFav = (Button) findViewById(R.id.btnAnyadirFavoritoProfesor);

        btnAnyadirProfesorFav.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // Falta anyadir a la base de datos
                Toast.makeText(Ver_Profesor.this, "Profesor" + user.getText() +
                        " añadido a favoritos",
                        Toast.LENGTH_SHORT).show();

            }

        });

    }

    /*
    * Método para añadir el Listener a la barra de valoración
    *
    */
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

    /*
    * Método para añadir el Listener al botón de enviar la valoración al profesor en cuestión
    *
    */
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

    /*
     * Método para poblar el Spinner de asignaturas que imparte el profesor en cuestión
     *
     */
    private void populateAsignaturasSpinner() {

        if(profesor.getAsignaturas() != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, R.layout.row_spinner, profesor.getAsignaturas());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            asignaturas = (Spinner) findViewById(R.id.asignaturasProfesorPerfil);
            asignaturas.setAdapter(adapter);
        }

    }

    /*
     * Método para poblar el Spinner de cursos a los que imparte el profesor en cuestión
     *
     */
    private void populateCursosSpinner() {

        if(profesor.getCursos() != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this, R.layout.row_spinner, profesor.getCursos());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cursos = (Spinner) findViewById(R.id.cursosProfesorPerfil);
            cursos.setAdapter(adapter);
        }

    }

    /*
     * Método para poblar el Spinner de horarios a los que imparte el profesor en cuestión
     *
     */
    private void populateHorariosSpinner() {

        if(profesor.getCursos() != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this, R.layout.row_spinner, profesor.getHorarios());
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            horarios = (Spinner) findViewById(R.id.horarioProfesorPerfil);
            horarios.setAdapter(adapter);
        }

    }


    /*
    * Método para poblar todos los campos del perfil del profesor en cuestión
    *
    */
    private void populateFields() {

        // TODO: acceso a la base de datos en función del profesor que el usuario selecciona
        user = (TextView) findViewById(R.id.nombreProfesorPerfil);
        user.setText(profesor.getNombreUsuario());

        ciudad = (TextView) findViewById(R.id.ciudadProfesorPerfil);
        ciudad.setText(profesor.getCiudad());

        experiencia = (TextView) findViewById(R.id.experienciaProfesorPerfil);
        experiencia.setText(profesor.getExperiencia());

        // Llamada a los métodos para poblar los distintos Spinners. Solo está el de asignaturas.
        populateAsignaturasSpinner();
        populateCursosSpinner();
        populateHorariosSpinner();

        //final HashCode hashCode = Hashing.sha1().hashString("luis", Charset.defaultCharset());

        email = (TextView) findViewById(R.id.emailProfesorPerfil);
        email.setText(profesor.getMail());

        telefono = (TextView) findViewById(R.id.tlfnoProfesorPerfil);
        telefono.setText(profesor.getTelefono());

        modalidad = (TextView) findViewById(R.id.modalidadProfesorPerfil);
        modalidad.setText(profesor.getModalidad());

        valoracionMedia = (TextView) findViewById(R.id.valoracionesProfesorPerfil);
        valoracionMedia.setText(profesor.getValoracion().toString());

    }

}
