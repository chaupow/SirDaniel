package general;

import general.Settings.State;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.Delay;

public class ButtonListener extends Thread {
	
	StateMachine stateMachine;
	boolean shouldRun = true;
	
	public ButtonListener(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	@Override
	public void run() {
		while(!interrupted()) {
			while(!shouldRun) Delay.msDelay(10);
			Button.waitForAnyPress();
			if (stateMachine.state == State.race) Button.waitForAnyPress();
			System.out.println("State aborted");
			Delay.msDelay(1000);
			stateMachine.abortState();				
			
			Movement.getInstance().stop();
			shouldRun = false;
			ClaudisMain.restart();		
		}
	}
}
