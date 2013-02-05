import general.Movement;
import general.SuperMotor;


public class Settings {
	
	//Calibartion Flags hier rein
	//initRace, ...
	//reset
	
	public static boolean race = false;
	
	public static boolean bridge = false;
	
	public static boolean labyrinth = false;
		
	public static boolean swamp = false;
	
	public static boolean bluetooth = false;
	
	public static boolean turntable = false;
	
	public static boolean slider = false;
	
	public static boolean rocker = false;
	
	public static boolean plank_bridge = false;
	
	public static boolean linefollow = false;
	
	public static boolean colors = false;
	
	public static boolean boss = false;
	
	
	public static void initRace() {
		SuperMotor.turnTo(0, false);
	}
	
	public static void initBridge() {
		SuperMotor.turnTo(180, false);
	}
	
	public static void initLabyrinth(){
		SuperMotor.turnTo(0, false);
	}
	
	public static void initSwamp(){
		SuperMotor.turnTo(0, false);
	}
	
	public static void initBluetooth(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initTurntable(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initSlider(){
		
		Movement.getInstance().travel(150);
		SuperMotor.turnTo(0, false);
	}
	
	public static void initRocker(){
		SuperMotor.turnTo(90, false);
	}
	
	
	public static void initPlankBridge(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initLineFollow(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initColors(){
		SuperMotor.turnTo(90, false);
	}
	
	public static void initBoss(){
		SuperMotor.turnTo(0, false);
	}
	
	
	public static void calibrateLight(){
		
	}
	
}

