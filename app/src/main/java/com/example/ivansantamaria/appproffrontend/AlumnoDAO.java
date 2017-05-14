package com.example.ivansantamaria.appproffrontend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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

//    public ArrayList<ProfesorVO> getProfesoresFavoritos(API api) throws APIexception {
//        JSONObject respuesta =  api.get("/api/favoritos/get");
//        try {
//            // cursos (se puede pasar como cadena vacía) modalidad y experiencia son opcionales
//            // (cursos ponerlo a null). Modalidad (tres rayas) experiencia como cadena vacía
//            String nombre = respuesta.getString("userName");
//            String telefono = respuesta.getString("telefono");
//            String mail = respuesta.getString("email");
//            String ciudad = respuesta.getString("ciudad");
//
//            // Pasar el string a ArrayList<String> según el token
//            String _horarios = respuesta.getString("horarios");
//            String[] auxHorarios = _horarios.split(",");
//            ArrayList<String> horarios = new ArrayList<>();
//            for(String tmp:auxHorarios) horarios.add(tmp.replace("[\"","").replace("\"]",""));
//
//            String _cursos = respuesta.getString("cursos");
//            String[] auxCursos = _cursos.split(",");
//            ArrayList<String> cursos = new ArrayList<>();
//            for(String tmp:auxCursos) cursos.add(tmp.replace("[\"","").replace("\"]",""));
//
//            ArrayList<String> asignaturas = new ArrayList<>();
//            JSONArray _asignaturas = respuesta.getJSONArray("asignaturas");
//            for(int i = 0; i < _asignaturas.length(); i++)
//            {
//                try {
//                    JSONObject jo = _asignaturas.getJSONObject(i);
//                    asignaturas.add(jo.getString("nombre"));
//                } catch (JSONException e){e.printStackTrace();}
//            }
//
//            //Double valoracion = respuesta.getDouble("valoracionMedia");
//            String experiencia = respuesta.getString("experiencia");
//
//            String modalidad = respuesta.getString("modalidad");
//
//            ProfesorVO prof = new ProfesorVO(nombre, null, telefono, mail, ciudad, horarios, cursos,
//                    asignaturas, -1.00, experiencia, modalidad);
//
//            return prof;
//
//        } catch (JSONException e) {
//            ProfesorVO prof = new ProfesorVO();
//            return prof;
//        }
//    }

}
