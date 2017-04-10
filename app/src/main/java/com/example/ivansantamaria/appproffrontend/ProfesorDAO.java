package com.example.ivansantamaria.appproffrontend;

public class ProfesorDAO {

    public ProfesorVO perfilProfesor(String profesor) {
        //Integrar con la base de datos, con la conexión parsear el JSON
        ProfesorVO profe = null;

        profe = new ProfesorVO(profesor,"637485130","isakedo@gmail.com","Barcelona",null,null,null,
                5.0f,"250 años en la enseñanza obligatoria con un descanso de 12 años para ser " +
                "profesor particular de matemática discreta","presencial");

        return profe;
    }

}
