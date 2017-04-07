public class Boton {
//oliwis
   private boolean state;
   
   public Boton () {
      state = false;   // OFF
   }   
   public void turnON(){
      state = true;    // ON
   }
   public void turnOFF(){
      state = false;
   }
   public boolean getState(){
      return state;
   }
   public String toString() {
      return state?"1":"0";
   } 
}
