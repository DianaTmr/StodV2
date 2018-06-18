package diana_tyemir.com.stod;

// Dependencias
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import diana_tyemir.com.stod.models.Enfermedad;
import diana_tyemir.com.stod.models.Sintoma;

// Interfaces
interface VolleyCallback_E {
	void onSuccess(ArrayList<Enfermedad> enfermedadList);
}

interface VolleyCallback_S {
	void onSuccess(ArrayList<Sintoma> sintomasList);
}


public class Api {

	public Api() {}

	final String URL = "https://stod.wrennch.com";

	/**
	 * Evalua una enfermedad dependiendo de sus síntomas.
	 * @param index Números de identificacion de cada sintoma.
	 * @param c Contexto de la Activity.
	 * @param callback Respuesta del servidor.
	 */
	public void evaluarEnfermedad(final String index, Context c, final VolleyCallback_E callback) {
		final ArrayList<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
		RequestQueue MyRequestQueue = Volley.newRequestQueue(c);

		StringRequest MyStringRequest = new StringRequest(Request.Method.GET, this.URL+"/sintomas/get_disease.php?id=" + index, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {

					JSONObject jsonObj = new JSONObject(response);
					int code = jsonObj.getInt("code");
					JSONArray results = jsonObj.getJSONArray("results");

					if (code == 200) {
						for (int i = 0; i < results.length(); i++) {
							JSONObject c = results.getJSONObject(i);
							int id = c.getInt("id");
							int gravity = c.getInt("gravedad");
							String name = c.getString("nombre");
							String description = c.getString("descripcion");
							enfermedades.add(new Enfermedad(id, gravity, name, description));
						}
						callback.onSuccess(enfermedades);
					}
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) { }
		}) {};
		MyRequestQueue.add(MyStringRequest);
	}

	public void getSintomas(Context c, final VolleyCallback_S callback) {
		final ArrayList<Sintoma> sintomasList = new ArrayList<Sintoma>();

		RequestQueue MyRequestQueue = Volley.newRequestQueue(c);

		StringRequest MyStringRequest = new StringRequest(Request.Method.GET, this.URL+"/sintomas/list.php", new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {

					JSONObject jsonObj = new JSONObject(response);
					int code = jsonObj.getInt("code");
					JSONArray results = jsonObj.getJSONArray("results");

					if (code == 200) {
						for (int i = 0; i < results.length(); i++) {
							JSONObject c = results.getJSONObject(i);
							int id = c.getInt("id");
							String name = c.getString("nombre");
							System.out.println("Síntoma añadido: "+name);

							sintomasList.add(new Sintoma(id, name));
						}
						callback.onSuccess(sintomasList);
					}
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) { }
		}) {};
		MyRequestQueue.add(MyStringRequest);
	}
}
