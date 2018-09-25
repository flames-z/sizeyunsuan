package team.zw.sizeyunsuan;

public class Generate{
	int n,r;
	
	
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
	
	//随机出一个真分数或自然数
	void rand() {
		int n1 =(int)(Math.random()*2);
		if(n1==0) {
			System.out.printf("%d",(int) (Math.random()*r));
		}
		else {
			//随机这是一个大于1的分数，还是小于1
			if ((int)(Math.random()*2)==0) {                   //大于1
				
			fraction f2 = new fraction();
			f2.n = (int) (Math.random()*r);
			f2.nm = (int) (Math.random()*(r-1))+1;
			f2.deno = (int) (Math.random()*(r-1))+1;
			System.out.printf("%d %d%d",f2.n,f2.nm,f2.deno);
			}
			else {                                          //小于1
				fraction f3 = new fraction();
				f3.n = 0;
				f3.nm = (int) (Math.random()*(r-1))+1;
				f3.deno = (int) (Math.random()*(r-1))+1;
				System.out.printf("%d %d%d",f3.nm,f3.deno);
				}
			}
	}
	
	 /**************
	   void fh1{                                               //只有一个运算符的情况
	  //报错：void is an invalid type for the variable fh1
			fraction f1 = rand(10);
			fraction f2 = rand(10);
			String s1  =  opch();
			System.out.printf("e = %d %d/%d   %s  %d %d/%d",f1.n ,f1.nm,f1.deno,s1,
					f2.n ,f2.nm,f2.deno);   
	}***************/
	
	public static void main(String[] args) {
		
		Generate g = new Generate();
		System.out.printf("e = "); 
		g.rand();
		System.out.printf(g.opch());
		g.rand();
		}
}
class fraction {
	int n;
	int nm;
	int deno;
}
