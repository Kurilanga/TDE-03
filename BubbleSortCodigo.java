import java.util.Random;

public class BubbleSortCodigo{
    static void ordenacaoBubble(int[] arr) {
        int n = arr.length;
        int temp = 0;
        int iteracoes = 0;
        int trocas = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                iteracoes++;

                if (arr[j - 1] > arr[j]) {
                    trocas++;
                    // Troca os elementos
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Número de Iterações: " + iteracoes);
        System.out.println("Número de Trocas: " + trocas);
    }

    public static void main(String[] args) {
        int[] tamanhos = {10000};

        for (int tamanho : tamanhos) {
            int[] arr = gerarArrayAleatorio(tamanho);
            //System.out.println("Vetor Antes da Ordenação Bubble (Tamanho " + tamanho + ")");
            //imprimirArray(arr);
            long startTime = System.currentTimeMillis();
            ordenacaoBubble(arr);
            long endTime = System.currentTimeMillis();
            //System.out.println("Vetor Após a Ordenação Bubble (Tamanho " + tamanho + ")");
            //imprimirArray(arr);
            System.out.println("Tempo decorrido para tamanho " + tamanho + ": " + (endTime - startTime) + "ms");
            System.out.println();
        }
    }

    static int[] gerarArrayAleatorio(int tamanho) {
        int[] arr = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            arr[i] = random.nextInt(10000); // Você pode ajustar o intervalo conforme necessário
        }

        return arr;
    }

    static void imprimirArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
