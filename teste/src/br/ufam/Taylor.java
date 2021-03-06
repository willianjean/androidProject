package br.ufam;

public class Taylor {

	public static int fatorial(int value){
		int fat = 1;
		for (int i = 1; i <value+1; i++) {
			int primeiro = i;
			fat = primeiro*(fat);
		}
		return fat;
	}

	
	public static double SerieTaylorEXP(int x, int n){
	
		double resultado = 0 ;
		for (int i = 0 ; i < n; i++) {
			resultado += (Math.pow(x, i))/(fatorial(i));
		}	
		return resultado;
	}
	
	public static double SerieTaylorLOG(int x, int n){		
	
		double resultado = 0 ;
		for (int i = 1; i < n; i++) {
			resultado += ((Math.pow((-1),i+1))/(i))*(Math.pow((x-1), i));
		}	
		return resultado;
	}
	
	public static void main(String[] args){
		System.out.println(SerieTaylorEXP(3,15));
	}
	

	
}
