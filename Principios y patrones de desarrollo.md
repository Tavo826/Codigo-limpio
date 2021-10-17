## Problemas en el diseño de software

* **Rigidez:** difícil de cambiar hasta en tareas sencillas

    **Consecuencias:**

    * Las estimaciones son más abultadas

    * Añadir funcionalidades nuevas cuesta mucho cuando antes era más rápido

* **Fragilidad:** rompimiento en múltiples sitios cada vez que se hace un cambio

    **Consecuencias:**

    * Subir una nueva versión y que se rompan partes que aparentemente no tienen que ver con lo modificado

    * Aparición de mayor cantidad de bugs, aumentando el coste de esfuerzo y tiempo en corregirlos

* **Inmovilidad:** es imposible reutilizar software de otros proyectos o incluso de otras partes del mismo

    **Consecuencias:**

    * Aumenta la complejidad del diseño y del código al introducir código duplicado

    * Complica el entendimiento del código y genera equivocaciones

* **Viscosidad:** el ecosistema de desarrollo es lento e ineficiente. Resulta más fácil realizar la solución mala y rápida

    **Consecuencias:**

    * Provoca el efecto bola de nieve: cuanto más tarde se corrija esa deuda técnica más difícil y costoso será resolverlo

    * Pérdida de tiempo, estrés, confusión, pasotismo, acciones inseguras, etc.

* **Complejidad innecesaria**

* **Opacidad**


# Principios Generales


## Principios S.O.L.I.D.

5 principios de diseño destinados a hacer que los diseños de software sean más comprensibles, flexibles y mantenibles

**Ventajas:**

* Facilitar el mantenimiento del código

* Reducir la complejidad de añadir nuevas funcionalidades

* Aumentar la reusabilidad de piezas y componentes

* Mejorar la calidad del código y su comprensión


### S. Single responsibility (SRP)

Un módulo de software debe tener una y solo una razón para cambiar. Su objetivo es limitar el impacto de un cambio

"Reúna las cosas que cambian por las mismas razones. Separe las cosas que cambian por diferentes razones"

**Ejemplo:**

La clase Employee tiene dos responsabilidades, la propia de un empleado que es trabajar y la de persistir su estado. Se pueden separar ambas responsabilidades en dos clases

![Ejemplo SRP](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/SRP.png)


### O. Open/closed (OCP)

Los módulos de software deben ser abiertos para su etensión pero cerrados para su modificación

**Abierto para su extensión:** A medida que cambian los requisitos de la aplicación, podemos ampliar el módulo con nuevos comportamientos que satisfagan esos cambios

**Cerrado por modificación:** al extenderse un módulo, su código original no debería verse afectado y tener que modificarse

La forma de implementar este principio en el mundo práctico, es a través del polimorfismo, ya sea por interfaces o clases abstractas

**Ejemplo:**

En una oficina se encuentra una cafetera utilizada por varias personas. Un día, alguien pidió que el café se pudiera preparar distinto. Esta solicitud implicaba un cambio en la configuración y el comportamiento de la cafetera

![Ejemplo OCP_1](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/OCP_1.png)

En vez de cambiar el comportamiento de la cafetera actual para intentar satisfacer a dos clientes distintos. Se cierra la clase CafeteraSencilla ante cualquier modificación, pero se crea una interfaz para abrirla a extensiones

![Ejemplo OCP_2](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/OCP_2.png)

Se logra cumplir con el nuevo requisito sin tener que arriesgar los anteriores. Lo mejor es que ahora se ofrecen 2 posibilidades en caso de que alguna persona cambie de opinión


### L. Liskov substitution (LSP)

"Si se ve como un pato, hace cuac como un pato, pero necesita baterías, probablemente tengas la abstracción incorrecta"

Los objetos de un programa deberían ser reemplazables por instancias de sus subtipos sin alterar el correcto funcionamiento del programa

Si en alguna parte del código se usa una clase, y esta es extendida, se debe poder utilizar cualquiera de las clases hijas y que el programa siga siendo válido

Los objetos de las subclases se deben comportar de igual forma que los de la superclase

**Diseño por contrato:** Cuando se llame a un método de la subclase, estos deben cumplir con una serie de precondiciones y postcondiciones

* Las precondiciones no pueden ser más restrictivas en un subtipo

* Las postcondiciones no pueden ser menos restrictivas en un subtipo

