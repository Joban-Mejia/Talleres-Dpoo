package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    // TODO completar
	
	private String horaSalida;
	private String horaLlegada;
	private String codigoRuta;
	private Aeropuerto destino;
	private Aeropuerto origen;
	
	public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta) {
		
	}
	
	public String getCodigoRuta() {
		// TODO Auto-generated method stub
		return this.codigoRuta;
	}
	
	public Aeropuerto getOrigen() {
		return this.origen;
		
	}
	
	public Aeropuerto getDestino() {
		return this.destino;
		
	}
	
	public String getHoraSalida() {
		return this.horaSalida;
	}


	public String getHoraLlegada() {
		return this.horaLlegada;
	}
	
	public int getDuracion() {
		
		
		int minutosSalida = getMinutos(this.horaSalida);
		int minutosLlegada = getMinutos(this.horaLlegada);
		int horasLlegada = getHoras(this.horaLlegada);
		int horasSalida = getHoras(this.horaSalida);
	
		// Convertir horas de llegada y salida a minutos
		
		// Caso de 11am - 14pm: Serian 3 horas de vuelo
		// Caso 23pm - 1am: serian 2 horas de vuelo
		
		int minutosTotales = minutosLlegada - minutosSalida;
		int horasTotales;
		
		if (horasLlegada >= horasSalida) {
			 horasTotales = horasLlegada - horasSalida;
		}
		
		else  {
			
			horasTotales = (horasLlegada + 24) - horasSalida;	
			
		}
		
		horasTotales = horasTotales * 60;
		
		
		int duracion = horasTotales + minutosTotales;
		
		return duracion;	
		
	}

	
    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }
  
}
