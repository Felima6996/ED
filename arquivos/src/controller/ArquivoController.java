package controller;

import java.io.File;

public class ArquivoController {
	
	public ArquivoController() {
		super();
	}
	
	public void procurar( String diretorio, String extencao) {
		
		File fileDir = new File( diretorio );
		File[] fileList = fileDir.listFiles();
		
		if( fileList != null) {
			for (File file : fileList) {
				System.out.println( file.getPath() );
				if (file.isDirectory() ) {
					procurar( file.getName() , extencao);
					
				} else {
					System.out.println( file.getName() );
				}
			}
		}
	}
}