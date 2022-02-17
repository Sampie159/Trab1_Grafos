package grafos;
import java.util.List;
import java.util.LinkedList;

public class Vertice {
    public Vertice pai;
    public int proInicial, proFinal, largura, num, grauSaida;
    public String cor;
    public List<Vertice> adj;

    public Vertice(int num) {
        this.num = num;
        this.adj = new LinkedList<>();
    }

    public String toString() {
        return "Vertice(" + num + ") " + " " + proInicial + " " + proFinal + " " + largura + " " + cor + " " + grauSaida;
    }
}
