import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;

/**
 * Esta clase se representará cada vez que el usuario quiera registrarse mediante la pulsación del botón "REGISTRARSE" en la pantalla de login
 * @author Álvaro Beral Pedret
 */
public class registro extends JFrame {

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
					registro frame = new registro();
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
	public registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 669);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 65, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(61, 27, 54));
		panel.setBounds(0, 0, 386, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//LABEL REGISTRO
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setForeground(new Color(172, 65, 142));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Microsoft YaHei", Font.BOLD, 22));
		lblRegistro.setBounds(0, 11, 386, 24);
		panel.add(lblRegistro);
		
		//CAMPO DE TEXTO DEL USUARIO
		textField = new JTextField();
		textField.setBounds(120, 104, 149, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(120, 66, 149, 27);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(120, 155, 149, 27);
		contentPane.add(lblContrasea);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(new Color(0, 0, 0));
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblCorreo.setBounds(120, 252, 149, 27);
		contentPane.add(lblCorreo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(120, 290, 149, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		//BOTÓN REGISTRAR
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnNewButton.setBounds(120, 380, 149, 23);
		contentPane.add(btnNewButton);
		
		//CAMPO DE TEXTO DE LA CONTRASEÑA
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 193, 149, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 414, 366, 206);
		contentPane.add(lblNewLabel);
		
		/**
		 * Evento .addMouseListener que permitirá al usuario registrarse tras cumplir con los requisitos mínimos del registro
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				String username = textField.getText();
				String correo = textField_2.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				if(textField.getText().equals("") || textField_2.getText().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
					
					lblNewLabel.setText("Es obligatorio rellenar todos los campos");
					
				}else {
					
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
					
					if(validacion) {//VALIDACIÓN EMAIL
						
						if(managementDB.comprobarUsuario(username) == "OK" || managementDB.comprobarCorreo(correo) == "OK") {
							
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
							
							if(contra_val) {
								
								managementDB.insertarUsusarios(username, password, correo);
								lblNewLabel.setText("Usuario creado correctamente");
								dispose();
								
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
							
							lblNewLabel.setText("Ya existen los siguientes datos : " + managementDB.comprobarUsuario(username)+ "\n" + managementDB.comprobarCorreo(correo));
							
						}//CIERRE IF
						
					}else {
						
						lblNewLabel.setText("Escribe un correo válido");
							
					}//CIERRE IF
						
				}//CIERRE IF				
			}
		});
		
	}//CIERRE REGISTRO();
}//CIERRE CLASE
