package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_S2_15663_N과M9 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   static StringBuilder sb;
   static Set<String> set;
   static int[] select;
   static boolean[] check;

   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      set = new HashSet<String>();
      st = new StringTokenizer(br.readLine());
      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
      }
      select = new int[M];
      check = new boolean[arr.length];
      per(arr, 0);

      Object[] strs = set.toArray();
      Arrays.sort(strs);

      for (Object str : strs) {
         bw.write(str.toString()+"\n");
         //bw.newLine();
      }
      
      br.close();
      bw.flush();
      bw.close();
   }

   private static void per(int[] arr, int k) {
      // TODO Auto-generated method stub

      if (k == select.length) {
         sb = new StringBuilder();
         for (int i = 0; i < select.length; i++) {
            sb.append(select[i] + " ");
         }
         set.add(sb.substring(0,sb.length()-1));
         return;
      }
      if (k == arr.length) {
         return;
      }

      for (int i = 0; i < arr.length; i++) {
         if (!check[i]) {
            check[i] = true;
            select[k] = arr[i];
            per(arr, k + 1);
            check[i] = false;
         }
      }
   }

}