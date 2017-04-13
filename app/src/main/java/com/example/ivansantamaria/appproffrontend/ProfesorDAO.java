package com.example.ivansantamaria.appproffrontend;

import java.util.ArrayList;

public class ProfesorDAO {

    public ProfesorVO perfilProfesor(String profesor) {
        //Integrar con la base de datos, con la conexión parsear el JSON
        ProfesorVO profe = null;

        profe = new ProfesorVO(profesor," 637485130"," isakedo@gmail.com"," Barcelona",
                new ArrayList<String>() {{ add(" Lunes Mañana"); add(" Lunes Tarde");}},
                new ArrayList<String>() {{ add(" Primaria"); add(" Secundaria");}},
                new ArrayList<String>() {{ add(" Matemáticas"); add(" Ingles");}},
                4.4f," 250 años en la enseñanza obligatoria con un descanso de 12 años para ser " +
                "profesor particular de matemática discreta","Presencial");

        return profe;
    }

}
