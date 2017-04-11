/**
Motor: En este diseño la unidad de control maneja el motor para mover la cabina.
Se optó por este camino para reducir métodos en la cabina que solo eran de paso 
para llegar al motor.
El atributo fundamental del motor es timer. este hace que el motor trabaje
en paralelo que los llamados de pisos provenientes del main.
El estado del motor se usa para distinguir en su Unidad de Control
cuando llega un nuevo envento, dado que si el motor esta detenido, debe iniciar
su movimiento. 
esta clase no es publica pues se usa solo en este archivo
El atributo mas important del motor en el objeto timer de la clase Timer. 
Esta clase permite generar invociones regulares y en "paralelo" con el 
resto de la ejecucion (el programa main en este caso).
Cuando el timer parte, este genera invocaciones regulares al metodo 
actionPerformed. El timer puede ser detenido invocando su metodo stop,
asi se terminan las invocaciones paraletas de actionPerformed.
Cabe destacar que mientras el timer este corriendo, el programa no termina
aun cuando el main haya concluido. Esto es asi porque esta actividad paralela
(otro hilo de ejecucion) es parte del programa y este termina solo cuando
no hay algun flujo o hilo de ejecucion corriendo.
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