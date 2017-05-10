import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Solution {
	
	public static void main(String[] args) {new Solution();	}
	
	int [][] grafo;
	boolean[] visited ;
	
	public Solution() {
		Scanner in = new Scanner(System.in);
		int testCase;
		int numOfNodes;
		
		for (int i = 0; i < 10; i++) {
			grafo = new int[100][100];
			visited = new boolean[100];
			testCase = in.nextInt();
			numOfNodes = in.nextInt();
			for (int j = 0; j < numOfNodes; j++) {
				addEdge(in.nextInt(), in.nextInt());
			}
			for(int k = 0 ; k< visited.length;k++){
				visited[i] = false;
			}
			find = false;
			dfs(0);
			System.out.println(String.format("#%d %d", testCase,(find?1:0)));
		}
	}
	
	
	public void addEdge(int v1,int v2){
		grafo[v1][v2] = 1;
	}
	
	boolean find;
	public void dfs(int item) {
		
		Stack<Integer> pilha = new Stack<>();		
		pilha.push(item);
		visited[item] = true;
		
		while(true){			
			for (int i = 0; i < grafo.length; i++) {
				if(grafo[item][i]==1 && !visited[i]){
					if(i==99){
						find = true;
						return;
					}
					pilha.push(i);
					visited[i] = true;
					dfs(i);
				}
			}
			if(!pilha.isEmpty()){
				item = pilha.peek();
				pilha.pop();						
			}else
				break;
			
		}		
	}
	
	
}
