package view; // Define que este arquivo pertence ao pacote view

import controller.ListaEncadeadaSimplesController; // Importa o controller que você criou

public class ListaEncadeadaSimples {
    public static void main(String[] args) {
        try {
            // Cria o objeto do controller
            ListaEncadeadaSimplesController obj = new ListaEncadeadaSimplesController();
            
            // Chama o método teste e imprime o resultado no console
            System.out.println(obj.teste());
            
        } catch (Exception e) {
            // Caso ocorra algum erro (como índice inexistente), ele será mostrado aqui
            e.printStackTrace();
        }
    }
}