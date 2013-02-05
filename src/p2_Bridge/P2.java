package p2_Bridge;
import general.Settings;
import general.SirDanielArbitrator;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class P2 implements Behavior {
	   
   private SirDanielArbitrator arby;
   private Thread t;

   public P2(){
	   

	   Behavior driveRight = new P2_DriveLeft();
	   Behavior avoidAbyss = new P2_AvoidAbyss();
	   
	   Behavior [] b = {driveRight, avoidAbyss};
	   arby = new SirDanielArbitrator(b, true);	   
	   t = new Thread(arby);
	   
   }
   
@Override
public boolean takeControl() {
	// TODO Auto-generated method stub
	return Settings.bridge;
}

@Override
public void action() {
	t.start();
	}

@Override
public void suppress() {
	// TODO Auto-generated method stub
	Settings.bridge = false;
}


}
