package com.app.vinair.util;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.app.vinair.R;
import com.app.vinair.model.FlightDataModel;

public class XMLHandler extends DefaultHandler {
	
	private final String TAG_RESPONSE = "response";
	private final String TAG_TRIPS = "trips";
	private final String TAG_AIRLINES = "airlines";
	private final String TAG_ARRIVAL_DATE = "arrivalDate";
	private final String TAG_ARRIVAL_TIME = "arrivalTime";
	private final String TAG_CONFORMATION = "confirmation";
	private final String TAG_DEPARTURE_DATE = "departureDate";
	private final String TAG_DEPARTURE_TIME = "departureTime";
	private final String TAG_FEES = "fees";
	private final String TAG_FROM = "from";
	private final String TAG_STOPS = "stops";
	private final String TAG_TO = "to";

	private FlightDataModel data;
	String elementValue = null;
	Boolean elementOn = false;
	private ArrayList<FlightDataModel> mDataList = new ArrayList<FlightDataModel>();

	public ArrayList<FlightDataModel> getXMLData() {
		return mDataList;
	}

	public void setXMLData(ArrayList<FlightDataModel> data) {
		mDataList = data;
	}

	/**
	 * This will be called when the tags of the XML starts.
	 **/
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		elementOn = true;
		if (localName.equals(TAG_RESPONSE)) {
			
		} else if (localName.equals(TAG_TRIPS)) {
			/**
			 * We can get the values of attributes for eg. if the CD tag had an
			 * attribute( <CD attr= "band">Akon</CD> ) we can get the value
			 * "band". Below is an example of how to achieve this.
			 * 
			 * String attributeValue = attributes.getValue("attr");
			 * data.setAttribute(attributeValue);
			 * 
			 * */
			data = new FlightDataModel();
			data.setServiceProviderLogo(R.drawable.aa_logo);
		}
	}

	/**
	 * This will be called when the tags of the XML end.
	 **/
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		elementOn = false;
		if(localName.equals(TAG_TRIPS))
			mDataList.add(data);
		else if (localName.equalsIgnoreCase(TAG_AIRLINES)) 
			data.setServiceProviderName(elementValue);
		else if (localName.equalsIgnoreCase(TAG_ARRIVAL_DATE))
			data.setArrivalDate(elementValue);
		else if (localName.equalsIgnoreCase(TAG_ARRIVAL_TIME))
			data.setArrivalTime(elementValue);
		else if (localName.equalsIgnoreCase(TAG_CONFORMATION))
			data.setConfirmationCode(elementValue);
		else if (localName.equalsIgnoreCase(TAG_DEPARTURE_DATE))
			data.setDepartureDate(elementValue);
		else if (localName.equalsIgnoreCase(TAG_DEPARTURE_TIME))
			data.setDepartureTime(elementValue);
		else if (localName.equalsIgnoreCase(TAG_FEES))
			data.setFee(elementValue);
		else if (localName.equalsIgnoreCase(TAG_FROM))
			data.setFrom(elementValue);
		else if (localName.equalsIgnoreCase(TAG_STOPS))
			data.setStops(elementValue);
		else if (localName.equalsIgnoreCase(TAG_TO))
			data.setTo(elementValue);		
	}

	/**
	 * This is called to get the tags value
	 **/
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (elementOn) {
			elementValue = new String(ch, start, length);
			elementOn = false;
		}
	}
}