* Las invariantes establecidas por el supertipo deben ser mantenidas por los subtipos


### I. Interface segregation (ISP)

Muchas interfaces cliente específicas son mejores que una interfaz de propósito general

Cuando un cliente depende de una clase que implementa una interfaz, cuya funcionalidad este cliente no usa pero que otros clientes si, este cliente estará siendo afectado por los cambios que fuercen otros clientes en la clase en cuestión

Siempre será preferible muchas interfaces pequeñas a una gran interfaz con pocos métodos

**Ejemplo:**

Un atún se ve forzado a tener un método volar, se pueden separar ambas habilidades en distintas interfaces. Una para voladores y otra para nadadores

![Ejemplo ISP](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/ISP.png)

### D. Dependency inversion (DIP)

Las entidades de software deben depender de abstracciones, no de implementaciones. Además los módulos de alto nivel no deberían depender de los de bajo nivel. Ambos deberían depender de abstracciones

Gracias a la flexibilidad se pueden sustituir componentes sin que los clientes que los consumen se vean afectados ya que dependen de la abstracción y no de la implementación concreta

Es fundamental que la abstracción se defina en base a las necesidades del módulo y no en las capacidades de la implementación.

![Método DIP](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/DIP_method.png)

**Ejemplo:**

Normalmente las capas de alto nivel consumen las de bajo nivel, generando un fuerte acoplamiento. Para evitar esto, se introduce una cpa de abstracción que permite reutilizar las capas de mayor nivel

![Ejemplo DIP](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/DIP.png)


## Don Repeat Yourself (DRY)

El objetivo principal es evitar la duplicación de la lógica, cada pieza de funcionalidad debe tener una identidad única, no ambigua y representativa dentro del sistema

Este principio permite que los cambios en cualquier parte del proceso requieran cambios en un único lugar

* Hace el código más mantenible

* Reduce el tamaño del código

* Ahorra tiempo

**Ejemplo:**

Tener 3 métodos para abrir una conexión a una base de datos. Cada uno tiene su propio código, pero la función final es conectarse a la base de datos

Si más adelante cambia la manera de conectarse a la base de datos, el tipo de base de datos o enviar datos a otros sistemas de almacenamiento. Se deben modificar los 3 métodos

## Inversio of Control (IoC) (Don't call us, we call you - Hollywood Principle)

Utiliza el diseño orientado a objetos para delegar en un tercero (framework o contenedor) diferentes tipos de flujos de control para lograr un bajo acoplamiento

Ayuda a aumentar la modularidad de un programa y al diseño de clases con bajo acoplamiento, lo que las hace testeables, mantenibles y extensibles

**Patrones de diseño implementados en este principio:**

* Service locator

* Dependency injection

* Template method

* Strategy

* Abstract Factory

* Observer

Las formas más conocidas de este principio son:

* Localizador de servicios (Service Locator): las dependencias aún se solicitan explícitamente desde la clase dependiente

* Inyección de dependencias: un agente externo se encarga de proveer las dependencias, sin mediar acoplamiento entre la dependencia y su proveedor

![Método IoC](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/IoC.png)


## You Aren't Gonna Need IT (YAGNI)

No se deben agregar funciones extras hasta que no sea necesario


## Keep It Simple, Stupid (KISS)

Necesidad de minimizar los errores tratando de realizar las tareas de forma efectiva y eficiente complicándose lo menos posible. Se debe evitar la complejidad innecesaria

## Law of Demeter (LoD) (Principle of least knowledge - Don't talk to stransgers')

Un método de un objeto sólo debería interactuar con:

1. Métodos del propio objeto

2. Los argumentos que reciben

3. Cualquier objeto creado dentro del método

4. Cualquier propiedad / campo directo dentro del propio objeto

Un objeto no tiene porqué conocer la estructura interna de los objetos con los que colabora


## Strive for loosely coupled design between objects that interact

![SFLCDBOTI](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/SFLCDBOTI.png)

Tiene como objetivo reducir el riesgo de que un cambio en los objetos con los que interaccionamos provoque cambios en otros objetos

La arquitectura con bajo acoplamiento tiene como características:

* Reduce el riesgo de que un cambio en un elemento pueda provocar cambios en otros elementos

* Simplifica las pruebas, el mantenimiento y la resolución de problemas

* Los componentes en un sistema débilmente acoplado pueden reemplazarse con implementaciones alternativas que brinden los mismo servicios


