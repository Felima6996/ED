package view;

import controller.FatorialController;

public class Fatorial {
	
	public static void main( String [] args ) {
		FatorialController imp = new FatorialController();
		
		System.out.println("Resultado e: " + imp.calcular( 6 ) );
	}
}