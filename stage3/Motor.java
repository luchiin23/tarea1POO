/**
Motor: En este diseño la unidad de control maneja el motor para mover la cabina.
Se optó por este camino para reducir métodos en la cabina que sólo eran de paso 
para llegar al motor.
El atributo fundamental del motor es timer. Éste hace que el motor trabaje
en paralelo que los llamados de pisos provenientes del main.
El estado del motor se usa para distinguir en su Unidad de Control
cuando llega un nuevo envento, dado que si el motor está detenido, debe iniciar
su movimiento. 
esta clase no es pública pues se usa sólo en este archivo
El atributo más immportan del motor en el objeto timer de la clase Timer. 
Esta clase permite generar invociones regulares y en "paralelo" con el 
resto de la ejecución (el programa main en este caso).
Cuando el timer parte, éste genera invocaciones regulares al método 
actionPerformed. El timer puede ser detenido invocando su método stop,
así se terminan las invocaciones paraletas de actionPerformed.
Cabe destacar que mientras el timer esté corriento, el programa no termina
aún cuando el main haya conclluido. Esto es así porque esta actividad paralela
(otro hilo de ejecución) es parte del programa y éste termina sólo cuando
no hay algún flujo o hhilo de ejecución corriendo.
*/
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