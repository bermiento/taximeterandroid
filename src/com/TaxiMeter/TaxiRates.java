package com.TaxiMeter;

public class TaxiRates {
	private int entryFee;
	private DistanceUnit myDistanceFares;
	private TimeUnit myTimeFares;
	private int nightSurgeCharge;
	private int peakSurgeCharge;
    
	
	public TaxiRates(){
		myDistanceFares=new DistanceUnit(40,6);
		myTimeFares=new TimeUnit(40,12,60);
		
	}
	
	
}
