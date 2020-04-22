// Autor: A01635062 Estefania Jimenez Garcia 
// Clases: MyListaEnlazada.java y MyNodo.java
// Fecha: 14 de Enero del 2020
import java.util.NoSuchElementException;

public class MyListaEnlazada <E>{
	protected MyNodo<E> first,
					  last;
	private int size;
	public MyListaEnlazada() {
		this.first=this.last=null;
		this.size=0;
	}
	public int size() {
		return this.size;
	}
	public MyListaEnlazada(E[] datos) {
		// creamos un nodo temp
		MyNodo <E> temp= null;
		// usamos for para iterar datos
		for(int i=0; i<datos.length; i++) {
			// agregamos en i=0 como el primer nodo
			if(i==0) {
				this.first= new MyNodo<E> (datos[i]);
				// y ahora hacemos que el temp ahora es el primer nodo 
				temp= this.first;
				// y sumamos al tamaño
				this.size++;
			}else if(i==datos.length-1) { // si entonces i es igual que la posicion del ultimo entonces se agrega como last
				this.last = new MyNodo<E> (datos[i]);
				// ahora se linkea el ultimo 
				temp.setNext(last);
				// y sumamos al tamaño
				this.size++;
			}else {
				// se crea un nodo nuevo
				MyNodo<E> nvo= new MyNodo<E>(datos[i]);
				// se linkea el nodo temporal  a este nuevo nodo
				temp.setNext(nvo);
				// y ahora hacemos que el neuvo sea ek temporal
				temp=nvo;
				// y agregamos el tamaño
				this.size++;
			}
		}
	}
	public void flush() {
		this.first=this.last;
		this.size=0;
		System.gc();
	}
	public void desplazarLista(int pos) {
		// desplazar pos lugares hacia la izquierda
		for(int i=0; i<pos;i++) {
			this.insertLast(this.removeFirst());
		}
	}
	public void desplazarListaIzquierda(int pos) { 
		MyNodo<E> current=this.first,
				current2;
		for(int i=0; i<pos-1; i++) {
			current=current.getNext();
		}
		current2=current.getNext();
		current.setNext(null);
		this.last.setNext(this.first);
		this.first=current2;
		this.last=current;
		
	}
	public boolean isEmpty() {
		return this.first==null;
	}
	
