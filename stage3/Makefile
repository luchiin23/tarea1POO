JFLAGS = -g
JC = javac
JVM= java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Boton.java \
        Botonera.java \
        BotoneraCabina.java \
        BotoneraPisoIntermedio.java \
        BotoneraPrimerPiso.java \
        BotoneraUltimoPiso.java \
        Cabina.java \
        CajaAscensor.java \
        ControlUnit.java \
        DownRequest.java \
        Motor.java \
        Sensor.java \
        stage3Test.java \
        UpRequest.java

ARGS = inputEvents.txt
# main variable
MAIN = stage3Test

default: classes

classes: $(CLASSES:.java=.class)

# run tarjet
run: 
	$(JVM) $(MAIN) $(ARGS)

clean:
	$(RM) *.class