package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class PG_CP_2_튜플 {

	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println("처음:" + s);
        
        String ss = s.substring(2, s.length()-2);
        System.out.println("양쪽 끝 {{, }} 제거: " + ss);
        
        
        String[] sss = ss.split("\\},\\{");
        String[][] arr = new String[sss.length][];
        for (int i = 0; i < sss.length; i++) {
			System.out.println(sss[i]);
			String[] temp = sss[i].split(",");
			arr[i] = new String[temp.length];
			for (int j = 0; j < temp.length; j++) {
				arr[i][j] = temp[j];
			}
		}
        
        Arrays.sort(arr, new Comparator<String[]>() {
        	@Override
        	public int compare(String[] o1, String[] o2) {
        		return o1.length - o2.length;
        	}
        });
        
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				set.add(Integer.parseInt(arr[i][j]));
			}
		}
        
        Integer[] setArr = set.toArray(new Integer[set.size()]);
        int[] answer = Arrays.stream(setArr).mapToInt(Integer::intValue).toArray();
        
        for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
