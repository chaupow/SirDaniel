package general;

import general.Settings.State;
import lejos.nxt.Button;
import lejos.util.Delay;

public class ClaudisMain {
	static StateMachine stateMachine = new StateMachine();
	static BarcodeReader barcodeReader = new BarcodeReader();
	static ButtonListener buttonListener = new ButtonListener(stateMachine);
	static int lineCount;
	static Movement movement = Movement.getInstance();
	
	public static void main(String[] args) {
		Button.waitForAnyPress();
		Settings.calibrateLight();
		Button.waitForAnyPress();
		SuperMotor.calibrate();
		SuperMotor.turnTo(90, false);
		buttonListener.start();
		
		searchBarcode();		
	}
	
	public static void searchBarcode() {
		movement.travel(-20);
		lineCount = barcodeReader.run();
		System.out.println("Barcode gelesen");
//		Delay.msDelay(1000);
		switch (lineCount) {
		case 3: stateMachine.setState(State.gate); break;
		case 4: stateMachine.setState(State.swamp); break;
		case 5: stateMachine.setState(State.bridge); break;
		case 6: stateMachine.setState(State.line); break;
		case 7: stateMachine.setState(State.labyrinth); break;
		case 8: stateMachine.setState(State.colorGate); break;
		case 9: stateMachine.setState(State.line); break;
		case 10: stateMachine.setState(State.rocker); break;
		case 11: stateMachine.setState(State.turntable); break;
		case 12: stateMachine.setState(State.slider); break;
		case 13: stateMachine.setState(State.race); break;
		}
	}
	
	public static void restart() {
		Button.waitForAnyPress();
		buttonListener.shouldRun = true;
		searchBarcode();
	}
}
