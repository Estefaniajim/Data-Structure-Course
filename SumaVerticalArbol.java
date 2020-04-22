//
import java.util.Enumeration;
import java.util.Hashtable;
public class SumaVerticalArbol {
	static HashTable<Integer, Integer> ht = new HashTable<>();
	
	public static void sumaVerticalArbol(MyABB<Integer> abb) {
		sumaVerticaArbol(abb.getRaiz(),0);
		Enumeration<Integer> llaves=ht.keys();
		Integer llaveActual;
		while(llaves.hasMoreElements()) {
			llaveActual=llaves.nextElement();
			System.out.print(llaveActual+ ":" + ht.get(llaveActual)+ ", ");
			
		}
		System.out.println();
		
	}
	private static void sumaVerticaArbol(NodoABB<Integer> current, int nivel) {
		if(current!=null) {
			if(!ht.containsKey(nivel)){
				ht.put(nivel, current.data);
					
				}else {
					Integer valor=ht.get(nivel);
					ht.put(nivel, valor+current.data);
	
			}
			sumaVerticaArbol(current.left, nivel-1);
			sumaVerticaArbol(current.right, nivel+1);
		}
		
	}

}
