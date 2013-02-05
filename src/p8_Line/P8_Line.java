package p8_Line;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.Section;
import general.SirDanielArbitrator;

public class P8_Line implements Section {
	
	private SirDanielArbitrator arby;
	private UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	
	@Override
	public void start() {
		
		Behavior findLine = new P8_FindLine();
		Behavior foundLine = new P8_FoundLine();
		Behavior lost = new P8_Lost();
		Behavior findEnd = new P8_FindEnd();
		Behavior avoidObstacle = new P8_AvoidObstacle(sonic);
		
		Behavior [] b = {foundLine, findLine, findEnd, lost, avoidObstacle};
		
		arby = new SirDanielArbitrator(b, true);
		
		Thread t = new Thread(arby);
		
		System.out.println("Line started");
		t.start();
	}

	@Override
	public void stop() {
		arby.stop();
	}
	
	
	
	
	
	
	
	
	   /*public static void main(String [] args) {
		    
			UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
			
//			Arbitrator arby = new Arbitrator(b, true);
			SirDanielArbitrator arby = new SirDanielArbitrator(b,true);
			
			Movement.getInstance().setTravelSpeed(360);
//			P8_Config.lost = false;
			P8_Config.numberOfSearches = 0;
			Thread t = new Thread(arby);			
			Button.waitForAnyPress();
			SuperMotor.setSpeed(380);
			SuperMotor.calibrate();
			SuperMotor.turnTo(90, false);
			t.start();
//			arby.start();
			LCD.drawString("rausgesprungen", 0, 0);
			Button.waitForAnyPress();
			
	   }

*/


}
