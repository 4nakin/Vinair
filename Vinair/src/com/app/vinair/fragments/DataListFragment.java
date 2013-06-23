package com.app.vinair.fragments;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.app.vinair.DetailsActivity;
import com.app.vinair.R;
import com.app.vinair.adapter.DataListAdapter;
import com.app.vinair.model.FlightDataModel;
import com.app.vinair.util.XMLHandler;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class DataListFragment extends Fragment {
	
	private final String DATAURL = "http://travel-api.elasticbeanstalk.com/rest/travel/tripDetails?&name=mukundu&email=mrtkumaran@yahoo.com";

	public static final String ARG_SECTION_NUMBER = "section_number";
	private static final int SEARCH_PAST = 1;
	private static final int SEARCH_TODAY = 2;
	private static final int SEARCH_UPCOMING = 3;

	private View mViewHolder;
	private ListView mDataList;
	private DataListAdapter mAdapter;
	public static FlightDataModel data;
	private ArrayList<FlightDataModel> mData = new ArrayList<FlightDataModel>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mAdapter = new DataListAdapter(getActivity());
		mViewHolder = inflater.inflate(R.layout.fragment_data_list, null);
		mDataList = (ListView) mViewHolder.findViewById(R.id.data_list);
		mDataList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent(getActivity(), DetailsActivity.class);
				data = mAdapter.getItem(arg2);
				startActivity(intent);
			}
		});

		return mViewHolder;
	}

	@Override
	public void onResume() {
		super.onResume();
		initList();
	}

	@Override
	public void onPause() {
		super.onPause();
		mData.clear();
	}

	private void initList() {
		switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
		case SEARCH_PAST:
			mDataList.setVisibility(View.GONE);
			mViewHolder.findViewById(R.id.data_list_empty).setVisibility(
					View.VISIBLE);
			break;
		case SEARCH_TODAY:
			mDataList.setVisibility(View.GONE);
			mViewHolder.findViewById(R.id.data_list_empty).setVisibility(
					View.VISIBLE);
			break;
		case SEARCH_UPCOMING:
			if (isNetworkAvailable()) {
				new RetreiveFeedTask().execute(DATAURL);
			} else
				Toast.makeText(getActivity(), R.string.error_no_network,
						Toast.LENGTH_LONG).show();
			break;
		}
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getActivity()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	
	class RetreiveFeedTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... urls) {
            try {
                URL url= new URL(urls[0]);
                SAXParserFactory factory =SAXParserFactory.newInstance();
                SAXParser parser=factory.newSAXParser();
                XMLReader xmlreader=parser.getXMLReader();
                
                XMLHandler theRSSHandler=new XMLHandler();
                xmlreader.setContentHandler(theRSSHandler);
                InputSource is=new InputSource(url.openStream());
                xmlreader.parse(is);
                mAdapter.setListData(theRSSHandler.getXMLData());
                return "";
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(String feed) {
        	if(feed != null)
        		mDataList.setAdapter(mAdapter);
        	else {
        		mDataList.setVisibility(View.GONE);
				mViewHolder.findViewById(R.id.data_list_empty)
						.setVisibility(View.VISIBLE);
        	
        	}
        }
     }
}
