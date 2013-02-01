import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import general.Movement;

public class test {

	public static void main (String[] args) {
		Movement movement = Movement.getInstance(); 
		movement.setSpeed(1);
		Button.waitForAnyPress();
		movement.forward();
		LCD.drawString("Movement forward", 1, 1);
		
		Button.waitForAnyPress();
		LCD.clear();
		movement.backward();
		LCD.drawString("Movement backward", 1, 1);
		
		Button.waitForAnyPress();
		LCD.clear();
		movement.turn_left(90);
		LCD.drawString("Turn Left", 1, 1);
		
		Button.waitForAnyPress();
		LCD.clear();
		movement.turn_right(90);
		LCD.drawString("Turn Right", 1, 1);

		Button.waitForAnyPress();
		LCD.clear();
		movement.arcForward(100);
		LCD.drawString("Arc forward", 1, 1);
	}
}
