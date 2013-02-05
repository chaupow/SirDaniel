package p5_turntable;

import general.SirDanielArbitrator;
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
		Behavior random = new Random();
		Behavior setRandom = new RandomDetect(1);
		Behavior turn = new TurnAround();
	   
		Behavior [] b = {follow, setRandom, random, search, turn};
		SirDanielArbitrator arby = new SirDanielArbitrator(b);
	   
		Thread t = new Thread(arby);
		Button.waitForAnyPress();
		t.start();
	}

}
