JFLAGS = -g
JC = javac
JVM= java
.SUFFIXES: .java .class .txt
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Boton.java \
        Botonera.java \
        BotoneraCabina.java \
        BotoneraPisoIntermedio.java \
        BotoneraPrimerPiso.java \
        BotoneraUltimoPiso.java \
        DownRequest.java \
        ElevatorLab.java \
        UpRequest.java

ARGS = inputEvents.txt
# main variable
MAIN = ElevatorLab

default: classes

classes: $(CLASSES:.java=.class)

# run tarjet
run: 
	$(JVM) $(MAIN) $(ARGS)

clean:
	$(RM) *.class
