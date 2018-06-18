package diana_tyemir.com.stod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {

	EditText email, pass1, pass2, user;
	Button entrar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		this.setTitle("Registro");

		email = (EditText) findViewById(R.id.ed_email);
		pass1 = (EditText) findViewById(R.id.ed_password);
		pass2 = (EditText) findViewById(R.id.ed_password2);
		user = (EditText) findViewById(R.id.ed_user);
		entrar = (Button) findViewById(R.id.btnEntrar);

		entrar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String name = user.getText().toString();
				String mail = email.getText().toString();
				String password = pass1.getText().toString();
				String password2 = pass2.getText().toString();

				if (password.equals(password2)) {
					trySignUp(name, mail, password);
				}
				else {
					Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden.", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	protected boolean trySignUp(final String name, final String email, final String password) {

		RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
		String url = "https://stod.wrennch.com/users/signup.php ";

		StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject jsonObj = new JSONObject(response);
					int code = jsonObj.getInt("code");

					if (code == 200) {
						Intent i = new Intent(getApplicationContext(), Login.class);
						startActivity(i);
						overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
					} else {
						Toast.makeText(getApplicationContext(), "Verifica que los datos estén correctos.", Toast.LENGTH_LONG).show();
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
				MyData.put("username", name);
				MyData.put("password", password);
				return MyData;
			}
		};
		MyRequestQueue.add(MyStringRequest);
		return false;
	}
}
