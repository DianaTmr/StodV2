package diana_tyemir.com.stod.localStorage;

import android.content.Context;
import android.content.SharedPreferences;

public class Auth {

	private final static String SHARED_PREF_NAME = "diana_tyemir.stod.SHARED_PREF_NAME";
	private final static String TOKEN_KEY = "diana_tyemir.stod.TOKEN_KEY";

	public static String getToken(Context c) {
		SharedPreferences prefs = c.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
		return prefs.getString(TOKEN_KEY, "");
	}

	public static void setToken(Context c, String token) {
		SharedPreferences prefs = c.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(TOKEN_KEY, token);
		editor.apply();
	}
}
