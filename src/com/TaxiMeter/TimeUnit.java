package com.TaxiMeter;

public class TimeUnit extends TaxiFareUnit {
	public int timePerUnit;
	public int travelingSpeed;
	
	public TimeUnit(int price){
		super(price);
	}
	public TimeUnit(int price,int Traveli){
		this(price,Traveli,60);
	}
	public TimeUnit(int price,int Travli,int timePU){
		super(price);
		setTimePerUnit(timePU);
		setTravelingSpeed(Travli);
	}
	public void setTimePerUnit(int seconds){
		if(seconds<0) throw new IllegalArgumentException("Time must be greater then 0\t"+seconds);
		timePerUnit=seconds;
	}
	public void setTravelingSpeed(int speed){
		if(speed<0)throw new IllegalArgumentException("Speed must be greater then 0\t"+speed);
	    travelingSpeed=speed;
	}
	public String toString(){
		return "For every "+timePerUnit+" seconds that you are traveling less then "+travelingSpeed+" MPH" +
				"\nYou are charged "+super.pricePerUnit+" cents";
	}
}
