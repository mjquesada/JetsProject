package com.skilldistillery.jets.models;

public abstract class Jet {
	private String model;
	private long price;
	private double speed;
	private int range;
	
	public Jet(String model, long price, double speed, int range) {
		super();
		this.model = model;
		this.price = price;
		this.speed = speed;
		this.range = range;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public String toString() {
		return "Aircraft Model: " + model + ", Price: $" + price + ", Speed: " + speed + " MPH" + ", Range: " + range + " miles";
	}
	
	public void fly() {
		System.out.println("Our " + this.getModel() + " is taking off!");
		System.out.printf("Our " + this.getModel() + " was in the air for %.2f" + " hours", (this.range / this.getSpeed()));
		System.out.println();
	}
	
	
}
