import java.util.Stack;

public class Seminar3 {

	//verifica daca un caracter reprezinta o paranteza deschisa
	public static boolean isOpen(char c) {

		if (c == '(' || c == '[' || c == '{') {
			return true;
		}
		return false;
	}

	//verifica daca un caracter reprezinta o paranteza inchisa
	public static boolean isClosed(char c) {
		if (c == ')' || c == ']' || c == '}') {
			return true;
		}
		return false;
	}

	//returneaza perechea unei parantereze inchise (paranteza deschisa corespunzatoare)
	public static char getClosedChar(char aChar) {
		if (aChar == ')') {
			return '(';
		}
		if (aChar == ']') {
			return '[';
		}
		if (aChar == '}') {
			return '{';
		}
		return 0;
	}

	public static void main(String[] args) {

		String paranteze = "(([]{()[]}))()";		
		System.out.println(isCorrect(paranteze));
		
	}

	//algoritmul de verificare
	public static boolean isCorrect(String str) {
		if (str.isEmpty() || str == null || isClosed(str.charAt(0)) || str.length() % 2 == 1) return false;
		Stack<Character> stack = new Stack();
		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (isOpen(currChar)) {
				stack.push(currChar);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (stack.pop() != getClosedChar(currChar)) {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}
}
