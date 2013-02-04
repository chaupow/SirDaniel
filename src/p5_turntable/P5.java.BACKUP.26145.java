package p5_turntable;

import general.SirDanielArbitrator;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;
import p4_LineFollower.FollowLine;
import p4_LineFollower.Random;
import p4_LineFollower.RandomDetect;
import p4_LineFollower.SearchLine;

public class P5 {
	
	public static void main(String[] args) {
	
		Behavior follow = new FollowLine();
		Behavior search = new SearchLine();
<<<<<<< HEAD
		Behavior driveIn = new DriveInBox();
		// BoxEntryDetect(afterNumberOfUnsuccessfulSearches, rotateSuperMotorToPosition)
		Behavior detectBox = new BoxEntryDetect(1, 0);
		Behavior turn = new TurnAround();
	   
		Behavior [] b = {follow, detectBox, driveIn, search, turn};
=======
		Behavior boxEntry = new BoxEntryDetect(1, 0);
		Behavior driveIn = new DriveInBox();
		Behavior turn = new TurnAround();
	   
		Behavior [] b = {follow, boxEntry, driveIn, search, turn};
>>>>>>> 16aba3d58022975faf07d27b37a4fb99234f1e95
		SirDanielArbitrator arby = new SirDanielArbitrator(b);
	   
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		
		SuperMotor.calibrate();
		SuperMotor.turnTo(90, false);
		t.start();
	}

}
