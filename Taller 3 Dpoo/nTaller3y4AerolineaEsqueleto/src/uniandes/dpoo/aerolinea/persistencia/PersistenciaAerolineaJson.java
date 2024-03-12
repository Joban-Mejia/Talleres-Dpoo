package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea{
	
	@Override
    public void cargarAerolinea( String archivo, Aerolinea aerolinea ) throws IOException, InformacionInconsistenteException
    {
		String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( )));
        JSONObject raiz = new JSONObject( jsonCompleto );
        
        for (int i = 0; i < aerolinea.getVuelos().size(); i++) {
            JSONObject vuelosObject = (JSONObject) aerolinea.getVuelos();
            		}
        
        for (int i = 0; i < aerolinea.getAviones().size(); i++) {
            JSONObject avionesObject = (JSONObject) aerolinea.getAviones();
            		}
        
        for (int i = 0; i < aerolinea.getRutas().size(); i++) {
            JSONObject rutasObject = (JSONObject) aerolinea.getRutas();
            		}
           
        
    }

    @Override
    public void salvarAerolinea( String archivo, Aerolinea aerolinea )throws IOException
    {
    	JSONObject jobject = new JSONObject( );

     
    }

}
