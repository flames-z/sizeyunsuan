package team.zw.sizeyunsuan;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import sun.launcher.resources.launcher;

import java.util.Stack;

public class Standard {
	public static final Map<String, Integer> basic = new HashMap<String, Integer>();
	 static {
	    basic.put("-", 1);
        basic.put("+", 1);
	    basic.put("x", 2);
	    basic.put("÷", 2);
	    basic.put("(", 0);//在运算中  （）的优先级最高，但是此处因程序中需要 故设置为0
	   }
	
	public static String translation(String e) {
		Stack<String> operator = new Stack<String>();
		
		String newEx = "";

		String[] items = e.split(" ");
//		System.out.println(items[2].equals("("));
		
		

		
		for(int i = 0; i < items.length; i++) {
//			System.out.println(items[i]);
			//检验是否是运算符
			if(isOperator(items[i])) {
				
				if(operator.empty() == false) {
					while(basic.get(operator.peek()) >= basic.get(items[i])) {
						newEx = newEx + operator.pop() + " ";
						if(operator.empty()) break;

					
					}
					operator.push(items[i]);
					
					
				} else {
					operator.push(items[i]);
				}
			} else {
				
				if(items[i].equals(")")) {
					while(operator.peek().equals("(") != true) {
						newEx = newEx + operator.pop() + " ";
					}
					
					operator.pop();
				}
				else 
				if(items[i].equals("(")) {

					operator.push(items[i]);

				}
				else {
					newEx = newEx + items[i] + " ";
				}
				
			}
		}
		
		while(operator.empty() == false) {
			newEx = newEx + operator.pop() + " ";
		}
		
		operator = null;
		System.out.printf(newEx + "\n");
		return newEx;
	}
	
	
	public static boolean isOperator(String str) {
		String operators = "+-x÷";
		if(operators.indexOf(str) == -1) return false;
		else return true;
		
	}
	
	public static Fraction calculator(String e) {
		Stack<Fraction> operand = new Stack<Fraction>();
		String[] items = e.split(" ");
		
		for(int i = 0; i < items.length; i++) {
			if(isOperator(items[i])) {
				Fraction opb = operand.pop();
				Fraction opa = operand.pop();
				Fraction fraction = new Fraction();
				System.out.println(items[i]);
				switch (items[i]) {
				case "+":
					operand.push(fraction.add(opa, opb));
					break;
				case "-":
					if(fraction.sub(opa, opb).n == -1) {
						System.out.print("aaa");
						return fraction;
					}
					operand.push(fraction.sub(opa, opb));
					break;
				case "×":
					operand.push(fraction.mul(opa, opb));
					break;
				case "÷":
					operand.push(fraction.div(opa, opb));
					break;
				default:
					break;
				}
			} else {

				Fraction f = new Fraction();
				String[] str = items[i].split("'");
				f.n = Integer.parseInt(str[0]);
				f.ne = Integer.parseInt(str[1].split("/")[0]);
				f.deno = Integer.parseInt(str[1].split("/")[1]);
				
				operand.push(f);
			}
		}
		return operand.pop();
	}
	
	public static 
	
	public static void main(String[] args) throws IOException {
		String expression = "2'3/4 ÷ ( 2'0/0 - 4'0/0 ) + 1'5/7";
		String suffix = Standard.translation(expression);
		Fraction f = new Fraction();
		f = Standard.calculator(suffix);
		if(f.n == -1) {
			System.out.print("不合法");
		}
		System.out.print(f.n + "'" + f.ne + "/" + f.deno);
		
		
	}
	
}
