package com.app.vinair;

import com.app.vinair.fragments.DataListFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends Activity {
	
	private TextView mServiceProvider, mDestination, mDeparture, mArrival, mStops;
	private ImageView mLogoImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		mServiceProvider = (TextView) findViewById(R.id.details_airline_provider_text);
		mDestination = (TextView) findViewById(R.id.details_destination_text);
		mDeparture = (TextView) findViewById(R.id.details_departure_text);
		mArrival = (TextView) findViewById(R.id.details_arrival_text);
		mStops = (TextView) findViewById(R.id.details_stop_text);
		mLogoImage = (ImageView) findViewById(R.id.details_airline_logo);
		
		mServiceProvider.setText(DataListFragment.data.getServiceProviderName());
		mDestination.setText(DataListFragment.data.getFrom() + " to " + DataListFragment.data.getTo());
		mDeparture.setText(DataListFragment.data.getDepartureDate() + " at " + DataListFragment.data.getDepartureTime());
		mArrival.setText(DataListFragment.data.getArrivalDate() + " at " + DataListFragment.data.getArrivalTime());
		if(DataListFragment.data.getStops() == 0)
			mStops.setText("NONSTOP");
		else
			mStops.setText(String.valueOf(DataListFragment.data.getStops()) + " STOP");
		mLogoImage.setImageResource(DataListFragment.data.getServiceProviderLogo());
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;
		}
		return true;
	}
}
