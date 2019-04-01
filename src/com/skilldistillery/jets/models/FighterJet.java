package com.skilldistillery.jets.models;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, long price, double speed, int range, Pilot pilot) {
		super(model, price, speed, range, pilot);

	}

	@Override
	public void fight() {
	}

}
