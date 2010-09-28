package com.TaxiMeter;

public class TaxiFareUnit {
	protected int pricePerUnit;
	
	public TaxiFareUnit(){
		
	}
	public TaxiFareUnit(int price){
		pricePerUnit= price;
	}

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
