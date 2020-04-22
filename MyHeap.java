//Autor: Estefania Jimenez Garcia A01635062
//Clase: MyHeap.java
//Fecha: 28 de Enero del 2020
//Comentarios: Los agrege adentro del codigo
public class MyHeap <E extends Comparable <E>> {
	private E[] heap;
	private int size;
	public MyHeap() {
		// tamaño default 
		this.heap=(E[])new Comparable[20];
		this.size=0;
	}
	public MyHeap(E[] datos) {
		// hacer heaífy 
		// agrege n que es el tamaño de los datos por que lo ocupamos para inciar el heap desde un array
		this.size=datos.length;
		heapify(datos,this.size);
		this.heap=datos;
	}
	// funcion para checar que se cumpla las condiciones del heap
	// en este metodo nos dan el tamaño de datos, y la posicion que queremos checar que se cumpla de la posion dada desde heapify (funcion abajo)
	private void heapifyRecursiva(E[] datos, int size, int pos) {
		// la logica es esta: 
		//poner el arreglo con las condiciones del heap
		// primero es encontrar el ultimo nodo con al menos un hijo  con (lenght/2)-1
		// agarrar de la posicion 0 hasta la posicion del ultimo nodo 
		// y checar si cumple con que sea mayos con 2K+1 y 2K+2
		int ultimoNodo=pos;// esta es la posicion del ultimo nodo con al menos un hijo que se la va a dar el metodo de preparacion
		int derecha= (2*pos)+2; // posicion del nodo hijo a la derecha del ultimo nodo
		int izquierda=(2*pos)+1; // posicion del nodo hijo a la izquierda del ultimo nodo
		// y ahora vamos a chechar si en realidad el ultimo nodo es mas grande que su hijo a la izquierda
		if(izquierda<size && datos[izquierda].compareTo(datos[ultimoNodo])>0) {
			//si es entonces ahora el ultimo nodo seria el hijo de la izquierda
			ultimoNodo=izquierda;
		}
		// y si no era mans grande que el de la izquierda entonces con el de la derecha
		 if(derecha<size && datos[derecha].compareTo(datos[ultimoNodo])>0) {
			// y si es actualizamos
			ultimoNodo=derecha;
		}
		// si al final si se cumplio alguno de los anteriores casos entonces ultimonodo seria diferente a la pos que se recibio
		//si se cambio esto entonces se va a tener que hacer el swap en el array 
		if(ultimoNodo==pos) {
			return;
		}
		swap(pos, ultimoNodo);
		
		
	}
	// esta es la funcion que si contulle el heap
	private void heapify(E[] datos, int size) {
		// hacemos el primer nodo que se va a ultizar usando la formula como el anterior metodo
		int ultimoNodo=(size/2)-1;
		// recorremos desde la posicion 0 hasta la posicion del utlimo nodo 
		// esto lo vamos a hacer desde atras primero tomando el ultimo nodo, despues uno antes de ese , etc hasta llegar al ultimo nodo
		for(int i=ultimoNodo; i>=0; i++) {
			// y asi checamos con cada posicon con la heapify recursiva 
			heapifyRecursiva(datos,size,i);
		}
		
		
	}
	public void push(E dato) {
		if(this.size==this.heap.length) {
			// en este caso el arreglo ya esta lleno 
			E[] aux=(E[]) new Comparable[this.heap.length+20];
			for(int i=0; i<this.heap.length;i++) {
				aux[i]=this.heap[i];
			}
			this.heap=aux;
		}
		this.heap[this.size++]=dato;
		// tenemos que hacer swap si la arreglo deja de ser heap despues de incertar en nodo hasta que se vuelva a hacer heap
	
		this.size++;
		
	}
	public void swap(int pos1, int pos2) {
		E aux= this.heap[pos1];
		this.heap[pos1]=this.heap[pos2];
		this.heap[pos2]=aux;
	}
	// en esta eliminamos un dato
	// en esta ya que ya puse n como atributo usare el size del array,  pero se puedo sin eso 
	// sinceramente no entendi si solo teniamos que eliminar un dato, o si iba a eliminar un dato en especifico
	// para eliminar un dato en especifico tendria que hacer una funcion buscar y despues hacerlo asi que hare 2 pops y con la funcion buscar
	public E pop() {
		// logica: usamos el utlimo dato de la linked list y lo remplazamos por la cabeza
		//despues checamos si cumple  con las condiciones y vamos haciendo heapify 
		E ultimoElemento=this.heap[this.size-1];
		// usamos el root y lo remplazamos con el ultimo elemento
		E elementoBorrado=this.heap[0];
		this.heap[0]=ultimoElemento;
		this.size--;
		// y ahora checamos si se cumple
		heapify(this.heap,this.size);
		// y pues regresamos el elemento borrado
		return elementoBorrado;
		}
	public E pop(E dato) {
		E ultimoElemento=this.heap[this.size-1];
		// buscamos la posicion del dato 
		int pos=buscar(dato);
		// con la posicion entonces borramos en esa posicon 
		E elementoBorrado=this.heap[pos];
		this.heap[pos]=ultimoElemento;
		this.size--;
		heapify(this.heap,this.size);
		return elementoBorrado; 
	}
	
	// va a ser private por que usuario no tendria acesso al array 
	private int buscar(E dato) {
		for (int i=0; i<this.size; i++) {
			if(this.heap[i].equals(dato)) {
				return i;
				}
			} return -1; // regresa error
		}
	 public void printArray() 
	    { 
	        for (int i = 0; i < this.size; ++i) 
	            System.out.print(this.heap[i] + " "); 
	  
	        System.out.println(); 
	    } 
	  
	    // Driver Code 
	    public static void main(String args[]) 
	    { 
	        
	    } 
}
