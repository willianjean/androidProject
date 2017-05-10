import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static char getOpposite(char c) {
        switch (c) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
            case '<':
                return '>';
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            case '>':
                return '<';
            default:
                return ' ';
        }
    }

    public static boolean isOpening(char c) {
        return "{[(<".contains("" + c);
    }

    public static boolean check(String str) {
        boolean valid = true;
        Stack<Character> tokenStack = new Stack<Character>();

        for (int i = 0; i != str.length(); i++) {
            char current = str.charAt(i);
            char opposite = getOpposite(current);

            if (opposite != ' ') {
                if (isOpening(current)) {
                    tokenStack.push(current);
                } else {
                    char top = ' ';
                    if (!tokenStack.isEmpty()) {
                        top = tokenStack.pop();
                    }
                    if (top != opposite) {
                        valid = false;
                        break;
                    }
                }
            }
        }

        valid = valid && tokenStack.size() == 0;

        return valid;
    }

    public static void main(String[] args) {
        int testCase, i;
        String str;
        int maxTestCases = 10;
        Scanner scanner = new Scanner(System.in);
        for (i = 0; i != maxTestCases; i++) {
            testCase = scanner.nextInt();
            str = scanner.next();
            System.out.println("#" + (i + 1) + " " + (check(str) ? "1" : "0"));
        }
        scanner.close();
    }

}
