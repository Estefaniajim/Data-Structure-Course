public class MiStack <E>{
	private MyListaEnlazada <E> stack;
	public MiStack() {
		this.stack=new MyListaEnlazada<>();
	}
	public E top() {
		return this.stack.first();
	}
	public void push(E valor) {
		this.stack.insertFirst(valor);
	}
	public E pop() {
		return this.stack.removeFirst();
	}
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	public int size() {
		return this.stack.size();
	}
	public void flush() {
		this.stack.flush();
	}
	public String toString() {
		return this.stack.toString();
	}
	public static void main(String[] args) {
		MiStack <Integer> pila= new MiStack<> ();
		for(int i=0; i<10; i++) {
			pila.push(i);
		}
		while (!pila.isEmpty()) {
			System.out.println(pila.pop());
		}
		
	}
}
