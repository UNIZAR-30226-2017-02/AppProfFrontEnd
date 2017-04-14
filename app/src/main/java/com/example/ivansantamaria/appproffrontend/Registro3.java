package com.example.ivansantamaria.appproffrontend;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

/**
 * Created by Rubenbros on 14/04/2017.
 */

public class Registro3 extends AppCompatActivity {

    private MultiSpinner horario;
    private MultiSpinner asignaturas;
    private Spinner curso;
    private Spinner modo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro3_profesor);
        horario = (MultiSpinner) findViewById(R.id.horarioProfesor);
        asignaturas = (MultiSpinner) findViewById(R.id.asigProfesor);
        curso = (Spinner) findViewById(R.id.spinner5);
        modo = (Spinner) findViewById(R.id.spinner6);
        Button registro = (Button) findViewById(R.id.registerbutton);
        final Intent i = new Intent(this, Perfil_Profesor.class);
        registro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final int code = guardarEnBd();
                if (code == -1) startActivity(i);
                else error(code);
            }
        });
    }

    private int guardarEnBd() {
        //Comprobar campos
        //Guardar en base de datos
        CheckBox tyc = (CheckBox) findViewById(R.id.TyC);
        if (!tyc.isEnabled()) return 8;
        return -1;
    }

    private void error(int code) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        switch (code) {
            case 8:
                dlgAlert.setMessage("Acepte los terminos y condiciones");
                break;
        }
        dlgAlert.setTitle("Error...");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
    }
}