import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.BarcodeReader;
import general.Movement;
import general.Settings;
import general.SirDanielArbitrator;

public class Main {
	
	public static void main (String[] args) {
		
		UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S3);
		
		Behavior b1 = new p0_Race.Race(sonar);
		Behavior [] bArray = {b1};
	    SirDanielArbitrator arby = new SirDanielArbitrator(bArray);
	    BarcodeReader barcodes = new BarcodeReader();
	    
	    Button.waitForAnyPress();
	    Settings.calibrateLight();
	    
	    Thread t = new Thread(arby);
	    t.start();
	    
	    Thread b = new Thread(barcodes);
	    b.start();
	}

}
