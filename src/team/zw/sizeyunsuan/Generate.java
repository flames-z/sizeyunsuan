package team.zw.sizeyunsuan;


public class Generate{
	int n,r;
	
	public Generate(int r) {
		this.r = r;
	}
	
	//随机出一个运算符
	String opch(){
		int n1 = (int)(Math.random()*4+1);
		if(n1==1)
			return " + ";
		else if (n1==2)
			return " - ";
		else if (n1==3)
			return " × ";
		else
			return " ÷ ";
	}
	public String expression(){
		
		int randd = (int)(Math.random()*3);

		if(randd==0){                                                         //一个运算符
			
			String str = getstring() + opch() + getstring();     
			return str;
			
			}
		
		else if (randd==1) {
			int a = (int)(Math.random()*3);
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
			
			int a = (int)(Math.random()*6);
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

	Fraction rand2() {
		int n1 =(int)(Math.random()*2);
		if(n1==0) {
			Fraction f1 = new Fraction();
			f1.n = (int) (Math.random()*r);
			f1.ne = 0;
			f1.deno = 0 ;
			return f1;
		}
		else {
			//随机这是一个大于1的分数，还是小于1
			if ((int)(Math.random()*2)==0) {                   //大于1
				
			Fraction f2 = new Fraction();
			f2.n = (int) (Math.random()*(r-1)+1);
			f2.deno = (int) (Math.random()*(r-2)+2);		//分母
			f2.ne = (int) (Math.random()*(f2.deno-1)+1);   //分子
			return f2;
			}
			else {                                          //小于1
				Fraction f3 = new Fraction();
				f3.n = 0;
				f3.deno = (int) (Math.random()*(r-2)+2);
				f3.ne = (int) (Math.random()*(f3.deno-1)+1);
				return f3;
				}
			}
	}
	
	String getstring() {
		
		Fraction f = rand2();
		return f.n+"'"+f.ne+"/"+f.deno;
	}

	String shuchu(String s) {
	String str1 = "0'";
	String str2 = "'0/0";
	String news = s.replace(str2, "");
	return news.replace(str1, "");
		
	}
	
}

