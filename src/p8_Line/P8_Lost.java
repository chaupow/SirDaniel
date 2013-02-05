package p8_Line;
import general.Movement;
import general.SensorCache;
import general.SuperMotor;
import p4_LineFollower.Config;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class P8_Lost implements Behavior {
	
		int threshold = P8_Config.lightThreshold;
		int[] degrees = {10, 30, 90};
		int middle = 90;
		boolean suppressed = false;	// richtig initialisiert?
		Movement movement = Movement.getInstance();
		int j = 0;
		//SensorCache cache = SensorCache.getInstance();
		
		public P8_Lost() {
			
		}
		
		public boolean takeControl() {
			return (SensorCache.getInstance().normalizedLightValue < threshold && P8_Config.numberOfSearches == 1 && !P8_Config.lost);
		}
		
		public void action() {
			suppressed = false;
			int i = 0;
			SuperMotor.turnTo(90, true);
			LCD.clear();
			LCD.drawString("Lost", 0, 3);
			movement.travel(50);
			
			P8_Config.lost = true;
//			while (!suppressed && SensorCache.getInstance().normalizedLightValue < threshold) {
//				movement.travel(-10, true);
//			}

			
			
			
//			if (P8_Config.leftTurn) {
//				while (SensorCache.getInstance().normalizedLightValue < threshold && i < degrees.length && !suppressed) {
//					// + means to the left
//					P8_Config.leftTurn = true;
//					if (SensorCache.getInstance().normalizedLightValue < threshold && !suppressed) SuperMotor.turnTo(middle + degrees[i], true);
//					while (SensorCache.getInstance().normalizedLightValue < threshold && Motor.C.isMoving() && !suppressed) {
//						LCD.drawInt(SensorCache.getInstance().normalizedLightValue, 0, 4);
//					}
//					
//					P8_Config.leftTurn = false;
//					if (SensorCache.getInstance().normalizedLightValue < threshold && !suppressed) SuperMotor.turnTo(middle - degrees[i], true);
//					while (SensorCache.getInstance().normalizedLightValue < threshold && Motor.C.isMoving() && !suppressed) {
//						LCD.drawInt(SensorCache.getInstance().normalizedLightValue, 0, 4);
//					}
//					
//					i++;
//				}
//			} else {
//				while (SensorCache.getInstance().normalizedLightValue < threshold && i < degrees.length && !suppressed) {
//					// - means to the right
//					P8_Config.leftTurn = false;
//					if (SensorCache.getInstance().normalizedLightValue < threshold && !suppressed) SuperMotor.turnTo(middle - degrees[i], true);
//					while (SensorCache.getInstance().normalizedLightValue < threshold && Motor.C.isMoving() && !suppressed);
//					
//					P8_Config.leftTurn = true;
//					if (SensorCache.getInstance().normalizedLightValue < threshold && !suppressed) SuperMotor.turnTo(middle + degrees[i], true);
//					while (SensorCache.getInstance().normalizedLightValue < threshold && Motor.C.isMoving() && !suppressed);
//					
//					i++;
//				}
//			}
//			
//			// getting here means the line has not been found
//			movement.stop();
//			P8_Config.numberOfSearches++;
			
		}
		
		public void suppress() {
			suppressed = true;
		}
	
}
