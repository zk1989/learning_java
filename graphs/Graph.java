import java.util.*;
import java.util.stream.Collectors;


public class Graph {
    private Map<String, ArrayList<Edge>> edges = new HashMap<>();

    public void addEdge(String from, String to, int weight) {
        edges.putIfAbsent(from, new ArrayList<>());
        edges.putIfAbsent(to, new ArrayList<>());
        edges.get(from).add(new Edge(to, weight));
    }

    public Map<String, ArrayList<Edge>> getEdges() {
        return edges;
    }

    public void createGraph() {
        edges.clear();

        addEdge("0", "1", 4);
        addEdge("0", "7", 8);

        addEdge("1", "0", 4);
        addEdge("1", "2", 8);
        addEdge("1", "7", 11);

        addEdge("2", "1", 8);
        addEdge("2", "3", 7);
        addEdge("2", "5", 4);
        addEdge("2", "8", 2);

        addEdge("3", "2", 7);
        addEdge("3", "4", 9);
        addEdge("3", "5", 14);

        addEdge("4", "3", 9);
        addEdge("4", "5", 10);

        addEdge("5", "2", 4);
        addEdge("5", "3", 14);
        addEdge("5", "4", 10);
        addEdge("5", "6", 2);

        addEdge("6", "5", 2);
        addEdge("6", "7", 1);
        addEdge("6", "8", 6);

        addEdge("7", "0", 8);
        addEdge("7", "1", 11);
        addEdge("7", "6", 1);
        addEdge("7", "8", 7);

        addEdge("8", "2", 2);
        addEdge("8", "6", 6);
        addEdge("8", "7", 7);
    }

    public void createTree() {
        edges.clear();

        addEdge("1", "2", 0);
        addEdge("1", "3", 0);

        addEdge("2", "4", 0);
        addEdge("2", "5", 0);
        addEdge("4", "8", 0);
        addEdge("4", "9", 0);
        addEdge("5", "10", 0);
        addEdge("5", "11", 0);

        addEdge("3", "6", 0);
        addEdge("3", "7", 0);
        addEdge("6", "13", 0);
        addEdge("7", "14", 0);


    }

    public void iterativeDfs(String rootVertex) {
        Stack<String> stack = new Stack<>();
        Set<String> visitedVertices = new HashSet<>();
        stack.push(rootVertex);
        while (!stack.empty()) {
            String vertex = stack.pop();
            if (visitedVertices.contains(vertex))
                continue;
            visitedVertices.add(vertex);
            System.out.print(vertex + ", ");
            ArrayList<Edge> edges_list = edges.get(vertex);
            for (int i = edges_list.size() - 1; i >= 0; i--) {
                Edge edge = edges_list.get(i);
                String vertex_name = edge.getVertex();
                stack.push(vertex_name);
            }
        }
    }

    public void recursiveDfs(String rootVertex) {
        System.out.print(rootVertex + ", ");
        ArrayList<Edge> edges_list = edges.get(rootVertex);
        for (int i = 0; i < edges_list.size(); i++) {
            Edge edge = edges_list.get(i);
            recursiveDfs(edge.getVertex());
        }
    }

    public void iterativeBfs(String rootVertex) {
        Queue<String> queue = new LinkedList<>();
        queue.add(rootVertex);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + ", ");
            ArrayList<Edge> edges_list = edges.get(vertex);
            for (Edge edge : edges_list) {
                String vertex_name = edge.getVertex();
                queue.add(vertex_name);
            }
            if (queue.isEmpty()) {
                break;
            }
        }
    }

    public void callRecursiveBfs(String rootVertex) {
        Queue<String> queue = new LinkedList<>();
        queue.add(rootVertex);
        recursiveBfs(queue);
    }

    public void recursiveBfs(Queue<String> queue) {
        if (queue.isEmpty()) {
            return;
        }
        String vertex = queue.poll();
        System.out.print(vertex + ", ");
        ArrayList<Edge> edges_list = edges.get(vertex);
        for (Edge edge : edges_list) {
            String vertex_name = edge.getVertex();
            queue.add(vertex_name);
        }
        recursiveBfs(queue);
    }


    public void dijkstraAlgorithm(String rootVertex, String destination) {
        // zbior Q z nieprzejrzanymi wierzcholkami - na poczatku zawiera wszystkie wierzcholki graphu
        Set<String> Q = new HashSet<>();
        Q.addAll(edges.keySet());

        // mapa koszty powie nam ktory element usunac ze zbioru Q
        // na poczatku algorytmu kazdy wierzcholek inny niz zrodlowy ma koszt dotarcia nieskonczonosc
        HashMap<String, Integer> koszty = new HashMap<>();
        for (String wierzcholek : Q) {
            koszty.put(wierzcholek, Integer.MAX_VALUE);
        }
        // na poczatku algorytmu dla wierzcholka zrodlowego koszt dotarcia wynosi 0
        koszty.put(rootVertex, 0);

        // wybieranie wierzcholka o najmniejszym koszcie dotarcia
        String wierzcholekONajmniejszymKoszcieDotarcia = "";
        Integer najmniejszyKosztDotarcia = Integer.MAX_VALUE;
        for (String koszt : koszty.keySet()) {
            Integer kosztDotarcia = koszty.get(koszt);
            if (kosztDotarcia < najmniejszyKosztDotarcia) {
                najmniejszyKosztDotarcia = kosztDotarcia;
                wierzcholekONajmniejszymKoszcieDotarcia = koszt;
            }
        }

        while (!Q.isEmpty()) {
            String v = wierzcholekONajmniejszymKoszcieDotarcia;
            Q.remove(v);
            for (Edge k : edges.get(v)) {
                String u = k.getVertex();
                int kosztDotarciaZKDoUPoprzezK = k.getWeight();
                if (kosztDotarciaZKDoUPoprzezK < koszty.get(u)) {
                    int kosztDotarciaDoV = koszty.get(v);
                    int suma = kosztDotarciaZKDoUPoprzezK + kosztDotarciaDoV;
                    koszty.put(u, suma);
                }
            }
        }
        dijkstraAlgorithm(wierzcholekONajmniejszymKoszcieDotarcia, rootVertex);
    }
}