//Estefania Jimenez Garcia A01635062
//Para convertir un numero decial a binario ocupas sacar el modulo del numero entre 2
// ese residuo va a ser el ultimo numero del numero a binario y seguir dividiendo el numero
// por lo cual primero sacas el modulo del numero y lo sumas a la string
// y usas recursion divididendo el numero entre 2 para sacar el siguiente numero y sumarselo a la string 
public class Base10a2 {
	public static String base10a2(int num) {
	String resultado="";
	//caso base 
	if (num==0) {
		return "0";
	}
	else {
		resultado +=num%2;
		return (base10a2(num/2)+ resultado);
	}
	}
	public static void  main(String[] args) {
		System.out.println(base10a2(1));
	}

}
