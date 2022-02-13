import grafos.*;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.addAresta(0,1);
        g.addAresta(1,2);
        g.addAresta(1,3);
        g.addAresta(1,4);
        g.addAresta(4,0);

        g.buscaLargura(1);

        for (Vertice v : g.vertices) {
            System.out.println(v.toString());
        }

        g.buscaProfundidade();

        for (Vertice v : g.vertices) {
            System.out.println(v.toString());
        }
    }
}
