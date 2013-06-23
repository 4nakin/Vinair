package com.app.vinair;

import com.app.vinair.fragments.SignInFragment;
import com.app.vinair.fragments.SignUpFragment;
import com.app.vinair.util.AppPreferences;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoginActivity extends Activity 
	implements SignInFragment.OnSignUpClickListener, 
	SignUpFragment.OnSignInClickListener{
	
	private AppPreferences mPrefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mPrefs = new AppPreferences(this);
		getFragmentManager().beginTransaction().replace(R.id.login_fragment_container, new SplashFragment()).commit();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		new Handler().postDelayed(new Runnable() {
			public void run() {
				if(mPrefs.isUserLoggedIn()) {
					startActivity(new Intent(LoginActivity.this, MainActivity.class));
					finish();
				} else
					flipCard(new SignInFragment());
            }
		}, 2000);		
	}
	
	public void flipCard(Fragment fragment) {
		getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                .replace(R.id.login_fragment_container, fragment)
                .commit();
    }

	@Override
	public void onSignUpClick() {
		flipCard(new SignUpFragment());
	}

	@Override
	public void onSignInClick() {
		flipCard(new SignInFragment());
	}
	
	public static class SplashFragment extends Fragment {
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			TextView textView = new TextView(getActivity());
			textView.setTextColor(getResources().getColor(android.R.color.white));
			textView.setGravity(Gravity.CENTER);
			textView.setText(getString(R.string.app_name).toUpperCase());
			textView.setTextSize(40);
			textView.setBackgroundColor(Color.parseColor("#60000000"));
			textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.ic_launcher);
			textView.setPadding(50, 50, 50, 50);
			return textView;
		}
	}
}
