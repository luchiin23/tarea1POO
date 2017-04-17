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

public boolean setRequest(String up_down, int action){
      if (up_down.equals("U"))
         up.turnON();
      else if (up_down.equals("D"))
         down.turnON();
      else{
    	  this.elevatorRequested(action);
    	  return false;
      }
         
      //super.elevatorRequested();
      this.elevatorRequested(action);
      return true;
   }
	public void elevatorRequested(int action){
    // to be completed
	   cu.elevatorRequested(floor, action);
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
   
