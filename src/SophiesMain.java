import p0_Race.Race;
import general.Calibration;
import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import lejos.nxt.Button;
import lejos.nxt.LightSensor;	
import lejos.nxt.SensorPort;
import lejos.util.Delay;

public class SophiesMain {
	
	private static LightSensor light = new LightSensor(SensorPort.S4);
	
	
	static boolean rising = true;
	static int max = 0;
	static int min = 1000;
	private final static int THRESHOLD = 100;
	private final static int TIME_FOR_SUFFIX = 1000;

	private static int finalLineCount = 0;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		init();
		
		while (Button.ESCAPE.isUp()) {
			switch(finalLineCount) {
			
			case 3:
				
			case 4: 
				
			case 5:
			
			case 6:
				
			case 7:
				
			case 8:
				
			case 9:
				
			case 10:
				
			case 11:
				
			case 12:
				
			case 13: while(Button.ENTER.isUp());
					Delay.msDelay(10000);
					Calibration.race = true;
					Race.race();
					Movement.getInstance().travel(-100);
					readBarcode();
					break;
				
			case 14: 

		
			}
			
			if(Button.ENTER.isDown()) readBarcode();

		}
				
	}
	
	private static void init(){
		
		SuperMotor.calibrate();
		while(Button.ENTER.isUp());
		readBarcode();
	}
	
	
	private static void readBarcode(){
		
		int currentValue;
		long currentTimestamp = System.currentTimeMillis();
		long lastTimestamp = 0;
		int tempLineCount = 0;
		
		Movement.getInstance().forward();	

		while (currentTimestamp - lastTimestamp > TIME_FOR_SUFFIX) {
			
			currentValue = light.getNormalizedLightValue();
			currentTimestamp = System.currentTimeMillis();
			if (rising) {
				if (currentValue >= max) {
					max = currentValue;
				} else {
					rising = false;
					min = max;
				}			
			} else {
				if (currentValue <= min) {
					min = currentValue;
				} else {
					rising = true;
					if (max-min > THRESHOLD) {
						lastTimestamp = currentTimestamp;
						tempLineCount++;
					}
					max = min;
				}
			}
			
					
		}

		finalLineCount = tempLineCount;

		Movement.getInstance().stop();
	}
}
