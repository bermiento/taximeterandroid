package com.TaxiMeter;
/**
 * 
 * @author Admin
 *
 */
public class DistanceUnit extends TaxiFareUnit {
	public static int ONE_FIFTH_MILE_IN_FEET=1056;
	public static int ONE_FIFTH_MILE_IN_METERS=321; //321.87
    public int speed;
	public int distance;
	
	/**
	 * Constructs a DistanceUnit with one Billing Unit costs price  
	 * @param price the price in cents
	 */
	public DistanceUnit(int price){
		super(price);
	}
	
	public DistanceUnit(int price,int spe){
		this(price,spe,DistanceUnit.ONE_FIFTH_MILE_IN_METERS);
	}
	public DistanceUnit(int price,int spe, int feet){
		super(price);
		setSpeed(spe);
		setDistance(feet);
	}
	/**
	 * This is the minimuim speed that the Taxi must be traveling at to be billed for one Distance Unit
	 * @param speeed in MPH
	 */
	public void setSpeed(int spe){
		if(spe<0)throw new IllegalArgumentException("Speed must be greater then 0 \t"+spe);
		speed=spe;
	}
	/**
	 * This is the distance that the Taxi must have traveled inorder to be billed for one Distance Unit
	 * @param feet
	 */
	public void setDistance(int feet){
		if(feet<0) throw new IllegalArgumentException("Distance must be greater then 0  \t"+feet);
		distance=feet;
	}
	public int getSpeed(){
		return speed;
	}
	public int getDistance(){
		return distance;
	}
	
	public String toString(){
		return "For every "+distance+" Feet that you are traveling greater then "+speed+" MPH" +
		"\nYou are charged "+super.pricePerUnit+" cents";
	}
	
	
}
