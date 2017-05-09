package com.example.ivansantamaria.appproffrontend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Facade {

    API api = null;

    //Deberían ser consultas
    private ArrayList<String> horariosDisponibles = new ArrayList<String>() {{
       add("Lunes Mañana"); add("Lunes Tarde"); add("Martes Mañana"); add("Martes Tarde");
    }};
    private ArrayList<String> cursosDisponibles = new ArrayList<String>() {{
        add("Primaria"); add("Secundaria"); add("Universidad");
    }};
    private ArrayList<String> modalidadesDisponibles = new ArrayList<String>() {{
        add("---"); add("Presencial"); add("On-line");
    }};

    public Facade(API api) {
        this.api = api;
    }

    public Facade() {
        this.api = null;
    }

    public ProfesorVO perfilProfesor(String profesor) throws APIexception {
        //Completa con la base de datos, aquí realizar conexión a base de datos
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.perfilProfesor(api, profesor);
    }

    public int registro_alumno(AlumnoVO alum) throws APIexception{
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.registro_alumno(api, alum);
    }

    public int registro_profesor(ProfesorVO prof) throws APIexception{
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.registro_profesor(api, prof);
    }

    public int actualizar_profesor(ProfesorVO prof) throws APIexception {
      /*  ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.actualizar_profesor(api, prof);*/
      return 0;
    }

    public JSONObject login(PersonaVO per, int tipo) throws APIexception{
        PersonaDAO personaDAO = new PersonaDAO();
        return personaDAO.login(api, per, tipo);
    }


    public ArrayList<String> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    public ArrayList<String> getAsignaturasDisponibles() {
        ArrayList<String> lista = new ArrayList<String>();
        try
        {
            JSONArray json = api.getArray("/api/asignaturas/get");

            for(int i = 0; i < json.length(); i++)
            {
                try {
                    JSONObject jo = json.getJSONObject(i);
                    lista.add(jo.getString("nombre"));
                } catch (JSONException e){e.printStackTrace();}
            }

        } catch (APIexception ex) {
            ex.printStackTrace();}

        return lista;

    }

    public ArrayList<String> getCursosDisponibles() {
        return cursosDisponibles;
    }

    public ArrayList<String> getModalidadesDisponibles() {
        return modalidadesDisponibles;
    }
}
