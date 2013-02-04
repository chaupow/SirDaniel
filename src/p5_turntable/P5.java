package p5_turntable;

import general.SirDanielArbitrator;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;
import p2_Bridge.P2_AvoidAbyss;
import p2_Bridge.P2_DriveRight;
import p4_LineFollower.FollowLine;
import p4_LineFollower.Random;
import p4_LineFollower.RandomDetect;
import p4_LineFollower.SearchLine;

public class P5 {
	
	public static void main(String[] args) {
	
		Behavior follow = new FollowLine();
		Behavior search = new SearchLine();
		Behavior boxEntry = new BoxEntryDetect(1, 0);
		Behavior driveIn = new DriveInBox();
		Behavior turn = new TurnAround();
	   
		Behavior [] b = {follow, boxEntry, driveIn, search, turn};
		SirDanielArbitrator arby = new SirDanielArbitrator(b);
	   
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		
		SuperMotor.calibrate();
		SuperMotor.turnTo(90, false);
		t.start();
	}

}
