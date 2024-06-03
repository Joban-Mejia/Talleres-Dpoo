package Interfaz_Final;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Interfaz_Final.*;
public class PanelVictoria extends JDialog{
	
	private Inicio interfaz;
	private JLabel lbWin;
	private JLabel lbImagen;
	
	public PanelVictoria(Inicio interfaz) {
		
		this.interfaz = interfaz;
		
		setBackground(Color.BLUE);
		setSize(new Dimension(400, 200));  // Adjusted size to fit the image and text
		setLayout(new GridBagLayout());
        setResizable(false);
        setLocationRelativeTo(null);  // Center the dialog on the screen
        setTitle("VICTORIA");
        
        lbWin = new JLabel("¡¡¡Ganaste!!!");
        lbWin.setHorizontalAlignment(SwingConstants.CENTER);
        lbWin.setFont(lbWin.getFont().deriveFont(20f));  // Increase font size
        
        lbImagen = new JLabel();
        lbImagen.setIcon(new ImageIcon("/data/luz.jpg"));  // Set the path to your image
        
        GridBagConstraints b = new GridBagConstraints();
        b.gridx = 0;
        b.gridy = 0;
        b.gridwidth = 1;
        b.gridheight = 1;
        b.weightx = 1.0;
        b.weighty = 0.5;
        b.insets = new Insets(5, 5, 5, 5);
        b.anchor = GridBagConstraints.CENTER;  // Center the text
        b.fill = GridBagConstraints.BOTH;
        add(lbWin, b);
        
        b.gridy = 1;  // Position the image below the text
        b.weighty = 0.5;
        add(lbImagen, b);

		setVisible(true);
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	setVisible(false);
                dispose();
                interfaz.nuevo();
                interfaz.setEnabled(true);
            }
        });
	}

}
