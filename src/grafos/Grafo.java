package grafos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
    public Vertice[] vertices;
    public List<Vertice> topologico;
    public List<Vertice> menorCaminho; //Uma sequencia de vertices do começo ao fim
    private Vertice ultimo;
    public boolean cicloEncontrado;
    //public boolean ultimoEncontrado;

    public Grafo(int n) { //inicializa os vertices do grafo
        vertices = new Vertice[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertice(i);
        }
        topologico = new LinkedList<>();
        ultimo = vertices[n-1];
        menorCaminho = new LinkedList<>();
        cicloEncontrado = false;
    }

    public void addAresta(int u, int v) { //não entendi como funciona
        vertices[u].adj.add(vertices[v]);
    }

    public void buscaLargura() {
        for (Vertice v : vertices) {
            v.largura = Integer.MAX_VALUE; //todos os vertices são iniciados com o valor "Infinito"
            v.paiL = null;
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
                    v.paiL = u;
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
            v.paiP = null;
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
                u.paiP = v;
                profundidade = buscaProximo(u, profundidade); //Salva o novo valor de profundidade em profundidade
            }
        }
        v.cor = "preto";
        profundidade++;
        v.proFinal = profundidade;
        topologico.add(0, v); //Adiciona o vértice v no começo da lista topológica do grafo
        return profundidade;
    }

    public void encontrarMenorCaminho() {
        Vertice aux = ultimo;
        while (aux != null) {
            menorCaminho.add(0, aux); //Adciona os vértices do fim ao início na lista menorCaminho. Baseado na árvore mínima criada pela busca em largura.
            aux = aux.paiL;
        }
    }

    public void encontrarCiclo() {
        for (Vertice v : vertices)
            v.paiP = null;
        for (Vertice v : vertices) {
            if (!cicloEncontrado) {
                if (v.disponivel) {
                    lerFrente(v);
                }
            }
            else
                return;
        }
    }

    private void lerFrente(Vertice vertice) {
        vertice.disponivel = false;
        if (!cicloEncontrado) {
            for (Vertice v : vertice.adj) {
                if (!v.disponivel) { //Se o vértice adjacente não está disponível.
                    if (vertice.paiP != null && !vertice.paiP.equals(v)) { //Se o pai de v existe e não for o vértice adjacente, um ciclo foi encontrado.
                        cicloEncontrado = true;
                        return; //Para de percorrer o loop pois não tem mais necessidade de continuar.
                    }
                } else {
                    v.paiP = vertice;
                    lerFrente(v);
                }
            }
        }
    }
}