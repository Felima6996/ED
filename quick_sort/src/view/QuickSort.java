package view;

import controller.QuickSortController;

public class QuickSort {
    public static void main(String[] args) {
        int[] vetor = {5, 1, 9, 0, 8, 6};

        QuickSortController quick = new QuickSortController();
        quick.ordenar(vetor);

        for (int i = 0; i < vetor.length; i++)
            System.out.println(vetor[i]);
    }
}