package com.skilldistillery.jets.models;

public class EWJet extends Jet implements ElectronicWarfare {

	public EWJet(String model, long price, double speed, int range) {
		super(model, price, speed, range);
	}

	@Override
	public void spy() {
	}

}
