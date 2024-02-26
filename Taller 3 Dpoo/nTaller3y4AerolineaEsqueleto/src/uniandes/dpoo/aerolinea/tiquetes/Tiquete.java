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
		return null;
		
	}

	
	public Vuelo getVuelo() {
		return null;
		
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	
	
	public int getTarifa() {
		return tarifa;
	}
	
	public void marcarComoUsado() {
		
	}
	
	public boolean esUsado() {
		return false;
		
	}
	
	

}
