package team.zw.sizeyunsuan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sizeyunsuan {
	public static void main(String[] args) {
		while(true) {
			System.out.println("\n--------------------伍欣怡&钟秋爽 结对程序----------------------");
	        System.out.println("                                                           ");
	        System.out.println("            -n 题目个数                ");
	        System.out.println("            -r 题目中数值（自然数、真分数和真分数分母）的范围                ");
	        System.out.println("                                                           ");
	        System.out.println("        例：-n 10       -e Key.txt              ");
	        System.out.println("        -r 10       -a Answers.txt              ");
	        System.out.println("-------------------------------------------------------------");
	        
	        System.out.println("请选择操作：1. 生成题目     2. 检查答案");
	        Scanner command = new Scanner(System.in);
	        
	        String op = command.nextLine();
	        if(op.equals("1")) {
	        	System.out.println("请输入命令： ");
	        	long start=System.currentTimeMillis();
		        String titleNum = command.nextLine().split(" ")[1];
		        String numRange = command.nextLine().split(" ")[1];
		        
		        System.out.println(titleNum);
		        System.out.println(numRange);
		     
		    	int n =  Integer.valueOf(titleNum).intValue();

		    	FileProcessor f = new FileProcessor();
		    	
		    	int range =  Integer.valueOf(numRange).intValue();
		    	Generate g = new Generate(range);
		    	int i = 1;	
		    		while(n!=0) {
		    			String e = g.expression();
		    			//System.out.println("e = " + e + "\n");
		    			Standard s = new Standard();
		    			Fraction ff = new Fraction();
		    			ff = s.calculator(s.translation(e));
		    			if(ff.n == -1) continue;
		    			String fs = ff.n +"'" +  ff.ne + "/"+ ff.deno ;
		    			fs = i + ". " + g.shuchu(fs) ;
		    			String ex = i + ". "+ g.shuchu(e) ;
		    			System.out.println(ex);
		    			f.writeFileContent(ex, "D://sizeyunsuan//Exercise.txt");
		    			f.writeFileContent(fs, "D://sizeyunsuan//Key.txt");
		    			i++;
		    			n--;	
		    		}
		    		System.out.println("执行时间："+(System.currentTimeMillis()-start)+"ms");
	        } else if(op.equals("2")) {
	        	
//	    		System.out.println("请将答案写入Answers.txt文件");
	    		System.out.println("请输入要比对的两个文件路径： ");
	    		String keyPath = command.nextLine().split(" ")[1];
			    String answerPath = command.nextLine().split(" ")[1];
	    		
			    Queue<String> keys = new LinkedList<String>();
			    Queue<String> answers = new LinkedList<String>();
			    
//			    FileProcessor f = new FileProcessor();
			    keys = FileProcessor.readFile(keyPath);
			    answers = FileProcessor.readFile(answerPath);
			    int i = 1;
			    int countC = 0;
			    int countW = 0;
			    String correct = "Correct(";
			    String wrong = "Wrong(";
			    
			    while(!answers.isEmpty()) {
			    	String key = keys.poll().toString();
			    	String answer = answers.poll().toString();
			    	if(key.equals(answer)) {
			    		if(countC != 0) {
				    		correct = correct + " ,";
				    	}
			    		correct = correct + i;
			    		countC++;
			    	} else {
			    		if(countW != 0) {
				    		wrong = wrong + " ,";
				    	}
			    		wrong = wrong + i;
			    		countW++;
			    	}
			    	i++;
			    }
			    
			    correct = correct + ")";
			    wrong = wrong + ")";
			    
//			    String result = correct + "\n" + wrong + "\n" + "正确数量：" + countC + "\n" + "错误数量：" + countW;
			    
			    FileProcessor.writeFileContent(correct, "Grade.txt");
			    FileProcessor.writeFileContent(wrong, "Grade.txt");
			    FileProcessor.writeFileContent("正确数量：" + countC, "Grade.txt");
			    FileProcessor.writeFileContent("错误数量：" + countW, "Grade.txt");

	    		
	    		
	        } else {
	        	System.out.println("命令输入有误，请重新输入命令 ");
	        	continue;
	        }
	        
	    		
		}		
	}
	
}
