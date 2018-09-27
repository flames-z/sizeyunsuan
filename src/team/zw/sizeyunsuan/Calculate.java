package team.zw.sizeyunsuan;

public class Calculate {
	int n;//大于1真分数前面的数
	int ne;//分子
	int deno;//分母
	
	public Calculate() {
		
	}
	
	public Calculate(fraction f) {
		this.n = f.n;
		this.ne = f.ne;
		this.deno = f.deno;
	}
	
	public Calculate add(fraction n1, fraction n2){
		fraction f1 = new fraction();
		if(n1.ne>0&&n2.ne>0) {
			
			//int newne = n1.ne * n2.deno + n1.deno * n2.ne+n1.n*n1.deno*n2.deno+n2.n*n2.deno*n1.deno;
			int lc = lcm(n1.deno,n2.deno);
			int newne = lc*n1.n+lc/n1.deno*n1.ne+lc*n2.n+lc/n2.deno*n2.ne;
			int newdeno = lc;
			int newn;
			if(newdeno < newne) {
				newn = newne/newdeno;
			}
			else newn =0;
			newne = newne-newn*newdeno;            //化假分数为真分数
			
			
			int g = gcd(newdeno, newne);
			
			f1.n = newn;
			f1.ne = newne/g;
			f1.deno = newdeno/g;
			return new Calculate(f1);
		}
		else if(n1.ne>0||n2.ne>0) {
			f1.n= n1.n+n2.n;
			f1.deno = n1.deno + n2.deno;
			f1.ne = n1.ne+n2.ne;
			return new Calculate(f1);
		}	
		else {
			f1.n= n1.n+n2.n;
			f1.deno = 0;
			f1.ne = 0;
			return new Calculate(f1);
		}
	}
	
	public Calculate sub(Calculate n1, Calculate n2) {
		
		//判断不出现负数,要在这里实现吗？还是在生成后再判断？
		/***if(newne<0) {
			System.out.println("出现负数");
		}***/
		int newne = n1.ne * n2.deno+n1.n*n1.deno - n1.deno * n2.ne-n2.n*n2.deno;
		int newdeno = n1.deno * n2.deno;
		int g = gcd(newdeno, newne);
		int newn;
		if(newdeno < newne) {
			newn = newne/newdeno;
		}
		else newn =0;
		return new Calculate(newn,newne/g, newdeno/g);
		
		
		
	}
	
	public int gcd(int a, int b) {   //求最大公因子
		int m = Math.max(a, b);
		int n = Math.min(a, b);
		int r;
		while(n !=0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	
	
	public int lcm(int a , int b) {   //求最小公倍数
		return a*b/gcd(a,b);
	}
	 
	
	public int compare(fraction f1 , fraction f2) {
		if (f1.n>f2.n)
			return 1;
		
		else if (f1.n<f2.n)
			return 0;
		
		else
			
		{
			if( f1.ne*f1.deno>f2.ne*f2.deno)
				return 1;
			else
				return 0;
		}
	}
	
	
}
