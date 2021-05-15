import java.util.*;
import java.lang.*;
import java.io.*;

class disjointsets {
    int n;
    int[] parent;

    public disjointsets() {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int getset(int x) {
        return parent[x];
    }

    public void union(int a, int b) {
        int parent_a = getset(a);
        int parent_b = getset(b);
        for (int i = 0; i < n; i++) {
            if (parent[i] == parent_b) {
                parent[i] = parent_a;
            }
        }
    }

}

class dsuusingrank {
    int[] parent;
    int[] rank;
    int n;

    public dsuusingrank() {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        rank = new int[n];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = 0;
        }
    }

    public int get(int[] parent, int element) {
        return parent[element] = (parent[element] == element ? element : get(parent, parent[element]));
    }

    public void union(int[] parent, int[] rank, int a, int b) {
        a = get(parent, a);
        b = get(parent, b);
        if (rank[a] == rank[b]) {
            rank[a]++;
        }
        if (rank[a] > rank[b]) {
            parent[b] = parent[a];
        } else {
            parent[a] = b;
        }
    }

}

class application {

    class pair3 {
        int w, a, b;

        public pair3(int w, int a, int b) {
            this.a = a;
            this.w = w;
            this.b = b;
        }

        @Override
        public String toString() {
            return "" + this.w;
        }
    }

    class kruskals_algorithm {
        Scanner ip = new Scanner(System.in);
        int[] father = new int[1000];

        int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return find(father[x]);
        }

        void unite(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            father[fx] = fy;
        }

        void kruskal(kruskals_algorithm samp, int n,int m){
            for (int i=0;i<100;i++){
                samp.father[i]=i;
            }
            List<pair3> edges = new ArrayList<>();
            for (int i=0;i<m;i++){
                int a= ip.nextInt();
                int b= ip.nextInt();
                int w= ip.nextInt();
                edges.add(new pair3(w,a,b));
            }
            System.out.println();

            int mst_weight = 0 , mst_edges = 0 , mst_ni=0;

            Collections.sort(edges, new Comparator<pair3>() {
                @Override
                public int compare(pair3 o1, pair3 o2) {
                    return o1.w-o2.w;
                }
            });

            while ((mst_edges<n-1)||(mst_ni<m)){
                int a = edges.get(mst_ni).a;
                int b= edges.get(mst_ni).b;
                int w = edges.get(mst_ni).w;

                if (samp.find(a)!=samp.find(b)){
                    samp.unite(a,b);

                    mst_weight+=w;

                    System.out.println(a+" "+b+" "+w);
                    mst_edges++;
                }
                mst_ni++;
            }

            System.out.println("weight of mst is"+mst_weight);
        }
    }
}


