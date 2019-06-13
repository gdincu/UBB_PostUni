import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Expresie {

	public boolean checkOperator(char x){
		if(x=='+' ||x=='-'||x=='*' ||x=='/') return true;
		return false;
	}
	public boolean checkParOp(char x){
		if(x=='(') return true;
		return false;
	}
	public boolean checkParCl(char x){
		if(x==')') return true;
		return false;
	}
	
	public boolean arePrioritateMaiMareSauEgala(char op1, char op2) {
		if (op1 == '*' || op1 == '/') {
			return true;
		}
		if (op2 == '+' || op2 == '-') {
			return true;
		}
		return false;
	}
	
	public Queue<Character> transformare(String expresie) {
		Queue<Character> coada = new LinkedList<Character>();
		Stack<Character> stiva = new Stack<Character>();
		
		for (int i = 0; i < expresie.length(); i++) {
			char element = expresie.charAt(i);
			if (checkParOp(element)) {
				stiva.push(element);
			} else if (checkParCl(element)) {
				while (stiva.peek() != '(') {
					Character e = stiva.pop();
					coada.add(e);
					//coada.add(stiva.pop())
				}
				stiva.pop(); //sa stergem paranteza (
			} else if (checkOperator(element)) {
				//sa verificam daca stiva e vida
				//sa verificam daca avem paranteza
				//cat timp pe varful stivei avem operator cu prioritate mai 
				//mare sau egala...
				if (stiva.isEmpty() || checkParOp(stiva.peek())) {
					stiva.push(element);
				} else {
					while (stiva.isEmpty() == false  &&
							checkParOp(stiva.peek()) == false && 
							arePrioritateMaiMareSauEgala(stiva.peek(), element)) {
						Character e = stiva.pop();
						coada.add(e);
					}
					stiva.push(element);
				}				
			} else { // e numar
				coada.add(element);
			}
		}
		while (stiva.isEmpty() == false) {
			Character e = stiva.pop();
			coada.add(e);
		}		
		return coada;
	}
	
	public int operatie(Integer i1, Integer i2, Character op) {
		if (op.equals('+')) {
			return i1 + i2;
		} else if (op.equals('-')) {
			return i1 - i2;
		} else if (op.equals('*')) {
			return i1 * i2;
		} else {
			return i1 / i2;
		}
	}
	
	public int calculeaza(Queue<Character> coada) {
		Stack<Integer> stiva = new Stack<Integer>();
		while (coada.isEmpty() == false) {
			Character e = coada.remove();
			if (checkOperator(e) == false) {
				Integer nr = Integer.parseInt(e.toString());
				stiva.push(nr);
			} else {
				Integer e1 = stiva.pop();
				Integer e2 = stiva.pop();
				Integer result = operatie(e2, e1, e);
				stiva.push(result);
				
			}
		}
		Integer result = stiva.pop();
		return result;		
	}
	
	public static void main(String args[]) {
		
		Expresie a = new Expresie();
		Queue<Character> postfix = a.transformare("2*(1+2*(3-4/(5+6))+7)-5*(2+7)");
		Integer result = a.calculeaza(postfix);
		System.out.println("Rezultatul este: " + result);
		
		
	}
	
}
