public class Main {
    public static void main(String[] args) {

        Graph tree = new Graph();
        tree.createTree();

        System.out.println("Depth-first search - iterative approach:");
        tree.iterativeDfs("1");

        System.out.println();
        System.out.println("Depth-first search - recursive approach:");
        tree.recursiveDfs("1");

        System.out.println();
        System.out.println("Breadth-first search - iterative approach:");
        tree.iterativeBfs("1");

        System.out.println();
        System.out.println("Breadth-first search - recursive approach:");
        tree.callRecursiveBfs("1");

        Graph graph = new Graph();
        graph.createGraph();

    }
}