package hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//https://www.acmicpc.net/problem/1920
public class BJ1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> A = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        String[] n = br.readLine().split(" ");
        for (String s : n) {
            A.add(Integer.parseInt(s));
        }

        int M = Integer.parseInt(br.readLine());
        String[] m = br.readLine().split(" ");
        for (String s : m) {
            if (A.contains(Integer.parseInt(s))) bw.write("1");
            else bw.write("0");
            bw.write('\n');
            bw.flush();
        }
        bw.close();
//        Set<Integer> N = new HashSet<>();
//        Set<Integer> M = new HashSet<>();
//        for(Iterator<Integer> iter =  M.iterator(); iter.hasNext();){
//            int num = iter.next();
//            if(N.contains(num)) System.out.println(1);
//            else System.out.println(2);
//        }
    }
}
