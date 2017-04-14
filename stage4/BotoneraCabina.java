import java.lang.Integer;
import java.util.ArrayList;

public class BotoneraCabina extends Botonera{
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
   public String toString() {
      String s="";
      for(Boton b: botones)
         s+=b.toString();
      return s;
   }
   public boolean setRequest(String s)
   {
     for(int i=0;i<=pisos;i++)
       {
         if (Integer.parseInt(s)==i){
           botones.get(i-1).turnON();
           return true;
         }
       }
     return false;
   }
}
