package com.example.ivansantamaria.appproffrontend;

import android.content.Intent;
import android.database.MatrixCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Listar_Profesores extends AppCompatActivity {

    private String profesor;

    private String nombre;
    private String ciudad;
    private ArrayList<String> horario;
    private String asignatura;
    private String curso;

    private ListView listView;
    private ArrayList<ProfesorVO> m_profesores;

    /** identificador para la actividad de ver profesor seleccionado */
    private static final int ACTIVITY_VER_PROFESOR=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar__profesores);

        listView = (ListView) findViewById(R.id.list);

        // Recogemos los datos para realizar la busqueda
        Bundle extras = getIntent().getExtras();


        // Nombre y ciudad si no han sido rellenados -> ""
        nombre = (extras != null) ? extras.getString("nombre") : null;
        ciudad = (extras != null) ? extras.getString("ciudad") : null;
        // Horario, asignatura y curso si no han sido rellenados -> "---"
        horario = (extras != null) ? extras.getStringArrayList("horario") : null;
        asignatura = (extras != null) ? extras.getString("asignatura") : null;
        curso = (extras != null) ? extras.getString("curso") : null;

        fillData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView c = (TextView) view.findViewById(R.id.nombreProfesorListar);
                profesor = c.getText().toString();
                verProfesor();
            }
        });

    }

    /**
     * Rellena la lista de notas con la información de la base de datos.
     */
    private void fillData() {
        // Acceso a la base de datos
        Facade facade = new Facade();
        //Buscamos los profesores
        m_profesores = new ArrayList<>();//Facade.buscarProfesores(nombre,ciudad, horario, asignatura, curso);
        m_profesores.add(facade.perfilProfesor("David"));
        m_profesores.add(facade.perfilProfesor("Fuste"));
        // Si no existen profesores se muestra mensaje
        if (m_profesores.isEmpty()){
            TextView empty = (TextView)findViewById(R.id.empty);
            empty.setVisibility(View.VISIBLE);
        }
        // Si si que existen se procede a mostrarlos
        else {

            // Create an array to specify the fields we want to display in the list
            String[] from = new String[]{"Nombre", "Ciudad",
                    "Asignaturas", "Horarios", "Valoración media"};

            // Se crea un cursor para mostrar los profesores
            MatrixCursor profesorCursor = new MatrixCursor(
                    new String[]{"_id", "Nombre", "Ciudad", "Asignaturas",
                            "Horarios", "Valoración media"});
            startManagingCursor(profesorCursor);

            // Se añaden los profesores encontrados al cursor
            for (int i = 0; i < m_profesores.size(); i++) {
                ProfesorVO p = m_profesores.get(i);
                profesorCursor.addRow(new Object[]{i, p.getNombreUsuario(), p.getCiudad(),
                        p.getAsignaturas(), p.getHorarios(), p.getValoracion()});
            }

            // and an array of the fields we want to bind those fields to
            int[] to = new int[]{R.id.nombreProfesorListar, R.id.ciudadProfesorListar,
                    R.id.asignaturasProfesorListar, R.id.horariosProfesorListar,
                    R.id.valoracionesProfesorListar};

            // Now create an array adapter and set it to display using our row
            SimpleCursorAdapter profesor =
                    new SimpleCursorAdapter(this, R.layout.row_listar_profesores, profesorCursor,
                            from, to);
            listView.setAdapter(profesor);
        }
    }

    private void verProfesor(){
        Intent i = new Intent(this, Ver_Profesor.class);
        i.putExtra("nombreUsuario", profesor);
        startActivityForResult(i, ACTIVITY_VER_PROFESOR);
    }

}
