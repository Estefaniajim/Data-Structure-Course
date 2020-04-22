public class EjerciciosLinkedList<E> extends MyListaEnlazada<E> {
	public void eliminarNodosRepetidos() {
		// creamos un nodo el cual va a ser el que va a servir para comparar al resto de los nodos
		MyNodo<E> primero=this.first;
		while(primero.getNext()!=null) {
			MyNodo<E> segundo=primero;
			while(segundo!=null && primero.getValor().equals(segundo.getValor())) {
				segundo=segundo.getNext();
			}
			primero.setNext(segundo);
			primero=primero.getNext();

		}
	}
	public static void main(String[] args) {
		String[] numeros= {"a","a","a","b","c","c","c","d"};
		MyListaEnlazada<String> lista= new MyListaEnlazada<>(numeros);
		
		
		
		
	}

}
