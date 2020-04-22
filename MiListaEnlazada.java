// Autor: A01635062 Estefania Jimenez Garcia 
// Clases: MiListaEnlazada.java y NodoLE.java
// Fecha: 4 de Septiembre 2019
import java.util.NoSuchElementException;

public class MiListaEnlazada<E> {
	private NodoLE<E> first;
	private NodoLE<E> last;
	private int size;
	
	public MiListaEnlazada() {
		this.first=this.last=null;
		this.size=0;
	}
	//Ejericio 1
	public MiListaEnlazada(E[] datos) {
		NodoLE<E> actual = null;
		// creamos un nodo actual 
		for(int i = 0; i < datos.length; i++) {
			// recorremos la lista
			if(i == 0) {
				// si i es igual a 0 significa que es el incio de la lista
				// y va a ser el primer dato
				this.first = new NodoLE<E>(datos[i]);
				// se cambia el nodo actual con el primero
				actual = first;
				this.size++;
				
			}else if(i == datos.length-1) {
				// en este caso i seria la ultima posicion en la lista
				// y seria el last de la linked list
				this.last = new NodoLE<E>(datos[i]);
				// se linkea el nodo actual con este nodo creado al final 
				actual.setNext(last);
				this.size++;
			}else {
				// se agregan los demas datos que no sean first o last
				// usamos un nodo temporal
				NodoLE<E> temp = new NodoLE<E>(datos[i]);
				actual.setNext(temp);
				actual = temp;
				this.size++;
			}
		}	
	}
	
