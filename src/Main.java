import grafos.*;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.addAresta(0,1);
        g.addAresta(1,2);
        g.addAresta(2,3);
        g.addAresta(3,4);

        g.buscaProfundidade();
        for (Vertice v : g.topologico) {
            System.out.println(v.toString() + " " + v.proFinal);
        }
    }
}
