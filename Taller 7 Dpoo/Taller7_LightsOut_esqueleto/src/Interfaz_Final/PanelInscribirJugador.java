package Interfaz_Final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Interfaz_Final.*;

public class PanelInscribirJugador extends JDialog implements ActionListener{
	
	  private Inicio interfaz;
	    
	    private JLabel lbJugador;
	    private JTextField txtJugador;
	    private JLabel lbMax;
	    private JButton btnJugar;
	    
	    public PanelInscribirJugador(Inicio interfaz) {
	        
	        this.interfaz = interfaz;
	        setResizable(false);
	        setSize(new Dimension(400, 300));  // Increase window size
	        setLayout(new GridBagLayout());
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  // Ensure the dialog is disposed, not minimized
	        
	        lbJugador = new JLabel("NOMBRE");
	        lbJugador.setHorizontalAlignment(SwingConstants.CENTER);
	        lbJugador.setFont(new Font("Arial", Font.BOLD, 20));  // Increase font size
	        
	        txtJugador = new JTextField();
	        txtJugador.setPreferredSize(new Dimension(200, 40));  // Increase text field size
	        txtJugador.setFont(new Font("Arial", Font.PLAIN, 20));  // Increase font size
	        
	        btnJugar = new JButton("JUGAR");
	        btnJugar.setForeground(Color.WHITE);
	        btnJugar.setBackground(Color.BLUE);
	        btnJugar.setActionCommand("JUGAR");
	        btnJugar.addActionListener(this);
	        btnJugar.setFont(new Font("Arial", Font.BOLD, 20));  // Increase font size
	        
	        lbMax = new JLabel("Max. 3 Caracteres");
	        lbMax.setHorizontalAlignment(SwingConstants.CENTER);
	        lbMax.setVerticalAlignment(SwingConstants.BOTTOM);
	        lbMax.setFont(new Font("Arial", Font.PLAIN, 14));  // Increase font size
	        lbMax.setPreferredSize(new Dimension(200, 20));  // Increase label size
	        
	        GridBagConstraints b = new GridBagConstraints();
	        b.gridx = 0;
	        b.gridy = 0;
	        b.fill = GridBagConstraints.HORIZONTAL;
	        b.weightx = 1;
	        b.insets = new Insets(10, 10, 10, 10);  // Increase padding
	        add(lbJugador, b);
	        
	        b.gridx = 0;
	        b.gridy = 1;
	        add(lbMax, b);
	        
	        b.gridx = 0;
	        b.gridy = 2;
	        add(txtJugador, b);
	        
	        b.gridx = 0;
	        b.gridy = 3;
	        add(btnJugar, b);

	        setVisible(true);
	    }
	    
	    public void actionPerformed(ActionEvent e) {
	        String cmd = e.getActionCommand();
	        if (cmd.equals("JUGAR")) {
	            String nombre = txtJugador.getText();
	            if (nombre.length() <= 3) {                
	                interfaz.nuevoJugador(nombre);
	                dispose();
	            } else {
	                lbMax.setForeground(Color.RED);  // Change to red if the name is too long
	                lbMax.setText("Nombre demasiado largo");
	            }
	        }
	    }

}
