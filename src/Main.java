
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static void swap(int[] array, int index1, int index2){
        int intermediario = array[index1];
        array[index1] = array[index2];
        array[index2] = intermediario;
    }

    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    swap(array, i, j);
                }
            }
        }
    }

    public static void insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int valor = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > valor){
                swap(array, j+1, j);
                j -= 1;
            }
        }
    }

    public static void quickSort(int[] array, int leftPointer, int pivotIndex) {
        if (leftPointer < pivotIndex) {
            int pivot = array[pivotIndex];
            int i = leftPointer;

            for (int rightPointer = leftPointer+1; rightPointer < pivotIndex; rightPointer++) {
                if (array[rightPointer] < pivot) {
                    swap(array, i, rightPointer);
                    i++;
                }
            }

            swap(array, i + 1, pivotIndex);
            int newPivotIndex = i + 1;

            quickSort(array, leftPointer, newPivotIndex - 1);
            quickSort(array, newPivotIndex + 1, pivotIndex);
        }
    }



        public static void main (String[]args){

            String[] arquivosAleatorio = {"src/inputs/aleatorio_100.csv", "src/inputs/aleatorio_1000.csv", "src/inputs/aleatorio_10000.csv"};
            String[] arquivosCrescente = {"src/inputs/crescente_100.csv", "src/inputs/crescente_1000.csv", "src/inputs/crescente_10000.csv"};
            String[] arquivosDecrescente = {"src/inputs/decrescente_100.csv", "src/inputs/decrescente_100.csv", "src/inputs/decrescente_100.csv"};

            int[] quantidadeDados  = {100, 1000, 10000};
            int indiceQntdDados = 0;

            long[][] resultadosAletorio = {new long[3], new long[3], new long[3]};
            long[][] resultadosCrescente = {new long[3], new long[3], new long[3]};
            long[][] resultadosDecrescente = {new long[3], new long[3], new long[3]};

            for(String caminho: arquivosAleatorio){

                BufferedReader arquivo = null;
                try {
                    arquivo = new BufferedReader(new FileReader(caminho));
                }catch (IOException e){
                    System.out.println("Erro ao ler arquivo: " + e.getMessage());
                }

                String linha;
                long duracaoBubble= 0;
                long duracaoInsertion = 0;
                long duracaoQuick = 0;
                int[] dados = new int[quantidadeDados[indiceQntdDados]];

                try {

                    int i = 0;
                    arquivo.readLine();
                    while((linha = arquivo.readLine()) != null){
                        dados[i] = Integer.parseInt(linha);
                        i++;
                    }

                    long startBubble = System.nanoTime();
                    Main.bubbleSort(dados.clone());
                    long endBubble = System.nanoTime();
                    duracaoBubble = endBubble - startBubble;

                    long startInsertion = System.nanoTime();
                    Main.insertionSort(dados.clone());
                    long endInsertion = System.nanoTime();
                    duracaoInsertion = endInsertion - startInsertion;

                    long startQuick = System.nanoTime();
                    Main.quickSort(dados.clone(), 0, dados.length-1);
                    long endQuick = System.nanoTime();
                    duracaoQuick = endQuick - startQuick;

                    resultadosAletorio[indiceQntdDados][0] = duracaoBubble;
                    resultadosAletorio[indiceQntdDados][1] = duracaoInsertion;
                    resultadosAletorio[indiceQntdDados][2] = duracaoQuick;

                    indiceQntdDados++;

                }catch (IOException e){
                    System.out.println("Erro ao ler valores do arquivo: " +e.getMessage());
                }


            }

            indiceQntdDados = 0;
            for(String caminho: arquivosCrescente){

                BufferedReader arquivo = null;
                try {
                    arquivo = new BufferedReader(new FileReader(caminho));
                }catch (IOException e){
                    System.out.println("Erro ao ler arquivo: " + e.getMessage());
                }

                String linha;
                long duracaoBubble= 0;
                long duracaoInsertion = 0;
                long duracaoQuick = 0;
                int[] dados = new int[quantidadeDados[indiceQntdDados]];

                try {

                    int i = 0;
                    arquivo.readLine();
                    while((linha = arquivo.readLine()) != null){
                        dados[i] = Integer.parseInt(linha);
                        i++;
                    }

                    long startBubble = System.nanoTime();
                    Main.bubbleSort(dados.clone());
                    long endBubble = System.nanoTime();
                    duracaoBubble = endBubble - startBubble;

                    long startInsertion = System.nanoTime();
                    Main.insertionSort(dados.clone());
                    long endInsertion = System.nanoTime();
                    duracaoInsertion = endInsertion - startInsertion;

                    long startQuick = System.nanoTime();
                    Main.quickSort(dados.clone(), 0, dados.length-1);
                    long endQuick = System.nanoTime();
                    duracaoQuick = endQuick - startQuick;

                    resultadosCrescente[indiceQntdDados][0] = duracaoBubble;
                    resultadosCrescente[indiceQntdDados][1] = duracaoInsertion;
                    resultadosCrescente[indiceQntdDados][2] = duracaoQuick;

                    indiceQntdDados++;

                }catch (IOException e){
                    System.out.println("Erro ao ler valores do arquivo: " +e.getMessage());
                }


            }

            indiceQntdDados = 0;
            for(String caminho: arquivosDecrescente){

                BufferedReader arquivo = null;
                try {
                    arquivo = new BufferedReader(new FileReader(caminho));
                }catch (IOException e){
                    System.out.println("Erro ao ler arquivo: " + e.getMessage());
                }

                String linha;
                long duracaoBubble= 0;
                long duracaoInsertion = 0;
                long duracaoQuick = 0;
                int[] dados = new int[quantidadeDados[indiceQntdDados]];

                try {

                    int i = 0;
                    arquivo.readLine();
                    while((linha = arquivo.readLine()) != null){
                        dados[i] = Integer.parseInt(linha);
                        i++;
                    }

                    long startBubble = System.nanoTime();
                    Main.bubbleSort(dados.clone());
                    long endBubble = System.nanoTime();
                    duracaoBubble = endBubble - startBubble;

                    long startInsertion = System.nanoTime();
                    Main.insertionSort(dados.clone());
                    long endInsertion = System.nanoTime();
                    duracaoInsertion = endInsertion - startInsertion;

                    long startQuick = System.nanoTime();
                    Main.quickSort(dados.clone(), 0, dados.length-1);
                    long endQuick = System.nanoTime();
                    duracaoQuick = endQuick - startQuick;

                    resultadosDecrescente[indiceQntdDados][0] = duracaoBubble;
                    resultadosDecrescente[indiceQntdDados][1] = duracaoInsertion;
                    resultadosDecrescente[indiceQntdDados][2] = duracaoQuick;

                    indiceQntdDados++;

                }catch (IOException e){
                    System.out.println("Erro ao ler valores do arquivo: " +e.getMessage());
                }


            }
            System.out.println("Representando os dados:");
            System.out.println("Tamanho 100: [BubbleSort, InsertionSort, Quicksort] Tamanho 1000: [BubbleSort, InsertionSort, Quicksort] Tamanho 10000: [BubbleSort, InsertionSort, Quicksort]");
            System.out.println();
            
            System.out.println("Tempo de execução em NanoSeg dados Aleatorios: ");
            System.out.println(Arrays.deepToString(resultadosAletorio));
            System.out.println();

            System.out.println("Tempo de execução em NanoSeg dados Crescentes:");
            System.out.println(Arrays.deepToString(resultadosCrescente));
            System.out.println();

            System.out.println("Tempo de execução em NanoSeg dados Decrescentes:");
            System.out.println(Arrays.deepToString(resultadosDecrescente));


    }



}


