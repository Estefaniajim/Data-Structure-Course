import java.util.Stack;
//Autor: Estefania Jimenez Garcia A01635062
//Clase: ValidaOperadoresAgrupacion.java
//Fecha: 20 de Enero del 2020
//Comentarios: Los agrege adentro del codigo
public class ValidaOperadoresAgrupacion {
	public static boolean valida(String palabra) {
		//validar si cuando se agrega a la pila (,[,{ 
		// tambien se agrege ),],}
		// creamos una pila vacia
		Stack<Character> pila = new Stack<>();
		// Voy a meter en la pila solo los signos (,[,{
		// iteramos el string con el for
		for(char signo: palabra.toCharArray()) {
			// checamos si son los signos que queremos meter
			if(signo == '(' || signo == '[' || signo == '{') {
				// si es asi lo agregamos a la pila
				pila.push(signo);
			} else {
        // checar si la pila no esta vacia 
        if (!pila.isEmpty()){
          // checamos el ultimo signo que acaban de entrar
        	char primerSigno = (Character) pila.peek();
          // y ahora vamos a checar por cada caso del signo
          // que tenemos ahorita y ver si se cierra con el signo que acabamos
          // de sacar de la pila
          if(signo == ')' && primerSigno == '(' // parentesis
            || signo ==  '}' && primerSigno == '{' // llaves
            || signo ==  ']' && primerSigno == '[' ) { // corchetes
            // si es entonces sacampos el primer signo para seguir checando los demas
            pila.pop();
          }
          // si la pila esta vacia, y el ultimo signo es un signo de salida  }, ], )
          // enotnces regersamos false por que no estaria balanceado
      	} else if (signo == ')' || signo ==  '}' || signo ==  ']' ){
          return false;
        }
			}
		}
		// ahora que ya se hiso ese paso por cada signo entonces checamos que la 
		// pila este vacia 
		if(pila.empty()) {
			// si esta vacia entonces si era valido 
			return true;
		} else {
			// si no signicia que no se cerro alguno de los signos de entrada por lo cual no es valida la exprecion 
			return false;
		}
	}
  public static void main(String[]  args) {
    //String palabra = "[3-2]+(5+8)";//True
    //String palabra1 = "[3-2)(5+8)";//False
    //String palabra2 = "(5+8)1+2+3+4";//True
    //String palabra3 = "4";//True
    //String palabra4 = ")))))1";//False
    //String palabra5 = "({1+2}-[3x3123])";//True
    //String palabra6 = "{3+2}+ (321+1) * 1";//True
    //String palabra7 = "";//True
    //String palabra8 = "{([])}";//True
    //String palabra9 = "((([])";//False
    //System.out.println(valida(palabra));
    //System.out.println(valida(palabra1));
    //System.out.println(valida(palabra2));
    //System.out.println(valida(palabra3));
    //System.out.println(valida(palabra4));
    //System.out.println(valida(palabra5));
    //System.out.println(valida(palabra6));
    //System.out.println(valida(palabra7));
    //System.out.println(valida(palabra8));
    //System.out.println(valida(palabra9));
  }
}