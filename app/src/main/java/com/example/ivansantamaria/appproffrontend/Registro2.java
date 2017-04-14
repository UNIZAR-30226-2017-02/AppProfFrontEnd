package com.example.ivansantamaria.appproffrontend;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Rubenbros on 14/04/2017.
 */

public class Registro2 extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private EditText email;
    private EditText tlf;
    private int prof;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prof = getIntent().getExtras().getInt("persona");
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirm);
        ;
        if (prof == 1) {
            email = (EditText) findViewById(R.id.email);
            tlf = (EditText) findViewById(R.id.telefono);
            setContentView(R.layout.activity_registro2_profesor);
            Button siguiente = (Button) findViewById(R.id.siguiente);
            final Intent i = new Intent(this, Registro3.class);
            final int code = guardarEnBd(prof);
            siguiente.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (code == -1) startActivity(i);
                    else error(code);
                }
            });
        } else {
            setContentView(R.layout.activity_registro2_alumno);
            Button registro = (Button) findViewById(R.id.register);
            final Intent i = new Intent(this, Busqueda_Profesores.class);
            final int code = guardarEnBd(prof);
            registro.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (code == -1) startActivity(i);
                    else error(code);
                }
            });
        }
    }

    private int guardarEnBd(int prof) {
        String usr = username.getText().toString();
        String psw = password.getText().toString();
        String cpsw = confirmPassword.getText().toString();
        if (usr == "") return 0;
        else if (psw == "") return 1;
        else if (cpsw == "") return 2;
        else if (cpsw != psw) return 3;
        if (prof == 1) {
            String mail = email.getText().toString();
            String phone = tlf.getText().toString();
            if (mail == "") return 4;
            else if (!mail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) return 5;
            else if (phone == "") return 6;
            else if (!phone.matches("(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}")) return 7;
            //Guardar en base de datos
            return -1;
        } else {
            //Guardar en base de datos
            CheckBox tyc = (CheckBox) findViewById(R.id.TyC);
            if (!tyc.hasSelection()) return 8;
            return -1;
        }
    }

    private void error(int code) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        switch (code) {
            case 0:
                dlgAlert.setMessage("Rellene el campo de usuario");
                break;
            case 1:
                dlgAlert.setMessage("Rellene el campo de contrasena");
                break;
            case 2:
                dlgAlert.setMessage("Rellene el campo de confirmacion de contrasena");
                break;
            case 3:
                dlgAlert.setMessage("Las contrasenas no coinciden");
                break;
            case 4:
                dlgAlert.setMessage("Rellene el campo de e-mail");
                break;
            case 5:
                dlgAlert.setMessage("Introduzca un e-mail valido");
                break;
            case 6:
                dlgAlert.setMessage("Relene el campo de telefono");
                break;
            case 7:
                dlgAlert.setMessage("Introduzca un telefono valido");
                break;
            case 8:
                dlgAlert.setMessage("Acepte los terminos y condiciones");
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