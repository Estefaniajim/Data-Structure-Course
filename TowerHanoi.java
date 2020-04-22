import java.util.Scanner;

public class TowerHanoi {
	public static int hanoi(int n) {
		if (n==1) {
			return 1;
		}
		return 2*(hanoi(n-1))+1;
	}
	public static void main(String[] args) {
		Scanner leer= new Scanner(System.in);
		System.out.println("Ingrese el numero");
		int n=leer.nextInt();
		System.out.println(hanoi(n));
	}
}
