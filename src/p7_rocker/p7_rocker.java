package p7_rocker;

import p8_Line.P8_Line;
import general.Movement;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

public class p7_rocker implements Behavior{
	
	double distance;
	double travelSpeed;
	UltrasonicSensor sonic; 
	/**
	 * @param distance Distance the robot has to travel to cross the rocker im mm.
	 * @param speed TravelSpeed
	 */
	public p7_rocker (double distance, double travelSpeed, UltrasonicSensor sonic){
		this.distance = distance/1.66;
		this.travelSpeed = travelSpeed;
		this.sonic = sonic;
	}
	
	
	public boolean takeControl(){
		return true;
	}
	
	public void suppress(){
		
	}
	
	public void action(){
		
		//TODO sonic wert anpassen
		if(sonic.getDistance() > 40) {
			Movement.getInstance().setTravelSpeed(travelSpeed);
			Movement.getInstance().travel(distance, false);	
			P7.getInstance().stop();
			P8_Line.getInstance().start(1);			
		}
		
	}

}
