import java.util.NoSuchElementException;

import org.w3c.dom.Node;
public class ArbolBinario {
	Node root;
// agregar un nodo 
	private Node agregarRecursiva(Node current, int value) {
		// chechas si esta iniciada el arbol binario
		// si esta vacia entonces se crea un nodo y se hace el inicio del arbo binario
	    if (current == null) {
	        return new Node(value);
	    }
	 // si el arbol no esta vacia, entonces se checha si el valor que se quiere agregar es mayor
	 // entonces se agrega a la isquierda
	 // si no entonces se agrega a la derecha
	    if (value < current.value) {
	        current.left = agregarRecursiva(current.left, value);
	    } else if (value > current.value) {
	        current.right = agregarRecursiva(current.right, value);
	    } else {
	        // si el valor ya existe entonces se regresa
	        return current;
	    }
	 // se envia el valor agregado
	    return current;
	}
	public void add(int value) {
	    root = agregarRecursiva(root, value);
	}
	// buscar un elemento
	private boolean buscarValorRecursivo(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.value) {
	        return true;
	    } 
	    if (value < current.value){
	    	return buscarValorRecursivo(current.left, value);
	    }
	    else {
	    	return buscarValorRecursivo(current.right, value);
	    }
	}
	public boolean buscarValor(int value) {
	    return buscarValorRecursivo(root, value);
	}
	// Recorrer el arbol binario
	//preorden 
	//21, 13, 10,18,33,25,29,27,30,40
	public void preorden() {
		preorden(this.root);
	}
	public void preorden(Node current) {
		if (current!= null) {
			System.out.print(current.value+ ",");
			preorden(current.left);
			preorden(current.right);
		}

	}
	//inorden
	// 10,13,18,21,25,27,29,30,33,40
	public void inorden() {
		inorden(this.root);
	}
	public void inorden(Node current) {
		if(current!=null) {
			inorden(current.left);
			System.out.print(current.value);
			inorden(current.right);
		}
	}
	//postorden
	//10,18,13,27,30,29,25,40,33,21
	public void postorden() {
		postorden(this.root);
	}
	public void postorden(Node current) {
		if (current!= null) {
			postorden(current.left);
			postorden(current.right);
			System.out.print(current.value);
		}
	//nivel 1 arr.arriba iz-der
	//21,13,33,10,18,25,40,29,27,30

}
	// eliminar
	public int remove(int value) {
		try {
			Node current=this.root,
					parent=null;
			while(current.value!=(value)) {
				parent=current;
				if(value<current.value) {
					current=current.left;
				}
				else {
					current=current.right;
				}
			}
			if (current.left==null && current.right==null) {
				if (parent.left==current) {
					parent.left=null;
				}
				else {
					parent.right=null;
				}
				return current.getNodeValue();
				}
		}catch(NullPointerException ex) {
			throw new NoSuchElementException("No se encontro el valor "+ value+ " en el arbol binario");
}
	
class Node {
    int value;
    Node left;
    Node right;
 
    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}