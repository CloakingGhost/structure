package stack;


import java.io.*;

import java.util.Stack;

public class BJ_9012 {
    public static void foo(String str) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < str.length()) {
            char a = str.charAt(i);
            if (a == '(') {
                stack.push(a);
            } else {
                if (stack.size() == 0) {
                    bw.write("NO\n");
                    bw.flush();
                    return;
                }
                stack.pop();
            }
            i++;
        }
        if (stack.size() != 0) {
            bw.write("NO\n");
        } else {
            bw.write("YES\n");
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            foo(br.readLine());

        }
        br.close();
    }

}
