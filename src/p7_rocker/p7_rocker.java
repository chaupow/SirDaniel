package p7_rocker;

import general.Calibration;
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
		
		//TODO barcode als takeControl
//		return Settings.rocker;
	}
	
	public void suppress(){
		
	}
	
	public void action(){
		
		//TODO sonic wert anpassen
		if(sonic.getDistance() > 20) {

			Movement.getInstance().setTravelSpeed(travelSpeed);
			Movement.getInstance().travel(distance);		
			
			Calibration.rocker = false;
			
		}
		
	}

}
