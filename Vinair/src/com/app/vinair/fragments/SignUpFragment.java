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

public class SignUpFragment extends Fragment {

	private View mViewHolder;
	private EditText mFirstName, mLastName, mEmail, mPassword, mRePassword;
	private Button mSignUpBtn, mLoginButton;
	private OnSignInClickListener mCallback;
	private AppPreferences mPrefs;
	
	public interface OnSignInClickListener {
		public void onSignInClick();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mPrefs = new AppPreferences(getActivity());
		mViewHolder = inflater.inflate(R.layout.fragment_signup, null);
		mFirstName = (EditText) mViewHolder.findViewById(R.id.signup_firstname_edittext);
		mLastName = (EditText) mViewHolder.findViewById(R.id.signup_lastname_edittext);
		mEmail = (EditText) mViewHolder.findViewById(R.id.signup_email_edittext);
		mPassword = (EditText) mViewHolder.findViewById(R.id.signup_password_edittext);
		mRePassword = (EditText) mViewHolder.findViewById(R.id.signup_repassword_edittext);
		mSignUpBtn = (Button) mViewHolder.findViewById(R.id.signup_btn);
		mLoginButton = (Button) mViewHolder.findViewById(R.id.login_btn);
		
		mSignUpBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mFirstName.getText().toString().trim().length() > 0 
						&& mLastName.getText().toString().trim().length() > 0 
						&& mEmail.getText().toString().trim().length() > 0 
						&& mPassword.getText().toString().trim().length() > 0 
						&&mRePassword.getText().toString().trim().length() > 0) {
					mPrefs.setUserLoginData("");
					startActivity(new Intent(getActivity(), MainActivity.class));
					getActivity().finish();
				} else
					Toast.makeText(getActivity(), R.string.error_signup_empty_field, Toast.LENGTH_LONG).show();	
			}
		});
		
		mLoginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mCallback.onSignInClick();
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
            mCallback = (OnSignInClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnHeadlineSelectedListener");
        }
	}
}
