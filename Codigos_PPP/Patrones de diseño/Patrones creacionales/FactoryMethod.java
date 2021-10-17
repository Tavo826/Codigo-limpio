'''
AnimalFactory tiene un método createAnimal (factory method) y cada implemenación se encarga de la creación de sus objetos

Todas las factorías implementan la misma interfaz, por lo que gracias al polimorfismo podemos crear tantas implementaciones como necesitemos o cambiar la implementación de una factoría sin que la clase que la use se vea afectada

Ventajas:

* Reduce el acoplamiento y encapsula el código encargado de crear objetos
* Aplica el Principio de Responsabilidad Unica
* Aplica el Principio Abierto a la extensión y cerrado a la modificación
'''

public interface Animal {}

public class Cat implements Animal {}
public class Cocodrile implements Animal {}
public class Dog implements Animal {}
public class Lion implements Animal {}

public interface AnimalFactory {
    Animal createAnimal();
}

public class WildAnimalFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        // creates only wild animals
    }
}

public class RandomAnimalFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        // creates random animals
    }
}