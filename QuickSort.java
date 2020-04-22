public class QuickSort {
	private static  <E extends Comparable<E>> void quicksort(E[] datos, int left, int right) {
		if(left<right) {
			int p=particionar(datos, left, right);
			quicksort(datos, left, p-1);
			quicksort(datos, p+1, right);
		}
	}
	private static  <E extends Comparable<E>> int particionar(E[] datos, int left, int right) {
		E pivote=datos[right];
		int i=(left-1);
		for (int j=left; j<right; j++) {
			if(datos[j].compareTo(pivote)<0) {
				i++;
				E a=datos[i];
				datos[i]=datos[j];
				datos[j]=a;
			}
		}
		E a=datos[i+1];
		datos[i+1]=datos[right];
		datos[right]=a;
		return i+1;
	}
	public static  <E extends Comparable<E>>  void imprimirLista2(E[] datos) {
		int n=datos.length;
		for(int i=0; i<n; i++) {
			System.out.println(datos[i]+ " ");
		}
		System.out.println("");
		
	}
	public static void main(String[] args) {
		Integer[] numeros= {100,200,50,20, 638494, 19,-2};
		int ini=0;
		int fin=numeros.length-1;
		quicksort(numeros,ini, fin);
		imprimirLista2(numeros);
	
	}
	

}
