public class BotoneraUltimoPiso extends Botonera implements DownRequest {
   private Boton down;
   private ControlUnit cu;
   private int floor;
   /*
   public BotoneraUltimoPiso(){
      down = new Boton();
   }
   */
   public BotoneraUltimoPiso(ControlUnit controlUnit, int numPisos) {
	   cu = controlUnit;
	   down = new Boton();
	   floor = numPisos;
}
public boolean setRequest(String s_down) {
      boolean result = s_down.equals("D");
      if (result)
         down.turnON();
      return result;         
   }

   public boolean isDownRequested() {
      return down.getState();
   }
    public void resetDownRequest(){
      down.turnOFF();
    }
}
