public class BotoneraPrimerPiso extends Botonera implements UpRequest {
   private Boton up;
   private ControlUnit cu;
   private int floor;
   /*
   public BotoneraPrimerPiso(){
      up = new Boton();
   }
   */
   public BotoneraPrimerPiso(ControlUnit controlUnit, int i) {
	   cu = controlUnit;
	   floor = i;
	   up = new Boton();
   }
   public boolean setRequest(String s_up) {
      boolean result = s_up.equals("U");
      if (result)
         up.turnON();
      this.elevatorRequested();
      return result;         
   }
   public void elevatorRequested(){
    // to be completed
	   cu.elevatorRequested(floor);
	   }

   public boolean isUpRequested() {
      return up.getState();
   }
    public void resetUpRequest()
    {
      up.turnOFF();
    }
}