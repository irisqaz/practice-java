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
            //int visits = visits(i, adjList, numRouters);
            //System.out.printf("number of vertices visited: %d \n", visits);
            if (isCritical(i, adjList, numRouters)) {
                critical.add(i);
            }
        }
        
        return critical;
    }

    private static boolean isCritical(int tvertex, List<List<Integer>> adjList, int numRouters) {
        boolean isCritical = false;

        for (int i = 0; i < numRouters; i++) {
            if (i != tvertex) {
                int count = visits(i, tvertex, adjList, numRouters);
                if(count != 6){
                    isCritical = true;
                    break;
                }
            }
        }

        return isCritical;
    }

    private static int visits(int vertex, int tvertex, List<List<Integer>> adjList, int numRouters) {

        // boolean[] visited = new boolean[numRouters]; // defaults to false
        HashSet<Integer> visited = new HashSet<>();
        dfs(vertex, tvertex, adjList, visited);
        return visited.size();
    }

    private static void dfs(int vertex, int tvertex, List<List<Integer>> adjList, HashSet<Integer> visited) {

        visited.add(vertex);

        for (Integer v : adjList.get(vertex)) {
            if(!visited.contains(v) && v != tvertex){
                dfs(v, tvertex, adjList, visited);
            }
        }

    }

    private static ArrayList<List<Integer>> adjacentList(List<List<Integer>> edges, int numRouters) {
        //ArrayList<List<Integer>> adj = new ArrayList<>(numRouters);
        
        ArrayList<List<Integer>> adj = new ArrayList<>(numRouters);
        
        // Declare and Initialize empty LinkedList
        for (int i = 0; i < numRouters; i++) {
            adj.add(new LinkedList<>());            
        }

        // Transfer edges to adj list
        for (List<Integer> edge : edges) {
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        return adj;
    }



    private static void printAdjList(List<List<Integer>> adjList) {
        System.out.println("\n");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.printf("[%d] -> %s \n", i, adjList.get(i));
        }
        System.out.println();
    }

}