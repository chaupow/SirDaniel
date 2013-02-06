package p8_colorbuttons;

import p8_Line.P8_Line;
import general.ClaudisMain;
import general.Movement;
import general.SirDanielArbitrator;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class ColorButtons {
	Movement movement = Movement.getInstance();
	public int requestedColor = -1;
	public int defineColor = 0;
	boolean colorsSet = false;
	public int [] average = new int[3];
	public int blackLines = -1;
	ColorGateControl gate = new ColorGateControl();
	SirDanielArbitrator arby;
	static ColorButtons cb = null;
	boolean boss = false;
	
	public static ColorButtons getInstance(){
		if (cb == null) {
			cb = new ColorButtons();
		}
		return cb;
	}
	
	private ColorButtons (){
		
	}
	
	public void start() {
		
		Behavior talkToGate = new P8_TalkToGate(this, gate);
		Behavior findColor = new P8_FindColor(this);
		Behavior defineColors = new P8_DefineColors(this);
		Behavior driveOver = new P8_DriveOverColors();
		Behavior setColors = new P8_SetColors(this);
		Behavior pushButton = new P8_PushButton(this);
		Behavior throughGate = new P8_DriveThroughGate(this);
		Behavior boss = new P8_BOSS();
		
		SuperMotor.turnTo(90, false);
		Behavior [] bArray = {defineColors, driveOver, setColors, findColor, pushButton, throughGate, talkToGate, boss};
		arby = new SirDanielArbitrator(bArray, true);
		Thread t = new Thread(arby);
		System.out.println("I will start now");
		t.start();
	}
	
	public void stop(){
		arby.stop();
	}
	
	public static void main (String[] args) {
		SuperMotor.calibrate();
		Button.waitForAnyPress();
		System.out.println("I will get Instance now");
		ColorButtons.getInstance().start();
	} 
}
