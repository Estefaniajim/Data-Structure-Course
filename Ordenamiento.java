
public class Ordenamiento{
	//BUBBLE SORT 
	// es void por que no regresa nada, por que solo ordena el array
	public static  <E extends Comparable<E>> void bubbleSort(E[] numeros) {
		boolean desordenado=true;
		for (int i=0; i<numeros.length-1 && desordenado; i++) {
			desordenado=false;
			for(int j=0; j<numeros.length-1; j++) {
				if(numeros[j].compareTo(numeros[j+1])>0) {// compare to
					swap(numeros, j, j+1);
					desordenado=true;
					
				}
			}
		}
	}
	public static  <E extends Comparable<E>> void swap(E[] valores, int i, int j) {
		E aux=valores[j];
		valores[j]=valores[i];
		valores[i]=aux;
	}
	public static <E extends Comparable<E>> void imprimeArreglo(E[] valores) {
		for(E valor: valores) {
			System.out.println(valor+"");
		}
		System.out.println();
	}
	// Merge sort
	public static <E extends Comparable<E>> void merge(E[] datos,int ini, int mid, int fin) {
			int n1= mid-ini+1;
			int n2= fin-mid;
			// creamos unos arrays temporales
			E[] tempini= (E[]) new Comparable[n1];
			E[] tempfin= (E[]) new Comparable[n2];
			// cpiamos los datos para los arrays temporales
			for (int i=0; i<n1; i++) {
				tempini[i]=datos[ini+i];
			}
			for (int j=0; j<n2; j++){
				tempfin[j]=datos[mid+j+1];
			}
			// creamos indices
			int i=0;
			int j=0;
			int k=ini;

			while (i<n1 && j<n2) {
				if(tempini[i].compareTo(tempfin[j])<0) {
					datos[k]=tempini[i];
					i++;
				}
				else{
					datos[k]=tempfin[j];
					j++;
		
				}
				k++;
			}
			while(i <n1) {
				datos[k]=tempini[i];
				k++;
				i++;
			}
			while(j<n2) {
				datos[k]=tempfin[j];
				k++;
				j++;
				
			}
		}
		private static <E extends Comparable<E>> void mergesort(E[] datos, int ini, int fin) {
			int mid;
			if (ini<fin) {
				mid=(ini+fin)/2;
				mergesort(datos, ini, mid);
				mergesort(datos, mid+1, fin);
				merge(datos,ini, mid, fin);
			}
		}
		public static <E extends Comparable<E>> void imprimeLista(E[] datos) {
			int n=datos.length;
			for(int i=0; i<n; i++) {
				System.out.println(datos[i]+ " ");
			}
			System.out.println();
		}
	
	
	//Quicksort
		private static  <E extends Comparable<E>> void quicksort(E[] datos, int left, int right) {
			if(left<right) {
				int p=particionar(datos, left, right);
				quicksort(datos, left, p-1);
				quicksort(datos, p+1, right);
			}
		}
		private static  <E extends Comparable<E>> int particionar(E[] datos, int left, int right) {
			// inicie el pivote al final
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
		// DARTOS USADOS PARA BUBBLESORT, MERGESORT Y QUICKSORT
		Integer[] numeros= {100,200,50,20, 638494, 19,-2};
		int ini=0;
		int fin=numeros.length-1;
		bubbleSort(numeros);
		System.out.println("BubbleSort");
		imprimeArreglo(numeros);
		mergesort(numeros, ini, fin);
		System.out.println("MergeSort");
		imprimeLista(numeros);
		quicksort(numeros,ini, fin);
		System.out.println("QuickSort");
		imprimirLista2(numeros);
		}
		
	}
