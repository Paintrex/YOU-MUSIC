import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.net.Socket;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.SwingConstants;

/**
 * Se trata de un JPanel el cual se encarga de que el usuario pueda buscar información relevante sobre una canción
 * @author Álvaro Bernal Pedret
 */
public class cancionesPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * contendrá el nombre de usuario que hay en la sesión
	 */
	String usuario = "";
	
	/**
	 * contendrá el id de usuario que hay en la sesión
	 */
	String id = "";
	
	/**
	 * contendrá el nombre de la canción introducida
	 */
	String cancion = "";
	
	/**
	 * contendrá el nombre del artista referenciado a la canción a buscar
	 */
	String artista = "";

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancionesPanel frame = new cancionesPanel();
					frame.setVisible(true);//PUEDE DAR FALLO
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cancionesPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PANEL PRINCIPAL
		JPanel panel = new JPanel();
		panel.setBackground(new Color(172, 65, 142));//BACKGROUND-COLOR FROM THE MAIN PANEL
		panel.setBounds(0, 0, 1084, 780);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//PANEL BASE DE LA IMG
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 58, 517, 337);
		panel_1.setBackground(new Color(240, 240, 240));
		panel.add(panel_1);
		panel_1.setLayout(null);
	
		//LABEL DE LA PUTA IMAGEN
		JLabel lblX = new JLabel("");
		lblX.setBounds(102, 11, 315, 315);
		panel_1.add(lblX);
							
		
		//HEADER PANEL
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.RED);
		panel_4.setBounds(0, 0, 1084, 46);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		//PANEL INTERNET CHECKER
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(13, 11, 11));
		panel_5.setForeground(new Color(0, 0, 0));
		panel_5.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_5.setBounds(0, 0, 174, 46);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		//CAMPO TEXTO INTERNET CHECKER
		JLabel lblInternetChecker = new JLabel("INTERNET CHECKER / API");
		lblInternetChecker.setHorizontalAlignment(SwingConstants.CENTER);
		lblInternetChecker.setBackground(Color.GREEN);
		lblInternetChecker.setForeground(new Color(172, 65, 142));
		lblInternetChecker.setFont(new Font("Microsoft YaHei", Font.BOLD, 10));
		lblInternetChecker.setBounds(24, 16, 140, 14);
		panel_5.add(lblInternetChecker);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 16, 14, 14);
		label.setIcon(new ImageIcon(((new ImageIcon("C:/Users/PAINTREX/eclipse-workspace/YOU-MUSIC/img/rojo.png")).getImage()).getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH)));
		panel_5.add(label);
		
		//PANEL BUSCADOR DE CANCIONES
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(13, 11, 11));
		panel_6.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_6.setBounds(173, 0, 530, 46);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		
		//CAMPO DE TEXTO DE ARTISTA (BUSCAR)
		textField = new JTextField();
		textField.setBounds(274, 11, 113, 24);
		panel_6.add(textField);
		textField.setColumns(10);
		
		//TEXTO BUSCAR
		JLabel lblBuscar = new JLabel("Artista : ");
		lblBuscar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblBuscar.setForeground(new Color(172, 65, 142));
		lblBuscar.setBounds(208, 15, 56, 14);
		panel_6.add(lblBuscar);
		
		//BOTÓN ACEPTAR BUSQUEDA
		JButton btnAceptar = new JButton("BUSCAR");
		btnAceptar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnAceptar.setBounds(397, 11, 121, 23);
		panel_6.add(btnAceptar);
		
		//CAMPO DE TEXTO DE CANCIONES (BUSCAR)
		textField_1 = new JTextField();
		textField_1.setBounds(85, 11, 113, 24);
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCancin = new JLabel("Canci\u00F3n : ");
		lblCancin.setForeground(new Color(172, 65, 142));
		lblCancin.setBackground(Color.RED);
		lblCancin.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblCancin.setBounds(10, 13, 65, 19);
		panel_6.add(lblCancin);
		
		//PANEL SALUTACIÓN AL USUARIO
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(13, 11, 11));
		panel_7.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_7.setBounds(702, 0, 382, 46);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		//BOTÓN MENÚ PRINCIPAL
		JButton btnMenPrincipal = new JButton("MEN\u00DA PRINCIPAL");
		btnMenPrincipal.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnMenPrincipal.setBounds(216, 12, 156, 24);
		panel_7.add(btnMenPrincipal);
		
		//BOTÓN AÑADIR A FAVORITOS
		JButton btnAadirAFavoritos = new JButton("A\u00D1ADIR A FAVORITOS");
		btnAadirAFavoritos.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnAadirAFavoritos.setBounds(10, 12, 196, 24);
		panel_7.add(btnAadirAFavoritos);
		
		//PANEL DE LOS DATOS 
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(22, 406, 517, 160);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		//DATOS A MOSTRAR
		JLabel lblNombreDeLa = new JLabel("Nombre de la canci\u00F3n :");
		lblNombreDeLa.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNombreDeLa.setBounds(10, 11, 156, 18);
		panel_3.add(lblNombreDeLa);
		
		JLabel lbllbum = new JLabel("\u00C1lbum : ");
		lbllbum.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lbllbum.setBounds(10, 40, 56, 18);
		panel_3.add(lbllbum);
		
		JLabel lblArtista = new JLabel("Artista : ");
		lblArtista.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblArtista.setBounds(10, 69, 56, 18);
		panel_3.add(lblArtista);
		
		JLabel lblGenero = new JLabel("Genero : ");
		lblGenero.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblGenero.setBounds(10, 98, 67, 18);
		panel_3.add(lblGenero);
		
		JLabel lblPuntuacin = new JLabel("Puntuaci\u00F3n : ");
		lblPuntuacin.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPuntuacin.setBounds(10, 127, 93, 18);
		panel_3.add(lblPuntuacin);
		
		JLabel lblPrueba = new JLabel("");
		lblPrueba.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPrueba.setForeground(new Color(50, 205, 50));
		lblPrueba.setBackground(new Color(50, 205, 50));
		lblPrueba.setBounds(176, 14, 331, 14);
		panel_3.add(lblPrueba);
		
		JLabel lblPrueba_1 = new JLabel("");
		lblPrueba_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPrueba_1.setForeground(new Color(50, 205, 50));
		lblPrueba_1.setBounds(76, 43, 431, 14);
		panel_3.add(lblPrueba_1);
		
		JLabel lblPrueba_2 = new JLabel("");
		lblPrueba_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPrueba_2.setForeground(new Color(50, 205, 50));
		lblPrueba_2.setBounds(76, 72, 431, 14);
		panel_3.add(lblPrueba_2);
		
		JLabel lblPrueba_3 = new JLabel("");
		lblPrueba_3.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPrueba_3.setForeground(new Color(50, 205, 50));
		lblPrueba_3.setBounds(76, 101, 431, 14);
		panel_3.add(lblPrueba_3);
		
		JLabel lblPrueba_4 = new JLabel("");
		lblPrueba_4.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPrueba_4.setForeground(new Color(50, 205, 50));
		lblPrueba_4.setBounds(101, 130, 406, 14);
		panel_3.add(lblPrueba_4);
		
		//PANEL LETRA DE LA CANCIÓN
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(549, 57, 509, 712);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		//SCROLLBAR LETRA DE LA CANCIÓN
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 509, 712);
		panel_8.add(scrollPane_1);
		
		//TEXT-AREA LETRA DE LA CANCIÓN
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		scrollPane_1.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		
		//PANEL DESCRIPCIÓN DE LA CANCIÓN
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(22, 577, 517, 192);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		//SCROLLBAR DESCRIPCIÓN DE LA CANCIÓN
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 517, 192);
		panel_2.add(scrollPane);
		
		//AREA DE TEXTO DE LA DESCRIPCIÓN
		JTextArea txtrPrueba = new JTextArea();
		txtrPrueba.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		scrollPane.setViewportView(txtrPrueba);
		txtrPrueba.setLineWrap(true);
		txtrPrueba.setWrapStyleWord(true);
		txtrPrueba.setEditable(false);
		
		
		
		/**
		 * Evento .addMouseListener que permitirá volver al menú principal cuando sea pulsado
		 */
		btnMenPrincipal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				Homepage hp = new Homepage();
				hp.setVisible(true);
				dispose();
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá iniciar la busqueda de la canción 
		 */
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				String artist_name = textField.getText();
				String track_name = textField_1.getText();
				
				try {
					
					//DATOS BASE DE LA CANCIÓN
					lblPrueba.setText(buscarCanciónB.getNombre(artist_name, track_name));
					lblPrueba_1.setText(buscarCanciónB.getAlbum(artist_name, track_name));
					lblPrueba_2.setText(buscarCanciónB.getArtista(artist_name, track_name));
					lblPrueba_3.setText(buscarCanciónB.getGenero(artist_name, track_name));
					lblPrueba_4.setText(buscarCanciónB.getPuntuacion(artist_name, track_name));
					
					//DATOS DE LA DESCRIPCIÓN
					txtrPrueba.setText(buscarCanciónB.getDescripcion(artist_name, track_name));
					
					//DATOS DE LA LETRA DE LA CANCIÓN
					textArea.setText(buscarCanciónB.getLetra(artist_name, track_name));
					
					//ESTO POSICIONA EL SCROLL ARRIBA CUANDO LE INYECTAMOS TODO EL TEXTO DE GOLPE
					txtrPrueba.setCaretPosition(0);
					textArea.setCaretPosition(0);
					
					//MOSTRAMOS LA PUTA IMAGEN DE LOS COJONES
					BufferedImage img = ImageIO.read(new URL(buscarCanciónB.getIMG(artist_name)));
					lblX.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(315, 315, 2)));
					
				} catch (Exception e) {
					
					ERROR error = new ERROR();
					error.setVisible(true);
					
				}	
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al usuario añadir la canción encontrada a su lista de canciones favoritas
		 */
		btnAadirAFavoritos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				if(lblPrueba.getText().equals("") || lblPrueba_2.getText().equals("")) {
					
					favoritosERROR ferror = new favoritosERROR();
					ferror.setVisible(true);
					
				}else {
					
					usuario = login.nombredeusuario;
					id = managementDB.devolverIDuser(usuario);
					artista = lblPrueba_2.getText();
					cancion = lblPrueba.getText();
					managementDB.insertarFavoritos(id, artista, cancion);
					
				}
						
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
		
	}//CIERRE DEL PANEL PRINCIPAL
}//CIERRE CLASE
