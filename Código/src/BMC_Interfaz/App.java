package BMC_Interfaz;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BMC_Modelo.Usuario;

import java.awt.Color;

public class App extends JFrame {
	public App() {
		getContentPane().setForeground(new Color(72, 61, 139));
		getContentPane().setBackground(new Color(72, 61, 139));
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("Biller Master Controller");
		frame.setSize(920, 670);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);		
		Iniciar_Sesion PanelInicio = new Iniciar_Sesion(frame);
		
		
		frame.setContentPane(PanelInicio);
		cerrarminimizar cm = new cerrarminimizar(frame);
		frame.add(cm);
		frame.setVisible(true);
		
		
	}


}