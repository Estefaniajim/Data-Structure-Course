
public class MergeSort{
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
	public static void main(String[] args) {
		Integer[] numeros= {100,200,50,20, 638494, 19,-2};
		int ini=0;
		int fin=numeros.length-1;
		mergesort(numeros, ini, fin);
		imprimeLista(numeros);
		
	}
	

}
