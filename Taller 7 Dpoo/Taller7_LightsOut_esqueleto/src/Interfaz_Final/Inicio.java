package Interfaz_Final;

import javax.swing.JFrame;


import uniandes.dpoo.taller7.modelo.*;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

public class Inicio extends JFrame{

	private Tablero tablero;
	private Top10 top10;
	
	private PanelJugador jugador;
	private PanelButtons buttons;
	private PanelTablero panelTablero;
	private PanelEspecificaciones especificaciones;
	private PanelVictoria victoria;
	private PanelTop10 panelTop10;
	private PanelInscribirJugador panelInscribirJugador;
	
	
	
	public Inicio() {
		
		top10 = new Top10();
		String nameArchivoTop = "data\\top10.csv";
		File archivoTop = new File(nameArchivoTop);
		top10.cargarRecords(archivoTop);
		Collection<RegistroTop10> records = top10.darRegistros();
		
		panelTop10 = new PanelTop10(records); 
		buttons = new PanelButtons(this);
		
		especificaciones = new PanelEspecificaciones(this);
		jugador = new PanelJugador();

		int size = especificaciones.getTamanoTablero();
		tablero = new Tablero(size);
		panelTablero = new PanelTablero(tablero.darTablero(), this);
		
		setBackground(Color.LIGHT_GRAY);
		setSize(new Dimension(850, 750));
		setLayout(new BorderLayout());
		
		add(panelTablero, BorderLayout.WEST);
		
		add(jugador, BorderLayout.SOUTH);
		
		add(especificaciones, BorderLayout.NORTH);
		
		add(buttons, BorderLayout.EAST);
		

		setResizable(false);
		setTitle("LightsOut Juego Impresionante :D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setEnabled(false);
		
		panelInscribirJugador = new PanelInscribirJugador(this);
		
		while (panelInscribirJugador.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
		
		tablero.desordenar(size);
		panelTablero.actualizarTablero();
		setEnabled(true);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				try {
					File archivoTop = new File(nameArchivoTop);
					top10.salvarRecords(archivoTop);
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void nuevo(int newSize, int dificultad) {
		Tablero newTablero = new Tablero(newSize);
		setTablero(newTablero);
		tablero.desordenar(dificultad);
		panelTablero.setTablero(tablero.darTablero());
		panelTablero.actualizarTablero();
		jugador.actualizarPuntaje(0);
		jugador.actualizarJugadas(tablero.darJugadas());
	}
	
	public void nuevo() {
		Tablero newTablero = new Tablero(especificaciones.getTamanoTablero());
		setTablero(newTablero);
		tablero.desordenar(especificaciones.getDificultad());
		panelTablero.setTablero(tablero.darTablero());
		panelTablero.actualizarTablero();
		jugador.actualizarJugadas(tablero.darJugadas());
	}
	
	public void setTablero(Tablero tablero) {
		
		this.tablero = tablero;
	}

	public void nuevoJugador(String nombre) {
		
		jugador.actualizarJugador(nombre);
	}

	public void jugar(int i, int j) {
		tablero.jugar(i, j);
		jugador.actualizarJugadas(tablero.darJugadas());
		int puntaje = tablero.calcularPuntaje();
		jugador.actualizarPuntaje(puntaje);
		if (tablero.tableroIluminado()) {
			victoria = new PanelVictoria(this);
			if (top10.esTop10(puntaje)) {
				top10.agregarRegistro(jugador.getNombreJugador(), puntaje);
				Collection<RegistroTop10> records = top10.darRegistros();
				panelTop10 = new PanelTop10(records);
				System.out.println("Nuevo Record");
			}
			setEnabled(false);
		}
	}
	
	public void reiniciar() {
		tablero.reiniciar();
		panelTablero.actualizarTablero();
	}
	
	public void cambiarJugador() {
		panelInscribirJugador = new PanelInscribirJugador(this);
	}
	
	public void mostrarTop10() {
		panelTop10.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		Inicio interfaz = new Inicio();
	}	
}
