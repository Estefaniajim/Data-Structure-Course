// Estefania Jimenez Garcia A01635062
// Para crear una multiplicacion con puras sumas
// podemos ver el segundo numero como las veces que se va a tener que sumar el primer numero
// lo cual podemos usar para crear como el loop 
// por lo cual sumamos el numero de veces que sea el segundo y cada ves que hacemos una suma le restamos
// pero esto solo se peude si ambos son positivos 
// por lo cual si detectamos que es negativo hacemos lo contrario
public class Multiplicacion {
	public static int multiplicacion(int n, int n2) {
		// siempre cualquier numero multiplicado por 0 es 0, por lo cual lo tomamos como casi base
		// en la recusion va a correr todos los numeros hasta que n2 llege a 0 y regrese 0 
		// cuando se regrese 0 se resolveran los demas casos
		if (n == 0 || n2 == 0) {
			return 0;
		}
		//si el numero es negativo
		else if( n2 < 0 ) {
			return - n + multiplicacion(n, n2 + 1);
		}

		else {
			return n + multiplicacion(n, n2 - 1);
		}
	}
	public static void main(String[] args) {
		System.out.println(multiplicacion(3,2));
	}

}
