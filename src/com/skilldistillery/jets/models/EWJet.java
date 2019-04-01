package com.skilldistillery.jets.models;

public class EWJet extends Jet implements ElectronicWarfare {

	public EWJet(String model, long price, double speed, int range, Pilot pilot) {
		super(model, price, speed, range, pilot);
	}

	@Override
	public void spy() {
	}

}
