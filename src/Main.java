import grafos.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Criador c = new Criador();
        Grafo g = c.criarGrafo();
        g.buscaLargura();
        g.buscaProfundidade();
        g.calcularGrausDeSaida();
        for (Vertice v : g.vertices) {
            System.out.println(v.toString() + "");
        }
        System.out.println("");
        List<Vertice> teste = g.prim();
        for (Vertice v : teste) {
            System.out.println(v.toString());
        }
    }
}
