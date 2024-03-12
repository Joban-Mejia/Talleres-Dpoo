package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {
	public static final double IMPUESTO = 0.28;
	
	
	abstract public int carcularTarifa(Vuelo vuelo, Cliente cliente);
	
	abstract protected  int calcularCostoBase(Vuelo vuelo, Cliente cliente);	
	
	abstract protected double calcularPorcentajeDescuento(Cliente cliente);
	
	abstract protected int calcularDistanciaVuelo(Ruta ruta);
	
	abstract protected int calcularValorImpuestos(int costoBase);
}
