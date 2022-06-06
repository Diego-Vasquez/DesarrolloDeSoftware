
# Segunda Práctica Desarrollo de software
## Respuestas 

### 1. Si ejecutamos las pruebas con cobertura desde IntelliJ IDEA, ¿cuales son los resultados que se muestran?, ¿Por qué crees que la cobertura del código no es del 100%?
Al aplicarle las pruebas de cobertura, podemos observar que para la fase 1
![Coverage 1](https://github.com/Diego-Vasquez/DesarrolloDeSoftware/blob/main/PC2/PC2/src/pictures/CoverageFase1.PNG)

, podemos ver que tenemos cubierto 79% del total del codigo.




sin embargo al ejecutar lafase 2, notamos que en este caso IntelliJ logra cubrir el 100 del codigo, 

### 2. ¿ Por qué John tiene la necesidad de refactorizar la aplicación?

### 3. La refactorización y los cambios de la API se propagan a las pruebas.
- Diagrama de clases de la fase tres:
En la fase tres como podemos notar consta de una serie de clases y métodos de herencia y interfaz.
![Coverage 1](https://github.com/Diego-Vasquez/DesarrolloDeSoftware/blob/main/PC2/PC2/src/pictures/"diagrama de clases de fase 3.png")

- Diagrama de clases de los test de la fase 3:
En el diagrama  de clases se muestra la relación entre las clases y las pruebas que estamos realizando para ver el funcionamiento de cada una de los métodos  con cada uno de los dos tipos de clases  de ticket o viajes.

#####¿Cuál es la cobertura del código?
En esta fase  en el script de testAiroport, verificamos los dos métodos  que se encuentran  en el script Flight que son los métodos de eliminar y agregar pasajeros.
Por este motivo lo que se hace  es realizar las pruebas  de los dos tipos de vuelos que hasta el momento tenemos que son Clase Económica y la clase de Negocios.
Estas clases son probadas con  los dos tipos de pasajeros que tenemos que  los vip y los no vip.

#####¿ La refactorización de la aplicación TDD ayudó tanto a mejorar la calidad del código?
La refactorización de la aplicación  básicamente nos permitió realizar iteraciones cortas y rápidas. Dado que aplicamos el concepto de divide y vencerás, al realizar  las pruebas de calidad.
Con la refactorización hemos optimizado el código del test y de esta manera aseguramos la funcionalidad.

### 4. ¿En qué consiste está regla relacionada a la refactorización?

### 5. Escribe el diseño inicial de la clase llamada PremiumFlight y agrega a la Fase 4 en la carpeta producción.

### 6. Ayuda a John e implementa las pruebas de acuerdo con la lógica comercial de vuelos premium de las figuras anteriores. Adjunta tu código en la parte que se indica en el código de la Fase 4. Después de escribir las pruebas, John las ejecuta

### 7. Agrega la lógica comercial solo para pasajeros VIP en la clase PremiumFlight. Guarda ese archivo en la carpeta Producción de la Fase 5.

### 8. Ayuda a John a crear una nueva prueba para verificar que un pasajero solo se puede agregar una vez a un vuelo. La ejecución de las pruebas ahora es exitosa, con una cobertura de código del 100 %. John ha implementado esta nueva característica en estilo TDD.
