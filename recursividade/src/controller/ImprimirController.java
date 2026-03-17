package controller;

public class ImprimirController {

    public ImprimirController() {
        super();
    }

    public void imprimir(int numero) {
        if (numero >= 10) return;

        System.out.println("Numero: " + numero);
        imprimir(++numero);
    }
}