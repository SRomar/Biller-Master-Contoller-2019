package BMC_DAO;

import javax.swing.JOptionPane;

public class No_hay_error {
	
	public boolean Solo_Numeros(String texto) {
		
		boolean esCorrecta;
		
		if(texto.matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^,·ª{}\\\\[\\\\]~-]+$") || texto.matches(".*[a-zA-Z]+.*") || texto.contains(" ")) {
			
			
			esCorrecta = false;
			
			return esCorrecta;
		}
		else {
			
			esCorrecta = true;
			
			
			return esCorrecta;
			
			
		}
		
	}
	
	public boolean Solo_Numeros_Y_Espacios(String texto) {
		
		boolean esCorrecta;
		
		if(texto.matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") || texto.matches(".*[a-zA-Z]+.*")) {
				
			
			esCorrecta = false;
			
			return esCorrecta;
		}
		else {
			
			esCorrecta = true;
			
			
			return esCorrecta;
			
			
		}
		
	}
	
	
	public boolean Solo_Letras(String texto) {
		
		boolean esCorrecta;
		
		if(texto.matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") || texto.matches(".*\\d+.*") || texto.contains(" ")) {
			
				
			esCorrecta = false;
			
			return esCorrecta;
		}
		else {
			
			esCorrecta = true;
			
			
			return esCorrecta;
			
			
		}
		
	}
	
	public boolean Solo_Numeros_y_Letras(String texto) {
		
		boolean esCorrecta;
		//Se aceptan espacios
		if(texto.matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$")) {

			
			esCorrecta = false;
			
			return esCorrecta;
		}
		else {
			
			esCorrecta = true;
			
			
			return esCorrecta;
			
			
		}
		
	}
	
	public boolean letras_y_numeros_separados(String texto) {
		boolean esCorrecta;
		if (texto.matches(".*[a-zA-Z]+.*") && texto.matches(".*\\d+.*")) {
		
			
	esCorrecta = false;
	
	return esCorrecta;
		}
		else {
	
			esCorrecta = true;
	
	
			return esCorrecta;
	
	
		}
	
	}
	
	public boolean textoVacio (String texto) {
		
		boolean esCorrecta;
		
		if (texto.matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") || texto.matches(".*\\d+.*") || texto.matches(".*[a-zA-Z]+.*")) {
		
	
	esCorrecta = false;
	
	return esCorrecta;
		}
		
		else {
	
			esCorrecta = true;
	
	
			return esCorrecta;
	
	
		}
		
		
	}
	
	public boolean Solo_Letras_Y_Espacios(String texto) {
		
		boolean esCorrecta;
		
		if(texto.matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") || texto.matches(".*\\d+.*")) {
			
				
			esCorrecta = false;
			
			return esCorrecta;
		}
		else {
			
			esCorrecta = true;
			
			
			return esCorrecta;
			
			
		}
		
	}
	
	public boolean Solo_Numeros_y_Letras_sin_Espacio(String texto) {
		
		boolean esCorrecta;
		//Se aceptan espacios
		if(texto.matches("^[!@#$%&/*()_+=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~-]+$") || texto.contains(" ") || texto.matches("")) {

			esCorrecta = false;
			System.out.println("el id esta mal");
			return esCorrecta;
		}
		else {
			
			esCorrecta = true;
			
			
			return esCorrecta;
			
			
		}
		
	}
	
	public boolean telefono(String telefono) {
		boolean correcto;
		
		if (telefono.matches(".*[a-zA-Z]+.*") || telefono.matches("^[!@#$%&/*()_=|<>¿?º;:_ñ¨^·ª{}\\\\[\\\\]~]+$") ) {
			correcto = false;
		}
		else {
			correcto=true;
		}
		
		return correcto;
	}
	
	
	
}
