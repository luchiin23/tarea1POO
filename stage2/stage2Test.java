import java.util.ArrayList;

public class stage2Test {
   public static void main (String [] args){
      // Elevator parameters
      int numPisos = 8;
      float floorHight = 3.0f; // meters

      // create elevator
      ArrayList<Sensor> sensores = new ArrayList<Sensor> ();
      CajaAscensor caja = new CajaAscensor(sensores);
      BotoneraCabina bc = new BotoneraCabina(numPisos);  // we do not use it in this stage
      Cabina cabina = new Cabina(bc, caja);
      ControlUnit controlUnit = new ControlUnit(cabina, sensores);      
      for (int i=0; i < numPisos; i++) {
         sensores.add(new Sensor(i*floorHight,i+1, controlUnit));
      }
      //caja.findSensor(5);
      //return;
      // commands needed to lift and descend the evelator between
      // the first and last floor.
      
      float deltaHight = 0.02f;  // 2 [cm] each time
      while(cabina.readFloorIndicator()< numPisos)
          cabina.move(deltaHight);
      while(cabina.readFloorIndicator()> 1)
         cabina.move(-deltaHight);
      while(cabina.readFloorIndicator()< numPisos)
         cabina.move(deltaHight);
      while(cabina.readFloorIndicator()> 1)
         cabina.move(-deltaHight);
      
   }
}