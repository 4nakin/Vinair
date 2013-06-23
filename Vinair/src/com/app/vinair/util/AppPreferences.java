package com.app.vinair.util;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {
	
	private SharedPreferences appPrefs;	
	private final String APP_PREFERENCES_NAME = "VinairAppPreferences";

	public AppPreferences(Context context) {
		appPrefs = context.getSharedPreferences(APP_PREFERENCES_NAME, 0);
	}
	
	public void setUserLoginData(String username) {
		SharedPreferences.Editor edit = appPrefs.edit();
		edit.putString("loggedInUsername", username);
		edit.putBoolean("userLoggedIn", true);
		edit.commit();
	}
	
	public void setUserLoggedOut() {
		SharedPreferences.Editor edit = appPrefs.edit();
		edit.putString("loggedInUsername", "");
		edit.putBoolean("userLoggedIn", false);
		edit.commit();
	}
	
	public boolean isUserLoggedIn() {
		return appPrefs.getBoolean("userLoggedIn", false);
	}
} 
