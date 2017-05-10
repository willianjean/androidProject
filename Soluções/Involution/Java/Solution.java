import java.util.Scanner;


public class Solution {
	
	int item;
	int numCount;
	public static void main(String[] args) {new Solution();	}
	
	public Solution() {
	
		Scanner in = new Scanner(System.in);
		int num;
		int ele;
		int test_case;
		
		for (int i = 0; i < 10; i++) {
			test_case = in.nextInt();
			num = in.nextInt();
			ele = in.nextInt();
			numCount = num;	
			item=1;
			System.out.println(String.format("#%d %d",test_case,elev(num,ele)));
		}
		
	}
	
	private int elev(int num, int e) {
		if(item==e)
			return num;
		else{
			item++;
			num *= numCount;
			return elev(num, e); 
		}
	}
}