## Composition over inheritance (Composive reuse principle)

![COI](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/COI.png)

Establece que las clases deben lograr un comportamiento polimórfico y la reutilización del código mediante la composición (al tener instancias de otras clases que implementan la funcionalidad deseada), en lugar de a través de la herencia de una clase base o primaria, siempre que sea posible

Con la herencia se estructuran las clases alrededor de lo que son, con composición, se estructuran las clases basándose en lo que hacen

El diseño inicial se simplifica identificando los comportamientos de los objetos del sistema en interfaces separadas, en lugar de crear una relación jerárquica para distribuir los comportamientos entre las clases a través de la herencia

Como desventaja, los diseños basados en un enfoque por composición son menos intuitivos


## Encapsulate what varies

Cuando se identifiquen partes de la aplicación que pueden cambiar, se deben aislar y encapsular en abstracciones que permitan realizar el cambio sin afectar a otras partes de la aplicación, este principio de apoya en los principios de Single responsability (SRP) y Open/closed (OCP)

Beneficios:

* Las variaciones en los requisitos de la responsabilidad acotada en un módulo, influyen únicamente en dicho módulo, reduciendo la fragilidad del sistema y aumentando su reusabilidad

* La solicitud de nuevos requisitos o nuevos comportamientos se obtiene mediante la incorporación de nuevos elementos en lugar de la modificación de los elementos ya existentes

Patrones de diseño que se basan en este principio:

* Abstract Factory

* Factory Methid

* Adapter

* Bridge

* Decorator

* Iterator

* Observer

* State

* Strategy

* Template Method

* Visitor


## The four rules of simple design

1. **Los test pasan:** El objetivo principal es que cada tarea funcione de la manera esperada y que haya un/unos tests que verifican que estos criterios se cumplen

2. **Expresan intención:** El código es autoexplicativo, fácil de entender y facilita la comunicación del propósito del mismo

3. **No hay duplicidades (DRY):** Si no se reduce, se diseña un software frágil y cualquier cambio puede romper otras partes

4. **Mínimo número de elementos:** Se debe reducir el número de componentes, clases métodos, etc. Eliminando todas aquellas cosas que incrementen la complejidad del sistema de manera innecesaria

### Ideas sobre estas cuatro reglas

* No hay unanimidad en el orden de los puntos 2 y 3, originando una idea generalizada de que ambos deberían estar en el mismo nivel de importancia

* El primer punto podría no ser considerado siquiera como un punto del diseño simple, sino como algo esencial y connatural al desarrollo de software. No debería plantearse la posibilidad de un código sin tests

* El último punto es considerado para muchos como una consecuencia de la continua aplicación de los puntos 2 y 3


## The boy scout rule

Si se ve alguna parte del código que se pueda mejorar, independientemente de quién lo haya hecho, se debe hacer

El objetivo es mejorar la calidad del código y evitar su deterioro con el fin de ayudar a cambiar o desarrollar una nueva funcionalidad de una forma más sencilla

La idea es hacerlo de manera acotada y segura, no es cuestión de cambiar un módulo entero, sino poco a poco, ir mejorando su calidad


## Last Responsible Moment

Propone como estrategia para abordar nuestros diseños, diferir nuestras decisiones, especialmente aquellas que se puedan considerar irreversibles, hasta el último momento posible. Este momento sería aquel en el que no tomar la decisión, supone un coste mayor que tomarla


# Design Patterns

Ofrecen soluciones comunes a problemas recurrentes de diseño de aplicaciones. Están dirigidos a resolver los problemas asociados con la creación e interacción de objetos, en lugar de problemas a gran escala que afrontan las arquitecturas generales del software

Su uso innecesario o excesivo puede suponer también una sobre ingeniería, dando como resultado un sistema excesivamente complejo que lejos de resolver los problemas, los aumenta, dando lugar a un diseño ineficiente, bajo rendimiento y problemas de mantenimiento

Se clasifican originalmente en tres grupos:

* **Creacionales:** Se utilizan para la instanciación de objetos, encapsulan la lógica de creación y aíslan al cliente de esta responsabilidad. Se intenta evitar el uso del operador *new* entre clases para reducir el acoplamiento

