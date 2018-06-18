package diana_tyemir.com.stod;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
	private static final String TAG = "FirstActivity";
	private static final int ANIMATION_SPEED = 1000; // 1 Segundo.
	private Button btnEmpezar;
	private com.mikhaellopez.circularimageview.CircularImageView cruz;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window w = getWindow();
			w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
		}
		setContentView(R.layout.activity_welcome);
		getSupportActionBar().hide();
		btnEmpezar = (Button) findViewById(R.id.btnEmpezar);
		cruz = (com.mikhaellopez.circularimageview.CircularImageView) findViewById(R.id.cruz);
		final Animation a = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);

		a.setDuration(ANIMATION_SPEED);
		cruz.startAnimation(a);

		a.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Animation fadeIn = new AlphaAnimation(0, 1);
				fadeIn.setInterpolator(new DecelerateInterpolator());
				fadeIn.setDuration(ANIMATION_SPEED);
				btnEmpezar.startAnimation(fadeIn);
				btnEmpezar.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						Intent i = new Intent(getApplicationContext(), Login.class);
						startActivity(i);
						overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
					}
				});
				btnEmpezar.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});

	}
}

