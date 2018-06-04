import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
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

/**
 * Esta clase representa el JPanel encargado de hacer las peticiones a la API referentes a la información de un determinado álbum
 * @author Álvaro Bernal Pedret
 */
public class albumesPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					albumesPanel frame = new albumesPanel();
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
	public albumesPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 818);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1084, 46);
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.GREEN);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 194, 46);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INTERNET CHECKER /API");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 10));
		lblNewLabel.setForeground(new Color(172, 65, 142));
		lblNewLabel.setBounds(45, 15, 139, 14);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(21, 15, 14, 14);
		label.setIcon(new ImageIcon(((new ImageIcon("C:/Users/PAINTREX/eclipse-workspace/YOU-MUSIC/img/rojo.png")).getImage()).getScaledInstance(14, 14, java.awt.Image.SCALE_SMOOTH)));
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(193, 0, 496, 46);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnBuscar.setBounds(377, 10, 89, 23);
		panel_2.add(btnBuscar);
		
		textField = new JTextField();
		textField.setBounds(122, 12, 245, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lbllbum = new JLabel("\u00C1lbum : ");
		lbllbum.setForeground(new Color(172, 65, 142));
		lbllbum.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lbllbum.setBounds(47, 14, 65, 14);
		panel_2.add(lbllbum);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(689, 0, 395, 46);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnMenuPrincipal = new JButton("MENU PRINCIPAL");
		btnMenuPrincipal.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnMenuPrincipal.setBounds(39, 10, 313, 23);
		panel_3.add(btnMenuPrincipal);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(172, 65, 142));
		panel_4.setBounds(0, 46, 1084, 734);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 24, 523, 460);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		//LABEL DE LA PUTA IMAGEN
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(47, 11, 438, 438);
		panel_5.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 495, 523, 214);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lbllbum_1 = new JLabel("\u00C1lbum : ");
		lbllbum_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lbllbum_1.setBounds(10, 11, 497, 23);
		panel_6.add(lbllbum_1);
		
		JLabel lblArtista = new JLabel("Artista : ");
		lblArtista.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblArtista.setBounds(10, 45, 497, 23);
		panel_6.add(lblArtista);
		
		JLabel lblAoLanzamiento = new JLabel("A\u00F1o lanzamiento : ");
		lblAoLanzamiento.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblAoLanzamiento.setBounds(10, 79, 497, 23);
		panel_6.add(lblAoLanzamiento);
		
		JLabel lblGenero = new JLabel("Genero : ");
		lblGenero.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblGenero.setBounds(10, 113, 497, 23);
		panel_6.add(lblGenero);
		
		JLabel lblEstilo = new JLabel("Estilo : ");
		lblEstilo.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblEstilo.setBounds(10, 147, 497, 23);
		panel_6.add(lblEstilo);
		
		JLabel lblPuntuacin = new JLabel("Puntuaci\u00F3n : ");
		lblPuntuacin.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPuntuacin.setBounds(10, 181, 497, 23);
		panel_6.add(lblPuntuacin);
		
		//PANEL DE LAS CANCIONES
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(543, 24, 531, 337);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		//JSCROLLPANEL DE LA TABLA
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 511, 315);
		panel_7.add(scrollPane_1);
		
		
		//TABLA DE LAS CANCIONES DEL ALBUM
		table_1 = new JTable(){
			 
			public boolean isCellEditable(int rowIndex, int colIndex) {
			 
			return false; //DE ESTA MANERA LAS CELDAS DEL JTABLE NO SON EDITABLES
			 
			}
		};
			
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Canci\u00F3n", "Duraci\u00F3n"
			}
		));
		scrollPane_1.setViewportView(table_1);
		DefaultTableModel modelo = (DefaultTableModel) table_1.getModel();
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(543, 372, 531, 337);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		//SCROLLBAR DE LA DESCRIPCIÓN
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 531, 337);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_8.add(scrollPane);
		
		//JTEXTAREA DE LA DESCRIPCION
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		/**
		 * Evento .addMouseListener que permitirá volver al menú principal cuando sea pulsado
		 */
		btnMenuPrincipal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				Homepage hp = new Homepage();
				
				hp.setVisible(true);
				dispose();
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá buscar el álbum introducido en su correspondiente caja de texto
		 */
		btnBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				modelo.setRowCount(0);//ESTO LIMPIA LAS FILAS DE LA TABLA PARA QUE NO SE STACKEEN
				String album_name = textField.getText();
				
				try {
					
					String nombre_cancion = "";
					String duracion_cancion = "";
					int segs;
					int minutos;
					int segundos;
					String tiempo = "";
					
					//MOSTRAMOS LA PUTA IMAGEN DE LOS COJONES
					BufferedImage img = ImageIO.read(new URL(buscarAlbumB.getIMG(album_name)));
					lblNewLabel_1.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(438, 438, 2)));
					
					//DATOS BASICOS
					lbllbum_1.setText("Album : " + buscarAlbumB.getAlbum(album_name));
					lblArtista.setText("Artista : " + buscarAlbumB.getArtista(album_name));
					lblAoLanzamiento.setText("Año lanzamiento : " + buscarAlbumB.getAno(album_name));
					lblGenero.setText("Genero : " + buscarAlbumB.getGenero(album_name));
					lblEstilo.setText("Estilo : " + buscarAlbumB.getEstilo(album_name));
					lblPuntuacin.setText("Puntuación : " + buscarAlbumB.getPuntuacion(album_name));
					
					//DESCRIPCIÓN
					textArea.setText(buscarAlbumB.getDescripcion(album_name));
					textArea.setCaretPosition(0);
					
					//PETICIÓN SOBRE LAS CANCIONES DE UN ALBUM Y SU DURACIÓN
					String canciones_album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/track.php?m=" + buscarAlbumB.getCancionesAlbum(album_name));
					
					// Cargamos el JSON en un JSONObject
					JSONObject obj2 = new JSONObject(canciones_album); // Le pasamos el String que contiene el JSON
					
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
					
						
				} catch (Exception excepcion) {
					
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
	}
}
