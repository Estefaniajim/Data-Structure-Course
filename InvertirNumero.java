
public class InvertirNumero {
	public static int invertirNumero(int num) {
		if(num<10) {
			return num;
		}else {
			return (num%10)+invertirNumero(num/10)*10;
		}
	}
	public static void main(String[] args) {
		System.out.print(invertirNumero(321));
	}
}
