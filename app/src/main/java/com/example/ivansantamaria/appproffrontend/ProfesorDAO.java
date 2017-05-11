package com.example.ivansantamaria.appproffrontend;

import org.json.JSONArray;
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
            String[] auxHorarios = _horarios.split(",");
            ArrayList<String> horarios = new ArrayList<>();
            for(String tmp:auxHorarios) horarios.add(tmp.replace("[\"","").replace("\"]",""));

            String _cursos = respuesta.getString("cursos");
            String[] auxCursos = _cursos.split(",");
            ArrayList<String> cursos = new ArrayList<>();
            for(String tmp:auxCursos) cursos.add(tmp.replace("[\"","").replace("\"]",""));

            ArrayList<String> asignaturas = new ArrayList<>();
            JSONArray _asignaturas = respuesta.getJSONArray("asignaturas");
            for(int i = 0; i < _asignaturas.length(); i++)
            {
                try {
                    JSONObject jo = _asignaturas.getJSONObject(i);
                    asignaturas.add(jo.getString("nombre"));
                } catch (JSONException e){e.printStackTrace();}
            }

            //Double valoracion = respuesta.getDouble("valoracionMedia");
            String experiencia = respuesta.getString("experiencia");

            String modalidad = respuesta.getString("modalidad");

            ProfesorVO prof = new ProfesorVO(profesor, null, telefono, mail, ciudad, horarios, cursos,
                    asignaturas, -1.00, experiencia, modalidad);

            return prof;

        } catch (JSONException e) {
            ProfesorVO prof = new ProfesorVO();
            return prof;
        }
    }

    public ProfesorVO verProfesor(API api, String profesor) throws APIexception {

        JSONObject payload = new JSONObject();
        try {
            payload.put("nombre", profesor);
        } catch (JSONException ex) {
            ProfesorVO prof = new ProfesorVO();
            return prof;
        }

        JSONObject respuesta =  api.post("/api/perfil/get", payload);
        try {
            // cursos (se puede pasar como cadena vacía) modalidad y experiencia son opcionales
            // (cursos ponerlo a null). Modalidad (tres rayas) experiencia como cadena vacía
            String telefono = respuesta.getString("telefono");
            String mail = respuesta.getString("email");
            String ciudad = respuesta.getString("ciudad");

            // Pasar el string a ArrayList<String> según el token
            String _horarios = respuesta.getString("horarios");
            String[] auxHorarios = _horarios.split(",");
            ArrayList<String> horarios = new ArrayList<>();
            for(String tmp:auxHorarios) horarios.add(tmp.replace("[\"","").replace("\"]",""));

            String _cursos = respuesta.getString("cursos");
            String[] auxCursos = _cursos.split(",");
            ArrayList<String> cursos = new ArrayList<>();
            for(String tmp:auxCursos) cursos.add(tmp.replace("[\"","").replace("\"]",""));

            ArrayList<String> asignaturas = new ArrayList<>();
            JSONArray _asignaturas = respuesta.getJSONArray("asignaturas");
            for(int i = 0; i < _asignaturas.length(); i++)
            {
                try {
                    JSONObject jo = _asignaturas.getJSONObject(i);
                    asignaturas.add(jo.getString("nombre"));
                } catch (JSONException e){e.printStackTrace();}
            }

            //Double valoracion = respuesta.getDouble("valoracionMedia");
            String experiencia = respuesta.getString("experiencia");

            String modalidad = respuesta.getString("modalidad");

            ProfesorVO prof = new ProfesorVO(profesor, null, telefono, mail, ciudad, horarios, cursos,
                    asignaturas, -1.00, experiencia, modalidad);

            return prof;

        } catch (JSONException e) {
            ProfesorVO prof = new ProfesorVO();
            return prof;
        }
    }


    public void profesorPagar(API api) throws APIexception {
        JSONObject respuesta =  api.get("/api/perfil/info");
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
            if(prof.getExperiencia() == null) payload.put("experiencia", "");
            else payload.put("experiencia", prof.getExperiencia());
            payload.put("tipo", 1);

            String horarios = "";
            for (String hor : prof.getHorarios()) horarios += hor + ",";
            horarios = horarios.substring(0, horarios.length()-1);
            payload.put("horarios", horarios);

            String asignaturas = "";
            for (String asi : prof.getAsignaturas()) asignaturas += asi + ",";
            asignaturas = asignaturas.substring(0, asignaturas.length()-1);
            payload.put("asignaturas", asignaturas);

            if(prof.getCursos() == null) payload.put("cursos", "");
            else {
                String cursos = "";
                for (String cur : prof.getCursos()) cursos += cur + ",";
                cursos = cursos.substring(0, cursos.length()-1);
                payload.put("cursos", cursos);
            }
            payload.put("modalidad", prof.getModalidad());


        } catch (JSONException ex) { return 10; }

        api.post("/api/register", payload);
        return -1;
    }

    public int actualizar_profesor(API api, ProfesorVO prof) throws APIexception{
        JSONObject payload = new JSONObject();
        try {
            payload.put("userName", prof.getNombreUsuario());
            payload.put("email", prof.getMail());
            payload.put("telefono", prof.getTelefono());
            payload.put("ciudad", prof.getCiudad());
            if (prof.getExperiencia() == null) payload.put("experiencia", "");
            else payload.put("experiencia", prof.getExperiencia());
            payload.put("tipo", 1);

            String horarios = "";
            for (String hor : prof.getHorarios()) horarios += hor + ",";
            horarios = horarios.substring(0, horarios.length() - 1);
            payload.put("horarios", horarios);

            String asignaturas = "";
            for (String asi : prof.getAsignaturas()) asignaturas += asi + ",";
            asignaturas = asignaturas.substring(0, asignaturas.length() - 1);
            payload.put("asignaturas", asignaturas);

            if (prof.getCursos() == null) payload.put("cursos", "");
            else {
                String cursos = "";
                for (String cur : prof.getCursos()) cursos += cur + ",";
                cursos = cursos.substring(0, cursos.length() - 1);
                payload.put("cursos", cursos);
            }
            payload.put("modalidad", prof.getModalidad());


        } catch (JSONException ex) {
            return 10;
        }

        api.post("/api/perfil/set", payload);
        return -1;
    }

}
