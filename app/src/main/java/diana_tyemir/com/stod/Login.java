package diana_tyemir.com.stod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import diana_tyemir.com.stod.localStorage.Auth;

public class Login extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		getSupportActionBar().hide();

		Window w = getWindow();
		w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);

		// Botones de Login / SignUp.
		TextView lblRegistrar = (TextView) findViewById(R.id.lblRegistro);
		Button btnEntrar = (Button) findViewById(R.id.btnEntrar);

		final EditText inputEmail = (EditText) findViewById(R.id.ed_email);
		final EditText inputPassword = (EditText) findViewById(R.id.ed_password);

		// Ir al formulario de registro.
		lblRegistrar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), SignUp.class);
				startActivity(i);
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
			}
		});

		// Accionar inicio de sesión.
		btnEntrar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String email = inputEmail.getText().toString();
				String password = inputPassword.getText().toString();

				tryLogin(email, password);
			}
		});
	}

	protected boolean tryLogin(final String email, final String password) {

		RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
		String url = "https://stod.wrennch.com/users/login.php ";

		StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject jsonObj = new JSONObject(response);
					int code = jsonObj.getInt("code");

					if (code == 200) {
						String token = jsonObj.getString("auth");
						Auth.setToken(getApplicationContext(), token);

						Intent i = new Intent(getApplicationContext(), Main.class);
						startActivity(i);
						overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
					} else {
						Toast.makeText(getApplicationContext(), "¡Email y/o contraseña incorrectos!", Toast.LENGTH_LONG).show();
					}
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
		}, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
			@Override
			public void onErrorResponse(VolleyError error) {
				//This code is executed if there is an error.
			}
		}) {
			protected Map<String, String> getParams() {
				Map<String, String> MyData = new HashMap<String, String>();
				MyData.put("email", email);
				MyData.put("password", password);
				return MyData;
			}
		};
		MyRequestQueue.add(MyStringRequest);
		return false;
	}

	@Override
	public void onBackPressed() {

	}
}