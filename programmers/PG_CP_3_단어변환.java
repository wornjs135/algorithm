package programmers;

public class PG_CP_3_단어변환 {
	
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int answer = 0;
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		int size = words.length;
		
		for (int i = 0; i < size; i++) {
			int diffCnt = getDiffCnt(begin, words[i]);
			
			if(diffCnt == 1) {
				dfs(words[i], target, words, new boolean[size], i, 1);
			}
		}
		
		answer = min == Integer.MAX_VALUE ? 0 : min;
		System.out.println(answer);
	}

	private static void dfs(String curr, String target, String[] words, boolean[] visited, int currIndex, int lvl) {
		if(curr.equals(target)) {
			if(min > lvl) {
				min = lvl;
			}	
			return;
		}
		
		visited[currIndex] = true;
		for (int i = 0; i < words.length; i++) {
			if(!visited[i]) {
				int diffCnt = getDiffCnt(curr, words[i]);
				if(diffCnt == 1) {
					dfs(words[i], target, words, visited, i, lvl+1);
				}
			}
		}
		visited[currIndex] = false;
	}
	
	private static int getDiffCnt(String a, String b) {
		int diffCnt = 0;
		for (int j = 0; j < a.length(); j++) {
			if(a.charAt(j) != b.charAt(j)) {
				diffCnt++;
			}
		}
		return diffCnt;
	}

}
