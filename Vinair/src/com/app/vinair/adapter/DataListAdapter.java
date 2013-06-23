package com.app.vinair.adapter;

import java.util.ArrayList;

import com.app.vinair.R;
import com.app.vinair.model.FlightDataModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DataListAdapter extends BaseAdapter {
	
	private ArrayList<FlightDataModel> mData = new ArrayList<FlightDataModel>();
	private LayoutInflater mInflator;
	
	public DataListAdapter(Context context) {
		mInflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public void setListData(ArrayList<FlightDataModel> data) {
		this.mData = data;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public FlightDataModel getItem(int pos) {
		return mData.get(pos);
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflator.inflate(R.layout.adapter_data_list, null);
			ImageView mLogo = (ImageView) convertView.findViewById(R.id.list_logo_image);
			TextView mDestination = (TextView) convertView.findViewById(R.id.list_destination_text);
			TextView mDeparture = (TextView) convertView.findViewById(R.id.list_departure_text);
			TextView mArrival = (TextView) convertView.findViewById(R.id.list_arrival_text);
			TextView mStops = (TextView) convertView.findViewById(R.id.list_stops_text);
			
			mLogo.setImageResource(mData.get(position).getServiceProviderLogo());
			mDestination.setText(mData.get(position).getFrom() + " to " + mData.get(position).getTo());
			mDeparture.setText(mData.get(position).getDepartureDate() + " at " + mData.get(position).getDepartureTime());
			mArrival.setText(mData.get(position).getArrivalDate() + " at " + mData.get(position).getArrivalTime());
			if(mData.get(position).getStops() == 0) 
				mStops.setText("NONSTOP");
			else 
				mStops.setText(Integer.valueOf(mData.get(position).getStops()) + " STOP");
		}
		return convertView;
	}

}
