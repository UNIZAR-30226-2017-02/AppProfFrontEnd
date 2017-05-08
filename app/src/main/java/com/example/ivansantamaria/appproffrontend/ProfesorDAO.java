package com.example.ivansantamaria.appproffrontend;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProfesorDAO {

    public ProfesorVO perfilProfesor(API api, String profesor) throws APIexception {

        JSONObject respuesta =  api.get("/api/perfil/info");

        try {
            // cursos (se puede pasar como cadena vacía) modalidad y experiencia son opcionales
            // (cursos ponerlo a null). Modalidad (tres rayas) experiencia como cadena vacía
            String telefono = respuesta.getString("telefono");
            String mail = respuesta.getString("email");
            String ciudad = respuesta.getString("ciudad");
            // Pasar el string a ArrayList<String> según el token
            String _horarios = respuesta.getString("horarios");
            ArrayList<String> horarios = null;

            // Pasar el string a ArrayList<String> según el token
            String _cursos = respuesta.getString("cursos");
            ArrayList<String> cursos = null;
            if (_cursos.equals("")) {
                _cursos = null;
            } else {
                // Lo pasamos a ArrayList

            }

            String _asignaturas = respuesta.getString("asignaturas");
            // Lo pasamos a ArrayList
            ArrayList<String> asignaturas = null;

            Double valoracion = respuesta.getDouble("valoracionMedia");
            String experiencia = respuesta.getString("experiencia");

            String modalidad = respuesta.getString("modalidad");
            if (modalidad.equals("")) {
                modalidad = null;
            }

            ProfesorVO prof = new ProfesorVO(profesor, null, telefono, mail, ciudad, horarios, cursos,
                    asignaturas, valoracion, experiencia, modalidad);

            return prof;

        } catch (JSONException e) { }

        return null;
    }

    public int registro_profesor(API api, ProfesorVO prof) throws APIexception{
        JSONObject payload = new JSONObject();
        try
        {
            payload.put("userName", prof.getNombreUsuario());
            payload.put("password", prof.getPassword());
            payload.put("email", prof.getMail());
            payload.put("telefono", prof.getTelefono());
            payload.put("ciudad", prof.getCiudad());
            if(prof.getExperiencia() == null) payload.put("experiencia", "---");
            else payload.put("experiencia", prof.getExperiencia());
            payload.put("tipo", 1);
        } catch (JSONException ex) { return 10; }

        api.post("/api/register", payload);

        JSONObject payload2 = new JSONObject();
        try
        {
            String horarios = "";
            for (String hor : prof.getHorarios()) horarios += hor + ",";
            horarios = horarios.substring(0, horarios.length()-1);
            payload2.put("horarios", horarios);

        } catch (JSONException ex) { return 10; }

        api.post("/api/perfil/set", payload2);
        return -1;
    }

    public int actualizar_profesor(API api, ProfesorVO prof) throws APIexception{


        return -1;
    }



}
