import java.util.Stack;

public class validasignos {
	public static void valid_paren(String input_str) {
		   // Declaring a stack
		   Stack<Character> s = new Stack<Character>();
		   // Iterating over the entire string.
		   for (char st : input_str.toCharArray()) {
		     //  If the input string contains an opening parenthesis,
		     //  push in on to the stack.
		     if (st == '(' || st == '{' || st == '[') {
		       s.push(st);
		     }
		     else {
		     // In the case of valid parentheses, the stack cannot be 
		     // be empty if a closing parenthesis is encountered.
		       if(s.empty()) {
		         System.out.println(input_str + 
		         " contains invalid parentheses.");
		         return;
		       }
		       // If the input string contains a closing bracket,
		       // then pop the corresponding opening parenthesis if
		       // present.
		       char top = (Character) s.peek();
		       if(st == ')' && top == '(' ||
		       st == '}' && top == '{' ||
		       st == ']' && top == '['){
		         s.pop();
		       }
		     }
		     }
		   //  Checking the status of the stack to determine the
		   //  validity of the string.
		   if(s.empty()) {
		     System.out.println(input_str + 
		     " contains valid parentheses.");
		   }
		   else{
		     System.out.println(input_str + 
		     " contains invalid parentheses.");
		   }
		 }
		 public static void main( String args[] ) {
		   String input_str1 = "{{}}()[()]";
		   String input_str2 = "(][)";
		   String input_str3 = ")";
		   valid_paren(input_str1);
		   valid_paren(input_str2);
		   valid_paren(input_str3);
		 }

}
