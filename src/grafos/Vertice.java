package grafos;
import java.util.List;
import java.util.LinkedList;

public class Vertice {
    Vertice pai;
    int proInicial, proFinal, largura;
    String cor;
    int num;
    List<Vertice> adj;
    int grauSaida;

    public Vertice(int num) {
        this.num = num;
        this.adj = new LinkedList<>();
    }

    public String toString() {
        return "Vertice(" + num + ")";
    }
}
