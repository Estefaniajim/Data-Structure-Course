public class Piramide {
	public static void piramide(int n) {
		pintarPiramide(n , 0);
	}
	public static void pintarPiramide(int e, int s) {
		if (e != 0) {
			String estrellas="";
			String espacios="";
			for(int i = 0; i < e; i++) {
				estrellas += " * ";
			}
			for(int i = 0; i < s; i++) {
				espacios += " ";
			}
			
			System.out.println(espacios+estrellas+espacios);
			pintarPiramide(e-1,s+1);
		}
	}
	
	public static void main(String[] args) {
		piramide(6);
	}
}
