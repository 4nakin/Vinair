package com.app.vinair.fragments;

import com.app.vinair.MainActivity;
import com.app.vinair.R;
import com.app.vinair.util.AppPreferences;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInFragment extends Fragment {

	private View mViewHolder;
	private EditText mUsernameText, mPasswordText;
	private Button mLoginBtn, mSignUpBtn;
	private OnSignUpClickListener mCallback;
	private AppPreferences mPrefs;
	
	public interface OnSignUpClickListener {
		public void onSignUpClick();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mViewHolder = inflater.inflate(R.layout.fragment_singin, null);
		mPrefs = new AppPreferences(getActivity());
		mUsernameText = (EditText) mViewHolder.findViewById(R.id.signin_username_edittext);
		mPasswordText = (EditText) mViewHolder.findViewById(R.id.signin_password_edittext);
		mLoginBtn = (Button) mViewHolder.findViewById(R.id.signin_login_btn);
		mSignUpBtn = (Button) mViewHolder.findViewById(R.id.signup_login_btn);
		
		mLoginBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(mUsernameText.getText().toString().trim().length() > 0 
						&& mPasswordText.getText().toString().trim().length() > 0) {
					if(mUsernameText.getText().toString().trim().equals("mrtkumaran@yahoo.com")
							&& mPasswordText.getText().toString().trim().equals("admin")) {
						mPrefs.setUserLoginData("");
						startActivity(new Intent(getActivity(), MainActivity.class));
						getActivity().finish();
					} else 
						Toast.makeText(getActivity(), R.string.error_login_wrong_credentials, Toast.LENGTH_LONG).show();
				} else 
					Toast.makeText(getActivity(), R.string.error_login_empty_field, Toast.LENGTH_LONG).show();				
			}
		});
		
		mSignUpBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mCallback.onSignUpClick();
			}
		});
		
		return mViewHolder;
	}
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnSignUpClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnHeadlineSelectedListener");
        }
    }
}
