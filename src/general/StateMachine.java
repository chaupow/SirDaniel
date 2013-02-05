package general;

import p2_Bridge.P2;
import general.Settings.State;

public class StateMachine {
	
	State state;
	State oldState;
	P2 bridge = new P2();
	
	public StateMachine() {
		this.state = State.race;
	}
	
	public void setState(State newState) {
		oldState = state;
		state = newState;
		
		switch (state) {
		case gate: ; break;
		case swamp: ; break;
		case bridge:  System.out.println("Bridge"); bridge.start(); break;
//		case line: { System.out.println("Ende"); bridge.stop();  break;}
		case labyrinth:  System.out.println("Labyrinth"); bridge.stop();  break;
//		case colorGate: ; break;
//		case rocker: p7_rocker.p7_rocker.start(); break;
//		case turntable: p5_turntable.P5.start(); break;
//		case slider: p6_slider.P6.start(); break;
//		case race: p0_Race.Race.start(); break;
		case boss: ; break;
		}
	}
	
}
