package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PG_CP_3_가장먼노드 {

    static class Node {
        int vertex;
        Node link;
        
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
        int answer = 0;

        Node[] graph = new Node[n+1];
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]] = new Node(edge[i][1], graph[edge[i][0]]);
            graph[edge[i][1]] = new Node(edge[i][0], graph[edge[i][1]]);
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        q.add(graph[1]);
        visited[1] = true;

        int cnt = 1;
        while(!q.isEmpty()) {
        	for (int i = 0, size = q.size(); i < size; i++) {
        		Node temp = q.poll();
                for (Node node = temp; node != null; node = node.link) {
    				if(!visited[node.vertex]) {
    					q.offer(graph[node.vertex]);
    					visited[node.vertex] = true;
    					dist[node.vertex] = cnt;
    				}
    			}
			}
            cnt++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 2; i < n+1; i++) {
            if (max < dist[i]) {
                max = dist[i];
                answer = 1;
            } else if (max == dist[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }


}
