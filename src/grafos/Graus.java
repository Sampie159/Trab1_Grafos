package grafos;

public class Graus {
    public void calcularGrausDeSaida(Grafo g) {
        for (Vertice v : g.vertices) {
            v.grauSaida = 0;
        }

        for (Vertice v : g.vertices) {
            for (Vertice u : v.adj) {
                v.grauSaida++;
            }
        }
    }

    public void mostrarGrausDeSaida(Grafo g) {
        for (Vertice v : g.vertices) {
            System.out.printf("%s.grauSaida = %d\n", v, v.grauSaida);
        }
    }
}
