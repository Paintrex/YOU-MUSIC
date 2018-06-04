import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;

/**
 * Esta clase representa en un JPanel la página de bienvenida.
 * @author Álvaro Bernal Pedret
 */
public class Homepage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lblInternetChecker;

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//TOP PANEL
		JPanel panel = new JPanel();
		panel.setBackground(new Color(13, 11, 11));//BACKGROUND-COLOR FROM THE FIRST PANEL
		panel.setBounds(0, 0, 1084, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//PANEL INTERNET CHECKER
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_3.setBounds(0, 0, 542, 61);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		//LABEL INTERNET CHECKER
		lblInternetChecker = new JLabel("");
		lblInternetChecker.setIcon(new ImageIcon(((new ImageIcon("C:/Users/PAINTREX/eclipse-workspace/YOU-MUSIC/img/rojo.png")).getImage()).getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH)));
		lblInternetChecker.setForeground(new Color(172, 65, 142));
		lblInternetChecker.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblInternetChecker.setBounds(163, 23, 14, 14);
		panel_3.add(lblInternetChecker);
		
		JLabel lblInternetChecker_1 = new JLabel("INTERNET CHECKER / API");
		lblInternetChecker_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblInternetChecker_1.setForeground(new Color(172, 65, 142));
		lblInternetChecker_1.setBounds(187, 23, 167, 14);
		panel_3.add(lblInternetChecker_1);
		
		//PANEL SALUTACIÓN USUARIO
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_4.setBounds(541, 0, 543, 61);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		//LABEL SALUTACIÓN USUARIO
		JLabel lblHolausuario = new JLabel("SALUDOS, " + login.nombredeusuario + " !");
		lblHolausuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblHolausuario.setForeground(new Color(172, 65, 142));
		lblHolausuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblHolausuario.setBounds(10, 23, 523, 18);
		panel_4.add(lblHolausuario);
		
		//MID PANEL
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(172, 65, 142));//BACKGROUND-COLOR FROM THE SECOND PANEL
		panel_1.setBounds(0, 61, 1084, 325);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//BOTÓN CANCIONES
		JButton btnCanciones = new JButton("CANCIONES");
		btnCanciones.setBounds(316, 21, 456, 53);
		btnCanciones.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		panel_1.add(btnCanciones);
		
		//BOTÓN ÁLBUMES
		JButton btnlbumes = new JButton("\u00C1LBUMES");
		btnlbumes.setBounds(316, 96, 456, 53);
		btnlbumes.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		panel_1.add(btnlbumes);
		
		//BOTÓN ARTISTAS
		JButton btnArtistas = new JButton("ARTISTAS");
		btnArtistas.setBounds(316, 172, 456, 53);
		btnArtistas.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		panel_1.add(btnArtistas);
		
		//BOTÓN "TUS CANCIONES FAVORITAS"
		JButton btnTusCancionesFavoritas = new JButton("TUS CANCIONES FAVORITAS");
		btnTusCancionesFavoritas.setBounds(316, 249, 456, 53);
		btnTusCancionesFavoritas.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		panel_1.add(btnTusCancionesFavoritas);
		
		//BOTTOM PANEL
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(61, 27, 54));//BACKGROUND-COLOR FROM THE THIRD PANEL
		panel_2.setBounds(0, 386, 1084, 196);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//TEXTO DESCRIPTIVO
		JLabel lblPrueba = new JLabel("");
		lblPrueba.setForeground(new Color(204, 102, 204));
		lblPrueba.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblPrueba.setVerticalAlignment(SwingConstants.TOP);
		lblPrueba.setBounds(10, 11, 1064, 174);
		panel_2.add(lblPrueba);
		
		/**
		 * Este evento .addMouseListener hara que cuando el usuario haga hover sobre el botón "CANCIONES" aparezca una pequeña descripción de lo que podrá encontrar si clicka
		 */
		btnCanciones.addMouseMotionListener(new MouseMotionAdapter() {
		public void mouseMoved(MouseEvent arg0) {
			
			lblPrueba.setText("<html>BUSCA TUS CANCIONES FAVORITAS E INFORMARTE SOBRE ELLAS CON TAN SOLO UN CLICK. PODRÁS ENCONTRAR : <br>"
						+ "<br>"
						+ "&nbsp;&nbsp; *EL ARTISTA COMPOSITOR <br>"
						+ "&nbsp;&nbsp; *EL ÁLBUM AL QUE PERTENECE <br>"
						+ "&nbsp;&nbsp; *SU GENERO <br>"
						+ "&nbsp;&nbsp; *SU PUNTUACIÓN EN BASE A LA PÁGINA www.theaudiodb.com <br>"
						+ "&nbsp;&nbsp; *INFORMACIÓN DE INTERÉS SOBRE LA MISMA<html>");
			
			}
		});
		
		/**
		 * Este evento .addMouseListener hara que cuando el usuario haga hover sobre el botón "ALBUMES" aparezca una pequeña descripción de lo que podrá encontrar si clicka
		 */
		btnlbumes.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				
				lblPrueba.setText("<html>BUSCA TUS ALBUMES FAVORITOS E INFORMARTE SOBRE ELLOS CON TAN SOLO UN CLICK. PODRÁS ENCONTRAR : <br>"
						+ "<br>"
						+ "&nbsp;&nbsp; *EL ARTISTA COMPOSITOR <br>"
						+ "&nbsp;&nbsp; *AÑO DE LANZAMIENTO <br>"
						+ "&nbsp;&nbsp; *SU GENERO <br>"
						+ "&nbsp;&nbsp; *SU ESTILO <br>"
						+ "&nbsp;&nbsp; *SU PUNTUACIÓN EN BASE A LA PÁGINA www.theaudiodb.com <br>"
						+ "&nbsp;&nbsp; *INFORMACIÓN DE INTERÉS SOBRE EL MISMO <br>"
						+ "&nbsp;&nbsp; *LAS CANCIONES QUE LO COMPONEN<html>");
				
			}
		});
		
		/**
		 * Este evento .addMouseListener hara que cuando el usuario haga hover sobre el botón "ARTISTAS" aparezca una pequeña descripción de lo que podrá encontrar si clicka
		 */
		btnArtistas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				
				lblPrueba.setText("<html>BUSCA TUS ARTISTAS FAVORITOS E INFORMARTE SOBRE ELLOS CON TAN SOLO UN CLICK. PODRÁS ENCONTRAR : <br>"
						+ "<br>"
						+ "&nbsp;&nbsp; *SU NOMBRE <br>"
						+ "&nbsp;&nbsp; *AÑO DE FORMACIÓN <br>"
						+ "&nbsp;&nbsp; *ESTILO <br>"
						+ "&nbsp;&nbsp; *GENERO <br>"
						+ "&nbsp;&nbsp; *PÁGINA OFICIAL <br>"
						+ "&nbsp;&nbsp; *Nº DE INTEGRANTES<html>");
				
			}
		});
		
		/**
		 * Este evento .addMouseListener hara que cuando el usuario haga hover sobre el botón "TUS CANCIONES FAVORITAS" aparezca una pequeña descripción de lo que podrá encontrar si clicka
		 */
		btnTusCancionesFavoritas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent arg0) {
				
				lblPrueba.setText("<html>VISUALIZA TU LISTA DE CANCIONES FAVORITAS.<br><html>");

				
			}
		});
		
		/**
		 * Este evento .addMouseListener hara que cuando el usuario haga hover sobre el background de la app se formatée el texto a ""
		 */
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				
				lblPrueba.setText("");
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al usuario acceder al JPanel correspondiente a la busqueda de canciones
		 */
		btnCanciones.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				cancionesPanel cp = new cancionesPanel();
				cp.setVisible(true);
				dispose();
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al usuario acceder al JPanel correspondiente a la busqueda de albumes
		 */
		btnlbumes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				albumesPanel ap = new albumesPanel();
				ap.setVisible(true);
				dispose();
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al usuario acceder al JPanel correspondiente a la busqueda de artistas
		 */
		btnArtistas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				artistasPanel artp = new artistasPanel();
				artp.setVisible(true);
				dispose();
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al usuario acceder al JPanel correspondiente a su lista de canciones favoritas
		 */
		btnTusCancionesFavoritas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				cancionesFavoritas cf = new cancionesFavoritas();
				cf.setVisible(true);
				dispose();
				
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
						  lblInternetChecker.setIcon(icono);
						  
						}
									
					  s.close();
					  
				}catch(Exception e){

					//EN CASO DE QUE FALLE EL INTERNET
					icono = new ImageIcon(((new ImageIcon("C:/Users/PAINTREX/eclipse-workspace/YOU-MUSIC/img/rojo.png")).getImage()).getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH));
					lblInternetChecker.setIcon(icono);
					
				}	
			}//CIERRE RUN
			
		};//CIERRE TIMERTASK
	
		timer = new Timer();
		timer.scheduleAtFixedRate(tarea, 1, velmil);
		
	}//CIERRE Homepage();
}//CIERRE CLASE
