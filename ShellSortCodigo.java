import java.util.Random;

public class ShellSortCodigo {
    public static void main(String[] args) {
        int[] tamanhos = {10000};

        for (int tamanho : tamanhos) {
            int[] vetor = gerarVetorAleatorio(tamanho);
            int[] incrementos = gerarIncrementosShell(tamanho);

            long inicio = System.currentTimeMillis();
            int numeroTrocas = ordenarShell(vetor, incrementos);
            long fim = System.currentTimeMillis();

            System.out.println("Tamanho do vetor: " + tamanho);
            System.out.println("Tempo de execução: " + (fim - inicio) + " milissegundos");
            System.out.println("Número de trocas: " + numeroTrocas);
            System.out.println("Número de iterações: " + incrementos.length);
            System.out.println();
        }
    }

    public static int ordenarShell(int[] vetor, int[] incrementos) {
        int numeroTrocas = 0;
        for (int incr = 0; incr < incrementos.length; incr++) {
            int salto = incrementos[incr];
            for (int j = salto; j < vetor.length; j++) {
                int y = vetor[j];
                int k;
                for (k = j - salto; k >= 0 && y < vetor[k]; k -= salto) {
                    vetor[k + salto] = vetor[k];
                    numeroTrocas++;
                }
                vetor[k + salto] = y;
            }
        }
        return numeroTrocas;
    }

    public static int[] gerarIncrementosShell(int tamanho) {
        // Gere os incrementos do Shell Sort
        int[] incrementos = new int[tamanho];
        int h = 1;
        int i = 0;
        while (h < tamanho) {
            incrementos[i++] = h;
            h = 3 * h + 1;
        }
        int[] resultado = new int[i];
        System.arraycopy(incrementos, 0, resultado, 0, i);
        return resultado;
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(1000); // Gere números aleatórios de 0 a 999
        }
        return vetor;
    }
}