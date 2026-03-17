package view;

import controller.BubbleSortController;

public class BubbleSort {

    public static void main(String[] args) {
        int vetor[] = {1, 5, 3, 9, 4, 8};

        BubbleSortController bubble = new BubbleSortController();
        bubble.ordenar(vetor);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}