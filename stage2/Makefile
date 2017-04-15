JFLAGS = -g
JC = javac
JVM= java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = BotoneraCabina.java Cabina.java CajaAscensor.java ControlUnit.java Sensor.java stage2Test.java

ARGS = inputEvents.txt
# main variable
MAIN = stage2Test

default: classes

classes: $(CLASSES:.java=.class)

# run tarjet
run: 
	$(JVM) $(MAIN) $(ARGS)

clean:
	$(RM) *.class
