package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BMC_DAO.No_hay_error;
import BMC_DAO.ProductoDAO;
import BMC_Modelo.Usuario;

import java.awt.Font;

public class IngresoSKUModificacionProductos extends JPanel {
	private JTextField textFieldSku;

	ProductoDAO pd = new ProductoDAO();
	No_hay_error nh = new No_hay_error();
	
	public IngresoSKUModificacionProductos(JFrame frame, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("sku_del_producto.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("Atrás");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Stock panel = new Stock(frame, u);
				setVisible(false);
				frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
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
		
		textFieldSku = new JTextField();
		textFieldSku.setBorder(null);
		textFieldSku.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldSku.setBounds(298, 283, 324, 20);
		add(textFieldSku);
		textFieldSku.setColumns(10);
		
		JLabel lblModificar = new JLabel("");
		lblModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				if(nh.Solo_Numeros(textFieldSku.getText())==false || textFieldSku.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
					a = 1;
				}
				else if(nh.textoVacio(textFieldSku.getText())) {
					JOptionPane.showMessageDialog(null, "Datos Incompletos");
					a = 1;
				}
				
				if(a == 0) {
					int sku = new Integer(textFieldSku.getText());
					
					if(sku<1 || pd.existeId(sku)==false) {
						JOptionPane.showMessageDialog(null, "Datos Incorrectos");
						a = 1;
					}
					if(a == 0) {
						Modificar_Producto panel = new Modificar_Producto(frame, sku, u);
			   			frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.getContentPane().add(cm);
			   			frame.validate();
					}
				}
			}
		});
		lblModificar.setBounds(374, 558, 171, 34);
		add(lblModificar);
		
		
		
		
		
		add(lblFondo);
	}
}
