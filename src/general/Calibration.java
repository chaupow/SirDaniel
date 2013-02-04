package general;

public class Calibration {
	
	/** barcode detection threshold. */
	public static final int THRESHOLD = 300;
	
	/** number of black values after a barcode. */
	public static final int SUFFIX_BLACK = 20;	
	
	/** width of a coding stripe in meters. */
	public static final double STRIPE_WIDTH = 0.025;
	
	/** minimum power to move the robot. */
	public static final int MOVEMENT_POWER = 24;	
	
	
	//TODO Wert anpassen
	/** Treshold to detect green colored field **/
	public static final int TRESHOLD_GREEN = 300;
	
	//TODO Wert anpassen
	/** Treshold to detect red colored field **/
	public static final int TRESHOLD_RED = 400;
		
	//TODO Wert anpassen
	/** Treshold to detect yellow colored field **/
	public static final int TRESHOLD_YELLOW = 600;
	
	
	

	/**Number of 5 degree turns the robot performed driving across the bridge**/
	public static int NumberOfTurns = 0;
	
	
	/**Flag indicating that the bridge algorithm should trigger**/
	public static boolean bridge = false;
	
	/**Flag indicating the rocker is reached**/
	public static boolean rocker = false;
	
	/**Flag indicating that the rolls and the slider is reached**/
	public static boolean slider = false;
		
}
