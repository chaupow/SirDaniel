package general;

import general.Settings.State;
import lejos.nxt.Button;

public class ButtonListener implements Runnable {
	
	StateMachine stateMachine;
	
	public ButtonListener(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	@Override
	public void run() {
		Button.waitForAnyPress();
		Button.waitForAnyPress();
		stateMachine.abortState();		
		Movement.getInstance().stop();
		ClaudisMain.restart();
	}
}
