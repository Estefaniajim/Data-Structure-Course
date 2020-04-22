import java.util.Iterator;
import java.util.LinkedList;



public class HashTable<K,V> {
	private int size;
	private final static double LOADFACTOR=0.75; // minetras mas elementos hayan entonces cada entrada seria bastante tardado
	// para disminuir collisiones, checa que al menos el 25% de la hast table esta vacia
	// vamos a utilizar un arreglo de listas que van a guardar hash tables
	private LinkedList<NodoHT<K,V>>[] tabla;
	public HashTable(int length) {
		this.tabla=(LinkedList<NodoHT<K,V>>[])  new LinkedList[length];
		for(int i=0; i<this.tabla.length;i++) {
			this.tabla[i]=new LinkedList<NodoHT<K,V>>();
		}
		this.size=0;
	}
	public HashTable() {
		this(11);
	}
	public void put(K llave, V valor) {
		
		int pos=llave.hashCode()%this.tabla.length;
		this.tabla[pos].addFirst(new NodoHT(llave, valor));
		this.size++;
		if(((double)this.size)/this.tabla.length > HashTable.LOADFACTOR) {
			
		}
	}
	public V get(K llave) {
		int pos= Math.abs(llave.hashCode()%this.tabla.length);
		for(NodoHT<K,V> nodo:this.tabla[pos]) {
			if(nodo.llave.equals(llave)) {
				return nodo.valor;
			}
		}return null;
	}
	// hashing
	private void rehashing() {
		HashTable<K,V> ht= new HashTable<>(2*this.tabla.length+1);
		for(LinkedList<NodoHT<K,V>> lista : this.tabla) { // con esta te da la tabla de la lista
			for(NodoHT<K,V> elemento: lista) { // en la lista te da cada elemento
				ht.put(elemento.llave, elemento.valor);// se agrega cada valor ala nueva lista
			}
		}
		this.tabla=ht.tabla;// se elimina la tabla
		System.gc();
	}
	// borrar
	public V delete(K llave) {
		int pos=Math.abs(llave.hashCode()%this.tabla.length);
		Iterator<NodoHT<K,V>> it=this.tabla[pos].iterator(); //itera de manera eficiente la lista
		NodoHT<K,V> current; 
		while(it.hasNext()) {//minetras tenga next regresa true
			current=it.next();// con next agarras el siguiente 
			if(llave.equals(current.llave)) {
				//borrar el elemento 
				it.remove(); //borra el ultimo elemento que se regreso despues del next
				this.size--;
				return current.valor;
			}
		}
		return null;
	}
	// borrar la tabla
	public void flush() {
		this.tabla=(LinkedList<NodoHT<K,V>>[]) new LinkedList[11];
		this.size=0;
	}
	// is empty 
	public boolean isEmpty() {
		return this.size==0;
	}
	// contains a key 
	public boolean containsKey(K llave) {
		//return this.get(llave)!=null;
		int pos=Math.abs(llave.hashCode()% this.tabla.length); //sacamos la posicion de la llave 
		for(NodoHT<K,V> nodo:this.tabla[pos])// chechamos si current tiene un next 
			if( nodo.llave.equals(llave)) {
				return true;
			}
		return false; // si no se encontro se regresa false
	}
	
	// hashing
	public 
	
	public static void main(String[] args) {
		HashTable<String, Integer> tabla=new HashTable<>();
		tabla.put("uno", 1);
		tabla.put("dos", 2);
		tabla.put("tres", 3);
		tabla.put("cuatro", 4);
		tabla.put("cinco", 5);
		tabla.put("seis",6 );
		tabla.put("siete", 7);
		tabla.put("ocho",8 );
		tabla.put("nueve", 9);
		tabla.put("dies", 10);
		tabla.put("once", 11);
		tabla.get("uno");
		tabla.delete("cinco");
		
		}
}
class NodoHT<K,V>{
	// la llave y el valor pueden ser cosas distintas
	K llave;
	V valor;
	
	public NodoHT(K llave, V valor) {
		this.llave=llave;
		this.valor=valor;
	}
}
