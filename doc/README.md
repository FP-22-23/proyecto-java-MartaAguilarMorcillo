# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Marta Aguilar Morcillo   uvus:NMY0786

Aquí debes añadir la descripción del dataset y un enunciado del dominio del proyecto.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.cars**: Paquete que contiene los tipos del proyecto.
  * **fp.cars.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto
    * **Car_sales.csv**: Archivo csv que contiene los datos referentes a los coches en venta de un concesionario.
    
## Estructura del *dataset*

El dataset original Car_sales.csv se puede obtener de la URL http://kaggle.com/willstr/car-salescsv. Originalmente tiene 15 columnas y cada fila contiene datos sobre un coche en concreto. El dataset usado en este proyecto tiene 10 columnas, 6 se han tomado del dataset original, y cuatro, el color del vehículo, su precio, el booleano sobre si el coche se encuentra o no averiado y las características especiales de cada coche, se han generado de forma aleatoria. A continuación se describen las 10 columnas del dataset:

* **manufacturer**: de tipo cadena, indica la marca del coche.
* **color**: de tipo cadena, indica el color del coche. Puede tomar los valores: Black, White, Red, Blue o Grey.
* **manufacturer price**: de tipo double. Indica el precio de cada coche impuesto por el fabricante.
* **damaged vehicle**: de tipo booleano, indica si el coche está o no averiado.
* **horsepower**: de tipo entero. Indica los caballos de fuerza, es decir, la potencia de cada coche.
* **engine size**: de tipo double. Indica el tamaño del motor.
* **width**: de tipo double. Indica el ancho del coche.
* **length**: de tipo double. Indica la longitud del coche.
* **registration date**: de tipo fecha. Indica la fecha en la que se matriculó el coche.
* **characteristics**: de tipo cadena, contiene una secuencia con las características particulares de cada coche. Las características están separados por ampersands(&).

## Tipos implementados

DLos tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base
DRepresenta los datos importantes de coche en cocnreto a la hora de comprarlo. Propiedades:

**Propiedades**:
* manufacturer, de tipo String, consultable y modificable. Contiene la marca del coche.
* color, de tipo Color, consultable y modificable. Indica el color del coche. Puede tomar los valores BLACK, WHITE, RED, BLUE, GREY.
* manufacturerPrice, de tipo Double, consultable y modificable. Contiene el precio al que vende el fabricante el coche.
* damagedVehicle, de tipo Boolean, consultable y modificable. Indica si el coche está averiado o no.
* horsepower, de tipo Integer, consultable y modificable. Contiene los caballos de fuerza del coche, es decir, su potencia.
* registrationDate, de tipo LocalDate, consultable y modificable. Indica la fecha de matriculación del coche.
* characteristics, de tipo List<String>, consultable y modificable. Lista de las características particulares del coche.
* getEstadoCoche, de tipo EstadoCoche, consultable. Es una propiedad derivada que se obtiene a partir de la propiedad registrationDate e indica el estado del coche, en cuanto a si se trata de un coche antiguo o más nuevo. Puede tomar los valores ANTIGUO, MODERNO.
* getMarketPrice, de tipo Double, consultable. Es una propiedad derivada que se obtiene a partir de las propiedades getEstadoCoche y manufacturerPrice e indica el precio del coche en el mercado, es decir, su valor de venta al pública.
* measurements, de tipo Measurements, consultable y modificable. Es una propiedad auxiliar que crea un objeto de la clase Measurements, la cual tiene las siguientes propiedades:
* engineSize, de tipo Double, consultable. Contiene el tamaño del motor del coche.
* width, de tipo Double, consultable. Contiene la anchura del coche.
* length, de tipo Double, consultable. Contiene la longitud del coche.

**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo Coche a partir de los siguientes parámetros: String manufacturer, Color color, Double manufacturerPrice, Boolean damagedVehicle, Integer horsepower, LocalDate registrationDate.

**Restricciones**:
 
- R1: El fabricante que hace referencia a la propiedad manufacturer no puede ser una cadena vacía.
- R2: El precio puesto por el fabricante, que es la propiedad manufacturerPrice, debe ser positivo.
- R3: La fecha, recogida en la propiedad registrationDate, debe ser igual o anterior a la de hoy.

**Criterio de igualdad**: Dos objetos de tipo Coche son iguales si todas sus propiedades básicas son iguales.

**Criterio de ordenación**: Por los caballos de fuerza del coche, la fecha de matriculación y el precio de mercado.

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...

#### Tipos auxiliares
* getEstadoCoche, de tipo EstadoCoche, consultable. Es una propiedad derivada que se obtiene a partir de la propiedad registrationDate e indica el estado del coche, en cuanto a si se trata de un coche antiguo o más nuevo. Puede tomar los valores ANTIGUO, MODERNO.
* getMarketPrice, de tipo Double, consultable. Es una propiedad derivada que se obtiene a partir de las propiedades getEstadoCoche y manufacturerPrice e indica el precio del coche en el mercado, es decir, su valor de venta al pública.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
