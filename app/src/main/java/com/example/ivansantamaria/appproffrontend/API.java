package com.example.ivansantamaria.appproffrontend;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class API
{
	// Direccion base al backend
	private String baseurl;

	// Token de la app
	private String token = null;

	/*
	 * Constructor de la clase. baseurl es del tipo http://localhost:8080
	 */
	public API (String _baseurl)
	{
		this.baseurl = _baseurl;

		//this.token = null; // Cargar el token del almacenamiento si existía
	}

	/*
	 * Obtiene el string con los datos dada una ruta tipo /api/login
	 */
	private String getStringJson (String _url) throws Exception
	{
		URL url = new URL(this.baseurl + _url);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoInput(true);

		// Si se disponía de token, se envía con la petición
		if (token != null)
		{
			connection.setRequestProperty("xtoken", this.token);			
		}

		connection.connect();

		InputStream inputStream = url.openStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));

		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = rd.readLine()) != null) {
            sb.append(line + "\n");
        }
        connection.disconnect();

        return sb.toString();
	}

	private String postStringJson (String _url, String body) throws Exception
	{
		int nbytes = body.getBytes("UTF-8").length;
		URL url = new URL(this.baseurl + _url);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		//connection.setRequestMethod("POST");
		((HttpURLConnection)url.openConnection()).setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty( "Content-Length", Integer.toString(nbytes));
		connection.setDoOutput(true);
		connection.setUseCaches(false);

		connection.connect();

		OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	    writer.write(body);
	    writer.close();

		//getErrorStream() .getResponseCode()
	    InputStream inputStream = url.openStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));

		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = rd.readLine()) != null) {
            sb.append(line + "\n");
        }
        connection.disconnect();

        return sb.toString();
	}

	/*
	 *  Lanza una petición a la url dada ( url hace referencia a tipo /api/login )
	 *  y devuelve un objeto JSON parseado
	 */
	public JSONObject get (String url) throws Exception
	{
		String datos = getStringJson(url);

        JSONObject jObject = new JSONObject(datos);

        // Si se ha devuelto un token, se adopta como nuevo token de la app
        try
        {
        	this.token = jObject.getString("token");
        	// Faltaría guardar en memoria el nuevo token para cuando se haga
        	// init de la app
        } catch (JSONException ex) {}

        return jObject;
	}

	/*
	 *  Lanza una petición a la url dada ( url hace referencia a tipo /api/login )
	 *  y devuelve un array JSON
	 */
	public JSONArray getArray (String url) throws Exception
	{
		String datos = getStringJson(url);

        return new JSONArray(datos);
	}

	/*
	 * Manda una petición POST a la url /api/login. 
	 * <payload> contiene un json en formato string.
	 * Devuelve un objeto JSON
	 */
	public JSONObject post (String url, String payload) throws Exception
	{
		String datos = postStringJson(url, payload);

		JSONObject jObject = new JSONObject(datos);

        // Si se ha devuelto un token, se adopta como nuevo token de la app
        try
        {
        	this.token = jObject.getString("token");
        	// Faltaría guardar en memoria el nuevo token para cuando se haga
        	// init de la app
        } catch (JSONException ex) {}

        return jObject;
	}

	/*
	 * Manda una petición POST a la url /api/login. 
	 * <payload> contiene un json en formato string.
	 * Devuelve un array de JSON
	 */
	public JSONArray postArray (String url, String payload) throws Exception
	{
		String datos = postStringJson(url, payload);

        return new JSONArray(datos);
	}
}