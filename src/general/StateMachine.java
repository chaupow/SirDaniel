package general;

import p0_Race.Race;
import p1_labyrinth.P1;
import p2_Bridge.P2;
import p5_turntable.P5;
import p8_Line.P8_Line;
import general.Settings.State;

public class StateMachine {
	
	State state;
	P2 bridge = new P2();
	P1 labyrinth = new P1();
	Race race = new Race();
	P8_Line line = P8_Line.getInstance();
	P5 turntable = P5.getInstance();
	
	
	public StateMachine() {
		this.state = null;
	}
	
	public void setState(State newState) {
		if (state != null) abortState();
		this.state = newState;		
		
		switch (state) {
//		case gate: System.out.println("Gate"); break;
//		case swamp: System.out.println("Swamp"); break;
		case bridge:  System.out.println("Bridge"); bridge.start(); break;
		case line: System.out.println("Line"); line.start(1); break;
		case labyrinth:  System.out.println("Labyrinth"); labyrinth.start(); break;
//		case colorGate: System.out.println("ColorGate"); break;
//		case rocker: System.out.println("Rocker"); p7_rocker.p7_rocker.start(); break;
		case turntable: System.out.println("Turntable"); turntable.start(false); break;
//		case slider: System.out.println("Slider"); p6_slider.P6.start(); break;
		case race: System.out.println("Race"); race.start(); break;
//		case boss: System.out.println("Boss"); break;
		}
	}
	
	public void abortState() {
		switch (state) {
//		case gate: System.out.println("Gate"); break;
//		case swamp: System.out.println("Swamp"); break;
		case bridge:  System.out.println("Abort Bridge"); bridge.stop(); break;
		case line: System.out.println("Abort Line"); line.stop(); break;
		case labyrinth:  System.out.println("Abort Labyrinth"); labyrinth.stop(); break;
//		case colorGate: System.out.println("ColorGate"); break;
//		case rocker: System.out.println("Rocker"); p7_rocker.p7_rocker.start(); break;
		case turntable: System.out.println("Abort Turntable"); turntable.stop(); break;
//		case slider: System.out.println("Slider"); p6_slider.P6.start(); break;
		case race: System.out.println("Abort Race"); race.stop(); break;
//		case boss: System.out.println("Boss"); break;
		}
		state = null;
	}
	
}
