'''
Se quiere encontrar una ruta para llegar de un sitio a otro utilizando los algoritmos de búsqueda de caminos más famosos. Se crea la interfaz PathfindingStrategy que con el método find() va a hacer los cálculos oportunos para encontrar una ruta

La clase de Contexto es el cliente de la estrategia
'''

interface PathfindingStrategy {
    public void find();
}

public class Context {
    PathfindingStrategy c;

    public Context(Strategy c) {
        this.c = c;
    }

    public void setStrategy(Strategy c) {
        this.c = c;
    }

    public void preformTask() {
        c.find();
    }
}

public class AStarAlgorithm implements PathfindingStrategy {
    public void find() {
        System.out.println("Has usado A*");
    }
}

public class DijkstraAlgorithm implements PathfindingStrategy {
    public void find() {
        System.out.println("Has usado Dijkstra");
    }
}

public class Main {
    public static void main(String[] args) {
        // Algoritmo A*
        PathfindingStrategy aStar = new AStarAlgorithm();
        Context context = new Context(aStar);
        context.performTask();

        // Algoritmo Dijkstra
        PathfindingStrategy dijkstra = new DijkstraAlgorithm();
        context.setStrategy(dijkstra);
        context.performTask();

        // Vuelve a A*
        context.setStrategy(aStar);
        context.performTask();
    }
}