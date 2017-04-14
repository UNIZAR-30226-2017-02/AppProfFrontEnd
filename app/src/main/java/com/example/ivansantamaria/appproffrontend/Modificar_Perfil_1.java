package com.example.ivansantamaria.appproffrontend;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Modificar_Perfil_1 extends AppCompatActivity implements MultiSpinner.MultiSpinnerListener {

    private Facade facade = null;
    private ProfesorVO profesor = null;

    private TextView user;
    private EditText telefono;
    private EditText email;
    private EditText ciudad;
    private MultiSpinner horarios = null;
    private MultiSpinner asignaturas = null;
    private Button siguienteButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar__perfil_1);

        final com.example.ivansantamaria.appproffrontend.Modificar_Perfil_1 local = this;
        siguienteButton = (Button) findViewById(R.id.siguienteMod);

        facade = new Facade();
        profesor = facade.perfilProfesor("Isak");
        populateFields();

        siguienteButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String telefonoProf = telefono.getText().toString();
                String emailProf = email.getText().toString();
                String ciudadProf = ciudad.getText().toString();
                ArrayList<String> horariosProf = horarios.getValues();
                ArrayList<String> asignaturasProf = asignaturas.getValues();

                if(telefonoProf.equals("") || emailProf.equals("") || ciudadProf.equals("") ||
                        horariosProf.isEmpty() || asignaturasProf.isEmpty())
                {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(local);

                    dlgAlert.setMessage("Todos estos campos son obligatorios");
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
                    //ACTUALIZAR BASE DE DATOS
                    Intent i = new Intent(local, Modificar_Perfil_2.class);
                    startActivityForResult(i, 0);
                }
            }
        });

    }

    private void populateFields() {

        telefono = (EditText) findViewById(R.id.tlfnoProfesorMod);
        telefono.setText(profesor.getTelefono());

        email = (EditText) findViewById(R.id.emailProfesorMod);
        email.setText(profesor.getMail());

        ciudad = (EditText) findViewById(R.id.ciudadProfesorMod);
        ciudad.setText(profesor.getCiudad());

        user = (TextView) findViewById(R.id.usuarioProfesorMod);
        user.setText(profesor.getNombreUsuario());

        horarios = (MultiSpinner) findViewById(R.id.horariosProfesorMod);
        horarios.setItems(facade.getHorariosDisponibles(),facade.getHorariosDisponibles(),
                profesor.getHorarios(),"", this);

        asignaturas = (MultiSpinner) findViewById(R.id.asignaturasProfesorMod);
        asignaturas.setItems(facade.getAsignaturasDisponibles(),facade.getAsignaturasDisponibles(),
                profesor.getAsignaturas(),"", this);

    }

    public void onItemsSelected(boolean[] selected) {
        //Esto hay que ponerlo pero a saber para que... seguiremos investigando
    }
}
