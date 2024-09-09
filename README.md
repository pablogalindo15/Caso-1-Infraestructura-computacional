Caso 1: Manejo de la Concurrencia - Arquitectura de Productores y Consumidores
===========================================================================

Este repositorio contiene la implementación de una arquitectura de productores y consumidores para una fábrica simulada, desarrollada como parte del curso ISIS 2203 Infraestructura Computacional en la Universidad de los Andes, Colombia. El proyecto se centra en el aprendizaje y aplicación práctica de conceptos de concurrencia y sincronización en Java.

Descripción del Proyecto
------------------------

El proyecto simula una fábrica con las siguientes características:

- Productores que generan dos tipos de productos: "A" y "B"
- Distribuidores que manejan la distribución de estos productos
- Un sistema de almacenamiento que incluye un depósito de producción, una cinta transportadora y un depósito de distribución
- Operarios internos que mueven los productos entre los diferentes componentes del sistema

Este sistema se utiliza como un escenario para abordar y resolver problemas clásicos de concurrencia, incluyendo:

- Exclusión mutua: Garantizar el acceso seguro a recursos compartidos como los depósitos
- Señalamiento: Coordinar la comunicación entre productores, consumidores y operarios internos
- Barreras: Sincronizar el inicio y finalización de las operaciones de los diferentes threads

Objetivos de Aprendizaje
------------------------

- Comprender y aplicar conceptos fundamentales de concurrencia
- Implementar soluciones a problemas de sincronización usando Java
- Desarrollar habilidades en el manejo de threads y mecanismos de sincronización en Java
- Analizar y resolver situaciones de interbloqueo (deadlock) y condiciones de carrera

Estructura del Sistema
----------------------

- 4 operarios productores (2 tipo "A", 2 tipo "B")
- 4 operarios distribuidores (2 tipo "A", 2 tipo "B")
- 2 operarios internos
- 1 depósito de producción
- 1 cinta transportadora
- 1 depósito de distribución

Implementación
--------------

- Lenguaje: Java
- Uso de threads para simular los operarios
- Sincronización mediante funcionalidades básicas de Java:
  - synchronized
  - wait
  - notify
  - notifyAll
  - yield
  - join
  - CyclicBarrier

Funcionalidades Clave
---------------------

- Producción y distribución concurrente de productos
- Manejo de capacidad limitada en depósitos
- Terminación controlada del proceso mediante productos especiales "FIN_A" y "FIN_B"
- Sincronización entre productores, distribuidores y operarios internos
- Implementación de espera pasiva y semi-activa según el rol del operario

Cómo Ejecutar
-------------

1. Clone el repositorio
2. Compile los archivos Java
3. Ejecute el programa principal
4. Ingrese los valores solicitados para:
   - Número de productos (numProductos)
   - Capacidad del depósito de producción (capDepProd)
   - Capacidad del depósito de distribución (capDepDist)

Documentación
-------------

Para más detalles sobre el diseño, implementación y validación del proyecto, consulte el documento PDF incluido en el repositorio. Este documento contiene:

- Diagrama de clases
- Explicación detallada de la sincronización entre objetos
- Descripción del funcionamiento global del sistema
- Validación realizada

Autores
-------

1. Pablo Galindo Largachacha
2. María José Amorocho
3. Juanita Gil

Notas
-----

Este proyecto fue desarrollado como parte de un caso de estudio académico para aprender sobre concurrencia y sincronización en Java. No está destinado para uso en producción, sino como una herramienta educativa para explorar conceptos avanzados de programación concurrente.
