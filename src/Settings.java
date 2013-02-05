import general.Movement;
import general.SuperMotor;


public class Settings {
	
	//Calibartion Flags hier rein
	//initRace, ...
	//reset
	/**Flag race**/
	public static boolean race = false;
	/**Flag bridge**/
	public static boolean bridge = false;
	/**Flag labyrinth**/
	public static boolean labyrinth = false;
	/**Flag swamp**/	
	public static boolean swamp = false;
	/**Flag bluetooth**/
	public static boolean bluetooth = false;
	/**Flag turntable**/
	public static boolean turntable = false;
	/**Flag slider**/
	public static boolean slider = false;
	/**Flag rocker**/
	public static boolean rocker = false;
	/**Flag plnak_bridge**/
	public static boolean plank_bridge = false;
	/**Flag linefollow**/
	public static boolean linefollow = false;
	/**Flag colors**/
	public static boolean colors = false;
	/**Flag boss**/
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

