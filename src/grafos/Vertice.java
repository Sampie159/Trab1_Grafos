package grafos;
import java.util.List;
import java.util.LinkedList;

public class Vertice {
    public Vertice pai;
    public int proInicial, proFinal, largura, num, grauSaida;
    public String cor;
    public List<Vertice> adj;
    public boolean disponivel;

    /*Vai criar um vertice com um número baseado em qual indice foi descoberto
    ademais, a função ira fazer uma lista para cada vertice para poder descobrir vertices adjacentes*/
    public Vertice(int num) {
        this.num = num;
        this.adj = new LinkedList<>();
        disponivel = false;
    }
    /*Vai retorna o indice do vértice, profundidade inicial e final, busca em largura a cor que ficou o vertice e seu grau de saida*/
    public String toString() {
        return "Vertice(" + num + ") " + " " + proInicial + " " + proFinal + " " + largura + " " + cor + " " + grauSaida;
    }
}
