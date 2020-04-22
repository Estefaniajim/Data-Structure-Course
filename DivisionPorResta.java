// funcion recursiva que hace division mediante resta
public class DivisionPorResta {
	public static int division(int a,int b) {
		if (a<b) {
			return 0;
		}else {
			return division(a-b,b)+1;
		}
	}
	public static void main(String[] args) {
		System.out.print(division(8,2));
	}
}
