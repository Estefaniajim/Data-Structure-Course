public class BusquedaBinariaRecursiva {
	// funcion de preparacion
	public static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,E valor) {
		//inicia la funcion usando datos del main
		return binarySearchRec(valores,0,valores.length,valor);
	}

	private static <E extends Comparable<E>> int binarySearchRec(E[ ] valores,int min,int max,E valor) {
		//condicion base
		if(max<min) {
			return -1;
		}
		int mid=(min+max)/2;
		if(valor.equals(valores[mid])) {
			return mid;
		} else if(valor.compareTo(valores[mid])>0) {
			return binarySearchRec(valores,mid+1,max,valor);
			}else {
				return binarySearchRec(valores,min,mid-1,valor);
			}
	}
	public static void main(String[] args) {
		Integer[] numeros= {10,15,19,31,33,35,50,53,63,75,79,90,100};
		int pos=binarySearchRec(numeros,75);
		if (pos==-1) {
			System.out.println("El numero no se encontro");
		}
		else {
			System.out.println("El numero se encuentra en la posicion "+ pos);
		}

}
}