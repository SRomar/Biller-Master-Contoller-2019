package BMC_Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import sun.jvm.hotspot.oops.java_lang_Class;

import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import BMC_DAO.No_hay_error;
import BMC_DAO.UsuariosDAO;
import BMC_Modelo.Administrador;
import BMC_Modelo.EmpleadoDeAlmacen;
import BMC_Modelo.Usuario;
import BMC_Modelo.Vendedor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrarUsuarios extends JPanel {
	private JTextField textFieldUsuario;
	private JTextField textFieldDni;
	private JTextField textFieldDomicilio;
	private JTextField textFieldTelefono;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private String path;
	private JPasswordField passwordField_1;
	public RegistrarUsuarios(JFrame frame, Usuario u) {
		setSize(920, 640);
		setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		JPasswordField passwordField = new JPasswordField(10);
		passwordField.setText(null);
		passwordField.setColumns(10);
		passwordField.setBorder(null);
		passwordField.setBackground(SystemColor.text);
		passwordField.setBounds(403, 327, 334, 28);
		add(passwordField);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(39, 447, 329, 28);
		textFieldUsuario.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldUsuario.setBorder(null);
		textFieldUsuario.setBackground(SystemColor.text);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JComboBox comboBoxPerfil = new JComboBox();
		comboBoxPerfil.setMaximumRowCount(3);
		comboBoxPerfil.setForeground(new Color(34, 139, 34));
		comboBoxPerfil.setFont(new Font("Dialog", Font.BOLD, 15));
		comboBoxPerfil.setBounds(399, 93, 338, 22);
		comboBoxPerfil.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Vendedor", "Empleado de Almacen"}));
		comboBoxPerfil.setToolTipText("");
		add(comboBoxPerfil);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(764, 88, 144, 143);
		lblFoto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Component 77.png")));
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBackground(Color.WHITE);
		add(lblFoto);
		
		ActionListener elegirFoto = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	File fotito = fotito();		
		    	path = fotito.getPath();
		    	ImageIcon imagen = new ImageIcon(path);
		    	lblFoto.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));
		    	
		
		    }
		};
			
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(39, 327, 330, 28);
		textFieldDni.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldDni.setBorder(null);
		textFieldDni.setBackground(SystemColor.text);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldDomicilio.setBorder(null);
		textFieldDomicilio.setBackground(SystemColor.text);
		textFieldDomicilio.setBounds(42, 566, 330, 28);
		textFieldDomicilio.setColumns(10);
		add(textFieldDomicilio);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(400, 205, 330, 28);
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldTelefono.setBorder(null);
		textFieldTelefono.setBackground(SystemColor.text);
		add(textFieldTelefono);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(40, 207, 329, 28);
		textFieldApellido.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldApellido.setBorder(null);
		textFieldApellido.setBackground(SystemColor.text);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(39, 89, 330, 28);
		textFieldNombre.setFont(new Font("Open Sans Semibold", Font.PLAIN, 15));
		textFieldNombre.setBorder(null);
		textFieldNombre.setBackground(SystemColor.text);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		
	
		    	
		    	
		    	
		
		ActionListener volver = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Personal panel = new Personal(frame, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
		        frame.validate();

		    }
		};
		
		passwordField_1 = new JPasswordField(10);
		passwordField_1.setText((String) null);
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(SystemColor.text);
		passwordField_1.setBounds(405, 444, 331, 28);
		add(passwordField_1);
		
		JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
	    		textFieldDni.setText(null);
	    		textFieldUsuario.setText(null);
	    		passwordField.setText(null);
	    		textFieldNombre.setText(null);
	    		textFieldApellido.setText(null);
	    		textFieldDomicilio.setText(null);
	    		textFieldTelefono.setText(null);
	    		lblFoto.setIcon(new ImageIcon("C:\\Users\\Gertrudis\\eclipse-workspace\\Biller_Master_Controller\\res\\Component 77.png"));
	    		comboBoxPerfil.setSelectedItem(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios_Cancelar.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios.png")));
			}
		});
		lblCancelar.setBounds(514, 593, 181, 27);
		add(lblCancelar);
		
		JLabel lblRegistrar =  new JLabel("");
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {UsuariosDAO ud = new UsuariosDAO();
			int dniUsuario = 1;
	    	
			int a = 0;
	    	
	    	//datos incompletos
			
			No_hay_error nh = new No_hay_error();
			
			
			if(textFieldNombre.getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Ingrese un nombre.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
	    		a = 1;
	    	}
			
			else if(textFieldApellido.getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Ingrese un apellido.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
	    		a = 1;
	    	}
			
			else if(textFieldDni.getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Ingrese un DNI.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
	    		a = 1;
	    	}
			else if(textFieldUsuario.getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Ingrese un usuario.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
	    		a = 1;
	    	}
	    	
	    	else if(textFieldDomicilio.getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Ingrese un domicilio.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
	    		a = 1;
	    	}
	    	
	    	else if(textFieldTelefono.getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Ingrese un teléfono.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
	    		a = 1;
	    	}
	    	
	    	
	    	else if(passwordField.getText().equals("")) {
	    		JOptionPane.showMessageDialog(null, "Ingrese una contraseña.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
	    		a = 1;
	    	}
	    	else {
	    		dniUsuario = new Integer (textFieldDni.getText());
			}
	    	
			
			if (nh.Solo_Numeros(textFieldTelefono.getText())) {
	    		JOptionPane.showMessageDialog(null, "El telefono debe contener caracteres especiales.\n Ejemplo: +54 11 5031-3150");
	    		a=1;
			}
	    	
	    	
			if (nh.Solo_Letras_Y_Espacios(textFieldNombre.getText())==false || nh.Solo_Letras_Y_Espacios(textFieldApellido.getText())==false || nh.Solo_Numeros(textFieldDni.getText())==false
	    			|| nh.Solo_Numeros_y_Letras(textFieldUsuario.getText())==false || nh.Solo_Numeros_y_Letras(textFieldDomicilio.getText())==false ||nh.telefono(textFieldTelefono.getText())==false
	    			|| nh.Solo_Numeros_y_Letras(passwordField.getText())==false || nh.Solo_Numeros_y_Letras(passwordField_1.getText())==false ) {
	    		
	    		JOptionPane.showMessageDialog(null, "Datos Incorrectos");
    			a = 1;
				
			}
	    	
	    	
	    	
	    	
	    	
	    	if(a==0){
	    		
	    		
		    	String usuario = textFieldUsuario.getText();
		    	String contrasenia = passwordField.getText();	
		    	String nombre = textFieldNombre.getText();
		    	String apellido = textFieldApellido.getText();
		    	String domicilio = textFieldDomicilio.getText();
		    	String telefono = textFieldTelefono.getText();
		    	String tipo = comboBoxPerfil.getSelectedItem().toString();
		    	
		    	
		    	//File foto = new File();
		    	if (textFieldDni.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$")) {
		    		JOptionPane.showMessageDialog(null, "El DNI solo puede contener números.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
		    		a=1;
				}
		    	if (textFieldTelefono.getText().matches("^[A-Za-z!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$")) {
		    		JOptionPane.showMessageDialog(null, "El teléfono solo puede contener números.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
		    		a=1;
				}
		    	
				if (textFieldUsuario.getText().matches("^[0-9!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\\\\\[\\\\\\\\]~-]+$")) {
					JOptionPane.showMessageDialog(null, "Nombre de usuario inválido", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
					a = 1;
				}
		    	
		    	
		    	
		    	
		    	
		    	//verificaciones
		    	
			    	if(ud.existeNombre(textFieldUsuario.getText().toString())==true) {
			    		JOptionPane.showMessageDialog(null, "Usuario ya existente.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
			    		textFieldUsuario.setText(null);
			    		a = 1;
			    	}
			    	
			    	
			    	if(dniUsuario<10000000L || dniUsuario>900000000L) {
			    		JOptionPane.showMessageDialog(null, "DNI Inválidos.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
			    		textFieldDni.setText(null);
			    		a = 1;
			    	}
			    	if(ud.existeDni(dniUsuario)==true) {
			    		JOptionPane.showMessageDialog(null, "DNI ya registrado.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
			    		textFieldDni.setText(null);
			    		a = 1;
			    	}
			    	
			    	
			    	if (passwordField.getText().toString().equals(passwordField_1.getText().toString())!=true) {
			    		JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "Datos Inválidos.", JOptionPane.WARNING_MESSAGE);
			    		a = 1;
					}
			    	
			    	
			    	
			    	if(a==0) {
	    		if(tipo.equals("Administrador")) {
	    			
		    		Usuario nuevoUsuario = new Administrador();
		    		nuevoUsuario.setDni(dniUsuario);
		    		nuevoUsuario.setNombre(nombre);
		    		nuevoUsuario.setApellido(apellido);
		    		nuevoUsuario.setUsuario(usuario);
		    		nuevoUsuario.setContrasenia(contrasenia);
		    		nuevoUsuario.setDomicilio(domicilio);
		    		nuevoUsuario.setTelefono(telefono);
		    		nuevoUsuario.setTipo(tipo);
		    		nuevoUsuario.setFoto(path);
		    		
		    		ud.ALTA(nuevoUsuario);
		    		JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.", "Aviso.", JOptionPane.INFORMATION_MESSAGE);
		    	}
		    	else if(tipo.equals("Vendedor")) {
		    		Usuario nuevoUsuario = new Vendedor();
		    		nuevoUsuario.setDni(dniUsuario);
		    		nuevoUsuario.setNombre(nombre);
		    		nuevoUsuario.setApellido(apellido);
		    		nuevoUsuario.setUsuario(usuario);
		    		nuevoUsuario.setContrasenia(contrasenia);
		    		nuevoUsuario.setDomicilio(domicilio);
		    		nuevoUsuario.setTelefono(telefono);
		    		nuevoUsuario.setTipo(tipo);
		    		nuevoUsuario.setFoto(path);
		    		
		    		ud.ALTA(nuevoUsuario);
		    		JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.", "Aviso.", JOptionPane.INFORMATION_MESSAGE);
		    	}
		    	else if(tipo.equals("Empleado de Almacen")) {
		    		Usuario nuevoUsuario = new EmpleadoDeAlmacen();
		    		nuevoUsuario.setDni(dniUsuario);
		    		nuevoUsuario.setNombre(nombre);
		    		nuevoUsuario.setApellido(apellido);
		    		nuevoUsuario.setUsuario(usuario);
		    		nuevoUsuario.setContrasenia(contrasenia);
		    		nuevoUsuario.setDomicilio(domicilio);
		    		nuevoUsuario.setTelefono(telefono);
		    		nuevoUsuario.setTipo(tipo);
		    		nuevoUsuario.setFoto(path);
		    		
		    		ud.ALTA(nuevoUsuario);
		    		ud.registrarAlmacenero(nuevoUsuario.getDni());
		    		JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.", "Aviso.", JOptionPane.INFORMATION_MESSAGE);
		    	}
	    		if(a==0) {	    		
	    		
		    		textFieldDni.setText(null);
		    		textFieldUsuario.setText(null);
		    		passwordField.setText(null);
		    		textFieldNombre.setText(null);
		    		textFieldApellido.setText(null);
		    		textFieldDomicilio.setText(null);
		    		textFieldTelefono.setText(null);
		    		passwordField_1.setText(null);
		    		
		    		lblFoto.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Component 77.png")));
		    		comboBoxPerfil.setSelectedItem(0);
	    		}
	    	}
	    	}
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios_Registrar.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios.png")));
			}
		});
		lblRegistrar.setBounds(717, 593, 181, 29);
		add(lblRegistrar);
		
		JLabel lblInicio = new JLabel("");
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Personal panel = new Personal(frame, u);
		        frame.setContentPane(panel);cerrarminimizar cm = new cerrarminimizar(frame); frame.add(cm);
		        frame.validate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios_Retroceso.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios.png")));
			}
		});
		lblInicio.setBounds(840, 17, 55, 31);
		add(lblInicio);
		
		JLabel lblElegirFoto = new JLabel("");
		lblElegirFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File fotito = fotito();		
		    	path = fotito.getPath();
		    	ImageIcon imagen = new ImageIcon(path);
		    	lblFoto.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));
		    	
			}
			@Override
			public void mouseEntered(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios_Seleccionar_Foto.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios.png")));
			}
		});
		lblElegirFoto.setBounds(764, 243, 144, 28);
		add(lblElegirFoto);
		
		
		lblFondo.setBounds(0, 0, 920, 640);
		lblFondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Alta_Usuarios.png")));
		add(lblFondo);
		
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
