package com.TaxiMeter;

/**
 * Calculates the price of the TaxiMeter for every time that incrementMeter() is called
 * @author Admin
 *
 */
public class TimeMeter {

	private TimeUnit myRates;
	private long numOfSeconds;
	private long myPrice;
/**
 * Constructs a TimeMeter based on the TimeUnitRates
 * @param myRates
 */
	public TimeMeter(TimeUnit myRates){
		this.myRates=myRates;
		numOfSeconds=0;
	}
	
	/**
	 * increments the meter by one second
	 */
	public void incrementMeter(){
		numOfSeconds++;
	}
	
	public long getWholeTimeUnits(){
		return numOfSeconds/myRates.getTimePerUnit();
	}
	public long getHalfTimeUnits(){
		return numOfSeconds%myRates.getTimePerUnit();
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
			"Number of Seconds passed: "+numOfSeconds+"\n"+
			"Number of whole billing units passed: "+this.getWholeTimeUnits()+
			"Number of half Billing units passed: "+this.getHalfTimeUnits()+
			myRates;
	}
}
