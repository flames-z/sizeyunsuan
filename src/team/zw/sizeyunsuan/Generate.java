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
			return "+";
		else if (n1==2)
			return "-";
		else if (n1==3)
			return "✖";
		else
			return "➗";
	}
	public String expression(){
		
		int randd = (int)(Math.random()*3);

		if(randd==0){                                                         //一个运算符
			
			String str = getstring()+"+"+getstring();     
			return str;
			
			}
		
		else if (randd==1) {
			int a = (int)(Math.random()*3);
			String str0 =  getstring() + opch() + getstring() + opch() + getstring();
			String str1 = " ("+ getstring() + opch() + getstring() + ")" + opch() + getstring();
			String str2 = getstring() + opch() + " (" + getstring() + opch() + getstring() + ")";
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
			
			int a = (int)(Math.random()*5);
			String str0 = " ("+getstring() + opch() + getstring() + ")" + opch() + getstring() + opch() + getstring();
			String str1 = getstring() + opch() +" ("+ getstring() + opch() + getstring() + ")" + opch() + getstring();
			String str2 = getstring() + opch() + getstring() + opch() +" ("+ getstring() + opch() + getstring() + ")";
			String str3 = " ("+getstring() + opch() + getstring() + opch()  + ")"+ getstring() + opch() + getstring();
			String str4 = getstring() + opch() +" ("+ getstring() + opch() + getstring() + opch() + getstring() + ")";
			
			switch(a) {
			
			case(0):
			return str0;
			
			case(1):
			return str1;
				
<<<<<<< HEAD
			Fraction f2 = new Fraction();
			f2.n = (int) (Math.random()*r);
			f2.ne = (int) (Math.random()*r);
			f2.deno = (int) (Math.random()*r);
			Fraction cal = new Fraction(f2);
			System.out.printf("%d'%d/%d",f2.n,f2.ne,f2.deno);
			}
			else {                                          //小于1
				Fraction f3 = new Fraction();
				f3.n = 0;
				f3.ne = (int) (Math.random()*r);
				f3.deno = (int) (Math.random()*r);
				Fraction cal = new Fraction(f3);
				System.out.printf("%d/%d",f3.ne,f3.deno);
				}
=======
			case(2):
			return str2;
			
			case(3):
			return str3;
			
			case(4):
			return str4;
>>>>>>> 5d775e7cd688760652783f066477fc9ca364943e
			}
		}
	     
		//不知道为什么一定要有
		return "";
		
	}
<<<<<<< HEAD
	Fraction rand2() {
=======
	
	fraction rand2() {
>>>>>>> 5d775e7cd688760652783f066477fc9ca364943e
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
		
		fraction f = rand2();
		return " "+f.n+"'"+f.ne+"/"+f.deno+" ";
	}
	 /**************
	   void fh1{                                               //只有一个运算符的情况
	  //报错：void is an invalid type for the variable fh1
			Fraction f1 = rand(10);
			Fraction f2 = rand(10);
			String s1  =  opch();
			System.out.printf("e = %d %d/%d   %s  %d %d/%d",f1.n ,f1.nm,f1.deno,s1,
					f2.n ,f2.nm,f2.deno);   
	}***************/
	
	public static void main(String[] args) {
		int r = 10;
		Generate g = new Generate(r);
<<<<<<< HEAD
		System.out.printf("e = "); 
		Fraction f1 = new Fraction();
		f1 = g.rand2();
		System.out.printf(g.opch());
		Fraction f2 = new Fraction();
		f2 = g.rand2();
		System.out.println();
		Fraction c = new Fraction();
		System.out.printf("%d'%d/%d",c.div(f1,f2).n, c.div(f1,f2).ne, c.div(f1,f2).deno);
		}
=======
		

		System.out.println(g.expression());
		g.getstring();		
		
	}
>>>>>>> 5d775e7cd688760652783f066477fc9ca364943e
}
