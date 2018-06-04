import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPasswordField;

/**
 * JPanel que representará el inicio de sesión para los usuarios y administradores
 * @author Álvaro Bernal Pedret
 */
public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;
	
	/**
	 * variable que almacenará el nombre de usuario que haya iniciado sesión
	 */
	public static String nombredeusuario = "";
	
	private JLabel lblInternetChecket;

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel contenido = new JPanel(null); //Con esto el layout no está predefinido y puedes mover tus controles más cómodamente.
		JFrame ventana = new JFrame(); //Sencillo, instancías un JFrame
		ventana.setContentPane(contenido); //Para terminar ese panel lo agregas a la ventana.
		contentPane.setLayout(null);
		
		lblInternetChecket = new JLabel("INTERNET CHECKET / API");
		lblInternetChecket.setForeground(Color.BLACK);
		lblInternetChecket.setBounds(30, 547, 153, 14);
		contentPane.add(lblInternetChecket);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(((new ImageIcon("C:/Users/PAINTREX/eclipse-workspace/YOU-MUSIC/img/rojo.png")).getImage()).getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH)));
		label.setBounds(10, 547, 14, 14);
		contentPane.add(label);
		
		//USERNAME TEXTFIELD
		textField = new JTextField();
		textField.setBounds(159, 234, 183, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//LABEL USUARIO
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(49, 175, 145));
		lblUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(159, 209, 183, 14);
		contentPane.add(lblUsuario);
		
		//LABEL CONTRASEÑA
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(49, 175, 145));
		lblContrasea.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(159, 285, 183, 14);
		contentPane.add(lblContrasea);
		
		//BOTÓN INICIAR SESIÓN
		JButton btnNewButton = new JButton("INICIAR SESI\u00D3N");
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnNewButton.setBounds(159, 361, 183, 33);
		contentPane.add(btnNewButton);
		
		//JPANEL DE LA IMAGEN DE USUARIO
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,0));
		panel.setBounds(159, 11, 183, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(((new ImageIcon("C:\\Users\\PAINTREX\\eclipse-workspace\\YOU-MUSIC\\img\\user_icon.png")).getImage()).getScaledInstance(183, 183, java.awt.Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(0, 0, 183, 183);
		panel.add(lblNewLabel_1);
		
		//BOTÓN REGISTRARSE
		btnNewButton_1 = new JButton("REGISTRARSE");
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnNewButton_1.setBounds(159, 507, 183, 23);
		contentPane.add(btnNewButton_1);
		
		//CAMPO PASSWORD 
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 310, 183, 26);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 446, 474, 33);
		contentPane.add(lblNewLabel_2);
		
		//BACKGROUND IMAGE
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 494, 572);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\PAINTREX\\eclipse-workspace\\YOU-MUSIC\\img\\notas.jpg"));
		contentPane.add(lblNewLabel);
		
		/**
		 * Evento .addMouseListener que llevará las comprobaciones necesarias para determinar si una persona es quien dice ser e iniciar sesión
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			String username = textField.getText();
			String password = String.valueOf(passwordField.getPassword());
			
				try {
					if(username.equals("Paintrex") && password.equals("123")) {
						
						nombredeusuario = textField.getText();
						panelAdministrador pad = new panelAdministrador();
						pad.setVisible(true);
						dispose();
						
					}else {
						
						if(managementDB.login(username, password) == "CORRECTO") {
							
							nombredeusuario = textField.getText();
							Homepage hp = new Homepage();
							hp.setVisible(true);
							
							dispose();
							
						}else {
						
							lblNewLabel_2.setText("Usuario o Contraseña inválidos");
							
						}
						
					}
					
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
			
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá hacer visible el JPanel para que los futuros usuarios se puedan registrar 
		 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				registro rgs = new registro();
				rgs.setVisible(true);
					
			}
		});
		
		/**
		 * timer se encarga de llevar el tiempo que va a tardar el metodo en volverse a ejecutar
		 */
		Timer timer;
		
		/**
		 * tarea se encarga de inicializar la TimerTask()
		 */
		TimerTask tarea;
		
		/**
		 * velocidad se encarga de llevar cada cuanto tiempo en segundos va a tardar el metodo en volver a ejecutarse
		 */
		int velocidad = 2;
		
		/**
		 * velmil se encarga de convertir la velocidad en milisegundos
		 */
		int velmil = velocidad * 1000;
		
		/**
		 * dirWeb es la dirección web a la que aputaremos para comprobar si el servicio API está operativo
		 */
		String dirWeb = "www.theaudiodb.com";
		
		/**
		 * puerto se encarga de llevar el puerto al que recurriremos a la hora de hacer la petición a la api e internet
		 */
		int puerto = 80;
				
		tarea = new TimerTask() {
			
			/**
			 * Metodo run(); que se encarga de comprobar cada 2 segundos si el servicio API y la conexión a internet del usuario están operativos
			 */
			@Override
			public void run() {
				Icon icono;
						
				try{
					  Socket s = new Socket(dirWeb, puerto);
							  
					  if(s.isConnected()){
								  
						  //EN CASO DE QUE FUNCIONE EL INTERNET
						  icono = new ImageIcon(((new ImageIcon("C:/Users/PAINTREX/eclipse-workspace/YOU-MUSIC/img/verde.png")).getImage()).getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH));
						  label.setIcon(icono);
								  
					  }
											
					  s.close();
							  
				}catch(Exception e){

					//EN CASO DE QUE FALLE EL INTERNET
					icono = new ImageIcon(((new ImageIcon("C:/Users/PAINTREX/eclipse-workspace/YOU-MUSIC/img/rojo.png")).getImage()).getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH));
					label.setIcon(icono);
							
				}	
			}//CIERRE RUN
					
		};//CIERRE TIMERTASK
			
		timer = new Timer();
		timer.scheduleAtFixedRate(tarea, 1, velmil);
		
	}//CIERRE public login();
}//CIERRE CLASE
