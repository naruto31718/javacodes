import java.util.ArrayList;

public class graphs_1 {
    int vertices;
    ArrayList<ArrayList<Integer>> adj_matrix;

    public graphs_1(int v) {
        this.vertices = v;
        adj_matrix = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            this.adj_matrix.add(new ArrayList<Integer>());
    }

    public static void main(String[] args) {

        graphs_1 g1 = new
                graphs_1(5);

        g1.make_connection(0, 1);
        g1.make_connection(0, 4);
        g1.make_connection(1, 2);
        g1.make_connection(1, 3);
        g1.make_connection(1, 4);
        g1.make_connection(2, 3);
        g1.make_connection(2, 4);
        g1.make_connection(3, 4);

        g1.printGraph(g1.adj_matrix);
    }

    public void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void make_connection(int v1, int v2) {
        this.adj_matrix.get(v1).add(v2);
        this.adj_matrix.get(v2).add(v1);
    }

}
