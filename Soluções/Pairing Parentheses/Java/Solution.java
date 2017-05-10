import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Solution {
	
	public static void main(String[] args) {new Solution();	}
	
	public Solution() {
		Scanner in = new Scanner(System.in);
		String sentence ;
		int numCharacters;
		int parenO = 0;
		int parenC = 0;
		int chaO = 0;
		int chaC = 0;
		int cocO = 0;
		int cocC = 0;
		int l = 0;
		int g = 0;
		
		char[] word;
		for(int i = 0; i < 10;i++){
			numCharacters = in.nextInt();
			sentence = in.next();
			word = sentence.toCharArray();
			for (int j = 0; j < word.length; j++) {
				switch (word[j]) {
				case '(':
					parenO++;
					break;
				case ')':
					parenC++;
					break;
				case '[':
					cocO++;
					break;
				case ']':
					cocC++;
					break;
				case '{':
					chaO++;
					break;
				case '}':
					chaC++;
					break;
				case '<':
					l++;
					break;
				case '>':
					g++;
					break;
				default:
					break;
				}				
			}
			if (parenO == parenC && chaO==chaC && cocO==cocC && l == g)
				System.out.println(String.format("#%d %d",(i+1),1));
			else
				System.out.println(String.format("#%d %d",(i+1),0));
			parenO = parenC = chaO = chaC = cocO = cocC = l = g =0;
		}
		
	}
	
}
