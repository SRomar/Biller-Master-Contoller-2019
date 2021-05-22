package BMC_Interfaz;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_Modelo.Usuario;

import javax.swing.ImageIcon;

public class Personal extends JPanel {

	/**
	 * Create the panel.
	 */
	public Personal(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel Fondo = new JLabel("");
		Fondo.setBounds(0, 0, 920, 640);

    	Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Nada.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(839, 11, 58, 42);
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
				setCursor(c);
				Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Inicio.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Nada.png")));
				
			}
		});
		setLayout(null);
		setLayout(null);
		add(lblInicio);
		
		
		
		
	
		JLabel lblAltaUsuarios = new JLabel("");
		lblAltaUsuarios.setBounds(464, 188, 332, 48);
		lblAltaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrarUsuarios panel = new RegistrarUsuarios(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Alta.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Nada.png")));
			}
		});
		add(lblAltaUsuarios);
		
		JLabel lblBajaUsuarios = new JLabel("");
		lblBajaUsuarios.setBounds(464, 254, 332, 48);
		lblBajaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Baja_Usuarios panel = new Baja_Usuarios(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Baja.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Nada.png")));
			}
		});
		add(lblBajaUsuarios);
		
		JLabel lblModificarUsuarios = new JLabel("");
		lblModificarUsuarios.setBounds(464, 321, 332, 48);
		lblModificarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IngresoDniModificacionUsuario panel = new IngresoDniModificacionUsuario(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Mod.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Nada.png")));
			}
		});
		add(lblModificarUsuarios);
		
		JLabel lblConsultarUsuarios = new JLabel("");
		lblConsultarUsuarios.setBounds(464, 389, 332, 48);
		lblConsultarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultar_Usuarios panel = new Consultar_Usuarios(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Consultar.png")));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {Fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("U_Nada.png")));
			}
		});
		add(lblConsultarUsuarios);
		add(Fondo);
		
	}
	}


