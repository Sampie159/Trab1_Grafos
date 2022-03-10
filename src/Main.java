import grafos.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Criador c = new Criador();
        Grafo g = c.criarGrafo();
        g.buscaLargura();
        g.buscaProfundidade();
        g.encontrarMenorCaminho();
        for (Vertice v : g.menorCaminho) {
            System.out.println(v);
        }
        g.encontrarCiclo();
        System.out.println(g.cicloEncontrado);
        for (Vertice v : g.topologico) {
            System.out.println(v);
        }
    }
}
