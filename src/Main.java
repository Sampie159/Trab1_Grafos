import grafos.*;

public class Main {
    public static void main(String[] args) {
        Criador c = new Criador();
        Grafo g = c.criarGrafo();
        g.buscaLargura();
        g.buscaProfundidade();
        g.calcularGrausDeSaida();
        for (Vertice v : g.topologico) {
            System.out.println(v.toString());
        }
    }
}
