package grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
    public Vertice[] vertices;
    public List<Vertice> topologico;

    public Grafo(int n) { //inicializa os vertices do grafo
        vertices = new Vertice[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertice(i);
        }
        topologico = new LinkedList<>();
    }

    public void addAresta(int u, int v) { //não entendi como funciona
        vertices[u].adj.add(vertices[v]);
    }

    public void buscaLargura() {
        for (Vertice v : vertices) {
            v.largura = Integer.MAX_VALUE; //todos os vertices são iniciados com o valor "Infinito"
            v.pai = null;
            v.cor = "branco"; //não percorrido
        }
        vertices[0].cor = "cinza"; //primeiro vertice a ser visitado
        vertices[0].largura = 0;
        List<Vertice> prioridade = new LinkedList<>(); //não entendi o que é prioridade //SAMUEL ME EXPLICA ISSO
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
        for (Vertice v : vertices) { //zera o grau de saida de todos os vertices
            v.grauSaida = 0;
        }

        for (Vertice v : vertices) {
            for (Vertice u : v.adj) { //calcula grau de saida de todos os vertices
                v.grauSaida++;
            }
        }
    }

    public List<Vertice> prim() {
        List<Vertice> caminho = new ArrayList<>();
        for (Vertice v : vertices) {
            v.chave = Integer.MAX_VALUE;
            v.pai = null;
        }
        vertices[0].chave = 0;
        caminho.add(vertices[0]);
        return caminho;
    }
}
