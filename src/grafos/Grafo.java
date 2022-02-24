package grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
    public Vertice[] vertices;
    public List<Vertice> topologico;
    //public boolean ultimoEncontrado;

    public Grafo(int n) {
        vertices = new Vertice[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertice(i);
        }
        topologico = new LinkedList<>();
    }

    public void addAresta(int u, int v) {
        vertices[u].adj.add(vertices[v]);
    }

    public void buscaLargura() {
        for (Vertice v : vertices) {
            v.largura = Integer.MAX_VALUE; //"Infinito" em Java pelo que eu entendi
            v.pai = null;
            v.cor = "branco";
        }
        vertices[0].cor = "cinza";
        vertices[0].largura = 0;
        List<Vertice> prioridade = new LinkedList<>();
        prioridade.add(vertices[0]);
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

    private int buscaProximo(Vertice v, int profundidade) {
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
        topologico.add(0, v); //Adiciona o vértice v no começo da lista topológica do grafo
        return profundidade;
    }

    public void calcularGrausDeSaida() {
        for (Vertice v : vertices) {
            v.grauSaida = 0;
        }

        for (Vertice v : vertices) {
            for (Vertice u : v.adj) {
                v.grauSaida++;
            }
        }
    }

    public List<Vertice> prim() {
        List<Vertice> arvore = new ArrayList<>();
        for (Vertice v : vertices) {
            v.pai = null;
        }
        vertices[0].disponivel = true;
        arvore.add(vertices[0]);
        arvore = lerFrente(arvore, vertices[0]);
        return podarArvore(arvore, vertices[vertices.length - 1]);
    }

    private List<Vertice> lerFrente(List<Vertice> arvore, Vertice vertice) {
        for (Vertice v : vertice.adj) {
            if (v.disponivel) {
                arvore.add(v);
                v.pai = vertice;
                v.disponivel = false;
                arvore = lerFrente(arvore, v);
            }
        }
        return arvore;
    }

    //Função que encontra o menor caminho da árvore.
    private List<Vertice> podarArvore(List<Vertice> arvore, Vertice ultimo){
        List<Vertice> caminho = new ArrayList<>();
        caminho.add(arvore.get(0));
        for (Vertice v : arvore) { //Para todo vértice da arvore.
            for (Vertice u : v.adj) { //Para todo u filho de v.
                caminho = lerFilho(caminho, u, ultimo);
            }
        }
        return caminho;
    }

    //Função que le os próximos elementos.
    private List<Vertice> lerFilho(List<Vertice> caminho, Vertice vertice, Vertice ultimo) {
        if (vertice.equals(ultimo)) {
            caminho.add(vertice);
            ultimo = vertice.pai;
            return caminho;
        }
        for (Vertice v : vertice.adj) {
            caminho = lerFilho(caminho, v, ultimo);
        }
        return caminho;
    }
}