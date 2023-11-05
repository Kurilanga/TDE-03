public class MergeSortCodigo {
    private static long iteracoes = 0;
    private static long trocas = 0;

    public static void main(String[] args) {
        int[] tamanhos = {10000};

        for (int tamanho : tamanhos) {
            int[] a = new int[tamanho];
            gerarArrayAleatorio(a);

            iteracoes = 0;
            trocas = 0;

            //System.out.println("Array original:");
            //imprimirArray(a);

            long tempoInicio = System.currentTimeMillis();
            mergeSort(a, tamanho);
            long tempoFim = System.currentTimeMillis();
            long tempoDecorrido = tempoFim - tempoInicio;

            System.out.println("Tamanho do vetor: " + tamanho);
            //System.out.println("Array ordenado:");
            //imprimirArray(a);
            System.out.println("Tempo decorrido: " + tempoDecorrido + " milissegundos");
            System.out.println("Número de iterações: " + iteracoes);
            System.out.println("Número de trocas: " + trocas);
            System.out.println();
        }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int meio = n / 2;
        int[] l = new int[meio];
        int[] r = new int[n - meio];

        for (int i = 0; i < meio; i++) {
            l[i] = a[i];
        }
        for (int i = meio; i < n; i++) {
            r[i - meio] = a[i];
        }

        mergeSort(l, meio);
        mergeSort(r, n - meio);

        merge(a, l, r, meio, n - meio);
    }

    public static void merge(int[] a, int[] l, int[] r, int esquerda, int direita) {
        int i = 0, j = 0, k = 0;

        while (i < esquerda && j < direita) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
            trocas++;
        }
        while (i < esquerda) {
            a[k++] = l[i++];
        }
        while (j < direita) {
            a[k++] = r[j++];
        }
        iteracoes++;
    }

    public static void gerarArrayAleatorio(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
    }

    public static void imprimirArray(int[] a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


