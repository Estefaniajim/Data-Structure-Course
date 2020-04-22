public class NReinas {
	//Si Reina 1(i,j) y Reina 2(k,l) se cumple *valor absoluto* (j-l)=(i-k)
	private int[] tablero;
	public NReinas(int n) {
		this.tablero=new int[n];
		for (int i=0;i<this.tablero.length;i++) {
			this.tablero[i]=-1;
		}
	}
	private void imprimirTablero() {
		for(int i=0;i<this.tablero.length;i++) {
			System.out.print(this.tablero[i]+ ",");
		}
		System.out.println();
	}
	//Valida que no haya reina en la fila ni en la diagonal y regresa True (funcion de validación)
	private boolean valida(int fila, int columna) {
		//revisa que no haya ninguna reina en la misma fila
		for(int i=0; i<columna;i++) {
			if(fila==this.tablero[i]) {
				return false;
			}
		}
		// revisa que no haya ninguna reina en diagonal
		for(int i=0;i<columna;i++) {
			if(Math.abs(fila-this.tablero[i])==Math.abs(columna-i)) {
				return false;
			}
		}
		return true;
	}
	//busca una solucion, haciendo backtracking
	private void busca(int columna) {
		for(int i=0;i<this.tablero.length;i++) {
			if(valida(i,columna)) {
				this.tablero[columna]=i;
				if(columna<this.tablero.length-1) {
					this.busca(columna+1);
				}else {
					this.imprimirTablero();
				}
			}
		}
	}
	//metodo de preparacion
	public void busca() {
		this.busca(0);
	}
	
	public static void main(String[] args) {
		NReinas nr=new NReinas(5);
		nr.busca();
		
	}

}
