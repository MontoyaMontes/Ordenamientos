# Ordenamientos
4 diferentes algoritmos de ordenamiento, más un generador de listas con números aleatorios ordenada.

Montoya Montes Pedro
pmontoyam@ciencias.unam.mx

--Instrucciones:--

El programa se compila de la siguiente forma:
*En la carpeta contenedora de los archivos fuentes se ejecuta javac Practica3.java y javac generaArreglo.java

El programa se ejecuta de la siguiente forma:
*En la carpeta contenedora de los archivos binarios se ejecuta:

java Practica3 [archivo:txt] [número:entero] [busqueda:cadena]

[archivo:txt] es un archivo de texto que contiene nuestra secuencia de números.
[número:entero] es un número que se buscará en el [archivo:txt].
[busqueda:cadena] es una cadena del tipo de búsqueda a realizar = lineal | binaria | exponencial | interpolacion.

--Ejemplo:--

EJEMPLO DE ENTRADA:
java Practica3 numeritos.txt 7 lineal

CONTENIDO numeritos.txt:
1 2 3 5 6 7

SALIDA EJEMPLO:
Buscaré por Busqueda Lineal
El elemento está en el índice: 5

--Excepciones y errores:--

Si el archivo no se encuentra ó está vacío, se genera un nuevo arreglo y se buscará el número dado.
Si la cadena del tipo de busqueda se ingresa de forma incorrecta, se avisa al usuario y para.

Si cualquiera de los parámetros falta o no están en el orden correcto, se avisa al usuario y para.

--Clase que genera el nuevo arreglo:--

En caso de no existir el [archivo:txt], se avisa al usuario, se genera un nuevo arreglo ordenado (que se muestra al mismo) y 
se busca [número:entero] con la [busqueda:cadena] ordenadas.

La clase que genera el nuevo arreglo funciona obteniendo números aleatorios.
Uno en el método diferenciaRandom(), que da un valor del 1-15 (porque sí) para que difieran los valores entre si.
Otro en el método generaArreglo(), que da un valor entre 0-100 (porque sí) para que sea el primer valor de nuestro arreglo.
Finalmente uno en getArreglo(), que da un valor entre 1-30 (porque... necesita tener almenos un elemento) para que sea el tamaño de nuestro arreglo.
