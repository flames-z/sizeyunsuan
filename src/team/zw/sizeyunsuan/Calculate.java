package team.zw.sizeyunsuan;

public class Calculate {
	int n;//大于1真分数前面的数
	int ne;//分子
	int deno;//分母
	
	public Calculate() {
		
	}
	
	public Calculate(int n,int ne, int deno) {
		this.n = n;
		this.ne = ne;
		this.deno = deno;
	}
	
	public Calculate add(Calculate n1, Calculate n2){
		int newne = n1.ne * n2.deno + n1.deno * n2.ne+n1.n*n1.deno+n2.n*n2.deno;
		int newdeno = n1.deno * n2.deno;
		int g = gcd(newdeno, newne);
		int newn;
		if(newdeno < newne) {
			newn = newne/newdeno;
		}
		else newn =0;
		return new Calculate(newn,newne/g-newn*newdeno, newdeno/g);
		
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
}
