JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES =  Category.java Customer.java FileHandler.java Product.java ProductService.java Trader.java UserService.java Driver.java

default: classes

classes: $(CLASSES:.java=.class)
	java Driver

clean:
	$(RM) *.class
