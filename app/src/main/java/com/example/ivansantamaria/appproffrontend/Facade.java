package com.example.ivansantamaria.appproffrontend;

import org.json.JSONObject;

import java.util.ArrayList;

public class Facade {

    API api = null;

    //Deberían ser consultas
    private ArrayList<String> horariosDisponibles = new ArrayList<String>() {{
       add("Lunes Mañana"); add("Lunes Tarde"); add("Martes Mañana"); add("Martes Tarde");
    }};
    private ArrayList<String> asignaturasDisponibles = new ArrayList<String>() {{
        add("Matemáticas"); add("Ingles"); add("Lengua"); add("Física");
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

    public ProfesorVO perfilProfesor(String profesor) {
        //Completa con la base de datos, aquí realizar conexión a base de datos
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.perfilProfesor(profesor);
    }

    public int registro_alumno(AlumnoVO alum) throws APIexception{
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        return alumnoDAO.registro_alumno(api, alum);
    }

    public int registro_profesor(ProfesorVO prof) throws APIexception{
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.registro_profesor(api, prof);
    }

    public JSONObject login(PersonaVO per, int tipo) throws APIexception{
        PersonaDAO personaDAO = new PersonaDAO();
        return personaDAO.login(api, per, tipo);
    }


    public ArrayList<String> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    public ArrayList<String> getAsignaturasDisponibles() {
        return asignaturasDisponibles;
    }

    public ArrayList<String> getCursosDisponibles() {
        return cursosDisponibles;
    }

    public ArrayList<String> getModalidadesDisponibles() {
        return modalidadesDisponibles;
    }
}
