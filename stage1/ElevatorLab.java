import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ElevatorLab {
   public static void main(String[] args) {
        // Creacion botoneras
      int numPisos = 4;
      Botonera[] botoneras = new Botonera[numPisos+1]; // index goes from 0 to numPisos.
      botoneras[0] = new BotoneraCabina(4);
      botoneras[1] = new BotoneraPrimerPiso();
      for (int i=2; i< numPisos; i++)
         botoneras[i] = new BotoneraPisoIntermedio();
      botoneras[numPisos] = new BotoneraUltimoPiso();
      
        // Lectura archivo
      String filename = args[0];
      File file = new File(filename);
      Scanner in=null;
      try{
         in = new Scanner(file);
         int time=-1, nbotonera=0, piso;
         String accion="";
         System.out.println("tiempo"+"\t"+"cabina"+"\t"+"up"+"\t"+"down");
         System.out.println("----------------------------");
         while(in.hasNextLine()){
            if (time>0)   {  // reset previous request
               if (accion.equals("U"))
                  ((UpRequest) botoneras[nbotonera]).resetUpRequest();
               else if (accion.equals("D"))
                  ((DownRequest) botoneras[nbotonera]).resetDownRequest();
               else ((BotoneraCabina)botoneras[0]).resetFloorRequest(Integer.parseInt(accion));
            }   

            if (in.hasNextInt())
               time = in.nextInt();
            else {System.out.println("break1");break;}
            if (in.hasNextInt())
               nbotonera=in.nextInt();
            else {System.out.println("break2");break;}            
            accion = in.nextLine().trim();
            if (!botoneras[nbotonera].setRequest(accion))
               break;
               
             // show buttons's state   
            System.out.print(time+"\t"+(BotoneraCabina)botoneras[0]+"\t");
            for (int i=1; i < numPisos; i++)
               System.out.print(((UpRequest)botoneras[i]).isUpRequested()?"1":"0");
            System.out.print("0");
            System.out.print("\t");
            System.out.print("0");
            for (int i=2; i <= numPisos; i++)
               System.out.print(((DownRequest)botoneras[i]).isDownRequested()?"1":"0");
            System.out.println();
         }
      } catch(FileNotFoundException exception){
         System.out.println("The file " + file.getPath() + " was not found.");
         System.exit(-1);
      }
      if (in.hasNextLine())  // there was a break while reading the input file 
         System.out.println("Input file format error in: "+in.nextLine());   
    }
}