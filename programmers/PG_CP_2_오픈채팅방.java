package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_CP_2_오픈채팅방 {

	static class Chat {
		String action;
		String id;

		public Chat(String action, String id) {
			super();
			this.action = action;
			this.id = id;
		}
	}

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] answer = {};

		Map<String, String> users = new HashMap<>();
		Queue<Chat> chatQ = new LinkedList<>();

		StringTokenizer st = null;
		String action;
		String id;
		String nickname = null;
		for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			action = st.nextToken();
			id = st.nextToken();
			if (!action.equals("Leave")) {
				nickname = st.nextToken();
			}
			if (action.equals("Enter")) { // 채팅방에 입장했을 때
				if (!users.containsKey(id)) { // 새로운 회원이라면
					users.put(id, nickname); // 유저 등록
				} else { // 기존 회원이라면
					users.put(id, nickname);
				}
				chatQ.add(new Chat(action, id));
			} else if (action.equals("Change")) { // 채팅방 안에서 닉네임 변경했을 때
				users.put(id, nickname);
			} else {
				chatQ.add(new Chat(action, id));
			}
		}

		StringBuilder sb = null;
		List<String> result = new ArrayList<>();
		while (!chatQ.isEmpty()) {
			sb = new StringBuilder();
			Chat temp = chatQ.poll();
			sb.append(users.get(temp.id)).append("님이 ").append(temp.action.equals("Enter") ? "들어왔습니다." : "나갔습니다.");
			result.add(sb.toString());
		}

		answer = result.toArray(new String[result.size()]);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
