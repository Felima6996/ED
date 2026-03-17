package view;

import controller.ArquivoController;

public class Arquivo {
	public static void main( String[] args ) {
		ArquivoController imp = new ArquivoController();
		imp.procurar("C:\\", ".txt");
	}
}