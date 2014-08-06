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
	
	public double exponenciacao (double a) {
		return Math.exp(a);
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
	
	public double expTaylor(int x, int n){
		double result = 0;
		for (int i = 0; i < n; ++i){
			result += (Math.pow(x,i))/fact(n);
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
		n.expTaylor(1,2);
		
		System.out.println(result);
	}
	
	
}