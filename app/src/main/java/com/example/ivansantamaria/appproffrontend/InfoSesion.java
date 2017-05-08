package com.example.ivansantamaria.appproffrontend;

import android.app.Activity;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by android on 8/05/17.
 */

public class InfoSesion {

    private String username;
    private int tipo;

    public InfoSesion (Activity contexto)
    {
        SharedPreferences sharedPref = contexto.getPreferences(Context.MODE_PRIVATE);
        this.tipo = sharedPref.getInt("tipo", -1);
        this.username = sharedPref.getString("username", null);
    }

    public InfoSesion (Activity contexto, String _username, int _tipo)
    {
        SharedPreferences sharedPref = contexto.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", _username);
        editor.putInt("tipo", _tipo);
        editor.apply();

        this.tipo = _tipo;
        this.username = _username;
    }

    public String getUsername() {
        return username;
    }

    public int getTipo ()
    {
        return this.tipo;
    }
}
