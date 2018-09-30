package team.zw.sizeyunsuan;


public class Fraction {
	int n;//大于1真分数前面的数
	int ne;//分子
	int deno;//分母
	
	public Fraction() {
		
	}
	
	public Fraction(Fraction f) {
		this.n = f.n;
		this.ne = f.ne;
		this.deno = f.deno;
	} 
/****************	
	public Fraction trans(Fraction f){
		f.ne = f.n*f.deno + f.ne;
		f.n = 0;
		return f;	
	} 
	public Fraction trans2(Fraction f) {
		if(f.deno!=0) {
		f.n = f.ne/f.deno;
		}
		else
		f.n = 0;
		f.ne = f.ne -f.n*f.deno;
		return f;
	}
	public Fraction add(Fraction n1, Fraction n2) {
		trans(n1);
		trans(n2);
		Fraction f = new Fraction();
		int lc = lcm(n1.deno,n2.deno);
		f.ne = lc/n1.deno*n1.ne+lc/n2.deno*n2.ne;
		f.deno = lc;
		f.n = 0;
		trans2(f);
		int g = gcd(f.deno, f.ne);
		f.ne = f.ne/g;
		f.deno =f.deno/g;
		return f;
	}
	
	public Fraction sub(Fraction n1, Fraction n2) {
		Fraction f = new Fraction();
		trans(n1);
		trans(n2);
	
		if((n1.ne/n1.deno) < (n2.ne/n2.deno)) {
				f.n = -1;
				return f;
			}
		else {
			
			int lc = lcm(n1.deno,n2.deno);
			f.ne = lc/n1.deno*n1.ne-lc/n2.deno*n2.ne;
			f.deno = lc;
			f.n = 0;
			trans2(f);
			int g = gcd(f.deno, f.ne);
			f.ne = f.ne/g;
			f.deno =f.deno/g;
			return f;
		}
	}
	public Fraction mul(Fraction n1, Fraction n2) {
		trans(n1);
		trans(n2);
		Fraction f = new Fraction();
		f.ne = n1.ne*n2.ne;
		f.deno = n1.deno*n1.deno;
		f.n = 0;
		trans2(f);
		int g = gcd(f.deno, f.ne);
		f.ne = f.ne/g;
		f.deno =f.deno/g;
		return f;
	}
	public Fraction div(Fraction n1, Fraction n2) {
		trans(n1);
		trans(n2);
		Fraction f = new Fraction();
		f.ne = n1.ne*n2.deno;
		f.deno = n1.deno*n1.ne;
		f.n = 0;
		trans2(f);
		int g = gcd(f.deno, f.ne);
		f.ne = f.ne/g;
		f.deno =f.deno/g;
		return f;
	}
	**************/
	

	public Fraction add(Fraction n1, Fraction n2){
		Fraction f1 = new Fraction();
		if(n1.deno>0&&n2.deno>0) {
			
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
			return new Fraction(f1);
		}
		else if(n1.deno>0||n2.deno>0) {
			f1.n= n1.n+n2.n;
			f1.deno = n1.deno + n2.deno;
			f1.ne = n1.ne+n2.ne;
			return new Fraction(f1);
		}	
		else {
			f1.n= n1.n+n2.n;
			f1.deno = 0;
			f1.ne = 0;
			return new Fraction(f1);
		}
	}
	
