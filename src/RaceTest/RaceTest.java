package RaceTest;

import general.SirDanielArbitrator;
import general.SuperMotor;
import lejos.robotics.subsumption.Behavior;

public class RaceTest {
	public static int counter = 0;
	
	public  void run () {
		Behavior rf = new RaceFoward();
		Behavior rt = new RaceTurn(this);
		Behavior [] bArray = {rf, rt};
		SirDanielArbitrator arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		t.start();
	}
	
	public static void main (String[] args) {
		SuperMotor.calibrate();
		SuperMotor.turnTo(0, false);
		RaceTest race = new RaceTest();
		race.run();
	}
}
