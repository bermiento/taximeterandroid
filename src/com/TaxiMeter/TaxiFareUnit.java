package com.TaxiMeter;
/**
 * This class represents a Billable Unit for a Taxi Meter
 * @author Admin
 *
 */
public class TaxiFareUnit {
	protected int pricePerUnit;
	
	public TaxiFareUnit(){
		
	}
	public TaxiFareUnit(int price){
		pricePerUnit= price;
	}
/**
 * Sets the Price per every billable unit
 * @param price the price in cents per billable Unit
 */
	public void setPricePerUnit(int price){
		pricePerUnit=price;
	}
	public int getPricePerUnit(){
		return pricePerUnit;
	}
	
	
	
	public String toString(){
		return "Price per Unit "+this.getPricePerUnit();
	}
	
	
}
