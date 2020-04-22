
public class MyQueque<E> {
	MiListaEnlazada<E> lista;
	public MyQueque() {
		this.lista=new MiListaEnlazada<>();
	}
	public int size() {
		return this.lista.getSize();
	}
	public boolean isEmpty() {
		return this.lista.isEmpty();
	}
	// En una cola solo pudes insertar datos al final 
	// y por lo mismo solo puedes agarrar datos del inicio
	// enqueue siempre es insertar al final
	// y dequeue es remover el primero
	// por que asi la constante en vez de lineal
	public void enqueue (E valor) {
		this.lista.insertAtLast(valor);
	}
	public void dequeue() {
		this.lista.removeFirst();
	}
	public E next() {
		return this.lista.first();
	}
	public void flush() {
		this.lista= new MiListaEnlazada<>();
		System.gc();
		
		}
	}
	public static void main(String[] args) {
		MyQueque<String> cola= new MyQueque<>();
		cola.enqueue("JC");
		cola.enqueue("E");
		cola.enqueue("U");
		cola.enqueue("JL");
		cola.enqueue("JL");
		cola.enqueue("C");
		cola.enqueue("I");
		
		while(!cola.isEmpty()) {
			System.out.println(cola.dequeue());
		}
		
		
	}
	

}
