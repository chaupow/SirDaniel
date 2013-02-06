package p8_colorbuttons;

import p8_Line.P8_Line;
import general.Movement;
import general.SirDanielArbitrator;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
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
	boolean lab = false;
	boolean disconnected = false;
	UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	
	static ColorButtons cb=null;
	
	private ColorButtons(){}
	
	public static ColorButtons getInstance(){
		if (cb == null) {
			cb = new ColorButtons();
		}
		return cb;
	}	

	int speed = 1;
	int rotationSpeed = 1;
	int min_dist = 10;
	int shouldBe = 10;
	int minimumDifference = 30;

	public void start(boolean afterLine) {
		if (!afterLine) {
			P8_Line.getInstance().start(2); // 0 == called by turntable
		} else {
			Behavior talkToGate = new P8_TalkToGate(this, gate);
			Behavior findColor = new P8_FindColor(this);
			Behavior defineColors = new P8_DefineColors(this);
			Behavior driveOver = new P8_DriveOverColors();
			Behavior setColors = new P8_SetColors(this);
			Behavior pushButton = new P8_PushButton(this);
			Behavior throughGate = new P8_DriveThroughGate(this);
			Behavior labforward = new Lab_DriveForward(100, this);
			Behavior labcorrect = new Lab_Correct(sonic, min_dist, this);
			Behavior labturnRight = new Lab_TurnLeft(sonic, speed, rotationSpeed, shouldBe, minimumDifference, this);
			Behavior labturnLeft = new Lab_TurnRight(speed, rotationSpeed, this);
	
			SuperMotor.turnTo(90, false);
			Behavior [] bArray = {defineColors, driveOver, setColors, findColor, pushButton, throughGate, talkToGate, labforward,labcorrect, labturnRight, labturnLeft};
			arby = new SirDanielArbitrator(bArray, true);
			Thread t = new Thread(arby);
			t.start();
		}
	}
	
	public void stop() {
//		gate.disconnectFromGate();
		arby.stop();
	}
	
	
//	public static void main (String[] args) {
//		SuperMotor.calibrate();
//		Button.waitForAnyPress();
//		ColorButtons cb = ColorButtons.getInstance();
//		cb.start();
//	} 
}