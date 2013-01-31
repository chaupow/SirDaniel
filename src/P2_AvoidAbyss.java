import lejos.nxt.LCD;
import lejos.nxt.TouchSensor;
import lejos.robotics.subsumption.*;
import lejos.util.Delay;

public class P2_AvoidAbyss implements Behavior {
   private boolean suppressed = false;
   TouchSensor touch;
   private int speed;
   private int angle;
   private int rotationSpeed;
	Movement movement = new Movement();
   
   
   public P2_AvoidAbyss(TouchSensor touch, int speed, int rotationSpeed, int angle){
	   this.speed = speed;
	   this.angle = angle;
	   this.rotationSpeed = rotationSpeed;
	   this.touch = touch;
   }
   
   public boolean takeControl() {
      return (!touch.isPressed());
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
     suppressed = false;
     SuperMotor.turn();
     movement.turn_left(angle, rotationSpeed);
     movement.forward(speed);
     Delay.msDelay(500);
     SuperMotor.turn();	   
   }
}