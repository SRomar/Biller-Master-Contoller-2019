package BMC_Interfaz;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_Modelo.Usuario;

public class AbmClientes extends JPanel {

	public AbmClientes(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes.png")));
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(839, 14, 60, 38);
		lblInicio.setToolTipText("Atr�s");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Principal panel = new Principal(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes_retro.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes.png")));
				
			}
		});
		add(lblInicio);
		
	
		
		
		
		
		
		
		JLabel lblAlta = new JLabel("");
		lblAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				Alta_Clientes panel = new Alta_Clientes(frame, false, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
		        frame.validate();
		        
			}
			@Override
			public void mouseEntered(MouseEvent e) {	lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes_alta.png")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes.png")));
			}
		});
		lblAlta.setBounds(469, 190, 322, 43);
		add(lblAlta);
		
		JLabel lblModificacion = new JLabel("");
		lblModificacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IngresoDniModificacionClientes panel = new IngresoDniModificacionClientes(frame, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
		        frame.validate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes_mod.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes.png")));
			}
		});
		lblModificacion.setBounds(469, 323, 322, 43);
		add(lblModificacion);
		
		JLabel lblBaja = new JLabel("");
		lblBaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BajaClientes panel = new BajaClientes(frame, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
		        frame.validate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes_baja.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes.png")));
			}
		});
		lblBaja.setBounds(469, 256, 322, 43);
		add(lblBaja);
		
	
		JLabel lblConsulta = new JLabel("");
		lblConsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConsultarClientes panel = new ConsultarClientes(frame, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
		        frame.validate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes_cons.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Clientes.png")));
			}
		});
		lblConsulta.setBounds(469, 389, 322, 43);
		add(lblConsulta);
		
		
		add(lblInicio);
		add(lblFondo);
	}
	}


