import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.Socket;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Esta clase representa el JPanel encargado de hacer las peticiones a la API referentes a la información de un determinado artista
 * @author Álvaro Bernal Pedret
 */
public class artistasPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					artistasPanel frame = new artistasPanel();
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
	public artistasPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1084, 46);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInternetChecker = new JLabel("INTERNET CHECKER / API");
		lblInternetChecker.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblInternetChecker.setForeground(new Color(172, 65, 142));
		lblInternetChecker.setBounds(47, 16, 175, 14);
		panel.add(lblInternetChecker);
		
		JButton btnMenuPrincipal = new JButton("MENU PRINCIPAL");
		btnMenuPrincipal.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnMenuPrincipal.setBounds(889, 11, 156, 24);
		panel.add(btnMenuPrincipal);
		
		JLabel lblArtista = new JLabel("Artista : ");
		lblArtista.setForeground(new Color(172, 65, 142));
		lblArtista.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblArtista.setBounds(358, 16, 56, 14);
		panel.add(lblArtista);
		
		textField = new JTextField();
		textField.setBounds(449, 14, 194, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnNewButton.setBounds(686, 12, 89, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBounds(23, 16, 14, 14);
		label.setIcon(new ImageIcon(((new ImageIcon("C:/Users/PAINTREX/eclipse-workspace/YOU-MUSIC/img/rojo.png")).getImage()).getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH)));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(172, 65, 142));
		panel_1.setBounds(0, 46, 1084, 734);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(25, 32, 496, 353);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		//LABEL DE LA IMAGEN
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(84, 11, 331, 331);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(563, 32, 496, 353);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPaisDeOrigen = new JLabel("Pais de origen : ");
		lblPaisDeOrigen.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPaisDeOrigen.setBounds(10, 11, 476, 24);
		panel_3.add(lblPaisDeOrigen);
		
		JLabel lblNombre = new JLabel("Nombre : ");
		lblNombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNombre.setBounds(10, 57, 476, 24);
		panel_3.add(lblNombre);
		
		JLabel lblAoFormacin = new JLabel("A\u00F1o formaci\u00F3n : ");
		lblAoFormacin.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblAoFormacin.setBounds(10, 103, 476, 24);
		panel_3.add(lblAoFormacin);
		
		JLabel lblEstilo = new JLabel("Estilo : ");
		lblEstilo.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblEstilo.setBounds(10, 156, 476, 24);
		panel_3.add(lblEstilo);
		
		JLabel lblGenero = new JLabel("Genero : ");
		lblGenero.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblGenero.setBounds(10, 204, 476, 24);
		panel_3.add(lblGenero);
		
		JLabel lblPginaOficial = new JLabel("P\u00E1gina oficial : ");
		lblPginaOficial.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPginaOficial.setBounds(10, 255, 476, 24);
		panel_3.add(lblPginaOficial);
		
		JLabel lblNIntegrantes = new JLabel("N\u00BA Integrantes : ");
		lblNIntegrantes.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblNIntegrantes.setBounds(10, 309, 476, 24);
		panel_3.add(lblNIntegrantes);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(563, 411, 496, 294);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		//SCROLLPANEL DE LA DESCRIPCIÓN
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 496, 294);
		panel_4.add(scrollPane_1);
		
		//JTEXTAREA DE LA DESCRIPCIÓN
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setEditable(false);
		
		//JPANEL PARA LA TABLA DE 10 MOST LOVED SONGS
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(25, 411, 496, 294);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		//SCROLLPANEL DE LAS 10 MOST LOVED SONGS
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 476, 249);
		panel_5.add(scrollPane);
		
		//TABLA DE LAS 10 MOST LOVED SONGS
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Canci\u00F3n", "Duraci\u00F3n"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblMejoresCancionesDel = new JLabel("MEJORES CANCIONES DEL ARTISTA");
		lblMejoresCancionesDel.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblMejoresCancionesDel.setBounds(130, 9, 234, 14);
		panel_5.add(lblMejoresCancionesDel);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		/**
		 * Evento .addMouseListener que permitirá volver al menú principal cuando sea pulsado
		 */
		btnMenuPrincipal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				Homepage hp = new Homepage();
				hp.setVisible(true);
				dispose();
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá buscar el artista introducido en su correspondiente caja de texto
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				try {
					
					if(textField.getText().equals("")) {//DE ESTA MANERA EVITAMOS QUE EL CAMPO TEXTFIELD ESTÉ VACÍO
						
						ERROR error = new ERROR();
						error.setVisible(true);
						
					}else {
						
						String nombre_cancion = "";
						String duracion_cancion = "";
						int segs;
						int minutos;
						int segundos;
						String tiempo = "";
					
						String artist_name = textField.getText();
						modelo.setRowCount(0);//ESTO LIMPIA LAS FILAS DE LA TABLA PARA QUE NO SE STACKEEN
						
						lblPaisDeOrigen.setText("Pais de origen : " + buscarArtistaB.getPais(artist_name));
						lblNombre.setText("Nombre : " + buscarArtistaB.getNombre(artist_name));
						lblAoFormacin.setText("Año formación : " + buscarArtistaB.getAnoFormacion(artist_name));
						lblEstilo.setText("Estilo : " + buscarArtistaB.getEstilo(artist_name));
						lblGenero.setText("Genero : " + buscarArtistaB.getGenero(artist_name));
						lblPginaOficial.setText("Página oficial : " + buscarArtistaB.getPaginaOficial(artist_name));
						lblNIntegrantes.setText("Nº Integrantes : " + buscarArtistaB.getIntegrantes(artist_name));
						
						//MOSTRAMOS LA PUTA IMAGEN DE LOS COJONES
						BufferedImage img = ImageIO.read(new URL(buscarArtistaB.getIMG(artist_name)));
						lblNewLabel_1.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(331, 331, 2)));
						
						//MOSTRAMOS LA BIOGRAFIA DEL ARTISTA
						textArea_1.setText(buscarArtistaB.getDescripcion(artist_name));
						
						//ESTO COLOCA EL SCROLL AL PRINCIPIO AUTOMATICAMENTE
						textArea_1.setCaretPosition(0);
						
						//10 MOST LOVED SONGS
						
						try {
							String peticion_loved_songs = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/track-top10-mb.php?s=" + buscarArtistaB.getCanciones(artist_name));
							
							// Cargamos el JSON en un JSONObject
							JSONObject obj2 = new JSONObject(peticion_loved_songs); // Le pasamos el String que contiene el JSON
							
							JSONArray canciones = obj2.getJSONArray("track");
							
							for(int i = 0; i < canciones.length(); i++) {
								
								//Recogemos los datos necesarios del JSON
								JSONObject cancion = canciones.getJSONObject(i);
								
								try {nombre_cancion = cancion.getString("strTrack");} catch(Exception exception) { nombre_cancion = "No disponible";}
								try {duracion_cancion = cancion.getString("intDuration");} catch(Exception exception) { duracion_cancion = "No disponible";}
								
								segs = Integer.parseInt(duracion_cancion) / 1000;
								minutos = segs / 60;
								segundos = segs % 60; 
										
								if(minutos < 10) {
									tiempo = "0" + minutos;
									tiempo = tiempo + ":";
								}else {
									tiempo = "" + minutos;
									tiempo = tiempo + ":";	
								}
								
								if (segundos < 10) {
									tiempo = tiempo + "0" + segundos;
								}else {
									tiempo = tiempo + segundos;
								}
								
								modelo.addRow(new Object[] {nombre_cancion, tiempo});
									
							}//CIERRE BUCLE
							
						}catch (Exception exception) {
							
								modelo.addRow(new Object[] {"No disponible", "No disponible"});
							
						}
					}
					
				}catch(Exception exception) {
					
					ERROR error = new ERROR();
					error.setVisible(true);
					
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
		 * velmid se encarga de convertir la velocidad en milisegundos
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
		
	}//CIERRE DEL PANEL/FRAME
}//CIERRE CLASE
