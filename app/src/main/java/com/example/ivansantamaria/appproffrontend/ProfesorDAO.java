package com.example.ivansantamaria.appproffrontend;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProfesorDAO {

    public ProfesorVO perfilProfesor(String profesor) {
        //Integrar con la base de datos, con la conexión parsear el JSON
        ProfesorVO profe = null;

        profe = new ProfesorVO(profesor, "password", "637485130"," isakedo@gmail.com"," Barcelona",
                new ArrayList<String>() {{ add("Lunes Mañana"); add("Lunes Tarde");}},
                new ArrayList<String>() {{ add("Primaria"); add("Secundaria");}},
                new ArrayList<String>() {{ add("Matemáticas"); add("Ingles");}},
                4.4f," 250 años en la enseñanza obligatoria con un descanso de 12 años para ser " +
                "profesor particular de matemática discreta","Presencial");

        return profe;
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
            payload.put("experiencia", prof.getExperiencia());
            payload.put("tipo", 1);
        } catch (JSONException ex) { return 10; }

        api.post("/api/register", payload);
        return -1;
    }

}
