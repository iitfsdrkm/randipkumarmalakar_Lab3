package in.randip;

import java.util.Stack;

public class CheckBalancingBrackets {

	static boolean findBalance(String input) {
		boolean rtnValue = false;

		// Below if block checks if uneven(odd number of) brackets are in the input
		if(input.length() %2 != 0) {
			return rtnValue;
		}


		Stack<Character> brackets = new Stack<>();

		for(int index=0; index < input.length(); index++) {
			//rtnValue = false;
			char readChar = input.charAt(index);

			if(readChar == '{' || readChar == '[' || readChar == '(') {

				brackets.push(readChar);
				continue;
			}

			if(brackets.isEmpty()) {
				rtnValue = false;
				break;
			}

			if(readChar == '}') {
				char popChar = brackets.pop();
				if(popChar == '{') {
					rtnValue = true;
				}
				else {
					rtnValue = false;
					break;
				}
			}

			if(readChar == ']') {
				char popChar = brackets.pop();
				if(popChar == '[') {
					rtnValue = true;
				}
				else {
					rtnValue = false;
					break;
				}
			}

			if(readChar == ')') {
				char popChar = brackets.pop();
				if(popChar == '(') {
					rtnValue = true;
				}
				else {
					rtnValue = false;
					break;
				}


			}



		}

		return rtnValue;
	}

	public static void main(String[] args) {

		String expression = "([[{}]])";
		//String expression = "([[{}]])[]";
		//String expression = "([[{}]]))";

		if(findBalance(expression)) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}


	}

}

