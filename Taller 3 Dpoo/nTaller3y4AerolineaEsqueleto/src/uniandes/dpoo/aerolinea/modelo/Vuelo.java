package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {

	
	private String fecha;
	private Map<String, Tiquete> tiquetes;
	private Ruta ruta;
	private Avion avion;
	
	
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
	}



	public String getFecha() {
		return this.fecha;
	}


	public Ruta getRuta() {
		return this.ruta;
		
	}
	
	public Avion getAvion() {
		return this.avion;
	}
	
	
	public Collection<Tiquete> getTiquetes(){
		return (Collection<Tiquete>) tiquetes.values();
		
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException{
		
		
		int tiquetesVendidos = 0;
		for (int i = 0; i < cantidad; i++) {
			
			int calculadora1 = calculadora.carcularTarifa(this, cliente);
		
			Tiquete tiquete = new Tiquete(fecha, null, cliente, i);
			if (tiquete != null) {
				tiquetes.put(tiquete.getCodigo(), tiquete);
				tiquetesVendidos++;
			} else {
				throw new VueloSobrevendidoException(Vuelo.this);
			}
		}
		return tiquetesVendidos;

		
	}
	
	public boolean equals(Object obj) {
		
		
		return false;
		
	}

	
	
	
	
	
	
	
	
}