* **Estructurales:** Se utilizan par resolver problemas de composición de clases y objetos. Intentan que los cambios en los requisitos de la aplicación no ocasionen cambios en las relaciones entre los objetos. Normalmente estas relaciones están determinadas por las interfaces que soportan los objetos

* **De comportamiento:** Se utilizan para definir la interacción entre distintos objetos. La interacción debe ser de tal manera que puedan comunicarse fácilmente entre sí, minimizando el grado de acoplamiento


## Patrones creacionales

### Builder

Pretende separar la lógica de construcción de su representación. Se define una clase abstracta *Builder*, que es la encargada de crear las instancias de los objetos. Se utiliza en situaciones en las que el objeto tiene una gran cantidad de atributos en el constructor por lo que la construcción se realiza en un conjunto de pasos

Intervienen estos elementos:

* Builder: interfaz abstracta que crea los productos

* Builder concreto: implementación concreta del builder que crea productos de un cierto tipo

* Director: el encargado de utilizar la clase builder para crear los objetos

Se suele usar este patrón para construir objetos inmutables por lo que la clase del objeto original no debe tener setters

![Builder](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Builder.png)


### Singleton

Consiste en utilizar una sola instancia de clase, definiendo así un único punto global de acceso a ella. Dicha instancia es la encargada de la inicialización, creación y acceso a las propiedades de la clase

Este patrón es muy utilizado cuando se quiere controlar el acceso a un único recurso físico (fichero de lectura de uso exclusivo), o haya datos que deban estar disponibles para el resto de objetos de la aplicación (instancia de log por ejemplo)

Se define un método de acceso para recuperar la instancia de la clase. Este método también se encargará de crear la instancia en el caso de que se solicite por primera vez. Esto impide que otras clases creen nuevas instancias del Singleton

Este patrón se comporta como un objeto global donde cualquier parte de la aplicación la puede utilizar


### Dependency Injection

Se encarga de extraer la responsabilidad de la creación de instancias de un componente para delegarla en otro

Permite que un objeto reciba otros objetos de los que depende, en lugar de ser el propio objeto el que los cree. Estos otros objetos se llaman dependencias

El objeto receptor se llama cliente y el objeto pasado se llama servicio (objeto inyectado)

En lugar de que el cliente especifique qué servicio usará, el inyector le dice al cliente qué servicio usar

![Dependendy Injection](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Injection.png)


### Service Locator

Se utiliza para encapsular los procesos involucrados en la obtención de un servicio con una capa de abstracción fuerte. Utiliza un registro central (*Service Locator*) que, a demanda, devuelve el componente necesario para realizar una determinada tarea

Se basa en la creación de una clase llamada ServiceLocator, que sabe cómo crear las dependencias de otros tipos

La principal diferencia frente a la inyección de dependencias es que en este caso hay una solicitud explícita para obtener la dependencia mientras que en la inyección de dependencias la obtención viene ya dada

*Implementación del principio de inversión de control (IoC)*

![Service Locator](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/ServiceLocator.png)


### Abstract Factory

Su objetivo es proporcionar una interfaz para crear familias de objetos relacionados, sin especificar clases concretas

El cliente no sabe (ni le importa) qué objetos concretos obtiene de cada una de estas fábricas internas, ya que utiliza solo las interfaces genéricas de sus productos

Su estructura típica es la siguiente:

* **Cliente:** la clase que llamará a la factoría adecuada ya que necesita crear uno de los objetos que provee la factoría

* **Abstract Factory:** es la definición de las interfaces de las factorías. Debe de proveer un método para la obtención de cada objeto que pueda crear

* **Factorías Concretas:** son las diferentes familias de productos. Provee la instancia concreta del tipo de objeto que se encarga de crear

* **Producto abstracto:** definición de las interfaces para la familia de productos genéricos

* **Producto concreto:** implementación de los diferentes productos

Este patrón evita el uso de sentencias condicionales como *if* o *switch*

*Implementación del principio de inversión de control (IoC)*

![Abstract Factory](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/AbstractFactory.png)


### Factory Method

Provee una interfaz o clase abstracta (creator) que permite encapsular la lógica de creación de los objetos en subclases y éstas deciden qué clase instanciar. Los objetos se crean a partir de un método (factoy method) y no a través de un constructor como se hace normalmente.

Los ConcreteCreators devuelven siempre la interfaz (Product), esto permite que el cliente trate a los productos por igual

Su estructura es la siguiente:

