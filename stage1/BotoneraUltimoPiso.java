public class BotoneraUltimoPiso extends Botonera implements DownRequest {
   private Boton down;
   public BotoneraUltimoPiso(){
      down = new Boton();
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
