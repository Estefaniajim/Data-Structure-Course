public class BusquedaBinaria {
	// funcion de preparacion
	public static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,E valor) {
		return binarySearchRec(valores,0,valores.length,valor);
	}

	private static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,int min,int max,E valor) {
		while(min<=max) {
			int mid=(min+max)/2;
			if(valor.equals(valores[mid])) {
				return mid;
			} else if(valor.compareTo(valores[mid])>0) {
				binarySearchRec(valores,mid+1,max,valor);
				
			}else {
				binarySearchRec(valores,min,mid-1,valor);
			}
					
		}
		return -1;
	}
	public static void main(String[] args) {
		Integer[] numeros= {10,15,19,31,33,35,50,53,63,75,79,90,99};
		int pos=binarySearchRec(numeros,53);
		if (pos==-1) {
			System.out.println("El numero no se encontro");
		}
		else {
			System.out.println("El numero se encuentra en la posicion "+ pos);
		}

}
}