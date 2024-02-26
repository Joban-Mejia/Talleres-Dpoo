package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.Map;

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
		return fecha;
	}


	public Ruta getRuta() {
		return null;
		
	}
	
	public Avion getAvion() {
		return null;
	}
	
	public Collection<Tiquete> getTiquetes(){
		return null;
		
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
		return 0;
		
	}
	
	public boolean equals(Object obj) {
		return false;
		
	}

	
	
	
	
	
	
	
	
}
