/**
La causalidad de eventos es la siguiente: el motor hace mover la cabina,
√©sta presiona un sensor, y luego el sensor
reporta este evento a la unidad de control. La unidad de control es
responsable de informar la llegada a un nuevo piso y chequear y atender
posibles solicitudes de ese piso.
En la operaci√≥n de un ascensor, la Unidad de Control no requiere
pedir servicios a un sensor, pues es √©ste quien informa 
a la unidad de control de un cambio (la se√±al del sensor es una
entrada de la Unidad de Control y no una salida). Se ha puesto
una referencia a sensores en la unidad de control
para imprimir el estado de √©stos.
La Unidad de Control tiene una referencia a la cabina para informar 
a las personas en su interior del n√∫mero de piso en que van.
*/

public class ControlUnit {
   private Motor motor;
   private Cabina cabina;
   private Sensor[] sensores;
   private Botonera[] botoneras;
      
   public ControlUnit(Motor m,Cabina ca, Sensor[] s, Botonera[] b){
      motor = m;
      cabina = ca;
      sensores = s;
      botoneras = b;
   }
   public void elevatorRequested(int locationRequest){ ////////////////YO
      if (motor.getState() == Motor.STOPPED) { // start de motor
            // to go to the requested floor
         int cabinaLocation = cabina.readFloorIndicator();
         // to be completed
         
         //Hacer uso del motor para llegar al piso deseado
         //Creo que ac· se debe usar areThereHigherRequests y su par
         //para mientras se va bajando o subiendo verificar si debe seguir ese camino (dado que a˙n faltan peticiones por atender)
         //Esto ocurre porq el timer del motor le permite ejecutarse de forma paralela a las peticiones
         
      }
   }
   private void printElevatorState(){
      System.out.print(cabina.readFloorIndicator()+"\t"+motor.getState()+"\t");
      for (Sensor s: sensores)
         System.out.print(s.isActivated()?"1":"0");
      System.out.print("\t");
      for (int i=1; i < botoneras.length; i++) 
         if (botoneras[i] instanceof UpRequest) {
            UpRequest boton = (UpRequest) botoneras[i];
            System.out.print(boton.isUpRequested()?"1":"0");
         }   
      System.out.print("-\t-");
      for (int i=1; i < botoneras.length; i++) 
         if (botoneras[i] instanceof DownRequest) {
            DownRequest boton = (DownRequest) botoneras[i];
            System.out.print(boton.isDownRequested()?"1":"0");
         }   
      System.out.println();   
   }
   
   private void checkAndAttendUpRequest(int floor) {
      if (botoneras[floor] instanceof UpRequest){
         UpRequest boton = (UpRequest) botoneras[floor];
         if (boton.isUpRequested()) {
            boton.resetUpRequest();
            printElevatorState();
            motor.pause();
         }            
      }
   }
   
   private void checkAndAttendDownRequest(int floor) {
	   if (botoneras[floor] instanceof DownRequest)
	   {
		   DownRequest boton = (DownRequest) botoneras[floor];
	         if (boton.isDownRequested()) {
	            boton.resetDownRequest();
	            printElevatorState();
	            motor.pause();
	         }
	   }
   }
   public void activateSensorAction(int currentFloor){
      cabina.setFloorIndicator(currentFloor);
      // to be completed  
      
      //Actualiza el estado del botÛn asociado al piso (dado que el ascensor llegÛ al piso)
      //Desde abajo
      checkAndAttendUpRequest(currentFloor);
      //Desde arriba
      checkAndAttendDownRequest(currentFloor);
      
      
   }
   private boolean areThereHigherRequests(int currentFloor) {
      for (int i=currentFloor+1; i < botoneras.length; i++) {
         if(botoneras[i] instanceof UpRequest){
            UpRequest boton = (UpRequest) botoneras[i];
            if (boton.isUpRequested()) 
               return true;
         }
         if(botoneras[i] instanceof DownRequest){
            DownRequest boton = (DownRequest) botoneras[i];
            if (boton.isDownRequested()) 
               return true;
         }
      }
      return false;
   }
   
   private boolean areThereLowerRequests(int currentFloor) {
	      for (int i=1; i < currentFloor; i++)
	      {
	    	  if(botoneras[i] instanceof DownRequest)
	    	  {
	    		  DownRequest boton = (DownRequest) botoneras [i];
	    		  if (boton.isDownRequested())
	    			  return true;
	    	  }
	    	  if(botoneras[i] instanceof UpRequest)
	    	  {
	              UpRequest boton = (UpRequest) botoneras[i];
	              if (boton.isUpRequested()) 
	                 return true;
	          }
	      }
		return false;
	   }
}