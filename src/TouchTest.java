import lejos.nxt.*;
import lejos.robotics.subsumption.*;

public class TouchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Behavior b1 = new DriveForward(4);
		Behavior b2 = new TouchSensorRight(SensorPort.S2, 60);
		
		Behavior [] array = {b1,b2};
		
		Arbitrator a = new Arbitrator(array);
		a.start();

	}

}
