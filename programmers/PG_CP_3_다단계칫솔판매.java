package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class PG_CP_3_다단계칫솔판매 {

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		int[] answer = new int[enroll.length];
		
		Map<String, String> personInfo = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			personInfo.put(enroll[i], referral[i]);
		}
		Map<String, Integer> moneyInfo = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			moneyInfo.put(enroll[i], 0);
		}
		moneyInfo.put("-", 0);
		
		for (int i = 0; i < seller.length; i++) {
			dfs(personInfo, moneyInfo, seller[i], amount[i] * 100);
		}
		
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = moneyInfo.get(enroll[i]);
		}
		
		System.out.println(Arrays.toString(answer));
	}

	private static void dfs(Map<String, String> personInfo, Map<String, Integer> moneyInfo, String currSeller, int currPrice) {
		int price = currPrice;
		int temp = moneyInfo.get(currSeller);
		if(price / 10 == 0 || currSeller.equals("-")) {
			temp += price;
			moneyInfo.put(currSeller, temp);
		} else {
			temp += price - (price / 10);
			moneyInfo.put(currSeller, temp);
			dfs(personInfo, moneyInfo, personInfo.get(currSeller), price / 10);
		}
	}

}
