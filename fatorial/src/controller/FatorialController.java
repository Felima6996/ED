package controller;

public class FatorialController {
	public FatorialController(){
		super();
	}
	
	public int calcular ( int numero ) {
		if (numero <= 1)
			return 1;
		return numero * calcular( --numero );
	}
}