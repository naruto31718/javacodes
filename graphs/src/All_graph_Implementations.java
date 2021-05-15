import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class All_graph_Implementations {

    public static void main(String[] args) {
        Graph1 g1 = new Graph1(3); //undirected unweighted static size
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0); // using set
        g1.addEdge(3, 1); // not in the limits
        g1.print();
        System.out.println("---------------------------------------------");
        Graph2 g2 = new Graph2(); //undirected unweighted dynamic size
        g2.addNode(0);
        g2.addNode(1);
        g2.addNode(2);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(2, 0); // = g2.addEdge(0,2); return;
        g2.print();
        System.out.println("---------------------------------------------");
        Graph3 g3 = new Graph3(3); //undricted weighted static size
        g3.addEdge(0, 1, 22);
        g3.addEdge(0, 2, 33);
        g3.addEdge(1, 2, 44);
        g3.addEdge(2, 0, 666666); //rewrite the wight
        g3.addEdge(3, 1, 213); //not in the limits
        g3.print();
        System.out.println("---------------------------------------------");
        Graph4 g4 = new Graph4();
        g4.addNode(0);
        g4.addNode(1);
        g4.addNode(2);
        g4.addNode(3);
        g4.addNode(4);
        g4.addEdge(0, 1, 22);
        g4.addEdge(0, 2, 33);
        g4.addEdge(1, 2, 44);
        g4.addEdge(2, 0, 666666); //rewrite the wight
        g4.addEdge(3, 1, 213); //not in the limits
        g4.addEdge(2, 221, 22); //Error !!
        g4.printGraph();
    }

    static class Graph1 {
        private final int V;
        private final HashSet<Integer>[] adjListArray;

        Graph1(int V) {
            this.V = V;
            this.adjListArray = new HashSet[V];
            for (int i = 0; i < V; i++) {
                this.adjListArray[i] = new HashSet<Integer>();
            }
        }

        void addEdge(int src, int dest) {
            if (src >= this.V || dest >= this.V) {
                System.out.println("not in the limets");
                return;
            }
            this.adjListArray[src].add(dest);
            this.adjListArray[dest].add(src); //undirected graph
            return;
        }

        void print() {
            for (int i = 0; i < this.V; i++) {
                System.out.println("<<<" + i + "=" + ">>>");
                this.adjListArray[i].stream().forEach(e -> System.out.print("((" + e + "))"));
                System.out.println();
            }
        }
    }

    static class Graph2 {
        private final HashMap<Integer, LinkedList<Integer>> map;
        private int V;

        Graph2() {
            this.V = 0;
            this.map = new HashMap<>();
        }

        void addNode(int data) {
            if (map.containsKey(data)) {
                System.out.println("There is a Node");
                return;
            }
            this.V++;
            map.put(data, new LinkedList<>());
        }

        void addEdge(int src, int dest) {
            LinkedList currList = map.get(src);
            if (currList.contains(dest)) {
                System.out.println("there is the edge");
                return;
            }
            currList.add(dest);
            map.get(dest).add(src); //undirected graph
        }

        void print() {
            for (int key : map.keySet()) {
                System.out.println("<<<<" + key + ">>>>");
                map.get(key).stream().forEach(e -> System.out.println("((" + e + "))"));
            }
            return;
        }

        int Size() {
            return this.V;
        }
    }

    static class Graph3 {
        private final int V;
        private final HashSet<Integer>[] adjListArray;
        private final HashMap<Integer, HashMap<Integer, Integer>> weight;

        Graph3(int V) {
            this.V = V;
            this.adjListArray = new HashSet[this.V];
            for (int i = 0; i < V; i++) {
                this.adjListArray[i] = new HashSet<Integer>();
            }
            this.weight = new HashMap<>();
        }

        void addEdge(int src, int dest, int w) {
            if (src >= this.V || dest >= this.V) {
                System.out.println("not in the limets");
                return;
            }
            this.adjListArray[src].add(dest);
            this.adjListArray[dest].add(src); //undirected graph
            if (!this.weight.containsKey(src)) { //bug fixed
                this.weight.put(src, new HashMap<>());
            }
            this.weight.get(src).put(dest, w);
            if (!this.weight.containsKey(dest)) { //bug fixed //undirected graph
                this.weight.put(dest, new HashMap<>());
            }
            this.weight.get(dest).put(src, w);
            return;
        }

        void print() {
            for (int i = 0; i < this.V; i++) {
                System.out.println("<<<" + i + "=" + ">>>");
                int w;
                for (int num : this.adjListArray[i]) {
                    w = this.weight.get(i).get(num);
                    System.out.println("(((" + num + "))) w : " + w);
                }
            }
            return;
        }
    }

    static class Graph4 {
        private static int V;
        private final HashMap<Integer, HashSet<Integer>> map;
        private final HashMap<Integer, HashMap<Integer, Integer>> edgeMap;

        Graph4() {
            V = 0;
            this.map = new HashMap<>();
            this.edgeMap = new HashMap<>();
        }

        void addNode(int node) {
            for (int key : map.keySet()) {
                if (key == node) {
                    System.out.println("the node is exist");
                    return;
                }
            }
            V++;
            map.put(node, new HashSet<Integer>());
            return;
        }

        void addEdge(int src, int dest, int w) {
            if (!map.containsKey(src) || !map.containsKey(dest)) {
                System.out.println("thre is no node");
                return;
            }
            map.get(src).add(dest);
            map.get(dest).add(src);
            if (!this.edgeMap.containsKey(src)) {
                this.edgeMap.put(src, new HashMap<Integer, Integer>());
            }
            this.edgeMap.get(src).put(dest, w);
            if (!this.edgeMap.containsKey(dest)) {
                this.edgeMap.put(dest, new HashMap<Integer, Integer>());
            }
            this.edgeMap.get(dest).put(src, w);
            return;
        }

        void printGraph() {
            for (int i : map.keySet()) {
                System.out.println("<<<" + i + ">>>");
                for (int num : map.get(i)) {
                    int n = this.edgeMap.get(i).get(num);
                    System.out.println("(((" + num + "))) w : " + n);
                }
            }
            return;
        }

        int numberOfNodes() {
            return V;
        }
    }
}

