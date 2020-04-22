import java.util.NoSuchElementException;

// repaso para parcial 2
public class ArbolABB <E extends Comparable <E>> {
	// debe tener:
	nodoABB<E> raiz; //raiz
	private int size; //tamaño
	// constructor
	public ArbolABB() {
		//iniciamos raiz en null ya que no hay ningun dato
		this.raiz=null;
		//iniciamos tamaño en 0 ya que no hay datos
		this.size=0;
	}
	// buscar
	public E buscar(E dato) {
		nodoABB<E> current = this.raiz; // creamos un nodo current para iterar el arbol
		while(current!=null) { //si current llega a ser null entonces llegamos al final de la lista
			if(current.dato.equals(dato)) {
				return dato; // si el dato de current es igual al dato entonces se encontro
			}
			else if(dato.compareTo(current.dato)<0) {
				current=current.izquierda; // si el dato de current es mayor entonces se va a la izquierda por que son los menores
			}else if(dato.compareTo(current.dato)>0) {
				current=current.derecha;// si el dato es mayor entonces se va a la derecha por que son los mayores
			}
		}
		throw new NoSuchElementException("No se encontro dato"); // si llegamos al final de la lista y no se encontro el dato entonces regresamos que el dato no esta en el arbol
	}
// insertar
	public nodoABB<E> insertar(E dato) {
		nodoABB<E> current=this.raiz; // iteramos desde raiz
		nodoABB<E> nvo= new nodoABB<E>(dato); // creamos nuevo nodo
		while(current!=null) {// mientras no se acabe la lista
			if(dato.compareTo(current.dato)<0) { // si el dato es menor entonces es en izquierda
				if(current.izquierda==null) { // y si ek hijo a la izquierda esta vacio
					current.izquierda=nvo;  // entonces insertamos el nuevo en la derecha
					this.size++;
					return current.izquierda;
				}else {
					current=current.izquierda; // si no entonces lo iteramos a la izquierda
				}
			}else if(dato.compareTo(current.dato)<0) { // si el dato es mayor entonces es en la derecha
				if(current.derecha==null) {// y si el hijo en la derecha es null
					current.derecha=nvo;//se agrega 
					this.size++;
					return  current.derecha;
				}else {
					current=current.derecha; // si no se actualiza
				}
			}
		}
		this.raiz=nvo; // si el current es null entonces esta vacia 
		this.size++;
		return this.raiz;
	}
	// borrar un nodo
	public void borrar(E dato){
		nodoABB<E> current=this.raiz; // va a ser el nodo que va a ir recorriendo el abb
		nodoABB<E> previo=null; // nodio antes del current 
		boolean lado = false; // si es falso entonces es derecha, true izquierda
		while(current!=null) { // si current llega a null entonces significa que no esta el nodo
			if(!current.dato.equals(dato)) { // mientras current no sea el dato
				previo=current; // previo avansa a la posicon en current
				// 2 casos derecha o izquierda
				if(dato.compareTo(current.dato)<0) { // si el dato es menor entonces avanzamos current a izquierda
					current=current.izquierda;
					lado=true;
				}else { // si el dato es mayor entonces avamzamos a derecha
					current=current.derecha;
				}
			}
			// cuando acabe entonces previo va a ser el nodo que queremos borrar y previo va a ser un nodo antes
			// caso 1: no tiene hijos
			// solo borramos current poniendo el siguiente de current 
			if(current.derecha==null && current.izquierda==null) { // ambos hijos son null
				//dependiendo del lado
				if(lado) { // true es izquierda
					previo.izquierda=null;
					this.size--;
				}else {// derecha
					previo.derecha=null;
					this.size--;
				}
			}
			// caso 2: solo tiene 1 hijo
			if(current.derecha!=null) { // hijo de la derecha
				if(lado) { //true entonces current esta a la izquierda entonces current esta a la izquierda de previo
					previo.izquierda=current.derecha;
				}else { // si no current esta a la derecha
						previo.derecha=current.derecha;
					}
				this.size--;
				}
			if (current.izquierda!=null) { //hijo de la izquierda
				if(lado) { // true entonces current esta a la izquierda
					previo.izquierda=current.izquierda;
				}else {
					previo.izquierda=current.izquierda; // hacemos que la izquierda del previo sea la izquierda de current eliminando current
				}
				this.size--;
			}
		// caso 3: tiene 2 hijos
			if(current.derecha!=null & current.izquierda!=null) {
				nodoABB<E> predecesor=predecesor(current); // buscamos el predesesor
				current.dato=predecesor.dato; // hacemos que el valor de predecesor sea el valor de current
				// si el nodo izquierdo del current es el predecesor entonces
				if(current.izquierda==predecesor) {
					predecesor=null;
					this.size--;
				}
				else {
					// si no es entonces mandamos a borrar de forma iterativa el nodo predecesor
					borrar(predecesor.dato);
				}
			}
		}
	}

	// predecesor de un nodo 
	public nodoABB<E> predecesor(nodoABB<E> nodo){
		// predesesor es uno a la derecha y despues izquierda hasta el ultimo nodo
		nodoABB<E> current=nodo.derecha; // nos vamos al nodo de la derecha
		while(current.izquierda!= null) {
			current=current.izquierda; // y vamos a irnos hasta el ultimo nodo de la izquierda
		}
		return current.izquierda; // regresamos el ultimo nodo a la izquierda
	}
	// ordenes 
	
	//preorden : raiz, izquierda , derecha
	public void preorden() {
		preorden(this.raiz);
		System.out.println();
		
	}
	private void preorden(nodoABB<E> current) {
		while(current != null) {
			System.out.print(current.dato+" ,");
			preorden(current.izquierda);
			preorden(current.derecha);
		}
	}
	// inorden: izquierdo, raiz, derecho
	public void inorden() {
		inorden(this.raiz);
		System.out.println();
	}
	private void inorden(nodoABB<E> current) {
		while(current != null) {
			inorden(current.izquierda);
			System.out.print(current.dato+" ,");
			inorden(current.derecha);
		}
	}
	// postorden: izquierda, derecha, raiz
	public void postorden() {
		postorden(this.raiz);
		System.out.println();
	}
	private void postorden(nodoABB<E> current) {
		while(current != null) {
			postorden(current.izquierda);
			postorden(current.derecha);
			System.out.print(current.dato);
		}
		
	}
	// driver code
	public void main(String[] args) {
		ArbolABB<Integer> arbol= new ArbolABB<>();
		arbol.insertar(8);
		arbol.insertar(3);
		arbol.insertar(10);
		arbol.insertar(1);
		System.out.print(arbol);
		
	}
}
class nodoABB<E>{
	E dato;
	nodoABB<E> derecha,//right // mayor que el nodo padre
				izquierda;//left// menor que el nodo padre
	// constructor con dato
	public nodoABB(E dato) {
		this.dato=dato;
		this.derecha=null;
		this.izquierda=null;
		
	}
	//constructor con todo
	public nodoABB(E dato, nodoABB<E> derecha, nodoABB<E> izquierda) {
		this.dato=dato;
		this.derecha=derecha;
		this.izquierda=izquierda;
	}
	// metodo toString
	public String toString() {
		return this.dato.toString();
	}
}