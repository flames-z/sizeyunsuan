package team.zw.sizeyunsuan;

public class Calculate {
	int numerator;
	int denominator;
	
	public Calculate() {
		
	}
	
	public Calculate(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Calculate add(Calculate num1, Calculate num2){
		int newNumerator = num1.numerator * num2.denominator + num1.denominator * num2.numerator;
		int newDenominator = num1.denominator * num2.denominator;
		int g = gcd(newDenominator, newNumerator);
		
		return new Calculate(newNumerator/g, newDenominator/g);
		
	}
	
	public Calculate sub(Calculate num1, Calculate num2) {
		int newNumerator = num1.numerator * num2.denominator - num1.denominator * num2.numerator;
		int newDenominator = num1.denominator * num2.denominator;
		int g = gcd(newDenominator, newNumerator);
		
		return new Calculate(newNumerator/g, newDenominator/g);
	}
	
	public int gcd(int a, int b) {
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
