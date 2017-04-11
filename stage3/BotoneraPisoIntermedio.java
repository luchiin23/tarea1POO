public class BotoneraPisoIntermedio extends Botonera implements DownRequest, UpRequest {
   private Boton up, down;
   private ControlUnit cu;
   private int floor;
   /*
   public BotoneraPisoIntermedio() {
	   up = new Boton();
	   down = new Boton();
   }
   */
   public BotoneraPisoIntermedio(ControlUnit controlUnit, int i) {
	   cu = controlUnit;
	   floor = i;
	   up = new Boton();
	   down = new Boton();
}

public boolean setRequest(String up_down){
      if (up_down.equals("U"))
         up.turnON();
      else if (up_down.equals("D"))
         down.turnON();
      else{
    	  this.elevatorRequested();
    	  return false;
      }
         
      this.elevatorRequested();
      return true;
   }
   // UpRequest interface implementation
    public void resetUpRequest()
    {
      up.turnOFF();
    }
    public boolean isUpRequested()
    {
    	return up.getState();
    }

   // DownResquest interface implementation
    public void resetDownRequest()
    {
      down.turnOFF();
    }
    public boolean isDownRequested()
    {
    	return down.getState();
    }
}
   
