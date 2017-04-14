import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//Sensor, Caja asensor, 3botoneras

public class stage3Test {
   public static int currentTime=0;
   public static void main(String[] args) {
        // Elevator's parameters
	   System.out.println("piso\tEstadoM\tsensor\tUpReq\tDownReq");
      int numPisos = 6;
      float floorHight = 3.0f;
      float cabinaSpeed = 1f;   // [m/s]
      
        // Creación compoentes del ascensor
      Botonera[] botoneras = new Botonera[numPisos+1]; // index goes from 0 to numPisos.
      
      Sensor[] sensores = new Sensor[numPisos];  // Since the number of sensors does not
                // change, it is more efficient to use an array. Sorry for that change!
      CajaAscensor shaft = new CajaAscensor(sensores);
      BotoneraCabina bc = new BotoneraCabina(numPisos);  // we do not use it in this stage
      Cabina cabina = new Cabina(bc, shaft);
      Motor motor = new Motor(cabina, cabinaSpeed);
      ControlUnit controlUnit = new ControlUnit(motor, cabina, sensores, botoneras);

      botoneras[1] = new BotoneraPrimerPiso(controlUnit,1);
      for (int i=2; i< numPisos; i++)
         botoneras[i] = new BotoneraPisoIntermedio(controlUnit, i);
      botoneras[numPisos] = new BotoneraUltimoPiso(controlUnit, numPisos);

      for (int i=0; i < sensores.length; i++)
         sensores[i] = new Sensor(i*floorHight,i+1, controlUnit);
      
        // Lectura archivo
      String filename = args[0];
      File file = new File(filename);
      Scanner in=null;
      try{  // estudiaremos try catch en unas clases más
         in = new Scanner(file);
         int eventTime=0, nbotonera=0, piso;
         String accion="";
         while(in.hasNextLine()){
            // read new event
            if (in.hasNextInt())
               eventTime = in.nextInt();
            else break;
            if (in.hasNextInt())
               nbotonera=in.nextInt();
            else break;
            accion = in.nextLine().trim();
            // wait for it to occur.
            Thread.currentThread().sleep((eventTime-currentTime)*1000);
            currentTime = eventTime;
            // execute event
            if (nbotonera != 0)
            {
            	if (!botoneras[nbotonera].setRequest(accion))
            		break;
            }
            else
            	controlUnit.elevatorRequested(Integer.valueOf(accion));
         }
      } catch(FileNotFoundException exception){
         System.out.println("The file " + file.getPath() + " was not found.");
         System.exit(-1);
      } catch (InterruptedException e) {
         System.out.println("Got an interrruption while sleeping...");
      }
      if (in.hasNextLine())  // there was a break while reading the input file 
         System.out.println("Input file format error in: "+in.nextLine());   
    }
}