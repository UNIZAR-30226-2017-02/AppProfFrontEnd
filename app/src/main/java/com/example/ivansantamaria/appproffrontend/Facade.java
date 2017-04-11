package com.example.ivansantamaria.appproffrontend;

public class Facade {

    public ProfesorVO perfilProfesor(String profesor) {
        //Completa con la base de datos, aquí realizar conexión a base de datos
        ProfesorDAO profesorDAO = new ProfesorDAO();
        return profesorDAO.perfilProfesor(profesor);
    }

}
