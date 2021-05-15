import java.util.HashMap;
import java.util.LinkedList;

public class graphs_2 {
    int vertices;
    HashMap<Integer, LinkedList<Integer>> matrix;

    public graphs_2() {
        this.vertices = 0;
        matrix = new HashMap<>();
    }

    public static void main(String[] args) {
        graphs_2 g2 = new graphs_2();
        g2.add_vertice(20);
        g2.add_vertice(30);
        g2.add_vertice(40);
        g2.add_vertice(50);
        g2.add_vertice(60);
        g2.add_edge(20, 30);
        g2.add_edge(20, 40);
        g2.add_edge(40, 30);
        g2.add_edge(50, 30);
        g2.add_edge(40, 50);
        g2.add_edge(60, 20);
        g2.add_edge(30, 60);

        g2.print();
    }

    public void add_vertice(int data) {
        if (this.matrix.containsKey(data)) {
            System.out.println("Already contains vertex");
        }
        this.vertices++;
        this.matrix.put(data, new LinkedList<>());
    }

    public void add_edge(int src, int dest) {
        LinkedList curr = matrix.get(src);
        if (curr.contains(dest)) {
            System.out.println("Edge is already created");
            // matrix.get(dest).add(src);   //undirected graph
            return;
        }
        matrix.get(src).add(dest);
        //matrix.get(dest).add(src);  // undirected graph
    }

    public void print() {
        for (int key : matrix.keySet()) {
            System.out.print("Vertex is " + key + "   ");
            matrix.get(key).stream().forEach(e -> System.out.print("- > " + e));
            System.out.println();
        }
    }

}
