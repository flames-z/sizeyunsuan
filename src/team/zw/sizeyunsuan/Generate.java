package team.zw.sizeyunsuan;

import java.util.Random;

public class Generate{
	int n,r;
	Random ra = new Random();	
	
	public Generate(int r) {
		this.r = r;
	}
	
	//随机出一个运算符
	String opch(){
		
		int a = ra.nextInt(4);
		if (a==0) {
			return " + ";
		}
		else if (a==1) {
			return " - ";
		}
		else if (a==2) {
			return " × ";
		}
		else  {
			return " ÷ ";
		}
	}
	public String expression(){
		
		int randd = ra.nextInt(2);

		if(randd==0){                                                         //一个运算符
			
			String str = getstring() + opch() + getstring();     
			return str;
			
			}
		
		else if (randd==1) {
			int a = ra.nextInt(4);
			String str0 =  getstring() + opch() + getstring() + opch() + getstring();
			String str1 = "( "+ getstring() + opch() + getstring() + " )" + opch() + getstring();
			String str2 = getstring() + opch() + "( " + getstring() + opch() + getstring() + " )";
			switch(a) {
			
			case(0):
			return str0;
			
			case(1):
			return str1;
				
			case(2):
			return str2;
			}
		}
		
		else {
			
			int a = ra.nextInt(6);
			String str0 = "( "+getstring() + opch() + getstring() + " )" + opch() + getstring() + opch() + getstring();
			String str1 = getstring() + opch() +"( "+ getstring() + opch() + getstring() + " )" + opch() + getstring();
			String str2 = getstring() + opch() + getstring() + opch() +"( "+ getstring() + opch() + getstring() + " )";
			String str3 = "( "+getstring() + opch() + getstring() + opch()  + getstring() + " )" + opch() + getstring();
			String str4 = getstring() + opch() +"( "+ getstring() + opch() + getstring() + opch() + getstring() + " )";
			String str5 = "( " + getstring() + opch() + getstring() + " )" + opch() + "( "+ getstring() + opch() + getstring() + " )";
			
			switch(a) {
			
			case(0):
			return str0;
			
			case(1):
			return str1;
				
			case(2):
			return str2;
			
			case(3):
			return str3;
			
			case(4):
			return str4;
			
			case(5):
			return str5;
			}
		}
	     
		//不知道为什么一定要有
		return "";
		
	}

	Fraction rand() {
		
		int a = ra.nextInt(5);
		Fraction f = new Fraction();
		if(a>0) {

			f.n = ra.nextInt(r);
			f.ne = 0;
			f.deno = 0 ;
			return f;
		}
		else {
			//随机这是一个大于1的分数，还是小于1
			if (ra.nextInt(2)==0) {                   //大于1
				
			f.n = ra.nextInt(r);
			f.deno = ra.nextInt(r-2)+2;		//分母
			f.ne = ra.nextInt(f.deno-1)+1;   //分子
			return f;
			}
			else {                                          //小于1
			
				f.n = 0;
				f.deno = ra.nextInt(r-2)+2;
				f.ne = ra.nextInt(f.deno-1)+1;
				return f;
				}
			}
	}
	
	String getstring() {
		
		Fraction f = rand();
		return f.n+"'"+f.ne+"/"+f.deno;
	}

	String shuchu(String s) {
	String str1 = "0'";
	String str2 = "'0/0";
	String news = s.replace(str2, "");
	return news.replace(str1, "");
		
	}
	
}

