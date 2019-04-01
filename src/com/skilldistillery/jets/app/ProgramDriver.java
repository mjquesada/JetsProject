package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.models.Jet;

public class ProgramDriver {
	public static Scanner keyboard = new Scanner(System.in);
	Carrier carrier = new Carrier();

	public ProgramDriver() {

	}

	public void startupMenu() {
		boolean running = true;
		System.out.println("Attention on deck!");
		System.out.println("The captain has the helm");
		int choice = 0;

		do {

			System.out.println();
			System.out.println("What are your orders?");
			System.out.println("1. List fleet");
			System.out.println("2. Scramble (fly) all aircraft");
			System.out.println("3. View our fastest aircraft");
			System.out.println("4. View our longest range aircraft");
			System.out.println("5. Scramble fighter jets to dogfight");
			System.out.println("6. Spy on our enemies (with EW aircraft)");
			System.out.println("7. Fly an individual aircraft");
			System.out.println("8. Bring an aircraft up from the hangar (Add aircraft)");
			System.out.println("9. Remove an aircraft from the flightdeck (Remove aircraft)");
			System.out.println("10. Quit program");
			choice = keyboard.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Here are all of the available aircraft:");
				System.out.println();
				for (Jet jet : carrier.importJet) {
					System.out.println(jet);
				}
				break;
			case 2:
				System.out.println("Enemies inbound, scramble all the aircraft!");
				System.out.println();
				for (Jet jet : carrier.importJet) {
					jet.fly();
				}
				break;
			case 3:
				System.out.println("Our fastest aircraft is: ");
				carrier.fastestAircraft();
				break;
			case 4:
				System.out.println("The aircraft with the longest range is: ");
				carrier.longRangeAircraft();
				break;
			case 5:
				System.out.println("Incoming aircraft, prepare for dogfight");
				carrier.dogFight();
				break;
			case 6:
				System.out.println("Spy planes out");
				carrier.spyOnEnemies();
				break;
			case 7:
				carrier.flyIndividualJet(keyboard);
				break;
			case 8:
				System.out.println("What kind of aircraft is this?");
				System.out.println("1. Fighter Jet");
				System.out.println("2. Electronic Warfare");
				System.out.println("3. Helicopter");
				int input = 0;
				input = keyboard.nextInt();
				keyboard.nextLine();
				if (input == 1) {
					carrier.addFighterJet(keyboard);
					for (Jet jet : carrier.importJet) {
						System.out.println(jet);
					}
				} else if (input == 2) {
					carrier.addElectricJet(keyboard);
					for (Jet jet : carrier.importJet) {
						System.out.println(jet);
					}
				} else if (input == 3) {
					carrier.addHelicopter(keyboard);
					for (Jet jet : carrier.importJet) {
						System.out.println(jet);
					}
				}
				break;
			case 9:
				System.out.println("Ok, which aircraft should we send to the hangar?");
				carrier.removeAircraft(keyboard);
				break;
			case 10:
				System.out.println("Goodbye");
				running = false;
			}
		} while (running);
	}
}
