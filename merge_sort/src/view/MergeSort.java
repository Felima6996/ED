package view;

import controller.MergeSortController;

public class MergeSort {
    public static void main(String[] args) {
        int vetor[] = {1, 5, 3, 9, 4, 8};

        MergeSortController merge = new MergeSortController();
        merge.ordenar(vetor);

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}