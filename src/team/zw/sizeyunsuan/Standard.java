package team.zw.sizeyunsuan;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import java.util.Stack;

public class Standard {
	private static final Map<String, Integer> basic = new HashMap<String, Integer>();
	 static {
	    basic.put("-", 1);
        basic.put("+", 1);
	    basic.put("x", 2);
	    basic.put("÷", 2);
	    basic.put("(", 0);//在运算中  （）的优先级最高，但是此处因程序中需要 故设置为0
	   }
	
	public static void translation(String e) {
		Stack<String> operator = new Stack<String>();
		
		String newEx = "";
		
		String operators = "+-x÷";
		String[] items = e.split(" ");
		System.out.println(items[2].equals("("));
		
		

		
		for(int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
			if(operators.indexOf(items[i]) != -1) {
				if(operator.empty() == false) {
					while(operator.empty() != true) {
						if(basic.get(operator.peek()) >= basic.get(items[i])) {
							newEx = newEx + operator.pop();
						}
					}
					operator.push(items[i]);
					
					
				} else {
					operator.push(items[i]);
				}
			} else {
				
				if(items[i].equals(")")) {
					System.out.println("aaa");
//					while(operator.peek().equals("(") != true) {
//						newEx = newEx + operator.pop();
//					}
//					
//					operator.pop();
				}
				else 
				if(items[i].equals("(")) {
//					System.out.println(operator.peek());
					operator.push(items[i]);
//					System.out.println(operator.peek());
				}
				else {
					newEx = newEx + items[i];
				}
				
			}
		}
		
		while(operator.empty() == false) {
			newEx = newEx + operator.pop();
		}
		
		operator = null;
		System.out.printf(newEx);
	}
	
	public static void main(String[] args) throws IOException {
		Standard.translation("8 ÷ ( 5 - 4 ) + 7");
	}
	
}
