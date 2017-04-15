/**
Cabina: La Cabina es el carro del ascensor que sube y baja con personas.
La cabina tiene una botonera (que no se ocupará en esta etapa), una referencia
a la "caja ascensor" donde se encuentra, su posición actual, un indicador 
del piso en que se encuentra (requerido para mostrar piso actual) y una 
referencia al último sensor que activó y que al dejarlo debe desactivarlo.
La causa única de su movimiento es la invocación al método move.
En esta etapa la cabina se moverá en respuesta a las invoaciones a move.
 
Ante un movimiento, la cabina pregunta a la caja del ascensor por sensores en su nueva
posición.  De haber sensor, lo activa. Si no hay sensor se preocupa de desactivar
el último activado.
*/
import java.util.Random;

public class Cabina {
   private BotoneraCabina botonera; 
   private CajaAscensor shaft;
   private float position;  // in meters
   private int floorIndicator;
   private Sensor lastSensor=null;
   
   public Cabina (BotoneraCabina bc, CajaAscensor caja) {
      Random generator = new Random();
      botonera = bc;
      shaft = caja;
      position = generator.nextFloat();   //it starts between 0 an 1 [m]
      floorIndicator=1;
   }
   
   public int size()
   {
	   return botonera.ssize();
   }
   
   public void move(float delta) {
      // to be completed
	  Sensor sensor;
	  position+=delta;
	  sensor=shaft.findSensor(position);
	  // to be completed by you.
	  lastSensor=sensor;
   }
   public float getPosition(){
      return position;
   }
   public void setFloorIndicator (int floor){
      floorIndicator = floor;
   }
   public int readFloorIndicator() {
      return floorIndicator;
   }
   public void turnOnBc(int floor){
	   this.botonera.setRequest(String.valueOf(floor));
   }
   
   public boolean isReq(int floor)
   {
	   return botonera.isRequested(floor);
   }
   //true: si estaba apretado
   //false sino
   public boolean checkFloor(int currentFloor){
	   if (this.botonera.isRequested(currentFloor)){
		   this.botonera.resetFloorRequest(currentFloor);
		   System.out.println("en piso  "+currentFloor);
		   return true;
	   }
	   else
	   return false;
   }
}
