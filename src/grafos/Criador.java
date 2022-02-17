package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Criador {
    List<String> linhas;

    public Criador() {
        linhas = new ArrayList<>();
    }

    public Grafo criarGrafo() {
        try {
            File arq = new File("src/grafo.txt");
            Scanner leitor = new Scanner(arq);
            while (leitor.hasNextLine()) {
                linhas.add(leitor.nextLine());
            }
            leitor.close();
            int i = 0, j;
            Grafo g = new Grafo(linhas.get(0).length());
            for (String s : linhas) {
                j = 0;
                for (char c : s.toCharArray()) {
                    if (c == '1')
                        g.addAresta(i, j);
                    j++;
                }
                i++;
            }
            return g;
        } catch (FileNotFoundException e) {
            System.out.println("Erro: arquivo não encontrado.");
            e.printStackTrace();
            return null;
        }
    }
}
