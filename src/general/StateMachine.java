package general;

import p2_Bridge.P2;
import general.Settings.State;

public class StateMachine {
	
	State state;
	P2 bridge = new P2();
	
	public StateMachine() {
		this.state = State.race;
	}
	
	public void setState(State newState) {
		state = newState;
		
		// stop all other levels
		bridge.stop();		
		
		switch (state) {
		case gate: System.out.println("Gate"); break;
		case swamp: System.out.println("Swamp");; break;
		case bridge:  System.out.println("Bridge"); bridge.start(); break;
		case line: System.out.println("Line"); break;
		case labyrinth:  System.out.println("Labyrinth"); break;
		case colorGate: System.out.println("ColorGate"); break;
//		case rocker: System.out.println("Rocker"); p7_rocker.p7_rocker.start(); break;
//		case turntable: System.out.println("Turntable"); p5_turntable.P5.start(); break;
//		case slider: System.out.println("Slider"); p6_slider.P6.start(); break;
//		case race: System.out.println("Race"); p0_Race.Race.start(); break;
		case boss: System.out.println("Boss"); break;
		}
	}
	
}
