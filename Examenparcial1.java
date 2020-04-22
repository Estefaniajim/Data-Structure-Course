
public class Examenparcial1 extends MyListaEnlazada{
public boolean insertEnd(E element) {
	if(current.next != null) {
		insertEnd(element, current.next);
	}else {
		current.setNext(new myNodo<>(element));
	}
public void insertEnd(E element) {
	if(this.first==null) {
		first=new MyNodo<>(element);
	}else {
		insertEnd(element, this.first);
	}
}
public boolean remove(E valor) {
	if(this.first==null) {
		return false;
	} else if(this.first.valor.equals(valor)) {
		this.first=this.first.next;
		return true
	}else {
		MyNodo<E>  current.this.first;
		while(current.next!=null) {
			current.next=current.next.next;
			return true
		}
		current=current.next;
	}
	return false;
}
public class Recursion20200{
	public static <E extends Comparable<E>> int buscaUltimo(E[] valores, E valor){
		if(valores.length==0) {
			return -1;
		}else return buscaUltimo(valores, valor, 0);
		
	}
	public static <E extends Comparable <E>> int buscaUltimo(E[] valores, E valor, int pos) {
		if(pos==valores.length-1) {
			return valores[pos].equals(valores)?pos:-1;
		} else {
			int=res=buscaUltimo(valores, valor, pos+1);
			if(res>-1) {
				return res;
			} else {
				return valores[pos]element.equals(valor) ?pos:-1;
			}
		}
	}
}
}
}
