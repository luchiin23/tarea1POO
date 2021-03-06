import java.lang.Integer;
import java.util.ArrayList;

public class BotoneraCabina extends Botonera{
	//cambiar
   private ArrayList <Boton> botones;
   private int pisos;
   public BotoneraCabina(int n_pisos) {
     pisos=n_pisos;
      botones = new ArrayList <Boton> ();
      for (int i=0; i < n_pisos; i++) 
         botones.add(new Boton());
   }

   public void resetFloorRequest(int i) {
      botones.get(i-1).turnOFF();
   }
   
   public int ssize()
   {
	   return botones.size();
   }
   public String toString() {
      String s="";
      for(Boton b: botones)
         s+=b.toString();
      return s;
   }
   public boolean setRequest(String s, int action)
   {
     for(int i=1;i<=pisos;i++)
       {
         if (Integer.parseInt(s)==i){
           botones.get(i-1).turnON();
           return true;
         }
       }
     return false;
   }
   public boolean isRequested(int floor){
	   return botones.get(floor-1).getState();
   }
}