* Product: definición de las interfaces para la familia de productos genéricos

* ConcreteProduct: implementación de los diferentes productos

* Creator: declara el factory method que se encargará de instanciar nuevos objetos. Es importante que este método devuelva la interfaz Product. Normalmente el Creator suele ser una clase abstracta con cierta lógica de negocio relacionada con los productos a crear. Dependiendo de la instancia de producto que se devuelva se puede seguir un flujo u otro

* ConcreteCreator: crea la instancia del producto concreto

Se crea una implementación o subclase por cada producto

**Ejemplo:**

Se tienen como productos distintos tipos de animales. Todos ellos implementan la interfaz Animal para que siempre se dependa de una abstracción y nunca de una concreción

![Factory Method](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/FactoryMethod.png)


## Patrones estructurales


### Adapter (Wrapper)

Proporciona una interfaz unificada a un conjunto de interfaces en un subsistema. Permite que las clases puedan trabajar juntas ya que de otro modo, no podrían debido a tener interfaces incompatibles

**Tipos principales:**

* Adapatadores de clase: generalmente usan herencia múltiple o varias interfaces para implementarlo

* Adapatadores de onjetps: realizan las composiciones de objetos para adaptarlos

Conviene usarlo cuando:

* un componente tercero ya proporciona una funcionalidad que se puede integrar en nuestro sistema pero es incompatible

* La aplicación no es compatible con la interfaz que espera consumir el cliente

* Existe código legacy que se quiere utilizar en la aplicación sin tener que hacer ningún cambio sobre él

![Adapter](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Adapter.png)


### Data Access Object (DAO)

Se usa para abstraer y encapsular todo el acceso a la fuente de datos. DAO gestion al conexión con la fuente de datos para obtener y almacenar datos. Desacoplando la capa de negocio de la fuente de datos

En lugar de protegerse contra el impacto de un cambio improbable en el tipo de fuente de datos, el valor está en su capacidad de prueba y su uso para estructurar el código y mantenerlo limpio de código de acceso a datos

Su implementación concreta utiliza una API de bajo nivel para realizar las operaciones de acceso de datos

![DAO](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/DAO.png)


### Query Object

Es una estructura de objetos que puede formar una consulta SQL. Se puede crear esta consulta haciendo referencia a clases y campos en lugar de tablas y columnas

![Query](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Quesry.png)


### Decorator

Asigna responsabilidades adicionales a un objeto dinámicamente, proporcionando una alternativa fleible a la herencia para extender la funcionalidad

Estructura:

* Component: define la interfaz que debn implementar los objetos a los que se les pueden añadir funcionalidades

* ConcreteComponent: define un objeto al cual se le pueden agregar responsabilidades adicionales, implementa la interfaz Component

* Decorator: mantiene una referencia al Component asociado. Implementa la interfaz de la superclase Component, delegando en el Component asociado. El Decorator, en general, añade comportamiento antes o después de un método que ya existe en el Component

* ConcreteDecorator: añade responsabilidades al Component

Ventajas:

* Es más flexible que la herencia

* Permite añadir y eliminar responsabilidades en tiempo de ejecución

* Evita la herencia con muchas clases y la herencia múltiple

* Limita la responsabilidad de los componentes para evitar clases con excesivas responsabilidades en los niveles superiores de la jerarquía

![Decorator](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Decorator.png)


### Bridge

Desacopla la abstracción de la implemetnación. Permite que la abstracción y la implementación se desarrollen de forma independiente a través de un puente entre ambas

Participantes:

* Abstraction: recibe por parámetro la interfaz que servirá de puente con las implementaciones y es la que se comunicará con el cliente

* ConcreteAbstraction: puede trabajar con distintas implementaciones a través de la interfaz

* Implementator: declara una interfaz con sus respectivos métodos que serán los que actúen de enlace entre la abstracción y las implementaciones

Ventajas:

* El cliente siempre trabaja con abstracciones y nunca con implementaciones

* Cumple con el principio Open/Closed ya que se pueden añadir nuevas implementaciones independientes unas de otras

* Permite reducir el número de subclases que si se usara herencia pura

Permite hacer cambios a la abstracción, sin estar rompiendo las implementaciones continuamente

Se utiliza cuando:

* Se quiere que una abstracción y su implementación se definan y extiendande forma independiente

* Se quiere desacoplar la abstracción y su implementación para poder cambiarla en su ejecución

