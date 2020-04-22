import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;



public class MyABB<E extends Comparable<E>> {

	private NodoABB<E> raiz;
	private int size;

	public MyABB() {
		this.raiz=null;
		this.size = 0;

	}

	public void insert(E dato) {
		NodoABB<E> nvo = new NodoABB<>(dato);
		if (this.raiz() != null) {
			NodoABB<E> current = new NodoABB<>(dato);
			NodoABB<E> prev = null;

			current = this.raiz();
			while (current != null) {
				prev = current;
				current = dato.compareTo(current.data) < 0 ? current.left : current.right;
			}
			// Current esta en null y prev esta en quien sera el padre de dato.
			if (dato.compareTo(prev.data) < 0) {
				prev.left = nvo;
			} else {
				prev.right = nvo;
			}
		} else {
			this.raiz(nvo);
		}
		this.size++;
	}

	public E borrar(E dato) {
		NodoABB<E> current = this.getRaiz(), prev = null;

		boolean lado; // lado es true entonces el hijo esta del lado izquierdo sino esta del lado
						// derecho

		// buscando al nodo a borrar y al padre del nodo a borrar

		while (!dato.equals(current.data)) {

			prev = current;

			// current esta igualado a la condicion, si es verdadera toma el valor que esta
			// entre el ? y : y si es falso toma el ultimo valor

			current = dato.compareTo(current.data) < 0 ? current.left : current.right;
		}

		// current ya esta en el nodo a borrar y prev en el parent de current

		// revisar si current esta del lado izquierdo o derecho del padre

		lado = prev.left == current; // si es verdaero current es izq si no der

		// caso en el que el nodo a borrar es una hoja
		if (current.right == null && current.left == null) {
			if (lado) {
				prev.left = null;
			} else {
				prev.right = null;
			}

			// caso 2 solo tiene un hijo y es el izquierdo
		} else if (current.right == null) {
			if (lado) {
				prev.left = current.left;
			} else {
				prev.right = current.left;
			}

			// caso 2.5 solo tiene un hijo y es el derecho
		} else if (current.left == null) {
			if (lado) {
				prev.left = current.right;
			} else {
				prev.right = current.right;

			}
			// tiene dos hijos el nodo a eliminar
		} else {
			NodoABB<E> predecesor = predecesor(current);
			current.data = predecesor.data;
			if (current.left == predecesor) {
				predecesor = null;
			} else {
				E datin = borrar(predecesor.data);
				current.data = datin;
			} 
		}
		return current.data;

	}

	private NodoABB<E> predecesor(NodoABB<E> nodo) {
		NodoABB<E> current = nodo.left;
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}

	public E buscar(E dato){
		NodoABB<E> current = this.getRaiz();
		while(current != null) {
			if(dato.equals(current.data)) {
				return current.data;
			}else if(dato.compareTo(current.data) < 0) {
				current = current.left;
			}else {
				current = current.right;
			}
		}
		throw new NoSuchElementException(dato + "no se encontro en el arbol");
	}
	
	public void preorden() {
		
		preorden(this.getRaiz());
		System.out.println();
	}
	
	private void preorden(NodoABB<E> current) {
		if(current != null) {
			System.out.print(current.data + ",");
			preorden(current.left);
			preorden(current.right);
		}
		
	}
	
	public void inorden() {
		inorden(this.getRaiz());
		System.out.println();
	}
	
	public void inorden(NodoABB<E> current) {
		if(current != null) {			
			inorden(current.left);
			System.out.print(current.data + ",");
			inorden(current.right);
		}
	}
	
	public void postorden() {
		postorden(this.getRaiz());
		System.out.println();
	}
	
	public void postorden(NodoABB<E> current) {
		if(current != null) {			
			postorden(current.left);
			postorden(current.right);
			System.out.print(current.data + ",");
		}
	}
	public void nivel() {
		// no es recursivo
		// me auxilio de una cola.
	}
	
	public void amplitud() {
		amplitud(this.getRaiz());
	}
	
	public void amplitud(NodoABB<E>current) {
		if(current != null) {
			Queue<NodoABB<E>> fila = new LinkedList<NodoABB<E>>();
			Queue<NodoABB<E>> filaux = new LinkedList<NodoABB<E>>();
			fila.add(current);
			while(!fila.isEmpty()) {
				filaux.add(current = fila.poll());
				if(current.left != null) {
					fila.add(current.left);
				}if(current.right != null) {
					fila.add(current.right);
				}
			}
			System.out.println(filaux);
		}
		
	}
	public void primos(E valor) {
		Stack<NodoABB<E>> pila=new Stack<>();
		NodoABB<E> current=this.raiz;
		while(!current.data.equals(valor)) {
			pila.push(current);
			if(valor.compareTo(current.data)<0) {
				current=current.left;
			}else {
				current=current.right;
			}
		}
		pila.pop();
		NodoABB<E> abuelo=pila.pop();
		NodoABB<E> tio;
		if(valor.compareTo(abuelo.data)<0) {
			tio=abuelo.right;
			if(tio.left!=null) {
				System.out.println(tio.left.data);
			}
			if(tio.right!=null) {
				System.out.println(tio.right.data);
			}
		}else {
			tio=abuelo.left;
			if(tio.left!=null) {
				System.out.print(tio.left.data+",");
			}if(tio.right!=null) {
				System.out.print(tio.right.data);
			}
		}
	}
	public void invertirArborl() {
		this.invertirArborl(this.raiz);
	}
	public void invertirArborl(NodoABB<E> current) {
		if(current!=null) {
			invertirArborl(current.left);
			invertirArborl(current.right);
			NodoABB<E> temp=
		}
		
	}

	

	public static void main(String[] args) {

		MyABB<Integer> arbol = new MyABB<>();
		arbol.insert(21);
		arbol.insert(13);
		arbol.insert(33);
		arbol.insert(10);
		arbol.insert(18);
		arbol.insert(25);
		arbol.insert(40);
		arbol.insert(29);
		arbol.insert(27);
		arbol.insert(30);
		arbol.preorden();
		arbol.inorden();
		arbol.postorden();
		arbol.amplitud();
		System.out.println(arbol.buscar(21));
		System.out.println("Fin");
		//21,13,33,10,18,25,40
	}


}

class NodoABB<E> {
	E data;
	NodoABB<E> left, right;

	public NodoABB(E data, NodoABB<E> left, NodoABB<E> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public NodoABB(E data) {
		this(data, null, null);
	}

	public String toString() {
		return this.data.toString();
	}
}