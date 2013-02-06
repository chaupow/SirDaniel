package p6_slider;

import p1_labyrinth.P1_DriveForward;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.SirDanielArbitrator;
import general.SuperMotor;


public class P6 {
	private UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	private SirDanielArbitrator arby;
	private final int MIN_DIST = 13;
	
	private static P6 instance = null;

	public static P6 getInstance() {
		if(instance == null) {
			instance = new P6();
		}
		return instance;
	}
	
	public void start() {
		
		Config.NumberOfTurns = 0;
		SuperMotor.turnTo(0, false);

		Behavior forward = new P1_DriveForward(140);
		Behavior correct = new P6_Correct(sonic, MIN_DIST);
		Behavior button = new P6_PushButton();
		//Behavior slider = new P6_Slider();
		Behavior endSlider = new P6_EndSlider();
		
		Behavior [] b = {forward, correct, button, endSlider};
		arby = new SirDanielArbitrator(b, true);
		
		Thread t = new Thread (arby);
		System.out.println("Slider started");		
		t.start();
	}
	
	
	public void stop(){
		arby.stop();
	}

}
