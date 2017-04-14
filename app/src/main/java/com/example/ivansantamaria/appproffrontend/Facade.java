package com.example.ivansantamaria.appproffrontend;

import java.util.ArrayList;

public class Facade {

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

    public ProfesorVO perfilProfesor(String profesor) {
        //Completa con la base de datos, aquí realizar conexión a base de datos
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.perfilProfesor(profesor);
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
