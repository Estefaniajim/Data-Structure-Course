import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MiHashTable<K,V> {
	private LinkedList<nodoHT<K,V>>[] tabla;
	private int size;
	private nodoHT<K,V> inicio;
	// load factor es relacion entre numero de datos y tamaño de arreglo
	// si tenemos un arreglo de 100 el maximo numero de datos es 75
	private static final double LOAD_FACTOR=0.75;

	
	public MiHashTable() {
		// tabla es una linked lista la cual nontiene en cada posicon 
		//otars linkedlist para agrgar varios valores y llaves
		this.tabla=(LinkedList<nodoHT<K,V>>[]) new LinkedList[11];
		// agregar listas enlazadas en cada posicion de la lista
		for(int i=0; i<this.tabla.length; i++) {
			this.tabla[i]= new LinkedList<>();
		}
		this.size=0;
	}
	// rehashing
	public void rehashing() {
		// cuando nos pasamos del tamaño entonces aumentamos el tamaño de hash table
		// creamos una tabla temporal 
		LinkedList<nodoHT<K,V>>[] tablatemp=this.tabla;
		// hacemos que tabal se haga una lista vacia con el doble del tamaño +1
		this.tabla=(LinkedList<nodoHT<K,V>>[]) new LinkedList[this.tabla.length*2+1];
		for(int i=0; i<this.tabla.length; i++) {
			this.tabla[i]= new LinkedList<>();
		}
		// agregamos llos valores de tabla temp a la nueva tabla
		for(int i=0; i<tablatemp.length;i++) {
			if(tablatemp[i].size()>0) {
				for(int j=0; j<tablatemp[i].size(); j++) {
					int pos= tablatemp[i].get(j).llave.hashCode()%this.tabla.length;
					this.tabla[pos] = tablatemp[i];
					
				}
			}
		}
	}
	
	// buscar
	public V get(K llave) {
		// calcular el indize de la llave
		int pos=llave.hashCode()%this.tabla.length;
		for(int i=0; i<this.tabla[pos].size();i++) {
			if(this.tabla[pos].get(i).llave.equals(llave)) {
				return this.tabla[pos].get(i).valor;
			}
		}
		throw new NoSuchElementException("No se encontro");
	}
	
	// insertar
	public void put(K llave, V valor) {
		// sacamos el index
		int index=llave.hashCode()%this.tabla.length;
		// agregamos la tabla en el index el nodo al final
		this.tabla[index].addLast(new nodoHT<>(llave,valor));
		this.size++;
		// verificamos si  no nos pasamos del tamaño de la hash
		if((double) this.size/this.tabla.length >MiHashTable.LOAD_FACTOR) {
			rehashing();
		}
		
		
	}
	// borrar
	public V delete(K llave) {
		// calculamos la posicion
		int pos=llave.hashCode()%this.tabla.length;
		for(int i=0; i<this.tabla[pos].size(); i++) {
			if(this.tabla[pos].get(i).llave.equals(llave)) {
				this.size--;
				return this.tabla[pos].remove(i).valor;
			}
		}
		throw new NoSuchElementException("No se encontro dato");
	}

}
class nodoHT<K,V>{
	K llave;
	V valor;
	
	public nodoHT(K llave, V valor) {
		this.llave=llave;
		this.valor=valor;
	}
	
}
