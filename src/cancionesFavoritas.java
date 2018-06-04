import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Statement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Se trata de un JPanel el cual se encarga de mostrar las canciones favoritas de cada usuario.
 * @author Álvaro Bernal Pedret
 */
public class cancionesFavoritas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	
	/**
	 * contendrá el nombre de usuario que hay en la sesión
	 */
	String usuario = "";
	
	/**
	 * contiene el nombre de usuario de la base de datos
	 */
	private static final String user = "u634818610_alv";
	
	/**
	 * contiene la contraseña de la base de datos
	 */
	private static final String pass = "cc7BZemM";
	
	/**
	 * contiene la url de la base de datos
	 */
	private static final String url = "jdbc:mysql://sql151.main-hosting.eu/u634818610_alv";
	
	/**
	 * variable utilizada para establecer conexion con la base de datos
	 */
	public static Connection con = null;
	
	/**
	 * variable para la declaración de la conexion junto con la sentencia SQL que se va a ejecutar
	 */
	public static PreparedStatement pst = null;
	
	/**
	 * variable utilizada para almacenar la devolución de datos referente a la sentencia SQL previamente ejecutada
	 */
	public static ResultSet rs = null;
	
	/**
	 * variable para la declaración de la conexion junto con la sentencia SQL que se va a ejecutar
	 */
	public static PreparedStatement psInsertar;
	
	/**
	 * variable para la declaración de la conexion junto con la sentencia SQL que se va a ejecutar
	 */
	public static Statement stmmt;
	
	/**
	 * variable utilizada para establecer conexion con la base de datos
	 */
	public static Connection conexion;

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancionesFavoritas frame = new cancionesFavoritas();
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
	public cancionesFavoritas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 65, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 614, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTusCancionesFavoritas = new JLabel("TUS CANCIONES FAVORITAS");
		lblTusCancionesFavoritas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTusCancionesFavoritas.setFont(new Font("Microsoft YaHei", Font.BOLD, 22));
		lblTusCancionesFavoritas.setForeground(new Color(172, 65, 142));
		lblTusCancionesFavoritas.setBounds(10, 11, 594, 24);
		panel.add(lblTusCancionesFavoritas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 594, 185);
		contentPane.add(scrollPane);
		
		//TABLA DE CANCIONES FAVORITAS
		table = new JTable(){
			 
			public boolean isCellEditable(int rowIndex, int colIndex) {
			 
			return false; //DE ESTA MANERA LAS CELDAS DEL JTABLE NO SON EDITABLES
			 
			}
		};
		
		table.setModel(new DefaultTableModel());
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 57, 594, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar : ");
		lblBuscar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblBuscar.setBounds(10, 11, 56, 24);
		panel_1.add(lblBuscar);
		
		textField = new JTextField();
		textField.setBounds(76, 14, 151, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		//BOTÓN PARA ACEPTAR LA BUSQUEDA
		JButton btnAceptar = new JButton(" ACEPTAR");
		btnAceptar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnAceptar.setBounds(237, 13, 106, 23);
		panel_1.add(btnAceptar);
		
		JButton btnMenuPrincipal = new JButton("MENU PRINCIPAL");
		btnMenuPrincipal.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnMenuPrincipal.setBounds(427, 12, 157, 23);
		panel_1.add(btnMenuPrincipal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 360, 594, 23);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTuId = new JLabel("Tu ID : ");
		lblTuId.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuId.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblTuId.setBounds(10, 5, 574, 14);
		panel_2.add(lblTuId);
		
		//BOTÓN BORRAR
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnBorrar.setBounds(120, 314, 100, 23);
		contentPane.add(btnBorrar);
		
		//MOSTRAR EL ID DEL USUARIO
		usuario = login.nombredeusuario;
		lblTuId.setText("Tu ID : " + managementDB.devolverIDuser(usuario));
		
		JLabel lblPrueba = new JLabel("");
		lblPrueba.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrueba.setBounds(332, 314, 272, 23);
		contentPane.add(lblPrueba);
		
		JButton btnMiLista = new JButton("MI LISTA");
		btnMiLista.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnMiLista.setBounds(10, 314, 100, 23);
		contentPane.add(btnMiLista);
		
		/**
		 * variable utilizada para recoger el id del usuario logeado
		 */
		String id = managementDB.devolverIDuser(usuario);
		
		/**
		 * variable utilizada para generar la sentencia SQL
		 */
		String sql = "SELECT Cancion, Artista FROM Canciones WHERE ID='" + id + "'";
	
		try {
			
			con = DriverManager.getConnection(url, user, pass);	
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			  for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
				  
	                modelo.addColumn(rs.getMetaData().getColumnName(i));
	                
	            }
			  
	          while(rs.next()){
	        	  
	                Object[] fila = new Object[rs.getMetaData().getColumnCount()];
	                
	                for(int i=0; i < rs.getMetaData().getColumnCount(); i++){
	                	
	                    fila[i]=rs.getObject(i+1);
	                    
	                }
	                modelo.addRow(fila);
	            }
	        
	     
		}catch(Exception e) {
			
			System.out.println(e);
		
		}//CIERRE TRY AND CATCH
		
		
		
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
		 * Evento .addMouseListener que permitirá  al usuario borrar canciones favoritas que ya no quiera en su lista
		 */
		btnBorrar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("rawtypes")
			public void mouseClicked(MouseEvent arg0) {
				
				int fila_selec = table.getSelectedRow();
				
				
				if(fila_selec >= 0) {
					
					try {
						
						Vector datos_fila = modelo.getDataVector().elementAt(table.getSelectedRow());
						Object cancion = datos_fila.elementAt(0);
						Object artista = datos_fila.elementAt(1);
						String usuario = login.nombredeusuario;
						String id = managementDB.devolverIDuser(usuario);
						
						String sql = "DELETE FROM Canciones WHERE Cancion='" + cancion + "' AND Artista='" + artista + "' AND ID='" + id + "'";
						conexion = DriverManager.getConnection(url, user, pass);
						stmmt = (Statement) conexion.createStatement();
						psInsertar = conexion.prepareStatement(sql);
						psInsertar.executeUpdate();
						
						if(btnBorrar.isEnabled() == false) {}else { modelo.removeRow(fila_selec);}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
					
				}else {
					
					System.out.println("fila no seleccionada");
					
				}
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al usuario buscar la lista de canciones favoritas de otros usuarios (amigos que hayan compartido su ID)
		 */
		btnAceptar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				//MOSTRAR LISTA DE CANCIONES FAVORITAS
				
				String id = textField.getText();
				
				if(textField.getText().equals("")) {
					
					favoritosERROR4 ferror4 = new favoritosERROR4();
					ferror4.setVisible(true);
					
				}else {
					
					String sql = "SELECT Cancion, Artista FROM Canciones WHERE ID='" + id + "'";
					btnBorrar.setEnabled(false);
					
					try {
						
						con = DriverManager.getConnection(url, user, pass);	
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						
						//EN EL CASO DE QUE EL RESULTSET NO DEVUELVA NADA
						if(!rs.isBeforeFirst()) {
							
							favoritosERROR3 ferror3 = new favoritosERROR3();
							ferror3.setVisible(true);
							
						}else {
							
							modelo.setRowCount(0);
							
							 while(rs.next()){
					        	  
					              Object[] fila = new Object[rs.getMetaData().getColumnCount()];
					                
					              for(int i = 0; i < rs.getMetaData().getColumnCount(); i++){
					                	
					                  fila[i]=rs.getObject(i+1);
					                    
					              }
					              modelo.addRow(fila);
					        }//CIERRE WHILE
							
							String query = "SELECT Usuario FROM Usuarios WHERE ID='" + id + "'";
							con = DriverManager.getConnection(url, user, pass);	
							pst = con.prepareStatement(query);
							rs = pst.executeQuery();
							
							while(rs.next()) {
							
								String usuario = login.nombredeusuario;
								if(id.equals(managementDB.devolverIDuser(usuario))) {
									
									lblPrueba.setText("");

									
								}else {
									
									lblPrueba.setText("Canciones favoritas de : " + rs.getString(1));
									
								}		
							}
							
					        	
						}
						  
					}catch(Exception exception) {
						
						System.out.println(exception);
					
					}//CIERRE TRY AND CATCH
					
				}//CIERRE IF			
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al usuario volver a su lista de canciones favoritas de manera mas cómoda
		 */
		btnMiLista.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				usuario = login.nombredeusuario;
				String id = managementDB.devolverIDuser(usuario);
				String sql = "SELECT Cancion, Artista FROM Canciones WHERE ID='" + id + "'";
				
				try {
					
					con = DriverManager.getConnection(url, user, pass);	
					pst = con.prepareStatement(sql);
					rs = pst.executeQuery();
						
					modelo.setRowCount(0);
						
					while(rs.next()){
				        	  
						Object[] fila = new Object[rs.getMetaData().getColumnCount()];
				                
				        for(int i=0; i < rs.getMetaData().getColumnCount(); i++){
				                	
				        	fila[i]=rs.getObject(i+1);
				                    
				        }
				           	modelo.addRow(fila);
					}//CIERRE WHILE
					
					btnBorrar.setEnabled(true);
					
				}catch(Exception e){
				
					System.out.println(e);
					
				}
			}
		});
		
	}//CIERRE cancionesFavoritas()
}//CIERRE CLASE
