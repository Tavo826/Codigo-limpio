﻿## Problemas en el diseño de software

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

![Ejemplo SRP](/Images/SRP.png)

### O. Open/closed (OCP)

### L. Liskov substitution (LSP)

### I. Interface segregation (ISP)

### D. Dependency inversion (DIP)

## Don Repeat Yourself (DRY)

## Inversio of Control (IoC)

## You Aren't Gonna Need IT (YAGNI)

## Keep It Simple, Stupid (KISS)

## Law of Demeter (LoD)

## Strive for loosely coupled design between objects that interact

## Composition over inheritance

## Encapsulate what varies

## The four rules of simple design

## The boy scout rule

## Last Responsible Moment


# Design Patterns


## Patrones creacionales

### Builder

### Singleton

### Dependency Injection

### Service Locator

### Abstract Factory

### Factory Method


## Patrones estructurales

### Adapter

### Data Access Object (DAO)

### Query Object

### Decorator

### Bridge


## Patrones de comportamiento

### Command

### Chain of Responsibility

### Strategy

### Template Method

### Interpreter

### Observer

### State

### Visitor

### Iterator