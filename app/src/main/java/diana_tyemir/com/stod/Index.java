package diana_tyemir.com.stod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import diana_tyemir.com.stod.localStorage.Auth;

public class Index extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		System.out.println("Obteniendo código de acceso...");
		String webToken = Auth.getToken(getApplicationContext());

		System.out.println("=======================================================");
		System.out.println("Código: "+webToken);

		Intent i = new Intent(getApplicationContext(), (webToken.length() > 0) ? Main.class : Welcome.class);
		startActivity(i);
	}
}