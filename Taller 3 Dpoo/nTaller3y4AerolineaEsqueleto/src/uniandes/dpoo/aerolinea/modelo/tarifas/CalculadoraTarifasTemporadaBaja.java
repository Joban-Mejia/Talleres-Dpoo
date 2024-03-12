package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{

	protected static int COSTO_POR_KM_NATURAL = 600;
	protected static int COSTO_POR_KM_CORPORATIVO = 900;
	protected static double DESCUENTO_PEQ = 0.02;
	protected static double DESCUENTO_MEDIANAS = 0.1;
	protected static double DESCUENTO_GRANDES = 0.2;
	
	
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		
		Aeropuerto aeropuerto2 = vuelo.getRuta().getDestino();
		Aeropuerto aeropuerto1 = vuelo.getRuta().getOrigen();
		
		
		
		 int distancia = Aeropuerto.calcularDistancia(aeropuerto1, aeropuerto2);
		 int costoBase = COSTO_POR_KM_NATURAL;
		 if (cliente.getTipoCliente().equals("Corporativo")) {
		      costoBase = COSTO_POR_KM_CORPORATIVO;
		}
		   return costoBase * distancia;
		
		
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
		
		double porcentajeDescuento = 0.0;
	    
	    if (cliente.getTipoCliente().equals("Pequeño")) {
	        porcentajeDescuento = DESCUENTO_PEQ;
	    } else if (cliente.getTipoCliente().equals("Medianas")) {
	        porcentajeDescuento = DESCUENTO_MEDIANAS;
	    } else if (cliente.getTipoCliente().equals("Grandes")) {
	        porcentajeDescuento = DESCUENTO_GRANDES;
	    }
	    
	    
	    if (porcentajeDescuento == 0) {
	        porcentajeDescuento = 0.0;
	    } else if (porcentajeDescuento == 1) {
	        porcentajeDescuento = 1.0;
	    }
	    
	    return porcentajeDescuento;
		
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
