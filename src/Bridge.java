import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.*;

public class Bridge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Behavior b1 = new DriveForward(4);
		Behavior b2 = new TouchSensorBridge(SensorPort.S1);
		
		Behavior [] behavArray = {b1,b2};
		
		Arbitrator arb = new Arbitrator(behavArray);
		arb.start();
		
	}

}
