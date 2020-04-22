import javax.swing.JOptionPane; 
public class BinarySearchRecursive {
	private static <E extends Comparable<E>> int binarySearchRecursive(E valor, E[] valores, int min, int max) {
		while(max>=min) {
		int mid=(max+min)/2;
		if(valor.equals(valores[mid])) {
			return mid;
		} else if(valor.compareTo(valores[mid])<0) {
			return binarySearchRecursive(valor, valores, min, mid-1);
			
		}else {
			return binarySearchRecursive(valor, valores,  mid+1, max);
		}
	}
	return -1;
	}
	
	public static void main(String[] args) {
		String[] nombres= {"ana", "carmen", "denise", "estefania"};
		String nombre=JOptionPane.showInputDialog("ingrese nombre");
		int pos= binarySearchRecursive(nombre, nombres,0, nombres.length-1);
		if (pos==-1) {
			System.out.println("El nombre no se encontro");
		}
		else {
			System.out.println("El nombre se encuentra en la posicion "+ pos);
		}
		
	}
}
