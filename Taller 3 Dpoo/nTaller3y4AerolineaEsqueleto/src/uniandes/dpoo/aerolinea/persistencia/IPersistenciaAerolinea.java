package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public interface IPersistenciaAerolinea {
	
	public default void cargarAerolinea(String archivo, Aerolinea aerolinea) {
		
	}
	
	public default void salvarAerolinea(String archivo, Aerolinea aerolinea) {
		
	}

}
