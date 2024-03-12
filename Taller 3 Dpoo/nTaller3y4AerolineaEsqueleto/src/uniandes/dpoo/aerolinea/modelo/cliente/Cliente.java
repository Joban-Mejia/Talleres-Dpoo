package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente extends java.lang.Object{
	
	
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	
	public Cliente() {
		
	}

	public abstract String getTipoCliente();
	
	
	public abstract String getIdentificador();
	
	
	public void agregarTiquete(Tiquete tiquete) {
	}
	
	public int calcularValorTotal() {
		return 0;
			}
	
	public void usarTiquetes(Vuelo vuelo) {
		
	}
}