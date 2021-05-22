package BMC_Interfaz;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Usuario;

public class Devoluciones extends JPanel {

	UsuariosDAO ud = new UsuariosDAO();
	
	public Devoluciones(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Devoluciones.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(837, 12, 62, 41);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				if(ud.esAdmin(u.getDni())==true) {
					Principal panel = new Principal(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
				}
				else if(ud.esVendedor(u.getDni())==true) {
					Principal_Vendedor panel = new Principal_Vendedor(frame, u);
					setVisible(false);
					frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		setLayout(null);
		add(lblInicio);
		
		
		
		
		
		add(lblFondo);
	}
	}