	public E first() throws NoSuchElementException {
		try {
			return this.first.getDato();
		}
		catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede obtener el primer dato");
		}
		// sin poo return this.first().dato;
	}
	public E last() throws NoSuchElementException {
		try {
			return this.last.getDato();
		}
		catch(NullPointerException e) {
			throw new NoSuchElementException("No se puede obtener el ultimo dato");
		}
	}
	public int getSize() {
		return this.size;
	}
	public boolean isEmpty() {
		return this.size==0;
	}
	public void insertAtFirst(E dato) {
		//1. crear un nuevo nodo
		//2. refer nuevo.next=first
		//3. this.first=nuevo
		//4. this.size ++
		this.first=new NodoLE<E>(dato, this.first);
		// caso especial 
		if(this.last==null) {
			this.last=this.first;
		}
		this.size++;
	}
	// Ejercicio 2
	public void insertAtLast(E dato) {
		// veemos si la lista esta vacia con la 
		// funcion que ya tenemos 
		if(this.isEmpty()) {
			insertAtFirst(dato);
		}else {
			// creamos un nodo que tenga dato y null
			NodoLE<E> nuevo= new NodoLE<E>(dato);
			// lo referimos con el ultimo last
			this.last.setNext(nuevo);
			// y por ultimo ponemos que el nuevo es el nuevo last
			this.last=nuevo;
			this.size++;
		}
	}
	// Ejercicio 3
	public void insertAt (E dato, int pos) throws IndexOutOfBoundsException {
		// si la posicion es menor que 0 
		// o la posicion es mayor que el tamaño 
		// lanzamos error 
		if(pos<0 || pos>this.size) {
			throw new IndexOutOfBoundsException();
			}
		// ahora vemos otros casos
		// si por es igual a 0 entonces seria agregarlo al inicio
		else if(pos==0) {
			insertAtFirst(dato);
		}else if(pos == this.size) {
			insertAtLast(dato);
		}
		else {
			// creamos un nodo temporal que va a ser el primer nodo de nuestra lista
			NodoLE<E> temp=this.first;
			// y un nuevo nodo
			NodoLE<E> nuevo=new NodoLE<E>(dato);
			// Iteramos con i como contador 
			// lo igualamos a 0
			// despues vemos si i es menor a la posicion menos 1 ya que
			// si es mayor entonces seria agregar al inicio 
			// checamos que el nodo temp (el primer nodo de la lista)
			// que no sea null haciendolo el ultimo de la lista y sumamos i
			for(int i=0; i<pos-1 && temp.next!= null;i++) {
				// cuando llegue a que temp.next sea igual a null entonces se cierra el ciclo
				temp=temp.getNext();
			}
			// hacemos que el next de nuevo sea el next de temp para no perder el resto de la lista
			nuevo.setNext(temp.getNext());
			// y hacemos que el next del nodo actual sera el nuevo nodo
			temp.setNext(nuevo);
			this.size++;
		}
	}
	public E removeFirst() throws NoSuchElementException {
		// 1. E dato=this.first.getDato()
		// 2. this.first=first.next
		try {
		E dato= this.first.getDato();
		this.first=this.first.getNext();
		this.size--;
		if(this.size==0) {
			this.last=null;
		}
		return dato;
		// volvemos a aggarar el error de first() y lo cambiamos para que el mensaje sea differente
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("No se puede borrar el primer elemento de una lista vacia");
		}
	}
	// tarea1
	public E removeLast() throws NoSuchElementException {
		try {
		if(this.size<=1) {
			return this.removeFirst();
		}else {
		E dato=this.last();
		NodoLE<E> current=this.first;
		for(int i=0; i<this.size-1; i++) {
			current=current.next;
		}
		current.next=null;
		this.last=current;
		this.size--;
		return dato;
		}
		}
		catch(NoSuchElementException ex) {
			throw new NoSuchElementException("No se peude borrar el ultimo dato de la lista");
		}
	}

	//tarea 2
	public E RemoveAt(int pos) throws IndexOutOfBoundsException{
		if(pos<0 || pos>=this.size) {
			throw new IndexOutOfBoundsException("No se puede borrar el dato en la lista en la posicon"+ pos + "la lista tiene un tamaño de"+ this.size);
		}
		else if(pos==0) {
			return removeFirst();
		}
		else if(pos==this.size-1) {
			return this.removeLast();
		}
		else {
			E dato;
			NodoLE<E> temp=this.first;
			for(int i=0; i<pos-1;i++) {
				temp=temp.getNext();
			}
			dato=temp.getNext().getDato();
			temp.setNext(temp.getNext().getNext());
			this.size--;
			return dato;	
		}
	}
			
		
	//}
	public void setAt(E dato, int pos) throws IndexOutOfBoundsException{
		// se pone la exception en la primera y se ponde desde el principio y sin hacer identacion antes
		if(pos<0 || pos>=this.size) {
			throw new IndexOutOfBoundsException("Insertar en la posicion" + pos + "en una lista de tamaño" + this.size);
			// con el else if, cambiamos la velocidad a constante 
		}else if(pos==this.size-1) {
			this.last.setDato(dato);
		}
		else{
			NodoLE<E> current=this.first;
			for(int i=0; i<pos;i++) {
				current=current.next;
			}
			current.setDato(dato);
			//current.dato=dato;
			}
		}
	
	
	public String toString(){
		if(this.size == 0) {
			return "";
		}
		String res = "";
		NodoLE<E> temp = this.first;
		for (int i = 0; i < this.size-1; i++) {
			res += temp.getDato() + ",";
			temp = temp.getNext();
		}
		res += temp.getDato();
		return res;
	}

	public static void main(String[] args) {
		Integer[] listaNumeros= {1,2,3,4,5};
		MiListaEnlazada<Integer> linked= new MiListaEnlazada<>(listaNumeros);
		//linked.insertAt(6, -2); lanza el error
		linked.insertAt(6,5);
		linked.insertAtFirst(0);
		linked.insertAtLast(7);
		//System.out.println(linked.getSize());
		System.out.println(linked.toString());
	}

}
// cuando declaras una clase y tiene <E> significa que va a tener una clase de dato 
// luego declaras que clase de dato va a ser
class NodoLE<E>{
	E dato;
	NodoLE<E> next;
	int size;
	// si la clase va paremetrisada, y si no le pones al nodo next tambien genericos
	public NodoLE(E dato, NodoLE<E> next) {
		this.dato=dato;
		this.next=next;
	}
	public NodoLE(E dato) {
		this(dato, null);
	}
	// getters y setters
	public E getDato() {
		return dato;
		
	}
	public void setDato(E dato) {
		this.dato= dato;
		
	}
	public NodoLE<E> getNext() {
		return next;
	}
	public void setNext(NodoLE<E> next) {
		this.next= next;
	}
}