![Bridge](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Bridge.png)


## Patrones de comportamiento


### Command

Encapsula una solicitud como un objeto, permitiendo definir una interfaz para invocar acciones diversas

El onjetivo de un comando es ejecutar una serie de acciones en su receptor (Receiver). El cliente crea un objeto Command y generalmente, le pasa el Receiver para poder acceder a él. Cuando el Client desea ejecutar el Command, se utiliza el Invoker que almacena el Command y se encarga de iniciar su ejecución en algún momento, invocando al método execute del Command

![Command](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Command.png)

* Command: objeto que contiene toda la información necesaria para realizar una acción específica

* Receiver: objeto que realiza las operaciones cuando se ejecuta el comando

* Invoker: objeto encargado de ejecutar la acción, pero desconoce la implementación del comando. Únicamente recibe la interfaz y llama al método *execute*, aunque también se encarga de gestionar una cola de comandos o de realizar la acción de revertir

* Client: objeto que controla el proceso de ejecución de los comandos. Instancia los comandos deseados y se los pasa al invoker


### Chain of Responsibility

Evita acoplar el remitente de una solicitud a su receptor, al darle a más de un objeto la oportunidad de manejar la solicitud. Se encadenan los objetos receptores y pasa la solicitud a lo largo de la cadena hasta que un receptor lo maneja

Este tipo de patrón establece una jerarquía entre los receptores, pues los primeros en la cadena tienen prioridad sobre los siguientes, se pueden agregar nuevos receptores en cualquier momento al final de una cadena

![Chain Responsability](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Chain.png)

**Ejemplo:**

Se quiere determinar el medio de transporte para enviar un paquete dentro de una ciudad. Si un medio de transporte no está disponible, se consulta al siguiente:

Coche -> motocicleta -> Bicicleta -> A pie

Cada eslabón de la cadena sabrá si su medio de transporte se encuentra disponible. El mensajero usará el medio de transporte del primer eslabón que acepte la responsabilidad

![Example Chain Responsability](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/ChainExample.png)


### Strategy

Define una familia de algoritmos que se encapsulan cada uno de forma que sean intercambiables. El patrón estrategia permite que el algoritmo varíe independientemente de un cliente a otro

La clave es diseñar interfaces para la estrategia y su contexto, que sean lo suficientemente generales como para admitir una variedad de algoritmos. No debería tener que cambiar la estrategia o la interfaz de contexto para admitir un nuevo algoritmo

Los comportamientos de una clase no deben heredarse, deben encapuslarse utilizando interfaces

![Strategy](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Strategy.png)


### Template Method

Define el esqueleto de un algoritmo en una operación, delegando algunos pasos a subclases. Permite que las subclases redefinan ciertos pasos de un algoritmo sin cambiar la estructura del algoritmo

A través de la herencia, el método de plantilla en la clase base comienza a ejecutarse delegando parte de los detalles de la implementación en las clases hijas. Este mecanismo garantiza que el algoritmo general siga los mismo pasos cada vez, al tiempo que permite que los detalles de algunos pasos dependan de qué instancia recibió la solicitud original para ejecutar el algoritmo

![Template Method](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Template.png)

Con esto el código está en un solo sitio y además, está protegido dentro de la clase. Añadir nuevas implementaciones del algoritmo solo requiere implementar las operaciones del algoritmo. Pueden haber métodos que no hagan nada, pero que una subclase pueda darles una implementación, se los llama *hooks*


### Interpreter

Dado un lenguaje, define una representación de su gramática junto con un intérprete que usa dicha representación para interpretar sentencias del lenguaje

Generalmente debe usarse cuando la gramática es relativamente simple

![Interpreter](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Interpreter.png)

Ventajas e inconvenientes:

* Facilidad de cambiar y ampliar: puesto que el patrón usa clases para representar las reglas de la gramática, se puede usar la herencia para cambiarla o extenderla

* Fácil implementación:  las clases que definen los nodos del árbol sintáctico abstracto tienen implementaciones similares

* Las gramáticas complejas son difíciles de mantener que define una clase para cada regla de la gramática


### Observer

Define una dependencia entre objetos de forma que cuando un objeto cambia su estado, todos los objetos que depende de él son notificados y pueden reaccionar si lo desean a una acción

