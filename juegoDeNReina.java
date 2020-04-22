public class juegoDeNReina {
	private int[] reinas;
	public juegoDeNReina(int n) {
		this.reinas=new int[n];
		// inicias la posiciones de la reina en -1 para no 
		// confundirnos entre si la reina esta en posicion en 0 por que asi se inicio o por que se coloco ahi
		for(int i=0; i<n;i++) {
			this.reinas[i]=-1;
		}
	}
	public boolean valida(int fila, int columna) {
		// revisa las filas anteriores para validar que las reinas no se ataquen entre si
		// hay una formula
		// se va a deter una fila antes de la que va
		// va a checar 0,1,2,3,4
		for(int i=0; i<fila;i++) {
			if(this.reinas[i]==columna) {
				return false;
			}
		//aplicamos la formula
		if(Math.abs(fila-i)==Math.abs(columna-this.reinas[i])) {
			return false;
		}
			
	}
		return true;
	}
	public void imprimeTablero() {
		// por cada posicion que se itera que esta en reinas se guarda el numero
		for(int pos:this.reinas) {
			System.out.println(pos+",");
		}
		System.out.println();
	}
	private void busca(int fila) {
		for(int i=0;i<this.reinas.length;i++) {
			if(valida(fila,i)) {
				this.reinas[fila]=i;
				if (fila<this.reinas.length-1) {
					busca(fila+1);
				}else {
					imprimeTablero();
				}
			}
			
		}
	}
	public void busca() {// funcion de preparacion
		busca(0);
	}
	public static void main(String[] args) {
		juegoDeNReina reinas= new juegoDeNReina(5);
		reinas.busca();
	}
}
