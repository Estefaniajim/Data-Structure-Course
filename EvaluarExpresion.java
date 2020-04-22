//Autor: Estefania Jimenez Garcia A01635062 
//Nombre de la clase: EvaluarExpresion.java
//Fecha: 23 de Septiembre del 2019
//Comentarios u observaciones: 
// la intente hacer con mi stack ya creado pero tengo error
//por lo cual importo el stack de java ya echo
// pero pongo el codigo en comentarios de como lo haria si funcionara mi stack
import java.util.Stack; 
public class  EvaluarExpresion {
	public String expresionInfija;
	//constructor 
	EvaluarExpresion(String exp){
		this.expresionInfija=exp;
	}
	//s
	public void setExpresionInfija(String exp) {
		this.expresionInfija = exp;
	}
	public double  evaluaExpresion() 
	    { 
	        char[] cosas = expresionInfija.toCharArray(); 
	  
	         //creamos un stack para lus numeros 
	        //MyStack<Integer> valores = new MyStack<Integer>();
	        Stack<Double> valores = new Stack<Double>(); 
	        
	  
	        //stack para las operaciones
	        //MyStack<Character> signos = new MyStack<Character>(); 
	        Stack<Character> signos = new Stack<Character>(); 
	  
	        for (int i = 0; i < cosas.length; i++) 
	        { 
	             // si en la posicion hay un espacion entonces se lo salta
	            if (cosas[i] == ' ') 
	                continue; 
	  
	            // si el espacio es un numero entonces lo agrega al stack
	            if (cosas[i] >= '0' && cosas[i] <= '9') 
	            { 
	                StringBuffer cambio = new StringBuffer(); 
	                // si hya mas de 1 digito en el numero
	                while (i < cosas.length && cosas[i] >= '0' && cosas[i] <= '9') 
	                    cambio.append(cosas[i++]); 
	                valores.push((double) Integer.parseInt(cambio.toString())); 
	            } 
	  
	            // si el valor entonces es un parentesis que se abre se agrepa al stack se signos 
	            else if (cosas[i] == '(') 
	                signos.push(cosas[i]); 
	  
	            // Cuando se encuentra el parentesis que se cierra entonces resuelve lo que se habia guardado
	            else if (cosas[i] == ')') 
	            { 
	                while (signos.peek() != '(') 
	                  valores.push(hacerOperacion(signos.pop(), valores.pop(), valores.pop())); 
	                signos.pop(); 
	            } 
	  
	            // si el valor entonces es una suma, resta, diviosn, etc entonces
	            else if (cosas[i] == '+' || cosas[i] == '-' || 
	                     cosas[i] == '*' || cosas[i] == '/') 
	            { 
	                //Si el valor tiene mayor preferencia que el que esta en peek del stack se signos
	                // se aplica la operancion con los numeros de stack de numeros y se eliminan los valores que se usaron en la operacion
	                while (!signos.isEmpty() && tieneProcedencia(cosas[i], signos.peek())) 
	                  valores.push(hacerOperacion(signos.pop(), valores.pop(), valores.pop())); 
	  
	                // se agrega el signo 
	                signos.push(cosas[i]); 
	            } 
	        } 
	  
	        // si ya se se paro por toda la expresion, entonces se hace la operacion de los numeros restantes
	        while (!signos.isEmpty()) 
	            valores.push(hacerOperacion(signos.pop(), valores.pop(), valores.pop())); 
	  
	        // como el valor del peek del stack de valores ya es el ultimo entonces va a ser el resultadoado
	        //se regresa
	        return valores.pop(); 
	    } 
	  // La verdad no se si se peuda agregar extra funciones pero agrege  2 funciones
	 // tieneProcedencia para comparar 2 valores entre ellos y ver si el signno tiene mas preferencia que el otro
	 // y en otra se hiciera la operacion dependiendo de que si es suma, resta, division, etc
	 public static boolean tieneProcedencia(char valor1, char valor2) 
	    { 
	        if (valor2 == '(' || valor2 == ')') 
	            return false; 
	        if ((valor1 == '*' || valor1 == '/') && (valor2 == '+' || valor2 == '-')) 
	            return false; 
	        else
	            return true; 
	    } 
	    public static double hacerOperacion(char op, Double double1, Double double2) 
	    { 
	        switch (op) 
	        { 
	        case '+': 
	            return double2 + double1; 
	        case '-': 
	            return double2 - double1; 
	        case '*': 
	            return double2 * double1; 
	        case '/': 
	            if (double1 == 0)
	            	// si b es 0 entonces lanzamos error
	                throw new
	                UnsupportedOperationException("No se puede dividir ningun numero entre 0"); 
	            return double2 / double1; 
	        } 
	        return 0; 
	    } 
	    String  expresionPostfijo() 
	    { 
	        // creamos una string vacia para guardar el resultadoado
	        String resultado = new String(""); 
	          
	        // Iniciamos un stack vario con el nombre de pila
	        Stack<Character> pila = new Stack<>(); 
	          
	        for (int i = 0; i<expresionInfija.length(); ++i) 
	        { 
	            char c = expresionInfija.charAt(i); 
	              
	             // si es un numero o nua letra entonces se agrega a resultado
	            if (Character.isLetterOrDigit(c)) 
	                resultado += c; 
	               
	            // si entonces es ( entonces se agrega al stack de pila
	            else if (c == '(') 
	                pila.push(c); 
	              
	            //  si entonces es un ) se  busca hasta cerrarse
	            else if (c == ')') 
	            { 
	                while (!pila.isEmpty() && pila.peek() != '(') 
	                    resultado += pila.pop(); 
	                  
	                if (!pila.isEmpty() && pila.peek() != '(') 
	                    return "No se puede"; 
	                    pila.pop(); 
	            } 
	            else 
	            { 
	                while (!pila.isEmpty() && Prec(c) <= Prec(pila.peek())){ 
	                    if(pila.peek() == '(') 
	                        return "No se puede"; 
	                    resultado += pila.pop(); 
	             } 
	                pila.push(c); 
	            } 
	       
	        }
	        while (!pila.isEmpty()){ 
	            if(pila.peek() == '(') 
	                return "No se puede"; 
	            resultado += pila.pop(); 
	         } 
	        return resultado; 
	    } 
	    static int Prec(char ch) 
	    { 
	        switch (ch) 
	        { 
	        case '+': 
	        case '-': 
	            return 1; 
	       
	        case '*': 
	        case '/': 
	            return 2; 
	       
	        case '^': 
	            return 3; 
	        } 
	        return -1; 
	    } 
	}
	  
