package _02_LongChipCompetition;

import java.util.ArrayList;
import java.util.Random;

public class LongChipCompetition {
	/*
	 * The Beatles are eating lunch and playing a game to see who has the longest
	 * chip. (In England, french fries are called "chips".) Find the Beatle with the
	 * longest chip. You may not edit the Chip or Beatle classes. Make sure to
	 * initialize The Beatles before you start your search.
	 */
	private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

	public static void main(String[] args) {
		LongChipCompetition lcc = new LongChipCompetition();
		lcc.initializeBeatles();
		for (Beatle beatle : lcc.theBeatles) {
double longest = 0;
			for (int i = 0; i < beatle.getChips().size(); i++) {
				ArrayList<Chip> chips = beatle.getChips();
				for (int j = 0; j < chips.size(); j++) {
					if (chips.get(j).getLength() > chips.get(j - 1).getLength()) {
						 longest =chips.get(j).getLength();
					}
				}
			}
			System.out.println(beatle.getName() + "'s longest chip is " + longest + " long");
		}
	}

	private void initializeBeatles() {
		Beatle george = new Beatle("George");
		Beatle john = new Beatle("John");
		Beatle paul = new Beatle("Paul");
		Beatle ringo = new Beatle("Ringo");
		theBeatles.add(george);
		theBeatles.add(john);
		theBeatles.add(paul);
		theBeatles.add(ringo);
	}

	public ArrayList<Beatle> getTheBand() {
		return theBeatles;
	}
}

class Beatle {
	private String name;
	private ArrayList<Chip> chips = new ArrayList<Chip>();

	public Beatle(String name) {
		this.name = name;
		initializePlateOfChips();
	}

	private void initializePlateOfChips() {
		int numberOfChips = new Random().nextInt(100);
		for (int i = 0; i < numberOfChips; i++) {
			chips.add(new Chip(new Random().nextDouble() * 10));
		}
	}

	public ArrayList<Chip> getChips() {
		return this.chips;
	}

	public String getName() {
		return this.name;
	}
}

class Chip {
	private double length;

	public double getLength() {
		return length;
	}

	Chip(double d) {
		this.length = d;
	}
}
