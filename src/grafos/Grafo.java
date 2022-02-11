package grafos;

import java.util.LinkedList;
import java.util.List;

public class Grafo {
    Vertice[] vertices;

    public Grafo(int n) {
        vertices = new Vertice[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertice(i);
        }
    }

    public void addAresta(int u, int v) {
        vertices[u].adj.add(vertices[v]);
    }

    public void buscaLargura(Vertice inicial) {
        for (Vertice v : vertices) {
            v.largura = Integer.MAX_VALUE; //"Infinito" em Java pelo que eu entendi
            v.pai = null;
            v.cor = "branco";
        }
        inicial.cor = "cinza";
        inicial.largura = 0;
        List<Vertice> prioridade = new LinkedList<>();
        prioridade.add(inicial);
        while(!prioridade.isEmpty()) { //Enquanto a lista não for vazia
            Vertice u = prioridade.remove(0);
            for (Vertice v : u.adj) {
                if (v.cor.equals("branco")) {
                    v.pai = u;
                    v.cor = "cinza";
                    v.largura = u.largura + 1;
                    prioridade.add(v);
                }
            }
            u.cor = "preto";
        }
    }

    public void buscaProfundidade() {
        for (Vertice v : vertices) {
            v.cor = "branco";
            v.pai = null;
        }
        int profundidade = 0;
        for (Vertice v : vertices) {
            if (v.cor.equals("branco")) {
                profundidade = buscaProximo(v, profundidade); //Salva o novo valor de profundidade em profundidade
            }
        }
    }

    public int buscaProximo(Vertice v, int profundidade) {
        profundidade++;
        v.cor = "cinza";
        v.proInicial = profundidade;
        for (Vertice u : v.adj) {
            if (u.cor.equals("branco")) {
                u.pai = v;
                profundidade = buscaProximo(u, profundidade); //Salva o novo valor de profundidade em profundidade
            }
        }
        v.cor = "preto";
        profundidade++;
        v.proFinal = profundidade;
        return profundidade;
    }
}
