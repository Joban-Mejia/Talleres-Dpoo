package Interfaz_Final;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Interfaz_Final.*;

public class PanelButtons extends JPanel implements ActionListener{
	
private Inicio interfaz;
	
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop10;
	private JButton btnJugador;
	
	public PanelButtons(Inicio interfaz) {
		
		this.interfaz = interfaz;
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setPreferredSize(new Dimension(100, 40));
		btnNuevo.setBackground(Color.BLACK);
		btnNuevo.setBorder(new LineBorder(Color.BLACK));
		btnNuevo.setBorder(new LineBorder(Color.BLACK));
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setActionCommand("NUEVO");
		btnNuevo.addActionListener(this);
		
		btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setPreferredSize(new Dimension(100, 40));
		btnReiniciar.setBackground(Color.BLACK);
		btnReiniciar.setBorder(new LineBorder(Color.BLACK));
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setActionCommand("REINICIAR");
		btnReiniciar.addActionListener(this);
		
		btnTop10 = new JButton("TOP-10");
		btnTop10.setPreferredSize(new Dimension(100, 40));
		btnTop10.setBackground(Color.BLACK);
		btnTop10.setBorder(new LineBorder(Color.BLACK));
		btnTop10.setForeground(Color.WHITE);
		btnTop10.setActionCommand("TOP");
		btnTop10.addActionListener(this);
		
		btnJugador = new JButton("CAMBIAR JUGADOR");
		btnJugador.setPreferredSize(new Dimension(100, 40));
		btnJugador.setBackground(Color.BLACK);
		btnJugador.setBorder(new LineBorder(Color.BLACK));
		btnJugador.setForeground(Color.WHITE);
		btnJugador.setActionCommand("JUGADOR");
		btnJugador.addActionListener(this);
        
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(225, 610));
		setBorder(new EmptyBorder(5, 10, 5, 10));
		setLayout(new GridBagLayout());
		
		GridBagConstraints b = new GridBagConstraints();
		b.gridx = 0;
		b.gridy = 0;
		b.fill = GridBagConstraints.HORIZONTAL;
		b.weightx = 1;
		b.insets = new Insets(5, 5, 5, 5);
		add(btnNuevo, b);
		
		b.gridx = 0;
		b.gridy = 1;
		add(btnReiniciar, b);
		
		b.gridx = 0;
		b.gridy = 2;
		add(btnTop10, b);
		
		b.gridx = 0;
		b.gridy = 3;
		add(btnJugador, b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
		if (cmd.equals("NUEVO")) {
			interfaz.nuevo();
		} else if(cmd.equals("REINICIAR")) {
			interfaz.reiniciar();
		} else if(cmd.equals("TOP")) {
			interfaz.mostrarTop10();
		} else if(cmd.equals("JUGADOR")) {
			interfaz.cambiarJugador();
		}
		
	}

}
