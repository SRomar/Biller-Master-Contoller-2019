package BMC_Interfaz;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_Modelo.Usuario;

public class ABMfactura extends JPanel {


	public ABMfactura(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Facturarrr.png")));
		
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(836, 12, 63, 40);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Principal panel = new Principal(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Facturarrr_retro.png")));
				setCursor(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Facturarrr.png")));
				
			}
		});
		setLayout(null);
		add(lblInicio);
		add(lblFondo);
		
		JLabel lblLblfacturar = new JLabel("lblFacturar");
		lblLblfacturar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				Facturar panel = new Facturar(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Facturarrr_fac.png")));
			setCursor(c);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Facturarrr.png")));
			
		}
		});
		lblLblfacturar.setBounds(462, 189, 333, 47);
		add(lblLblfacturar);
	}
	}