El Subject provee de métodos para que cualquier objeto Observer pueda suscribirse o cancelar la suscripción, pasando una referencia de sí mismo al Observable o Subject. El Subject mantiene una lista con las referencias a sus Observers para notificarles cada cambio de estado

Los Observers están obligados a implementar los métodos que utiliza el Subject para notificar a sus Observers de los cambios que sufren

Se aplica cuando:

* Una abstracción tiene dos puntos de vista dependientes uno del otro. Encapsular estos puntos de vista en objetos separados permite cambiarlos y reutilizarlos

* Un cambio en un objeto requiere cambiar otros y no sabemos cuántos objetos van a cambiar

* Un objeto debería poder notificar a otros sin saber quiénes son

Ventajas:

* Se puede modificar el Subject y los Observers de forma independiente al estar desacoplados

* Permite reutilizar tanto Observers como Subjects

* Respeta el principio Open/Closed, permitiendo añadir Observers sin modificar Subjects

* Reduce el acoplamiento entre Subjects y Observer, ya que un Subject sólo reconoce su lista de Observers a través de una interfaz pero no la clase concreta

* El Subject se comunica con los Observers mediante broadcast o difusión

![Observer](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Observer.png)


### State

Permite que un objeto modifique su comportamiento cada vez que cambie su estado interno. Parecerá que cambia la clase del objeto

Se usa para encapsular todo el comportamiento variables de un objeto en función de su estado interno

![State](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/State.png)

Participantes

* Context:

    * Define la interfaz que será usada por los clientes

    * Mantiene una instancia que representa el estado actual del objeto

* State: define una interfaz para encapsular el comportamiento asociado con un determinado estado del Context

* Subclases de State: cada subclase implementa un comportamiento asociado a los diferetnes estados del Context

Ventajas:

* Separa el comportamiento del objeto por estados. Al convertir estos en clases separadas, nos permite fácilmente añadir nuevos estados y definir las transiciones hacia ellos

* Hace explícitas las transacciones entre estados. Podemos evitar las transiciones a estados internos inconsistentes, ya que las transiciones son atómicas para el Context

* Los objetos State pueden compartirse por diferentes contextos. Siempre que estos no tengan estado interno, comportándose como objetos del patrón Flyweight (sin estado intrínseco y con comportamiento)

![State](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/StateMethod.png)


### Visitor

Permite añadir funcionalidad sin necesidad de cambiar las clases de los elementos en los que va a ejecutarse, a través de los Visitors. Sugiere situar el comportamiento en una nueva clase llamada Visitor, en vez de integrarlo todo en la clase base

Participantes:

* Visitor: interfaz que declara una series de métodos, normalmente llamado visit y que reciben como parámetro elementos concretos a los que se les va a añadir funcionalidad

* ConcreteVisitor: implementan la interfaz Visitor y definen las funcionalidades que se aplicarán a los elementos o clase base. Aquí se define el comportamiento que debe tener la clase base

* Element: interfaz que declara un método que acepta los Visitors

* ConcreteElement: clase base que implementa la interfaz Element y tienen como objetivo redirigir al Visitor concreto que se encargará de añadir el comportamiento específico

Es útil cuando:

* Se necesita añadir nuevas operaciones frecuentemente

* Se tiene un mismo algoritmo y se requiere que funcione en distintas jerarquías de clases y se encuentre en un solo lugar

* La estructura de objetos cliente no se espera que cambie o no es nuestra

![Visitor](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Visitor.png)


### Iterator

Provee una forma de acceder secuencialmente a los elementos de una colección sin necesidad de exponer su representación interna, se extrae el comportamiento en un objeto llamada Iterator que se encarga de tener toda la información necesaria para manipularla

Participantes:

* Client: interactúa tanto con Iterator como Iterable a través de sus interfaces para no acoplarse a clases concretas

* Iterable: declara un método responsable de instanciar el objeto Iterator. Importante que el método devuelva la interfaz para no acoplarse a implementaciones

* ConcreteIterable: implementa la interfaz e instancia el Iterator concreto que iterará sobre una colección específica

* Iterator: declara los métodos necesarios para recorer la colección. Puede declarar varios métodos como remove, getFirst, currentItem, size, next, etc.

* ConcreteIterator: implementa los métodos declarados en la interfaz y es responsable de gestionar la posición de la iteración

![Iterator](https://github.com/Tavo826/Codigo-limpio/blob/master/Images_PPP/Iterator.png)


