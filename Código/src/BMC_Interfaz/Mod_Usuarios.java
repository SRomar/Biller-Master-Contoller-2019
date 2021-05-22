package BMC_Interfaz;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BMC_DAO.No_hay_error;
import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Usuario;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Mod_Usuarios extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDni;
	private JTextField textFieldUsuario;
	private JTextField textFieldTelefono;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	private JLabel lblFoto;
	private JLabel lblSeleccionarFoto;
	private JLabel lblVaciarCampos;
	private JLabel lblModificar;

	private String path = "";

	UsuariosDAO ud = new UsuariosDAO();
	private JTextField textFieldDomicilio;
	
	public Mod_Usuarios(JFrame frame, int d, Usuario u) {
		setBorder(null);
		setSize(920, 640);
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Mod_Usuarios.png")));
		
		JLabel lblInicio = new JLabel("");
		lblInicio.setBounds(838, 12, 60, 39);
		lblInicio.setToolTipText("AtrÃ¡s");
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(c);
				
				Personal panel = new Personal(frame, u);
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
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBorder(null);
		textFieldNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldNombre.setBounds(38, 88, 330, 30);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldApellido.setBorder(null);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(38, 204, 330, 30);
		add(textFieldApellido);
		
		textFieldDni = new JTextField();
		textFieldDni.setBorder(null);
		textFieldDni.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(38, 324, 330, 30);
		add(textFieldDni);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldUsuario.setBorder(null);
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(38, 446, 330, 30);
		add(textFieldUsuario);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldTelefono.setBorder(null);
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(402, 204, 330, 30);
		add(textFieldTelefono);
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Vendedor", "Empleado de Almacen"}));
		comboBoxTipo.setBounds(402, 88, 330, 30);
		add(comboBoxTipo);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBorder(null);
		passwordField1.setBounds(408, 326, 324, 30);
		add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBorder(null);
		passwordField2.setBounds(408, 444, 324, 30);
		add(passwordField2);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setFont(new Font("Dialog", Font.PLAIN, 15));
		textFieldDomicilio.setBorder(null);
		textFieldDomicilio.setColumns(10);
		textFieldDomicilio.setBounds(38, 565, 330, 30);
		add(textFieldDomicilio);
		textFieldDni.setEditable(false);
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(769, 93, 134, 134);
		add(lblFoto);
		
		lblSeleccionarFoto = new JLabel("");
		lblSeleccionarFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File fotito = fotito();		
		    	path = fotito.getPath();
		    	ImageIcon imagen = new ImageIcon(path);
		    	lblFoto.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));
			}
		});
		lblSeleccionarFoto.setBounds(762, 238, 148, 30);
		add(lblSeleccionarFoto);
		
		lblVaciarCampos = new JLabel("");
		lblVaciarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldDni.setText(null);
				textFieldNombre.setText(null);
		    	textFieldApellido.setText(null);
		    	textFieldUsuario.setText(null);
		    	passwordField1.setText(null);
		    	passwordField2.setText(null);
		    	textFieldDomicilio.setText(null);
		    	textFieldTelefono.setText(null);
		    	comboBoxTipo.setSelectedIndex(0);
		    	lblFoto.setText(null);    	
			}
		});
		lblVaciarCampos.setBounds(515, 593, 184, 30);
		add(lblVaciarCampos);
		
		lblModificar = new JLabel("");
		lblModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = 0;
				
		    	No_hay_error nh = new No_hay_error();

		    	if (nh.Solo_Numeros(textFieldTelefono.getText())) {
		    		JOptionPane.showMessageDialog(null, "El telefono debe contener caracteres especiales.\n Ejemplo: +54 11 5031-3150");
		    		a=1;
				}
		    	
				if (nh.Solo_Letras_Y_Espacios(textFieldNombre.getText())==false || nh.Solo_Letras_Y_Espacios(textFieldApellido.getText())==false || nh.Solo_Numeros(textFieldDni.getText())==false
		    			|| nh.Solo_Numeros_y_Letras(textFieldUsuario.getText())==false || nh.Solo_Numeros_y_Letras(textFieldDomicilio.getText())==false ||nh.telefono(textFieldTelefono.getText())==false
		    			|| nh.Solo_Numeros_y_Letras(passwordField1.getText())==false || nh.Solo_Numeros_y_Letras(passwordField1.getText())==false ) {
		    		
		    		JOptionPane.showMessageDialog(null, "Datos Incorrectos");
	    			a = 1;
					
				}
				if(a == 0) {
					int dni = new Integer(textFieldDni.getText());
			    	String nombre = textFieldNombre.getText();
			    	String apellido = textFieldApellido.getText();	    	
			    	String usuario = textFieldUsuario.getText();
			    	String pass1 = passwordField1.getText();
			    	String pass2 = passwordField2.getText();
			    	String domicilio = textFieldDomicilio.getText();
			    	String telefono = textFieldTelefono.getText();
			    	String tipo = comboBoxTipo.getSelectedItem().toString();
			    	
	
			    	//verificaciones
			    	if(a==0) {		
			    		if(dni<10000000 || dni>45000000) {
			    			JOptionPane.showMessageDialog(null, "DNI fuera de rango");
			    			textFieldDni.setText(null);
			    			a = 1;	
			    		}
			    		
			    		
			    		if(pass2.equals(pass1) == false) {
			    			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
			    			textFieldTelefono.setText(null);
			    			a = 1;
			    		}
			    	}
			    	
			    	
			    	
			    	if(a==0){
			    		if(path.equals("")) {
			    			Usuario u = ud.buscarUsuario(d);			    			
			    			path = u.getFoto();
			    		}
			    		ud.MODIFICACION(dni, nombre, apellido, usuario, pass1, domicilio, telefono, tipo, path);
			    		JOptionPane.showMessageDialog(null, "Modificacion realizada.");
			    		
			    	
				   	}	    	
				}
			}
		});
		lblModificar.setBounds(717, 593, 181, 30);
		add(lblModificar);
		
		add(lblFondo);
		
		
		Usuario us = ud.buscarUsuario(d);

		int dni = us.getDni();
		String str1 = Integer.toString(dni); 
		textFieldDni.setText(str1);
		
		
		String telefon = us.getTelefono();
		textFieldTelefono.setText(telefon);
		textFieldNombre.setText(us.getNombre());
		textFieldApellido.setText(us.getApellido());
		textFieldUsuario.setText(us.getUsuario());
		passwordField1.setText(us.getContrasenia());
		passwordField2.setText(us.getContrasenia());
		textFieldDomicilio.setText(us.getDomicilio());
		comboBoxTipo.setSelectedItem(us.getTipo());
		ImageIcon imagen2 = new ImageIcon(us.getFoto());
    	lblFoto.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));
		
		
		
	}
	
	public File fotito() {
		JFileChooser fc = new JFileChooser();
    	fc.setDialogTitle("Indicar foto del nuevo usuario");
    	fc.setAcceptAllFileFilterUsed(false);
    	fc.setFileFilter(new FiltroImagenUsuario());
    	File archivo = new File("");	
    	if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
     		File archivo1 = new File(fc.getSelectedFile().toString());
     		archivo = archivo1;
    	}
    	return archivo;
	}
	
}
