package BMC_Interfaz;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cerrarminimizar extends JPanel {
	ImageIcon imagen;
	/**
	 * Create the panel.
	 */
	public cerrarminimizar(JFrame frame) {
		setBackground(new Color(72, 61, 139));
		setForeground(new Color(72, 61, 139));
		setSize(920, 670);
		setLayout(null);
		
		JLabel lblCerrar = new JLabel("New label");
		lblCerrar.setBounds(888, 643, 23, 23);
		
		JLabel lblBillerMaster = new JLabel("");
		lblBillerMaster.setBounds(0, 640, 920, 30);
		lblBillerMaster.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Frame 7.png")));
		add(lblBillerMaster);
		JLabel lblMinimizar = new JLabel("New label");
		
		lblMinimizar.setBounds(860, 640, 23, 23);
		add(lblMinimizar);
		add(lblCerrar);
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Salir de Biller Master Controller?", "Aviso.",
				        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				System.exit(0);}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBillerMaster.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Frame 9.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBillerMaster.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Frame 7.png")));
			}
		});
		
	
		
		lblMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(Frame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBillerMaster.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Frame 8.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBillerMaster.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Frame 7.png")));
			}
		});
		
		

		
		
		
	}
}
