/**
La causalidad de eventos es La cabina se mueve,
ésta presiona un sensor, y luego el sensor debe
reportar este evento a la unidad de control responsable de
informar de la llegada a un nuevo piso y tomar otras acciones
como detener la cabina si así ha sido requeirdo para ese piso 
(esta última parte no está implementada aquí).
En la operación de un ascensor, la Unidad de Control no requiere
pedir servicios a un sensor, pues es éste quien informa 
a la unidad de control de un cambio (la señal del sensor es una
entrada y no una salida de la Unidad de Control). En esta etapa
se ha puesto una referencia a los sensores para imprimir el
estado de éstos cada ves que uno de ellos cambia.
La Unidad de Control tiene una referencia a al cabina para informar 
a las personas en su interior del número de piso en que van.
*/
import java.util.ArrayList;

public class ControlUnit {
   private Cabina cabina;
   private ArrayList<Sensor> sensores;
   public ControlUnit(Cabina ca, ArrayList<Sensor> s){
      cabina = ca;
      sensores = s;
   }
   public void activateSensorAction(int currentFloor){
      cabina.setFloorIndicator(currentFloor);
      // imprimir estado de Cabina y sensores
      System.out.print(cabina.readFloorIndicator()+"\t");
      for (int i=0; i<sensores.size(); i++)
         System.out.print(sensores.get(i).isActivated()?"1":"0");
      System.out.println();
   }
   public void deactivateSensorAction(int currentFloor){ 
      // to be completed
   }
}