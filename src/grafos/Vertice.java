package grafos;
import java.util.List;
import java.util.LinkedList;

public class Vertice {
    public Vertice pai;
    public int proInicial, proFinal, largura;
    public String cor;
    public int num;
    public List<Vertice> adj;
    public int grauSaida;

    public Vertice(int num) {
        this.num = num;
        this.adj = new LinkedList<>();
    }

    public String toString() {
        return "Vertice(" + num + ")";
    }
}
