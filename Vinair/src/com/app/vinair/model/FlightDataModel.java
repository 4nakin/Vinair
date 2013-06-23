package com.app.vinair.model;

import com.app.vinair.R;

public class FlightDataModel {

	private int mServiceProviderLogo;
	private String mServiceProviderName;
	private String mArrivalDate;
	private String mArrivalTime;
	private String mConfirmationCode;
	private String mDepartureDate;
	private String mDepartureTime;
	private String mFee;
	private String mFrom;
	private String mTo;
	private int mStops;	
	
	public FlightDataModel() { 
		this.mServiceProviderLogo = R.drawable.aa_logo;
		this.mServiceProviderName = "American Airlines";
		this.mArrivalDate = "2013-07-11";
		this.mArrivalTime = "7:30am";
		this.mConfirmationCode = "2384657B5";
		this.mDepartureDate = "2013-07-10";
		this.mDepartureTime = "5:50am";
		this.mFee = "199.9";
		this.mFrom = "Chicago";
		this.mTo = "San Francisco";
		this.mStops = 0;	
	}

	/**
	 * @return the mServiceProviderLogo
	 */
	public int getServiceProviderLogo() {
		return mServiceProviderLogo;
	}

	/**
	 * @param mServiceProviderLogo the mServiceProviderLogo to set
	 */
	public void setServiceProviderLogo(int mServiceProviderLogo) {
		this.mServiceProviderLogo = mServiceProviderLogo;
	}

	/**
	 * @return the mServiceProviderName
	 */
	public String getServiceProviderName() {
		return mServiceProviderName;
	}

	/**
	 * @param mServiceProviderName the mServiceProviderName to set
	 */
	public void setServiceProviderName(String mServiceProviderName) {
		this.mServiceProviderName = mServiceProviderName;
	}

	/**
	 * @return the mArrivalDate
	 */
	public String getArrivalDate() {
		return mArrivalDate;
	}

	/**
	 * @param mArrivalDate the mArrivalDate to set
	 */
	public void setArrivalDate(String mArrivalDate) {
		this.mArrivalDate = mArrivalDate;
	}

	/**
	 * @return the mArrivalTime
	 */
	public String getArrivalTime() {
		return mArrivalTime;
	}

	/**
	 * @param mArrivalTime the mArrivalTime to set
	 */
	public void setArrivalTime(String mArrivalTime) {
		this.mArrivalTime = mArrivalTime;
	}

	/**
	 * @return the mConfirmationCode
	 */
	public String getConfirmationCode() {
		return mConfirmationCode;
	}

	/**
	 * @param mConfirmationCode the mConfirmationCode to set
	 */
	public void setConfirmationCode(String mConfirmationCode) {
		this.mConfirmationCode = mConfirmationCode;
	}

	/**
	 * @return the mDepartureDate
	 */
	public String getDepartureDate() {
		return mDepartureDate;
	}

	/**
	 * @param mDepartureDate the mDepartureDate to set
	 */
	public void setDepartureDate(String mDepartureDate) {
		this.mDepartureDate = mDepartureDate;
	}

	/**
	 * @return the mDepartureTime
	 */
	public String getDepartureTime() {
		return mDepartureTime;
	}

	/**
	 * @param mDepartureTime the mDepartureTime to set
	 */
	public void setDepartureTime(String mDepartureTime) {
		this.mDepartureTime = mDepartureTime;
	}

	/**
	 * @return the mFee
	 */
	public String getFee() {
		return mFee;
	}

	/**
	 * @param mFee the mFee to set
	 */
	public void setFee(String mFee) {
		this.mFee = mFee;
	}

	/**
	 * @return the mFrom
	 */
	public String getFrom() {
		return mFrom;
	}

	/**
	 * @param mFrom the mFrom to set
	 */
	public void setFrom(String mFrom) {
		this.mFrom = mFrom;
	}

	/**
	 * @return the mTo
	 */
	public String getTo() {
		return mTo;
	}

	/**
	 * @param mTo the mTo to set
	 */
	public void setTo(String mTo) {
		this.mTo = mTo;
	}

	/**
	 * @return the mStops
	 */
	public int getStops() {
		return mStops;
	}

	/**
	 * @param mStops the mStops to set
	 */
	public void setStops(String mStops) {
		if(mStops.trim().length() > 0)
			this.mStops = Integer.parseInt(mStops);
		else
			this.mStops = 0;
	};
}
