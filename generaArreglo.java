import java.util.Random;
import java.util.Iterator;

public class generaArreglo{

  /*
  * 
  * Método diferenciaRandom(), que regresa un entero que será un entero aleatorio entre el 1 y el 15.
  *
  */
  private static int diferenciaRandom(){
    return new Random().nextInt(14)+1;
  }

  /*
  * 
  * Método generaArreglo(int n), que recibe como parámetro un entero n y regresa un int[] con un único elemento
  * el cual será un entero aleatorio entre el 0 y el 1000.
  *
  */
  private static int[] generaArreglo(int n){
    int[] arreglo = new int[n];
    arreglo[0]= new Random().nextInt(100);
    return arreglo;
	}

  /*
  * 
  * Método llenaArreglo(), que recibe como parámetro un entero n y regresa un int[] con n elementos.
  *
  */
	private static int[] llenaArreglo(int n){
		int[] arreglo = generaArreglo(n); //Generamos la arreglo con el elemento aleatorio.
		int i = 0;
    int ultimoE = arreglo[i];

    while(i<n-1){ //Llena.
      ultimoE = arreglo[i];
    	int rand = diferenciaRandom();
      arreglo[i+1]=ultimoE+rand;
    	i++;
    }
		return arreglo;
	}

  /*
  * 
  * Método llenaArreglo(),que regresa un int[] con n elementos, los cuales.
  *
  */
	public static int[] getArreglo(){
    int n = new Random().nextInt(29)+1;
		return llenaArreglo(n);
	}
}