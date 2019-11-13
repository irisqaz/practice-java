import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Routers
 */
public class Routers {
    public static void main(String[] args) {
        Integer[][] matrix = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 5, 6 }, { 3, 4 } };

        List<List<Integer>> links = new ArrayList<List<Integer>>();
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            Integer[] row = matrix[i];
            List<Integer> l = Arrays.asList(row);
            System.out.printf("%s", l);
            links.add(l);
        }

        List<Integer> critical = criticalRouters(links.size(), links.get(0).size(), links);

        System.out.printf(" -> %s\n\n", critical);
    }

    static List<Integer> criticalRouters(int numRouters, int numLinks, List<List<Integer>> links) {
        List<Integer> critical = new ArrayList<Integer>();

        List<List<Integer>> adjList = adjacentList(links, numRouters);
        printAdjList(adjList);

        for (int i = 0; i < numRouters; i++) {
            int visits = visits(i, adjList, numRouters);
            System.out.printf("number of vertices visited: %d \n", visits);
            if (isCritical(i)) {
                critical.add(i);
            }
        }

        return critical;
    }

    private static int visits(int vertex, List<List<Integer>> adjList, int numRouters) {

        // boolean[] visited = new boolean[numRouters]; // defaults to false
        HashSet<Integer> visited = new HashSet<>();
        dfs(vertex, adjList, visited);
        return visited.size();
    }

    private static void dfs(int vertex, List<List<Integer>> adjList, HashSet<Integer> visited) {
        visited.add(vertex);
        //System.out.printf("visited vertex %d, count is %d \n", vertex, visited.size());
        List<Integer> neighbors = adjList.get(vertex);
        for (Integer v : neighbors) {
            if (!visited.contains(v)) {
                dfs(v, adjList, visited);
            }
        }
    }

    private static ArrayList<List<Integer>> adjacentList(List<List<Integer>> links, int numRouters) {
        ArrayList<List<Integer>> adj = new ArrayList<>(numRouters);
        // initialize
        for (int i = 0; i < numRouters; i++) {
            adj.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < numRouters; i++) {
            List<Integer> edge = links.get(i);
            Integer v1 = edge.get(0);
            Integer v2 = edge.get(1);
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        return adj;
    }

    private static boolean isCritical(int i) {
        return false;
    }

    private static void printAdjList(List<List<Integer>> adjList) {
        System.out.println("\n");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.printf("[%d] -> %s \n", i, adjList.get(i));
        }
        System.out.println();
    }

}