package BMC_Interfaz;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

public class FiltroImagenUsuario extends FileFilter{ 

	@Override
	public boolean accept(File f) {
		 if ((f.getPath()).endsWith(".png") || (f.getPath()).endsWith(".jpg"))
	         return true;
	      else
	         return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
