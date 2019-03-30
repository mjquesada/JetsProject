package com.skilldistillery.jets.models;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, long price, double speed, int range) {
		super(model, price, speed, range);

	}

	@Override
	public void fight() {
	}

}
