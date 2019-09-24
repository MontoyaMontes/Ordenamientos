import java.util.Scanner;
import java.io.*;

/**
 * U.N.A.M
 * Facultad de ciencias
 * Montoya Montes Pedro
 * 31219536-2
 * pmontoyam@ciencias.unam.mx
 *
 * <p>Clase principal para resolver el problema de busqueda en 4 diferentes modalidades.</p>
 *
 */
public class Ordenamientos extends generaArreglo{

	/**
     * Método que lee el documento para poder conocer el total de elementos.
     * @return El total de elementos de nuestro documento.
     * Si hay un error de entrada, lanzamos una excepción y el tamaño queda igual a 0.
     */
	public static int getTamanio(String archivoEntrada)throws FileNotFoundException{
		int tamano = 0;
		try{ 

	    	File file = new File(archivoEntrada);//Abrimos el documento.
			Scanner inputFile = new Scanner(file);

			while(inputFile.hasNextInt()){
				inputFile.nextInt();
				tamano++;
			}

			inputFile.close();//Cerramos el documento.
			return tamano;

		}catch(Exception e){
			System.out.println("El archivo no es válido, se generará un nuevo arreglo:");
		}
		return tamano;
	}

	/**
     * Método que dado un documento llena un arreglo con dichos elementos.
     * @return El elemento <tt>a</tt> de la matriz de 2×2.
     */
	public static int[] llenaArreglo(String archivoEntrada, int tamano)throws FileNotFoundException{
		int[] numeritos = new int[tamano];      
		int indice = 0;
		try{ 
			
			File file = new File(archivoEntrada);//Abrimos el documento.
			Scanner inputFile = new Scanner(file);
			
			while (inputFile.hasNextInt() && indice < numeritos.length){
				numeritos[indice] = inputFile.nextInt();
				indice++;
			}
			
			inputFile.close();//Cerramos el documento.
		}catch(Exception e){
			System.out.println("El archivo no es válido, prueba de nuevo, error al llenar el arreglo.");
		}
		return numeritos;
	}  

