/*
En los ascensores, los sensores de piso se encuentran en la caja 
del ascensor (es la cabidad del edificio donde el ascensor circula).
Esta clase tiene todos los sesnores de piso.
Considerando la relacióon causal entre cabina y sensores, 
en respuesta al movimiento de la cabina (causa) ésta presiona un sensor.
Para cumplir con esta relación causal, la CajaAscensor ofrece el
servicio (método) de obtener acceso al sensor ubicado en una posición.
Como la Caja del Ascensor no solicita ningún servicio a la cabina,
CajaAscensor no incluye referencias a la Cabina en ella.
Nota: Los sensores generlamente están adosados a un riel guía 
de la cabina, con ese análisis del sistema esta clase pudo llamarse 
RielGuiaCabina, o algo así.
*/
import java.util.ArrayList;

public class CajaAscensor {
   private ArrayList <Sensor> sensores;
   public CajaAscensor (ArrayList<Sensor> ss) {
      sensores = ss;
   }
   public Sensor findSensor(float position) {
    /// to be implemented
   }
}