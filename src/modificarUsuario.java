import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;

/**
 * JPanel que se representará cuando un administrador quiera modificar datos de un usuario 
 * @author Álvaro Bernal Pedret
 */
public class modificarUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarUsuario frame = new modificarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public modificarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 65, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(169, 34, 175, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 150, 175, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario : ");
		lblUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblUsuario.setBounds(71, 36, 63, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a : ");
		lblContrasea.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblContrasea.setBounds(71, 91, 87, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblCorreo = new JLabel("Correo : ");
		lblCorreo.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblCorreo.setBounds(71, 152, 63, 14);
		contentPane.add(lblCorreo);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnAceptar.setBounds(71, 198, 273, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 232, 414, 149);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 89, 175, 20);
		contentPane.add(passwordField);
		
		/**
		 * Evento .addMouseListener utilizado para modificar los datos de un usuario
		 */
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				String username = textField.getText();
				String correo = textField_2.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				if(textField.getText().equals("")) {
					
					username = null;
					
				}
				
				if(textField_2.getText().equals("")) {
					
					correo = null;
					
				}
				
				if(String.valueOf(passwordField.getPassword()).equals("")){
					
					password = (String) panelAdministrador.modificar_contraseña;
					
				}
					
				Pattern pat = null;
				Matcher mat = null;
				pat = Pattern.compile("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$");
				mat = pat.matcher(correo);
				boolean validacion = false;
					
				if(mat.find()) {
						
					validacion = true;
						
				}else {
						
					validacion = false;
						
				}
					
					if(validacion || correo == "") {//VALIDACIÓN EMAIL
						
						if(managementDB.comprobarUsuario(username) == "OK" && managementDB.comprobarCorreo(correo) == "OK") {
							
							Matcher matcher = null;
							Pattern pattern = null;
							pattern = Pattern.compile("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,32}$");
							matcher = pattern.matcher(password);
							boolean contra_val = false;
							
							if(matcher.find()) {
								
								contra_val = true;
								
							}else {
								
								contra_val = false;
								
							}
							
							if(contra_val  || String.valueOf(passwordField.getPassword()).equals("")) {
								
								if(!String.valueOf(passwordField.getPassword()).equals("")) {
									
									managementDB.modificarUsusarios(username, password, correo, panelAdministrador.id);
									lblNewLabel.setText("Usuario modificado correctamente");
									panelAdministrador.refrescarTabla();
									dispose();
									
								}else {
									
									managementDB.modificarUsusariosContrasena(username, password, correo, panelAdministrador.id);
									lblNewLabel.setText("Usuario modificado correctamente");
									panelAdministrador.refrescarTabla();
									dispose();
									
								}
									
							}else {
								
								lblNewLabel.setText("<html>REQUISITOS CONTRASEÑA <br>"
										+ "&nbsp;&nbsp; *Mínimo 8 caracteres <br>"
										+ "&nbsp;&nbsp; *Máximo 32 <br>"
										+ "&nbsp;&nbsp; *Al menos una letra mayuscula <br>"
										+ "&nbsp;&nbsp; *Al menos una letra minuscula <br>"
										+ "&nbsp;&nbsp; *Al menos un dígito <br>"
										+ "&nbsp;&nbsp; *Sin espacios en blanco <br>"
										+ "&nbsp;&nbsp; *Al menos un carácter NO alfanumérico<html>");
								
							}
								
						}else {
							
							lblNewLabel.setText("Ya existen los siguientes datos : " + managementDB.comprobarUsuario(username)+ "\n \r" + managementDB.comprobarCorreo(correo));
							
						}//CIERRE IF
						
					}else {
						
						lblNewLabel.setText("Escribe un correo válido");
							
					}//CIERRE IF
				
			}
		});
	}
}
