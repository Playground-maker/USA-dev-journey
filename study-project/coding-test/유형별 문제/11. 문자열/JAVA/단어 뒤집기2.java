import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // 꺽쇄 판별
        boolean tag = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<') {
                tag = true;

                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                sb.append(str.charAt(i));
            }
            else if(str.charAt(i) == '>') {
                tag = false;
                sb.append(str.charAt(i));
            }

            // 꺽쇄 안 일때
            else if(tag == true) {
                sb.append(str.charAt(i));
            }
            // 꺽쇄 바깥
            else if(tag == false) {
                if(str.charAt(i) == ' ') {

                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(str.charAt(i));
                }
                else {
                    stack.push(str.charAt(i));
                }
            }
        }


        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb.toString());
    }
}