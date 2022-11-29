package _01_MurderOfCrows;

import static org.junit.Assert.assertArrayEquals;

public class StomachChecker {
	public static void main(String[] args) {
		MurderOfCrows moc = new MurderOfCrows();
		moc.initializeCrows();
		for (Crow crow : moc.theMurder) {
			if (crow.getStomachContents().equals("diamond")) {
				System.out.println(crow.getName() + " is the culprit");
			} else {
				System.out.println(crow.getName() + " is innocent, it only ate a " + crow.getStomachContents());

			}
		}
	}
}
