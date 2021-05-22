package BMC_Interfaz;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import BMC_Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Principal extends JPanel {

	/**
	 * Create the panel.
	 */
	int x = -165;
	
	
	public Principal(JFrame frame, Usuario u) {
		
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLayout(null);
		setSize(920, 640);
		
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		Cursor cc = new Cursor(Cursor.DEFAULT_CURSOR);
		
		
		JLabel lblFondo = new JLabel("");
		
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
		
		
		
		JLabel lblConfiguracion = new JLabel("");
		lblConfiguracion.setToolTipText("Cofiguracion");
		lblConfiguracion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Config.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Configuracion panel = new Configuracion(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
		});
		lblConfiguracion.setBounds(470, 66, 125, 100);
		add(lblConfiguracion);
		
		JLabel lblFacturar = new JLabel("");
		lblFacturar.setToolTipText("Facturar");
		lblFacturar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Facturar.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Facturar panel = new Facturar(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
		});
		lblFacturar.setBounds(585, 178, 125, 120);
		add(lblFacturar);
		
		JLabel lblLblstock = new JLabel("");
		lblLblstock.setToolTipText("Stock");
		lblLblstock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Stock.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Stock panel = new Stock (frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
		});
		lblLblstock.setBounds(596, 325, 114, 115);
		add(lblLblstock);
		
		JLabel lblLbldevoluciones = new JLabel("");
		lblLbldevoluciones.setToolTipText("Devoluciones");
		lblLbldevoluciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Devol.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Devoluciones panel = new Devoluciones(frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
		});
		lblLbldevoluciones.setBounds(470, 460, 125, 94);
		add(lblLbldevoluciones);
		
		JLabel lblLblhistorial = new JLabel("");
		lblLblhistorial.setToolTipText("Historial");
		lblLblhistorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Historial.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				HistorialPosta panel = new HistorialPosta(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
		});
		lblLblhistorial.setBounds(318, 460, 140, 94);
		add(lblLblhistorial);
		
		JLabel lblLblestadisticas = new JLabel("");
		lblLblestadisticas.setToolTipText("Estadisticas");
		lblLblestadisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Estadisticas.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Estadisticas panel = new Estadisticas(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
		});
		lblLblestadisticas.setBounds(220, 325, 98, 115);
		add(lblLblestadisticas);
		
		JLabel lblEmpleados = new JLabel("");
		lblEmpleados.setToolTipText("Empleados");
		lblEmpleados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Personal.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Personal panel = new Personal(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
		});
		lblEmpleados.setBounds(218, 178, 98, 120);
		add(lblEmpleados);
		
		JLabel lblClientes = new JLabel("");
		lblClientes.setToolTipText("Clientes");
		lblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Clientes.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(cc);
				lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("FP_Nada.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				AbmClientes panel = new AbmClientes (frame, u);
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
			}
		});
		lblClientes.setBounds(336, 62, 122, 104);
		add(lblClientes);
		
		JLabel Salir = new JLabel("");
		Salir.setToolTipText("Cerrar Sesion");
		Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Iniciar_Sesion panel = new Iniciar_Sesion(frame) ;
				setVisible(false);
				frame.setContentPane(panel);
				cerrarminimizar cm = new cerrarminimizar(frame);
				frame.add(cm);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Salir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exit 2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Salir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exit 1.png")));
			}
		});
		Salir.setIcon(new ImageIcon(getClass().getClassLoader().getResource("exit 1.png")));
		Salir.setBounds(10, 11, 90, 87);
		add(Salir);
		

	

		add(lblFondo);
		
	}
}
