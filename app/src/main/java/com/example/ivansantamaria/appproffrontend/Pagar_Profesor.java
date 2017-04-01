package com.example.ivansantamaria.appproffrontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pagar_Profesor extends AppCompatActivity {

    private TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar__profesor);

        user = (TextView) findViewById(R.id.usuarioProfesorPagar);
        user.setText("Isak");
    }
}
