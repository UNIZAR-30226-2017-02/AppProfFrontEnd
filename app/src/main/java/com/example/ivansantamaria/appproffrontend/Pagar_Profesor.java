package com.example.ivansantamaria.appproffrontend;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Pagar_Profesor extends AppCompatActivity {

    private TextView user;
    private EditText tarjeta;
    private EditText digito;
    private EditText titular;
    private Button pagarButton = null;
    private Spinner mesCad = null;
    private Spinner anyoCad = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar__profesor);

        populateFields();

        final com.example.ivansantamaria.appproffrontend.Pagar_Profesor local = this;
        pagarButton = (Button) findViewById(R.id.pagarProfesor);

        pagarButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(tarjeta.getText().toString().equals("") ||
                   digito.getText().toString().equals("") ||
                   titular.getText().toString().equals("") ||
                   mesCad.getSelectedItemPosition() == 0 ||
                   anyoCad.getSelectedItemPosition() == 0)
                {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(local);

                    dlgAlert.setMessage("Es necesario añadir todos los campos");
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
                    //PEDIR A LA BASE DE DATOS QUE AÑADE EL DINERO AL PROFESOR
                    finish();
                }
            }
        });
    }

    private void populateFields() {

        tarjeta = (EditText) findViewById(R.id.tar_credito);
        digito = (EditText) findViewById(R.id.digito);
        titular = (EditText) findViewById(R.id.propietario);

        user = (TextView) findViewById(R.id.usuarioProfesorPagar);
        user.setText("Isak");
    }
}