	 public void insertFirst(E valor) {
		 MyNodo<E> nvo= new MyNodo<> (valor,this.first);
		 if(isEmpty()) {
			 this.last=nvo;
		 }
		 first=nvo;
		 this.size++;
	 }
	 public void insertLast(E valor) {
		 if(isEmpty()) {
			 this.insertFirst(valor);
			 
		 }else {
			 MyNodo<E> nvo= new MyNodo<> (valor);
			 this.last.setNext(nvo);//this.last.next=nvo
			 this.last=nvo;
			 this.size++;
		 }
	 }
	 public E first() {
		 return this.first.getValor();
	 }
	 public E last() {
		 return this.last.getValor();
	 }
	 public String toString() {
	// regresa los elementos que contienen la lista separados con una coma
		 String res="";
		 MyNodo<E> current=this.first;
		 while(current!=null) {
			 res+=current.getValor()+",";
			 current=current.getNext();
		 }
		 return res;
	 }
	 public E removeFirst() {
		 if(!isEmpty()) {
			 E tmp=this.first.getValor();// E tmp=this.first.valor;
			 this.first=this.first.getNext();// this.first=this.first.next
			 this.size--;
			 return tmp; 
		 }else {
			 throw new NoSuchElementException("No se puede hacer un remove de una lista vacia");
		 }
		//try{
		 //E tmp=this.first.getValor();// E tmp=this.first.valor;
		 //this.first=this.first.getNext();// this.first=this.first.next
		 //return tmp;
		//}catch(NullPointerException e){
		 //throw new NoSuchElementException("No se ouede remover de una lista vacia");
		//}catch(IndexOutOfBondException e){

	}
		public E removeLast() throws NoSuchElementException {
			try {
			if(this.size<=1) {
				return this.removeFirst();
			}else {
			E dato=this.last.getValor();
			MyNodo<E> current=this.first;
			for(int i=0; i<this.size-1; i++) {
				current=current.getNext();
			}
			current.setNext(null);
			this.last=current;
			this.size--;
			return dato;
			}
			}
			catch(NoSuchElementException ex) {
				throw new NoSuchElementException("No se peude borrar el ultimo dato de la lista");
			}
		}
	// Tarea
	// desde aqui se inicia la tarea del dia 14 de Enero 
	public void insertAt(E valor, int pos) {
		if (pos==0) {// si el valor es 0 entonces sera le primer nodo
			insertFirst(valor);
			
		}else if (pos==this.size+1) {// si el valor es igual al tamaño de la lista entonces cera el ultimo
			insertLast(valor);
		}else {
			// creamos un nodo temproral
			MyNodo <E> temp=this.first;
			// creamos el nuevo nodo
			MyNodo <E> nvo= new MyNodo<> (valor);
			// iteramos la listos para llegar a la pos deseada mientars checamos que tmep next no llegue a null
			for(int i=0; i<pos-1 && temp.getNext()!=null ; i++) {
				// hacemos que temp llege a una posicion antes de pos
				temp=temp.getNext();
			}
			// temp llego a ser una posicion antes
			// cambiamos el next the nvo y lo hacemos que sea el next de temp
			nvo.setNext(temp.getNext());
			// cmabiamos el next the temp
			temp.setNext(nvo);
			// y agregamos un nodo mas en el tamaño
			this.size++;
		}
	}
	public E RemoveAt(int pos) throws IndexOutOfBoundsException{
		// Esto lo agrege por si pos es menor que 0 lo cual no es posible o si pos es mayor que el tamaño de la linked list, lo cual tampco es posible
		if(pos<0 || pos>=this.size) {
			// envia un error indicando el tamaño de la lista y la posicionq ue se quiere agregar
			throw new IndexOutOfBoundsException("No se puede borrar el dato en la lista en la posicon"+ pos + "la lista tiene un tamaño de"+ this.size);
		}
		// se checa si pos es igual a 0, si es asi entonces seria agregar el primer elemento a la lista (o a la primera posicion)
		else if(pos==0) {
			// y se manda a llamr la perpectiva funcion que hace esto
			return removeFirst();
		}
		// se checha si la pos es la ultima posicion de la lista, ya que seria agregarlo al final
		else if(pos==this.size-1) {
			return this.removeLast();
		}
		else {
			// si no es ninguno de los casos anteriores entonces
			// se crea una variable E que es para agarrar el daot que se va a borrar 
			E dato;
			// y  se crea un nodo temporal que es igual que el primer nodo para ir iterando en la linked list usando temp
			MyNodo<E> temp=this.first;
			for(int i=0; i<pos-1;i++) {
				// se itera hasta una posicion antes de pos 
				temp=temp.getNext();
			}
			// se agarra el dato del next de pos ya que es el nodo que se va a borrar
			dato=temp.getNext().getValor();
			// haces que el next de temp ahora sea el next next lo cual elimina la conexion entre temp y temp next
			temp.setNext(temp.getNext().getNext());
			// y reduces el tamaño
			this.size--;
			// por ultimo se regresa el dato que borraste
			return dato;	
		}
	}
	public void seatAt(int pos, E valor) {
		// Esto lo agrege por si pos es menor que 0 lo cual no es posible o si pos es mayor que el tamaño de la linked list, lo cual tampco es posible
		if(pos<0 || pos>=this.size) {
			throw new IndexOutOfBoundsException("Insertar en la posicion" + pos + "en una lista de tamaño" + this.size);
		}else if(pos==this.size-1) {
	// el primer paso es checar si pos no es la ultima posicion lo cual seria agregarlo hasta el final
			this.last.setValor(valor);
		}else if(pos==0) {
	// luego se checa si el valor no es igual a  0 que seria remplazar el dato del primer nodo
			this.first.setValor(valor);
		}else {
			// creamos un nodo temporal para recorrer la lista con esta y va a ser el primero nodo
			MyNodo<E> temp=this.first;
			// con el for iteramos
			for(int i=0;i<pos;i++) {
				temp=temp.getNext();
			}
			// ya que tenemos a temp siendo  la posicion que queremos
			// le damos al temp el valor que queremos
			temp.setValor(valor);
		}
	}
	public E getAt(int pos) {
		//checamos si pos es igual a 0
		if(pos==0) {// si es 0 entonces es el primer dato de la linked list y regresamos el dato del primer nodo
			return this.first.getValor();
			}else if(pos==this.size-1) { // checar si es el ultimo nodo y si es se regresa el dato del ultimo dato
				return this.last.getValor();
			}else {
				// creamos un nodo temp
				MyNodo<E> temp= this.first;
				// usamos for para iterar con i 
				for(int i=0; i<pos;i++) {
					temp=temp.getNext();
				}
				// ahora que temp es el nodo en pos regresamos el dato de temp
				return temp.getValor();
			}
		
		
	}
	 public static void main(String[] args) {
		 // parametrizar una lista de integer
		 MyListaEnlazada<Integer> lista=new MyListaEnlazada <>();
		 for(int i=1; i<21; i++) {
			 lista.insertLast(i*2);
		 }
		 System.out.println(lista);
		 lista.removeFirst();
		 System.out.println(lista);
		 lista.desplazarLista(2);
		 System.out.println(lista);
		 lista.insertAt(3, 1);
		 System.out.println(lista);
		
	 }
}
class MyNodo<E>{
	private E valor;
	private MyNodo<E> next;
	public MyNodo(E valor, MyNodo<E> next) {
		this.valor = valor;
		this.next = next;
	}
	public MyNodo(E valor) {
		this(valor,null);
	}
	public E getValor() {
		return valor;
	}
	public MyNodo<E> getNext() {
		return next;
	}
	public void setValor(E valor) {
		this.valor = valor;
	}
	public void setNext(MyNodo<E> next) {
		this.next = next;
	}
	public String toString() {
		return this.valor.toString();
	}
}
