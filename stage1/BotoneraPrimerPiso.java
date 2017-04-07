public class BotoneraPrimerPiso extends Botonera implements UpRequest {
   private Boton up;
   public BotoneraPrimerPiso(){
      
   }
   public boolean setRequest(String s_up) {
      boolean result = s_up.equals("U");
      if (result)
         up.turnON();
      return result;         
   }

   public boolean isUpRequested() {
      return up.getState();
   }
    public void resetUpRequest()
    {
      up.turnOFF();
    }
}