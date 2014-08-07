package br.ufam;

public class Calculadora_wj {

	public double soma (double a, double b){
		return a+b;
	}
	
	public int subtracao (int a, int b){
		return a-b;
	}
	
	public float multiplicacao (float a, float b){
		return a*b;
	}
	
	public float divisao (float a, float b){
		return a/b;
	}
	
	public double exponenciacao (double a, double b) {
		return Math.pow(a,b);
	}
	
	public double logaritimo (double a){
		return Math.log10(a);
	}
	
	//Taylor
	public static double fact(double i){
		if (i==0)
			return 1.0;
		return i*fact(--i);
	}
	
	public double expTaylor(double x, double n){
		double result = 0;
		for (int i = 0; i < n; ++i){
			result += ((Math.pow(x,i))/fact(i));
		}
		return result;
	}
	
	public double logTaylor(double x, double n){
		double result = 0;
		for (int i = 1; i < n; ++i){
			result += ((Math.pow((-1), i+1))/i)*(Math.pow((x-1), i));
		}
		return result;
	}
	
	public static void main(String[] args){
		double result = 0;
		Calculadora calc = new Calculadora();
		
		for (int n = 0; n<4; n++){
			result += (3^n)/(fact(n));
		}
		
		Calculadora_wj n = new Calculadora_wj();
		
		System.out.println(n.exponenciacao(2.718281828,3));
		System.out.println(n.expTaylor(3,15));
		System.out.println(n.logTaylor(2, 1000));
	}
	
	
}
