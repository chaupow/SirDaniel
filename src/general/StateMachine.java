package general;

import p0_Race.Race;
import p1_labyrinth.P1;
import p2_Bridge.P2;
import p5_turntable.P5;
import p6_slider.P6;
import p8_Line.P8_Line;
import p9_swamp.P9;
import general.Settings.State;

public class StateMachine {
	
	State state;
	P2 bridge = new P2();
	P1 labyrinth = new P1();
	P9 swamp = new P9();
	Race race = new Race();
	P8_Line line = P8_Line.getInstance();
	P5 turntable = P5.getInstance();
	P6 slider = new P6();
	
	public StateMachine() {
		this.state = State.race;
	}
	
	public void setState(State newState) {
		this.state = newState;
		
		// stop all other levels
//		bridge.stop();	
//		labyrinth.stop();
		
		switch (state) {
//		case gate: System.out.println("Gate"); break;
		case swamp: System.out.println("Swamp"); labyrinth.stop(); swamp.start(); break;
		case bridge:  System.out.println("Bridge"); race.stop(); bridge.start(); break;
//		case line: System.out.println("Line"); break;
		case labyrinth:  System.out.println("Labyrinth"); bridge.stop(); labyrinth.start(); break;
//		case colorGate: System.out.println("ColorGate"); break;
//		case rocker: System.out.println("Rocker"); p7_rocker.p7_rocker.start(); break;
		case turntable: System.out.println("Turntable"); labyrinth.stop(); turntable.start(false); break;
		case slider: System.out.println("Slider"); turntable.stop(); slider.start(); break;
		case race: System.out.println("Race"); race.start(); break;
//		case boss: System.out.println("Boss"); break;
		}
	}
	
	public void abortState() {
		switch (state) {
//		case gate: System.out.println("Gate"); break;
//		case swamp: System.out.println("Swamp"); break;
		case bridge:  System.out.println("Abort Bridge"); bridge.stop(); break;
//		case line: System.out.println("Line"); break;
		case labyrinth:  System.out.println("Abort Labyrinth"); labyrinth.stop(); break;
//		case colorGate: System.out.println("ColorGate"); break;
//		case rocker: System.out.println("Rocker"); p7_rocker.p7_rocker.start(); break;
		case turntable: System.out.println("Abort Turntable"); turntable.stop(); break;
//		case slider: System.out.println("Slider"); p6_slider.P6.start(); break;
		case race: System.out.println("Abort Race"); race.stop(); break;
//		case boss: System.out.println("Boss"); break;
		}
	}
	
}
