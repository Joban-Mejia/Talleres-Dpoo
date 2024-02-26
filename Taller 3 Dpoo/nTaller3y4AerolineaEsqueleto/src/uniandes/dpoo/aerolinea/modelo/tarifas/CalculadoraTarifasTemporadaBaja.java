package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaBaja {

	protected static int COSTO_POR_KM_NATURAL = 600;
	protected static int COSTO_POR_KM_CORPORATIVO = 900;
	protected static double DESCUENTO_PEQ = 0.02;
	protected static double DESCUENTO_MEDIANAS = 0.1;
	protected static double DESCUENTO_GRANDES0 = 0.2;
	
	
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		return 0;
		
	}
}