	public Fraction sub(Fraction n1, Fraction n2) {
		
		//判断不出现负数,要在这里实现吗？还是在生成后再判断？
		//如果被减数大于减数，则n = -1;
		Fraction f1 = new Fraction();
		
		if(n1.deno != 0 && n2.deno != 0) {
			if((n1.n + n1.ne/n1.deno) < (n2.n + n2.ne/n2.deno)) {
				f1.n = -1;
				return f1;
			}
		} else {
			
		}
		

		if(n1.deno>0&&n2.deno>0) {
			
			int lc = lcm(n1.deno,n2.deno);
			int newne = lc*n1.n+lc/n1.deno*n1.ne-(lc*n2.n+lc/n2.deno*n2.ne);
			
			
			if(newne < 0) {
				f1.n = -1;
				return f1;
			}
			
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
			return new Fraction(f1);
		}
		else if(n1.deno>0||n2.deno>0) {
			f1.n= n1.n-n2.n-1;
			
			if(f1.n < 0) {
				f1.n = -1;
				return f1;
			}
			
			f1.deno =n1.deno + n2.deno;
			f1.ne = n1.deno+n2.deno-(n1.ne+n2.ne);
			return new Fraction(f1);
		}	
		else {
			f1.n= n1.n-n2.n;
			
			if(f1.n < 0) {
				f1.n = -1;
				return f1;
			}
			f1.deno = 0;
			f1.ne = 0;
			return new Fraction(f1);
		}		
	}
	public Fraction mul(Fraction n1, Fraction n2) {
		Fraction f1 = new Fraction();
		if(n1.deno>0&&n2.deno>0) {
			
			int newne = (n1.n*n1.deno+n1.ne)*(n2.n*n2.deno+n2.ne);
			int newdeno = n1.deno * n2.deno;
			int newn;
			if(newdeno < newne && newdeno>0) {
				newn = newne/newdeno;
			}
			else newn =0;
			newne = newne-newn*newdeno;            //化假分数为真分数
			
			
			int g = gcd(newdeno, newne);
			
			f1.n = newn;
			f1.ne = newne/g;
			f1.deno = newdeno/g;
			return new Fraction(f1);
		}
		
		else if(n1.deno>0||n2.deno>0) {
			int newne = n1.n*n2.ne+n2.n*n1.ne;
			int newdeno =n1.deno + n2.deno;
			int newn;
			if(newdeno < newne) {
				 newn = newne/newdeno;
			}
			else newn = 0;
			newne = newne-newn*newdeno;
			int g = gcd(newdeno, newne);
			f1.deno = newdeno/g;
			f1.ne = newne/g;
			f1.n =  n1.n*n2.n+newn;
			
			return new Fraction(f1);
			}
	
		else {
			f1.n= n1.n*n2.n;
			f1.deno = 0;
			f1.ne = 0;
			return new Fraction(f1);
		}		
	}
	public Fraction div(Fraction n1, Fraction n2) {
		Fraction f1 = new Fraction();
		
		if((n2.n == 0 && n2.deno == 0) ||( n2.n == 0 && n2.ne == 0)) {
			f1.n = -1;
			return f1;
		}
		
		if(n1.deno>0&&n2.deno>0) {
			
			int newne = (n1.n*n1.deno+n1.ne)*n2.deno;
			int newdeno = n1.deno * (n2.n*n2.deno+n2.ne);
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
			return new Fraction(f1);
		}
		
		else if(n2.deno>0) {

			int newne = n1.n*n2.deno;
			int newdeno = n2.n*n2.deno+n2.ne;
			int newn;
			if(newdeno < newne) {
				 newn = newne/newdeno;
			}
			else newn = 0;
			newne = newne-newn*newdeno;
			int g = gcd(newdeno, newne);
			f1.deno = newdeno/g;
			f1.ne = newne/g;
			f1.n =  newn;
			
			return new Fraction(f1);
			}
		else if(n1.deno>0) {
			int newne = n1.n*n1.deno+n1.ne;
			int newdeno = n1.deno * n2.n;
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
			return new Fraction(f1);
		}
	
		else {
			f1.n= n1.n/n2.n;
			f1.deno = n1.n;			
			f1.ne = n2.n-f1.n*f1.deno;
			return new Fraction(f1);
		}		
	}
	public int gcd(int a, int b) {   //求最大公因子
		if(a == 0 && b == 0) return 1;
		
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
	 
	
	public int compare(Fraction f1 , Fraction f2) {
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
