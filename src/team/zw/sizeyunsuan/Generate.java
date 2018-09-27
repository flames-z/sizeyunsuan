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
			f2.ne = (int) (Math.random()*r);
			f2.deno = (int) (Math.random()*r);
			Calculate cal = new Calculate(f2);
			System.out.printf("%d'%d/%d",f2.n,f2.ne,f2.deno);
			}
			else {                                          //小于1
				fraction f3 = new fraction();
				f3.n = 0;
				f3.ne = (int) (Math.random()*r);
				f3.deno = (int) (Math.random()*r);
				Calculate cal = new Calculate(f3);
				System.out.printf("%d/%d",f3.ne,f3.deno);
				}
			}
	}
	fraction rand2() {
		int n1 =(int)(Math.random()*2);
		if(n1==0) {
			fraction f1 = new fraction();
			f1.n = (int) (Math.random()*r);
			f1.ne = 0;
			f1.deno = 0 ;
			System.out.printf("%d",f1.n);
			return f1;
		}
		else {
			//随机这是一个大于1的分数，还是小于1
			if ((int)(Math.random()*2)==0) {                   //大于1
				
			fraction f2 = new fraction();
			f2.n = (int) (Math.random()*(r-1)+1);
			f2.deno = (int) (Math.random()*(r-2)+2);		//分母
			f2.ne = (int) (Math.random()*(f2.deno-1)+1);   //分子
			System.out.printf("%d'%d/%d",f2.n,f2.ne,f2.deno);
			return f2;
			}
			else {                                          //小于1
				fraction f3 = new fraction();
				f3.n = 0;
				f3.deno = (int) (Math.random()*(r-2)+2);
				f3.ne = (int) (Math.random()*(f3.deno-1)+1);
				System.out.printf("%d/%d",f3.ne,f3.deno);
				return f3;
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
		int r = 10;
		Generate g = new Generate(r);
		System.out.printf("e = "); 
		fraction f1 = new fraction();
		f1 = g.rand2();
		System.out.printf(g.opch());
		fraction f2 = new fraction();
		f2 = g.rand2();
		System.out.println();
		Calculate c = new Calculate();
		System.out.printf("%d'%d/%d",c.div(f1,f2).n, c.div(f1,f2).ne, c.div(f1,f2).deno);
		}
}
class fraction {
	int n;
	int ne;
	int deno;
}
