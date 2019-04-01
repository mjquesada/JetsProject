package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.models.EWJet;
import com.skilldistillery.jets.models.FighterJet;
import com.skilldistillery.jets.models.Helicopter;
import com.skilldistillery.jets.models.Jet;
import com.skilldistillery.jets.models.Pilot;

public class Carrier {
	List<Jet> importJet = new ArrayList<Jet>();
	List<Pilot> pilotList = new ArrayList<>();

	public Carrier() {
		pilotList = generatePilots();
		readFromTxtJets();
	}

	public void readFromTxtJets() {

		try {
			FileReader fr = new FileReader("initialData.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] newJet = line.split(",");
				String model = newJet[1];
				long price = Long.parseLong(newJet[2]);
				double speed = Double.parseDouble(newJet[3]);
				int range = Integer.parseInt(newJet[4]);
				int randomPilot = ((int) (Math.random() * pilotList.size()));
				Pilot pilot = pilotList.get(randomPilot);

				if (newJet[0].equals("Fighter Jet")) {
					importJet.add(new FighterJet(model, price, speed, range, pilot));
				} else if (newJet[0].equals("EW")) {
					importJet.add(new EWJet(model, price, speed, range, pilot));
				} else if (newJet[0].equals("Helicopter")) {
					importJet.add(new Helicopter(model, price, speed, range, pilot));
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.err.println("Problem while reading " + "initialData.txt" + ": " + e.getMessage());
			return;
		}

	}

	public void listAircraft() {
		System.out.println("Inside list Aircraft");

		for (Jet jet : importJet) {
			System.out.println(jet);
		}
	}

	public void fastestAircraft() {
		Jet jet = new FighterJet(null, 0, 0, 0, null);
		double speed = 0;

		for (int i = 0; i < importJet.size(); i++) {
			if (importJet.get(i).getSpeed() > speed) {
				speed = importJet.get(i).getSpeed();
				jet = importJet.get(i);
			}
		}
		System.out.println(jet);

	}

	public void longRangeAircraft() {

		Jet jet = new FighterJet(null, 0, 0, 0, null);
		int range = 0;

		for (int i = 0; i < importJet.size(); i++) {
			if (importJet.get(i).getRange() > range) {
				range = importJet.get(i).getRange();
				jet = importJet.get(i);
			}
		}
		System.out.println(jet);

	}

	public void dogFight() {
		for (Jet jet : importJet) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
				System.out.println(jet.getModel() + " engaged hostile aircraft");
			}
		}
	}

	public void spyOnEnemies() {
		for (Jet jet : importJet) {
			if (jet instanceof EWJet) {
				((EWJet) jet).spy();
				System.out.println(jet.getModel() + " is in enemy airspace");
			}
		}
	}

	public void addFighterJet(Scanner keyboard) {
		String model;
		long price;
		double speed;
		int range;
		Pilot pilot;

		System.out.println("What is the model of the aircraft?");
		model = keyboard.nextLine();
		System.out.println("What is the price of the aircraft?");
		price = keyboard.nextLong();
		System.out.println("What is the maximum speed of the aircraft?");
		speed = keyboard.nextDouble();
		System.out.println("What is the maximum range of the aircraft?");
		range = keyboard.nextInt();
		System.out.println("What is the name of your pilot?");
		keyboard.nextLine();
		String pilotName = keyboard.nextLine();
		System.out.println("What is the pilots rank?");
		String rank = keyboard.nextLine();

		pilot = new Pilot(pilotName, rank);

		importJet.add(new FighterJet(model, price, speed, range, pilot));
		pilotList.add(pilot);
	}

	public void addElectricJet(Scanner keyboard) {
		String model;
		long price;
		double speed;
		int range;
		Pilot pilot;

		System.out.println("What is the model of the aircraft?");
		model = keyboard.nextLine();
		System.out.println("What is the price of the aircraft?");
		price = keyboard.nextLong();
		System.out.println("What is the maximum speed of the aircraft?");
		speed = keyboard.nextDouble();
		System.out.println("What is the maximum range of the aircraft?");
		range = keyboard.nextInt();
		System.out.println("What is the name of your pilot?");
		keyboard.nextLine();
		String pilotName = keyboard.nextLine();
		System.out.println("What is the pilots rank?");
		String rank = keyboard.nextLine();

		pilot = new Pilot(pilotName, rank);

		importJet.add(new EWJet(model, price, speed, range, pilot));
		pilotList.add(pilot);
	}

	public void addHelicopter(Scanner keyboard) {
		String model;
		long price;
		double speed;
		int range;
		Pilot pilot;

		System.out.println("What is the model of the aircraft?");
		model = keyboard.nextLine();
		System.out.println("What is the price of the aircraft?");
		price = keyboard.nextLong();
		System.out.println("What is the maximum speed of the aircraft?");
		speed = keyboard.nextDouble();
		System.out.println("What is the maximum range of the aircraft?");
		range = keyboard.nextInt();
		System.out.println("What is the name of your pilot?");
		keyboard.nextLine();
		String pilotName = keyboard.nextLine();
		System.out.println("What is the pilots rank?");
		String rank = keyboard.nextLine();

		pilot = new Pilot(pilotName, rank);

		importJet.add(new Helicopter(model, price, speed, range, pilot));
		pilotList.add(pilot);
	}

	public void removeAircraft(Scanner keyboard) {
		int counter = 1;
		int input;

		for (Jet jet : importJet) {
			System.out.println(counter++ + ": " + jet);
		}
		System.out.println("Which would you like to send to the hangar?");
		input = keyboard.nextInt();

		System.out.println(importJet.remove(input - 1) + " was removed");

	}

	public void flyIndividualJet(Scanner keyboard) {
		int counter = 1;
		int input;

		for (Jet jet : importJet) {
			System.out.println(counter++ + ": " + jet.getModel());
		}
		System.out.println("Which aircraft would you like to pilot?");
		input = keyboard.nextInt();

		System.out.println("Prepping " + importJet.get(input - 1).getModel() + " now");

	}

	public List<Pilot> generatePilots() {
		List<Pilot> pilots = new ArrayList<>();

		pilots.add(new Pilot("Adams", "Lt. CMDR"));
		pilots.add(new Pilot("Naranong", "Lt."));
		pilots.add(new Pilot("Clark", "Lt."));
		pilots.add(new Pilot("Fowler", "Lt. CMDR"));
		pilots.add(new Pilot("Bennekin", "Lt. "));

		return pilots;
	}
}
