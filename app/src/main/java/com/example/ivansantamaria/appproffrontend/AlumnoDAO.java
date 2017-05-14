package com.example.ivansantamaria.appproffrontend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class AlumnoDAO {

    public AlumnoVO perfilProfesor(String alumno_) {

        //Integrar con la base de datos, con la conexión parsear el JSON
        AlumnoVO alumno = null;

        /* Falta realizar hash de la password en el lado de la autenticación
         * Se está usando Guava de Google
         *       - https://github.com/google/guava
         * Ejemplo:
         * final HashCode hashCode = Hashing.sha1().hashString(yourValue, Charset.defaultCharset());
         */
        alumno = new AlumnoVO("lfueris", "Salty_as02!KjanUQP},,<as");

        return alumno;
    }

    public int registro_alumno(API api, AlumnoVO alum) throws APIexception{
        JSONObject payload = new JSONObject();
        try
        {
            payload.put("userName", alum.getNombreUsuario());
            payload.put("password", alum.getPassword());
            payload.put("tipo", 0);
        } catch (JSONException ex) { return 10; }

        api.post("/api/register", payload);
        return -1;

    }

    public void anyadir_profesor_favorito(API api, ProfesorVO profesor) throws APIexception {
        JSONObject payload = new JSONObject();
        try
        {
            payload.put("profesor", profesor.getNombreUsuario());

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        api.post("/api/favoritos/add", payload);
    }

    public ArrayList<ProfesorVO> getProfesoresFavoritos(API api) throws APIexception {
        ArrayList<ProfesorVO> lista = new ArrayList<ProfesorVO>();
        try {
            JSONArray array =  api.getArray("/api/favoritos/get");

            for (int i = 0; i < array.length(); i++) {
                try {
                    JSONObject jsonObject = array.getJSONObject(i);
                    String nombre = jsonObject.getString("userName");
                    Facade facade = new Facade(api);
                    lista.add(facade.perfilProfesor(nombre));
                } catch (JSONException e) { e.printStackTrace(); }
            }
        } catch (APIexception e) {
            e.printStackTrace();
        }
        return (new ArrayList<>( new LinkedHashSet<>(lista)));
    }

}
