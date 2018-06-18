package diana_tyemir.com.stod;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Main extends AppCompatActivity {

	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
		= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			FragmentManager manager = getSupportFragmentManager();
			Fragment fragment = null;

			switch (item.getItemId()) {
				case R.id.navigation_analysis:
					fragment = new Analysis();
					break;
				case R.id.navigation_profile:
					fragment = new Profile();
					break;
				case R.id.navigation_chat:
					fragment = new Chat();
					break;
				default:
					fragment = new Profile();
					break;
			}
			manager.beginTransaction().replace(R.id.content, fragment).commit();
			return true;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.setTitle("");
		FragmentManager manager = getSupportFragmentManager();
		BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
		manager.beginTransaction().replace(R.id.content, new Analysis()).commit();
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
	}
	public void setActionBarTitle(String title) {
		getSupportActionBar().setTitle(title);
	}

	@Override
	public void onBackPressed() {

	}
}
