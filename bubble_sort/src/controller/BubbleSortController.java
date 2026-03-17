package controller;

public class BubbleSortController {

    public BubbleSortController() {
        super();
    }

    public void ordenar(int[] vetor) {
        int aux;

        for (int i = 0; i < (vetor.length - 1); i++) {
            for (int j = 0; j < (vetor.length - 1); j++) {
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }
}