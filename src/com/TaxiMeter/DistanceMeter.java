package com.TaxiMeter;

public class DistanceMeter {
	private DistanceUnit myRates;
	private long myPrice;
	private long metersTraveled;
	private long initialTime;
	public DistanceMeter(DistanceUnit myRates){
		this.myRates=myRates;
		myPrice=0;
		initialTime=System.nanoTime();
	}
	public long getWholeTimeUnits(){
		return metersTraveled/myRates.getDistance();
	}
	public long getHalfTimeUnits(){
		return metersTraveled%myRates.getDistance();
	}
	public void incrementMeter(long distanceTraveled){
		long newTime=System.nanoTime();
		//subtract NewTimefrom initialTime and multiply by currentspeed to get the distance
		//save the NewTime as initialTime
		//long TimeDifference=initialTime-System.nanoTime();
		//todo stub
		//TimeDifference*currentSpeed(convert to feet/hr)
	//	initialTime=newTime;
		metersTraveled+=distanceTraveled;
		
	}
	/**
	 * 
	 * @return the current Price based on the whole billing units + the half billing units multiplied by the price per unit
	 */
	public long getPrice(){
		myPrice=myRates.getPricePerUnit()*(  this.getWholeTimeUnits()  +this.getHalfTimeUnits() );
		return myPrice;
	}
	public String toString(){
		return "TimeMeter Price: "+myPrice+" cents.\n"+
		"Number of whole billing units passed: "+this.getWholeTimeUnits()+
		"Number of half Billing units passed: "+this.getHalfTimeUnits()+
		myRates;
	}
	
	
}
