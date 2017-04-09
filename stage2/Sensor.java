/**
En este diseño se decidió guardar como estado de cada sensor su posisión y
el piso en que está instalado. Además se tiene una referencia a la unidad de control
porque ante una activación y desactivación del sensor, éste debe propagar esta señal
a la Unidad de Control. Así ésta puede tomar acción según el estado de las botoneras.
En este diseño, es también responsabilidad del sensor informar si una posición
estaría en el rango en que él se activa. Debe ser así pues el rango en que
un sensor permanece activado es un atributo de un sensor.
*/
public class Sensor {
   private final float position;  // in [m]
   private final int storyNum; // story is the space between two adjacent floor levels
   private boolean active;
   private ControlUnit controlUnit;
   private static float PRECISION = 0.05f; // [m] f because it's float, default is double  
   public Sensor (float pos, int piso, ControlUnit cu) {
      position = pos;
      storyNum = piso;
      active = false;
      controlUnit = cu;
   }
   public boolean isInRange(float h){
   /** return true if h is within position +- PRECISION 
   */
      // to be completed
   }
   public void activateAction() {
      active = true;
      controlUnit.activateSensorAction(storyNum); 
   }
   public void deactivateAction() {
      // to be completed
   }
   public boolean isActivated(){
       // to be completed
   }
}