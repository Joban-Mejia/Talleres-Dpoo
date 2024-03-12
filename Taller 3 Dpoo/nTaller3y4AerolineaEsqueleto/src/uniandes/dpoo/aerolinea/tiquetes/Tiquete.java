package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {
	
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Cliente cliente;
	private Vuelo vuelo;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		
		
	}
	


	public Cliente getCliente() {
		
		
		return this.cliente;
		
	}

	
	public Vuelo getVuelo() {
		return this.vuelo;
		
	}
	
	
	public String getCodigo() {
		return this.codigo;
	}
	
	
	public int getTarifa() {
		return this.tarifa;
	}
	
	public void marcarComoUsado() {
		
		if (usado == false) {
			
			usado = true;
			
		}
				
	}
	
	public boolean esUsado() {
		return this.usado;
		
	}
	
	

}
