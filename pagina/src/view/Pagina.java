package view;

import controller.PaginaController;

public class Pagina {
	public static void main ( String[] args) {
		try{
			PaginaController imp = new PaginaController("terra.com.br");
			
			imp.links( "https://www.terra.com.br/");
		} catch ( Exception e) {
			System.out.println("Falha ao carregar");
			e.printStackTrace();
		}
	}
}