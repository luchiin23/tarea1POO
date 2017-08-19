import java.awt.event.*;  // ActionListener, ActionEvent
import javax.swing.Timer;

public class Motor implements ActionListener {
   private Timer timer;
   private Cabina cabina;
   private float deltaHight;    // in [m]
   
   public static final int UP =0;  // it is better to use
   public static final int DOWN =1;  // enum type but we have
   public static final int PAUSED =2;  // not seen it.
   public static final int STOPPED =3;
   
   public int state;
   
   public Motor (Cabina c, float speed){
      int deltaTime = 100; // [ms]
      cabina = c;
      state = STOPPED;
      deltaHight = speed*deltaTime/1000.0f;
      timer = new Timer(deltaTime, this);
   }
   public void lift() {
      if (!timer.isRunning())
         timer.start();
      state = UP;
   }
   public void lower() {
      if (!timer.isRunning())
         timer.start();
      state = DOWN;
   }
   public void stop() {
      timer.stop();
      state = STOPPED;
   }
   public void pause() {
      int oldState =state;
      state = PAUSED;
      System.out.println("Pausing cabina ..... ");
      try {
          Thread.currentThread().sleep(2000);  
      } catch (InterruptedException e){}
      state = oldState;
   }
   public int getState(){
      return state;
   } 
   public void actionPerformed (ActionEvent event) {
      switch (state) {
         case UP: cabina.move(deltaHight);
                  break;
         case DOWN: cabina.move(-deltaHight);
                  break;
      }
   }
}