	/**
	 * Método de busqueda secuencial.
	 * @param <tt>elementoBuscado</tt>, el elemento a buscar.
	 * @param <tt>arr</tt>, el arreglo del cual buscaremos el elemento <tt>elementoBuscado</tt>.
	 * @return Regresa el índice el cual contiene el <tt>elementoBuscado</tt>, -1 si no lo encuentra.
	 */
    public static int busquedaSecuencial(int[] arr, int elementoBuscado){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == elementoBuscado){    
                return i;    
            }
        }
        return -1;    
    } 

	/**
	 * Método de busqueda binaria.
	 * @param <tt>elementoBuscado</tt>, el elemento a buscar.
	 * @param <tt>arr</tt>, el arreglo del cual buscaremos el elemento <tt>elementoBuscado</tt>.
	 * @param <tt>primero</tt> el primer elemento del arreglo.
	 * @param <tt>ultimo</tt> el último elemento del arreglo.
	 * @return Regresa el índice el cual contiene el <tt>elementoBuscado</tt>, -1 si no lo encuentra.
	 */
	public static int busquedaBinaria(int arr[], int primero, int ultimo, int elementoBuscado){
		if (primero<=ultimo){  
		int m = primero + (ultimo - primero)/2;
		if (arr[m] == elementoBuscado)
			return m;
		if (arr[m] > elementoBuscado)
			return busquedaBinaria(arr, primero, m-1, elementoBuscado); 
		else
			return busquedaBinaria(arr, m+1, ultimo, elementoBuscado);
		}
		return -1;  
	}

	/**
	 * Método de busqueda exponencial.
	 * @param <tt>elementoBuscado</tt>, el elemento a buscar.
	 * @param <tt>arr</tt>, el arreglo del cual buscaremos el elemento <tt>elementoBuscado</tt>.
	 * @param <tt>n</tt>, el tamaño de nuestro arreglo. 
	 * @return Regresa el índice el cual contiene el <tt>elementoBuscado</tt>, -1 si no lo encuentra.
	 */
	public static int busquedaExponencial(int arr[],int n, int elementoBuscado){
		int i = 0;
		if (arr[i] == elementoBuscado) 
			return i;
		i++;
		while (i < n && arr[i] <= elementoBuscado)
			i = i*2;
		return busquedaBinaria(arr, i/2, Math.min(i, n), elementoBuscado);
	}

	/**
	 * Método de busqueda por interpolación.
	 * @param <tt>elementoBuscado</tt>, el elemento a buscar.
	 * @param <tt>arr</tt>, el arreglo del cual buscaremos el elemento <tt>elementoBuscado</tt>.
	 * @return Regresa el índice el cual contiene el <tt>elementoBuscado</tt>, -1 si no lo encuentra.
	 */
	public static int busquedaPorInterpolacion(int [] arr, int elementoBuscado){
		int min = 0; 
		int max = (arr.length - 1);
		while (min <= max && arr[min] <= elementoBuscado && elementoBuscado <= arr[max]){
			if (min == max){ 
				if (arr[min] == elementoBuscado) 
					return min; 
				return -1; 
			} 
			int pos = min + (((max - min) / (arr[max] - arr[min]))*(elementoBuscado - arr[min])); 
			if (arr[pos] == elementoBuscado) 
				return pos; 
			if (arr[pos] < elementoBuscado) 
				min = pos + 1; 
			else
				max = pos - 1; 
		} 
		return -1; 
	} 

	/**
	 * Método el cual se encarga, dados los parametros, hacer la busqueda indicada.
	 * @param <tt>elementoBuscado</tt>, el elemento a buscar.
	 * @param <tt>arreglo</tt>, el arreglo del cual buscaremos el elemento <tt>elementoBuscado</tt>.
	 * @param <tt>tipoBusqueda</tt>, dependiendo la cadena, busca mediante dicho algoritmo, 
	 * si la cadena no corresponde con ninguna busqueda, lanza un error.
	 * @param <tt>tamano</tt>, tamaño del <tt>arreglo</tt>.
	 * @return Regresa <tt>respuesta</tt>, que es el entero que regresa cada algoritmo, -2 si la busqueda no es válida.
	 */
	public static int busquedas(String elementoBuscado, int[] arreglo, String tipoBusqueda, int tamano){
		int elementoABuscar = Integer.parseInt(elementoBuscado); //Ya que elementoBuscado es una cadena la convertimos a entero.
		int respuesta = -1;
		String mensajeABorrar = "";
		switch (tipoBusqueda) {
			case "lineal" : mensajeABorrar = "Buscaré por Busqueda Lineal";
			respuesta = busquedaSecuencial(arreglo, elementoABuscar);
			break;
	
			case "binaria" : mensajeABorrar = "Buscaré por Busqueda Binaria";
			int ultimo = arreglo.length-1;
			respuesta =busquedaBinaria(arreglo, 0, ultimo, elementoABuscar);
			break;
	
			case "exponencial" : mensajeABorrar ="Buscaré por Busqueda Exponencial";
			
			respuesta = busquedaExponencial(arreglo, tamano, elementoABuscar);
			break;
	
			case "interpolacion" : mensajeABorrar ="Buscaré por Busqueda por Interpolación";
			respuesta = busquedaPorInterpolacion(arreglo, elementoABuscar);
			break;
	
			default: mensajeABorrar = "Busqueda no válida";
			respuesta = -2;
			break;
		}
		System.out.println(mensajeABorrar);
		return respuesta;
	}

	/**
	 * Método principal.
	 */
	public static void main(String[] args)  throws IOException{
		try{
			String archivoEntrada = args[0];
			String elementoBuscado = args[1];
			String tipoBusqueda = args[2];

			int tamano = getTamanio(archivoEntrada);

			if(tamano != 0){
				int[] arreglo = llenaArreglo(archivoEntrada, tamano);

				int respuesta = busquedas(elementoBuscado, arreglo, tipoBusqueda, tamano);
			
				if (respuesta != -2)
					System.out.println((respuesta < 0) ? 
										"El elemento no está" : 
										"El elemento está en el índice: " + 
										respuesta);
			}
			if(tamano == 0){
				int[] arregloBueno = getArreglo();
				for(int i=0;i<arregloBueno.length;i++){    
		        	System.out.println("elementos del ejemplo : " + arregloBueno[i]);
	        	}
	        	int respuesta = busquedas(elementoBuscado, arregloBueno, tipoBusqueda, arregloBueno.length);
	        	if (respuesta != -2)
					System.out.println((respuesta < 0) ? 
										"El elemento no está" : 
										"El elemento está en el índice: " + 
										respuesta);	

			}
		}catch(Exception e){
			System.out.println("Paŕametro inválido!.");
		}
	}
}
