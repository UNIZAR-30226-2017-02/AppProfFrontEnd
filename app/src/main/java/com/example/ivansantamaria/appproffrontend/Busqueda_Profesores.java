package com.example.ivansantamaria.appproffrontend;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Busqueda_Profesores extends AppCompatActivity {

    //private String nombreUsuario;

    private EditText nombre;
    private EditText ciudad;
    private Spinner horarios;
    private Spinner asignaturas;
    private Spinner cursos;

    private Button buscarProfesor = null;
    private Button favoritoProfesor = null;

    /** identificador para la actividad de listar profesores de busqueda */
    private static final int ACTIVITY_LISTAR_BUSQUEDA=0;
    /** identificador para la actividad de listar profesores favoritos */
    private static final int ACTIVITY_LISTAR_FAVORITOS=1;

    private static final ArrayList<String> horariosList = new ArrayList<String>()
    {{ add("---"); add("Mañanas"); add("Tardes");}};

    private static final ArrayList<String> asignaturasList = new ArrayList<String>()
    {{ add("---"); add("Matematicas"); add("Fisica"); add("Ingles"); add("Frances"); add("Biologia");}};

    private static final ArrayList<String> cursosList = new ArrayList<String>()
    {{ add("---"); add("Primaria"); add("Secundaria"); add("Bachillerato"); add("Universidad");}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda__profesores);

        final com.example.ivansantamaria.appproffrontend.Busqueda_Profesores local = this;
        buscarProfesor = (Button) findViewById(R.id.buscarProfesor);
        favoritoProfesor = (Button) findViewById(R.id.favoritoProfesor);

        // Bundle extras = getIntent().getExtras();
        //Recoger informacion del usuario de la sesion
        //nombreUsuario = (extras != null) ? extras.getString("nombreUsuario") : null;

        populatefields();

        buscarProfesor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(nombre.getText().toString().equals("") &&
                        ciudad.getText().toString().equals("") &&
                        horarios.getSelectedItemPosition() == 0 &&
                        asignaturas.getSelectedItemPosition() == 0 &&
                        cursos.getSelectedItemPosition() == 0)
                {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(local);

                    dlgAlert.setMessage("Es necesario rellenar al menos un campo");
                    dlgAlert.setTitle("Error...");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                } else {
                    //PEDIR A LA BASE DE DATOS QUE REALICE LA BUSQUEDA DEL PROFESOR
                    listar_busqueda();
                }
            }
        });

        favoritoProfesor.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                listar_favoritos();
            }
        });
    }

    private void populatefields(){
        nombre = (EditText) findViewById(R.id.usuarioProfesorBusqueda);
        ciudad = (EditText) findViewById(R.id.ciudadProfesorBusqueda);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.row_spinner, horariosList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        horarios = (Spinner) findViewById(R.id.horariosProfesorBusqueda);
        horarios.setAdapter(adapter);

        adapter = new ArrayAdapter<>(
                this, R.layout.row_spinner, asignaturasList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        asignaturas = (Spinner) findViewById(R.id.asignaturasProfesorBusqueda);
        asignaturas.setAdapter(adapter);

        adapter = new ArrayAdapter<>(
                this, R.layout.row_spinner, cursosList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cursos = (Spinner) findViewById(R.id.cursoProfesorBusqueda);
        cursos.setAdapter(adapter);
    }

    private void listar_favoritos(){
        Intent i = new Intent(this, Listar_Profesores.class); //Profesores_Favoritos.class);
        //i.putExtra("nombreUsuario", nombreUsuario);
        startActivityForResult(i, ACTIVITY_LISTAR_FAVORITOS);
    }

    private void listar_busqueda(){
        Intent i = new Intent(this, Listar_Profesores.class);
        //i.putExtra("nombreUsuario", nombreUsuario);
        i.putExtra("nombre", nombre.getText().toString());
        i.putExtra("ciudad", ciudad.getText().toString());
        String horario = horariosList.get(horarios.getSelectedItemPosition());
        i.putExtra("horario", horario);
        String asignatura = asignaturasList.get(asignaturas.getSelectedItemPosition());
        i.putExtra("asignatura", asignatura);
        String curso = cursosList.get(cursos.getSelectedItemPosition());
        i.putExtra("curso", curso);
        startActivityForResult(i, ACTIVITY_LISTAR_BUSQUEDA);
    }
}
