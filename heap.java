
public class heap<E extends Comparable <E>>{
	private E[] heap;
	private int size;
	
	public heap(){
		this.heap=(E[]) new Comparable[20];
		this.size=0;
	}
	public heap(E[] lista) {
		this.size=lista.length;
		hepify(lista);
		this.heap=lista;
	}
	public void insertar(E dato) {
		// creamos una array en la cual le agregamos un tamaño por si el heap ya esta lleno
		E[] aux=(E[]) new Comparable[this.heap.length+1];
		for(int i=0; i<this.heap.length; i++) { // iteramos los datos del heap y los metemos al aux
			aux[i]=this.heap[i];
		}// ya que el aux tienes los datos del heap original metemos los datos
		// insertamos el valor del dato en la ultima posicion de heap 
		aux[this.heap.length+1]=dato;
		// y ya que este entonces hacemos hepify 
		hepify(this.heap); // ordenamos el heap
		this.size++;
		
	} 
	
	public void swap(int pos1, int pos2) {
		E aux=this.heap[pos1];
		this.heap[pos1]=this.heap[pos2];
		this.heap[pos2]=aux;
	}
	public void hepify(E[] array) {
		int tamaño=array.length;
		// vamos a primero aggarra la primera parte del array desde la mitad hasta la posicion 0
		// la mitad se agarra con (lenght/2)-1
		for(int i=(tamaño/2)-1; i>=0; i--) {// i es la mitad, mienstras que i sea mayor o igualq que cero recorre una posicion menos
			// hacemos sort al principio de la lista
			hepify(array,tamaño,i);
		}
		// ya solo queda hacerle hepify al root 
		for(int i=tamaño-1; i>=0; i--) {
			// guardamos el valor de root
			E aux=array[0];
			// despues el ultimo valor de la heap a root
			array[0]=array[i];
			// despues ponemos hasta el final el root
			array[i]=aux;
			// y mandamos a hacer hepify  al final 
			hepify(array,tamaño,i);
		}
	}
	private void hepify(E[] array, int tamaño, int i) {
		int mayor=i;
		int izquierdo=2*i+1;
		int derecho=2*i+2;
		if(izquierdo<tamaño && array[izquierdo].compareTo(array[mayor])>0) {
			// si el elemento en izquierdo es mayor a el elemento en la posicon mayor entonces
			// hacemos que el nuevo mayor sea el hijo izquierdo
			mayor=izquierdo;
		}
		if(derecho<tamaño && array[derecho].compareTo(array[mayor])>0) {
			// si el elemento en derecha es mayor al elemento en posicion mayor entonces
			//  hacemos que el nuevo mayor sea el hijo izquierdo
			mayor=derecho;
		}
		if(mayor != i) { // si al final se cambio el valor a mayor
			//hacemos swap de los elementos
			swap(i,mayor);
			// y mandamos a llamar la funcion con la siguiente posicion
			hepify(array, tamaño, mayor);
			
		}
	}
	public E borrar() {
		// para borrar un elemento en un heap simepre se elimina el root
		// igualamos el root con el ultimo elelemento del heap
		E borrado=this.heap[0];
		this.heap[0]=this.heap[this.size-1];
		// despues cremaos una lista auxilar con el tamaño menos 1
		E[] aux=(E[]) new Comparable[this.size-1];
		for(int i=0; i<this.size-1; i++) {
			aux[i]=this.heap[i];
		}
		this.heap=aux;
		this.size--;
		return borrado;
	}
	
}
