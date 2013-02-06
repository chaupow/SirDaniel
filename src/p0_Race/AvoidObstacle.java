package p0_Race;

import general.Movement;
import general.SensorCache;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class AvoidObstacle implements Behavior {

		SensorCache cache = SensorCache.getInstance();
		int min_dist = 0;
		int delay = 150;
		Movement movement;
		
		public AvoidObstacle(){
			movement = Movement.getInstance();
		}
		
		@Override
		public boolean takeControl() {
			return (cache.bumperPressed && !Constants.alreadyStopped);
		}

		@Override
		public void action() {
			Constants.alreadyStopped = true;
			movement.stop();
			Delay.msDelay(delay);		
		}

		@Override
		public void suppress() {
			// TODO Auto-generated method stub
			
		}


	
	
}
