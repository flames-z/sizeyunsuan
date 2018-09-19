package team.zw.sizeyunsuan;

import java.util.Scanner;

public class Sizeyunsuan {
	public static void main(String[] args) {
//		while(true) {
			System.out.println("\n--------------------伍欣怡&钟秋爽 结对程序----------------------");
	        System.out.println("                                                           ");
	        System.out.println("            -n 题目个数                ");
	        System.out.println("            -r 题目中数值（自然数、真分数和真分数分母）的范围                ");
	        System.out.println("                                                           ");
	        System.out.println("        例：-n 10 -r 10                     ");
	        System.out.println("-------------------------------------------------------------");
	        
	        System.out.println("请输入命令： ");
	        Scanner command = new Scanner(System.in);
	        
	        String titleNum = command.nextLine().split(" ")[1];
	        String numRange = command.nextLine().split(" ")[1];
	        
	        System.out.println(titleNum);
	        System.out.println(numRange);
	        
//		}
	}
}
