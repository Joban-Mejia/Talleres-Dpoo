package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;


public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {
	
	protected static int COSTO_POR_KM = 1000;
	
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		Aeropuerto aeropuerto2 = vuelo.getRuta().getDestino();
		Aeropuerto aeropuerto1 = vuelo.getRuta().getOrigen();
		
		
		
		 int distancia = Aeropuerto.calcularDistancia(aeropuerto1, aeropuerto2);
		 int costoBase = COSTO_POR_KM;
		 
		  return costoBase * distancia;
		
	}


	@Override
	public int carcularTarifa(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		
int costoBase = calcularCostoBase(vuelo, cliente);

	    
	    double porcentajeDescuento = calcularPorcentajeDescuento(cliente);

	    
	    double descuento = costoBase * porcentajeDescuento;

	   
	    int costoConDescuento = (int) (costoBase - descuento);

	    
	    int impuestos = calcularValorImpuestos(costoConDescuento);

	    
	    int tarifaTotal = costoConDescuento + impuestos;

	    return tarifaTotal;
		
	}


	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		
		double porcentajeDescuento = 0.0;
	   
	    return porcentajeDescuento;
	
	}


	@Override
	protected int calcularDistanciaVuelo(Ruta ruta) {
		// TODO Auto-generated method stub
		
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		int distancia = Aeropuerto.calcularDistancia(origen, destino);
		
		
		return distancia;
	}


	@Override
	protected int calcularValorImpuestos(int costoBase) {
		// TODO Auto-generated method stub
		
		int impuesto = (int) (IMPUESTO/costoBase);
		
		return impuesto;
	}
	
	
	
	
}
