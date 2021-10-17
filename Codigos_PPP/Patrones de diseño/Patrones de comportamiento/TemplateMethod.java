'''
Se define el esqueleto del algoritmo pero se deja a las subclases parte de la responsabilidad
'''

abstract class AbstractCalss {
    final void templateMethod() {
        step1();
        step2();
        concreteOperation();
        hook();
    }
    abstract void step1();
    abstract void step2();

    final void concreteOperation() {
        // implementation here...
    }

    void hook() {}
}