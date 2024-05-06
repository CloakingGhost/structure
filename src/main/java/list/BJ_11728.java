package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_11728 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = scan.nextInt();
            A.add(n);
        }
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int n = scan.nextInt();
            B.add(n);
        }

        // logic
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0; // A'index is i, B'index is j
        while (i < N && j < M){
            int a = A.get(i);
            int b = B.get(j);
            if (a<=b){
                result.add(a);
                i++;
            }else {
                result.add(b);
                j++;
            }
        }
        for(;i < N; i++){
            result.add(A.get(i));
        }
        for(;j < M; j++){
            result.add(B.get(j));
        }
        StringBuffer sb = new StringBuffer();
        for (int e : result) {
            sb.append(e + " ");
        }
        System.out.println(sb);
    }
}

