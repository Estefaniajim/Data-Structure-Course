//Autor: Estefania Jimenez Garcia A01635062
//Clase: MiABB.java
//Fecha: 28 de Enero del 2020
//Comentarios: Los agrege adentro del codigo
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
public class MiABB <E extends Comparable <E>>{
	private MyNodoABB<E> raiz;
	private int size;
	
	// constructor
	public MiABB() {
		this.raiz=null;
		this.size=0;
	}
	// buscar 
	public E buscar(E dato){
		MyNodoABB<E> current = this.raiz;
		while(current != null) {
			if(dato.equals(current.dato)) {
				return current.dato;
			}else if(dato.compareTo(current.dato) < 0) {
				current = current.izquierdo;
			}else {
				current = current.derecho;
			}
		}
		throw new NoSuchElementException("no se encontro en el arbol");
	}
	// insertar
	public void insert(E dato) {
		MyNodoABB<E> nuevo= new MyNodoABB<>(dato);
		if(this.raiz!=null) {
			MyNodoABB<E> current = this.raiz;
			MyNodoABB<E> temp = null;
			while (current!=null) {
				temp=current;
				current= dato.compareTo(current.dato) < 0 ? current.izquierdo : current.derecho;
			}
			// current ya llego a null y ahora
			// temp esta en el padre del nuevo nodo
			if(dato.compareTo(temp.dato)>0) {
				temp.derecho=nuevo;
			}else {
				temp.izquierdo=nuevo;
			}
			
		}else {
			// si es igual a null entonces es el primer nodo
			this.raiz=nuevo;
		}
		this.size++;
	}
	//borrar
	public E borrar(E dato) {
		MyNodoABB<E> current=this.raiz;
		MyNodoABB<E> temp=null;
		boolean lado; //false es derecho, true es izquierdp
		// recorremos la lista
		while(!dato.equals(current.dato)) {
			temp=current;
			current=dato.compareTo(current.dato) < 0 ? current.izquierdo:current.derecho;
		}
		if(temp.izquierdo==current) {
			lado=true;
		}else {
			lado=false;
		}
		// caso 1: el nodo a borrar es una hoja
		if(current.izquierdo==null && current.derecho==null) {
			if(lado) {
				temp.izquierdo=null;
			}else {
				temp.derecho=null;
			}
		}
		// caso 2: el nodo solo tiene un hijo
		//derecho
		else if(current.izquierdo==null) {
			// el lado izquierdo estara en null
			if(lado) {
				// si el lado es izquierdo
				// entonces usamos el izquierdo del current
				temp.izquierdo=current.izquierdo;
			} else {
				temp.derecho=current.derecho;
			}
		}
		// izquierdo
		else if(current.derecho==null) {
			if(lado) {
				temp.izquierdo=current.izquierdo;
			}else {
				temp.derecho=current.derecho;
			}
		}
		// caso 3: tiene 2 hijos para eliminar
		else {
			MyNodoABB<E> predecesor= predecesor(current);
			current.dato= predecesor.dato;
			if(current.izquierdo == predecesor) {
				predecesor=null;
			}else {
				E elementoTemp =  borrar(predecesor.dato);
				current.dato = elementoTemp;
			}
		}
		return current.dato;
	}
	private MyNodoABB<E> predecesor(MyNodoABB<E> current) {
		MyNodoABB<E> nodo=current.izquierdo;
		while(nodo.derecho != null) {
			nodo=nodo.izquierdo;
		}
		return nodo;
	}
 // preorden
	public void preorden() {
		// funcion para inciar
		preOrden(this.raiz);
		System.out.println();
		
	}
	public void preOrden(MyNodoABB<E> current) {
		// raiz, izquierdo , derecho
		if(current!= null) {
			System.out.println(current.dato+",");
			preOrden(current.izquierdo);
			preOrden(current.derecho);
		}
		
	}
	 // posorden
		public void postorden() {
			// funcion para inciar
			postOrden(this.raiz);
			System.out.println();
			
		}
		public void postOrden(MyNodoABB<E> current) {
			// izquierdo, derecha, raiz
			if(current!= null) {
				postOrden(current.izquierdo);
				postOrden(current.derecho);
				System.out.println(current.dato+",");
			}
			
		}
		 // inorden
		public void inorden() {
			// funcion para inciar
			inOrden(this.raiz);
			System.out.println();
			
		}
		public void inOrden(MyNodoABB<E> current) {
			// izquierda, derecha, raiz
			if(current!= null) {
				inOrden(current.izquierdo);
				System.out.println(current.dato+ ",");
				inOrden(current.derecho);
			}
			
		}
		// por nivel
		public void nivel() {
			// por cada nodo, se visita el nodo y despues sus hijos se ponen en la cola
			// raiz, derecho y izquierdo
			Queue<MyNodoABB<E>> cola = new LinkedList<MyNodoABB<E>>();
			cola.add(this.raiz);
			// agregamos el nodo 
			// y ahora metemos sus hijos
			while(!cola.isEmpty()) {
				// se saca el primer dato y se pone en un nodo temp
				MyNodoABB<E> temp= cola.poll();
				// y lo imprimimos
				System.out.println(temp.dato+",");
				// izquierdo
				if(temp.izquierdo!=null) {
					cola.add(temp.izquierdo);
				}else { //derecho
					cola.add(temp.derecho);
				}
				
			}
		}
		
		public void amplitud() {
			amplitud(this.raiz);
		}
		
		public void amplitud(MyNodoABB<E>current) {
			if(current != null) {
				Queue<MyNodoABB<E>> fila = new LinkedList<MyNodoABB<E>>();
				Queue<MyNodoABB<E>> filaux = new LinkedList<MyNodoABB<E>>();
				fila.add(current);
				while(!fila.isEmpty()) {
					filaux.add(current = fila.poll());
					if(current.izquierdo != null) {
						fila.add(current.izquierdo);
					}if(current.derecho != null) {
						fila.add(current.derecho);
					}
				}
				System.out.println(filaux);
			}
			
		}
		public void sumaNivelVertical() {
			
		}
		public static void main(String[] args) {

		}
	
} 
class MyNodoABB<E>{
	E dato;
	MyNodoABB<E> derecho,
				izquierdo;
	public MyNodoABB(E dato, MyNodoABB<E> izquierdo, MyNodoABB<E> derecho) {
		super();
		this.dato=dato;
		this.derecho=derecho;
		this.izquierdo=izquierdo;
	}
	public MyNodoABB(E dato) {
		this.dato=dato;
		this.derecho=null;
		this.izquierdo=null;
	}
	public String toString() {
		return this.dato.toString();
	}
}
