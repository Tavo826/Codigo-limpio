'''
La interfaz AbstractFactory declara un conjunto de métodos para crear los productos (Mail y CloudStorage), pero no se sabe a qué familia pertenecen, solo se quiere que mediante esta abstracción, se puedan crear productos (en general), independientemente de si son de una familia u otra.

La firma de los métodos deve devolver la interfaz correspondiente, de esta manera, el código no se acopla a una única implementación y el cliente se aísla de los detalles

Se debe crear una implementación AbstractFactory por cada familia

Ventajas:

* Reduce el acoplamiento
* Aplica el Principio de Responsabilidad Unica
* Aplica el Principio de Abierto a la extensión y cerrado a la modificación
'''

import AbstractFactory_1.*;

public interface AbstractFactory {
    Mail createMail();
    CloudStorage createCloudStorage();
}

public class GoogleFactory implements AbstractFactory {
    @Override
    public Mail createMail() {
        return new GoogleMail();
    }

    @Override
    public CloudStorage createCloudStorage() {
        return new GoogleCloudStorage();
    }
}

public class MicrosoftFactory implements AbstractFactory {
    @Override
    public Mail createMail() {
        return new MicrosoftMail();
    }

    @Override
    public CloudStorage createCloudStorage() {
        return new MicrosoftCloudStorage();
    }
}