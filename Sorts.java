public class Sorts {
	//buublesort
	public static <E extends Comparable<E>> void bubbleSort(E[] valores) {
		for(int i=0; i<valores.length-1;i++) {
			for(int j=0; j<valores.length-1;j++) {
				if(valores[j].compareTo(valores[j+1])>0){
					swap(valores, j, j+1);
				}
			}
		}
	}
	public static <E> void swap(E[] arreglo, int i, int j) {
		E temp=arreglo[i];
		arreglo[i]=arreglo[j];
		arreglo[j]=temp;
	}
	public static <E> void imprimirArreglo(E[] arreglo) {
		for (E tmp: arreglo) {
			System.out.print(tmp+",");
		}
		System.out.println();
	}
	//Merge Sort
	public static <E> void mergeSort(E[] arreglo) {
		mergesort(arreglo,0,arreglo.length-1);
	}
	public static <E> void mergesort(E[] arreglo, int inicio, int fin) {
		if(inicio<fin) {
			int central=(inicio+fin)/2;
			mergesort(arreglo, inicio, central);
			mergesort(arreglo, central+1,fin);
			mergesort(arreglo,inicio,fin);
		}
	}
	public static <E extends Comparable<E>> void mezcla(E[] arreglo, int ini, int fin) {
		//E[] arreglo=(E[])new ObjectE[10];
		E[] tmp=(E[]) new Comparable[fin-ini+1];
		int mid=(arreglo.length)/2;
		int n1=mid-ini+1;
		int n2=fin-mid;
		int j=ini,
			k=mid+1;
		for(int i=0; i<n1;i++) {
			tmp[i]=arreglo[mid+i+1];
		}
		if(arreglo[ini].compareTo(tmp[]))
		
	
		
	}
	// QuickSort
	private static <E extends Comparable <E>> void quicksort(E[] arreglo, int inicio, int fin) {
		if(inicio<fin) {
			int posPivote=particionar(arreglo, inicio, fin);
			quickSort();
		}
	}
			
	private static <E extends Comparable <E>> E particionar(E[] arreglo, int inicio, int fin){
		// regresa la posicion del pivote
		E pivote=arreglo[fin];
		E i=(inicio-1);
		for (int j=inicio; j<fin; j++) {
			if(arreglo[j].compareTo(pivote)<0) {
				i++;
				E a=arreglo[i];
				arreglo[i]=arreglo[j];
				arreglo[j]=a;
			}
		}
		E a=arreglo[i+1];
		arreglo[i+1]=arreglo[fin];
		arreglo[fin]=a;
		return i+1;
	}
		
	public static <E extends Comparable <E>> void swap(E[] arreglo, int inicio, int fin) {
		E pivote=particionar(arreglo, inicio,fin);
		for ( int i=0; i<arreglo.length-1; i++) {
			if(arreglo[i].compareTo(pivote)<0) {
				
			}
		}
		
	}
	
	public static <E extends Comparable<E>> void quicksort(E[] arreglo) {
		quicksort(arreglo, 0, arreglo.length-1);
	}
	}



