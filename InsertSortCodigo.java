import java.util.Random;

public class InsertSortCodigo {
    public static int[] ordenacaoPorInsercao(int array[]) {
        int n = array.length;
        int numTrocas = 0;
        int numIteracoes = 0;

        for (int j = 1; j < n; j++) {
            int chave = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > chave)) {
                array[i + 1] = array[i];
                i--;
                numTrocas++;
            }
            array[i + 1] = chave;
            numIteracoes++; // Conta a iteração do loop externo.
        }

        int[] resultados = {numTrocas, numIteracoes};
        return resultados;
    }

    public static void main(String a[]) {
        int[] tamanhos = {10000};
        for (int tamanho : tamanhos) {
            int[] arranjo = new int[tamanho];
            Random random = new Random();

            for (int i = 0; i < tamanho; i++) {
                arranjo[i] = random.nextInt(100); // Preencha aleatoriamente os valores entre 0 e 99
            }

            System.out.println("Arranjo de tamanho " + tamanho);
            // System.out.println("Antes da Ordenação por Inserção");
            //for (int i : arranjo) {
            //    System.out.print(i + " ");
            //}
            System.out.println();

            long tempoInicio = System.nanoTime();
            int[] estatisticas = ordenacaoPorInsercao(arranjo);
            long tempoFim = System.nanoTime();

            // System.out.println("Depois da Ordenação por Inserção");
            //for (int i : arranjo) {
            //   System.out.print(i + " ");
            //}
            System.out.println();

            System.out.println("Número de Trocas: " + estatisticas[0]);
            System.out.println("Número de Iterações: " + estatisticas[1]);
            long tempoExecucao = (tempoFim - tempoInicio) / 1000000; // Em milissegundos
            System.out.println("Tempo de Execução: " + tempoExecucao + " ms");
        }
    }
}
