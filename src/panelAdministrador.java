import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Statement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * JPanel que se representará cuando un administrador inicie sesión y de esta manera podrá gestionar los usuarios de la base de datos
 * @author Álvaro Bernal Pedret
 */
public class panelAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable table;
	
	/**
	 * variable utilizada para crear la conexión a la base de datos
	 */
	public static Connection con = null;
	
	/**
	 * variable utilizada para hacer la declaración de la conexión a la base de datos junto con la sentencia SQL a ejectutar
	 */
	public static PreparedStatement pst = null;
	
	/**
	 * variable utilizada para almacenar los datos devueltos frente a la sentencia SQL
	 */
	public static ResultSet rs = null;
	
	/**
	 * variable que almacena el usuario de la base de datos
	 */
	private static final String user = "u634818610_alv";
	
	/**
	 * variable que almacena la contraseña de la base de datos
	 */
	private static final String pass = "cc7BZemM";
	
	/**
	 * variable que almacena la dirección de la base de datos
	 */
	private static final String url = "jdbc:mysql://sql151.main-hosting.eu/u634818610_alv";
	
	/**
	 * variable utilizada para hacer la declaración de la conexión a la base de datos junto con la sentencia SQL a ejectutar
	 */
	public static PreparedStatement psInsertar;
	
	/**
	 * variable utilizada para hacer la declaración de la conexión a la base de datos junto con la sentencia SQL a ejectutar
	 */
	public static Statement stmmt;
	
	/**
	 * variable utilizada para crear la conexión a la base de datos
	 */
	public static Connection conexion;
	
	/**
	 * variable utilizada para almacenar el nombre de usuario que se va a modificar
	 */
	public static Object modificar_usuario;
	
	/**
	 * variable utilizada para almacenar la contraseña del usuario que se va a modificar
	 */
	public static Object modificar_contraseña;
	
	/**
	 * variable utilizada para almacenar el correo del usuario que se va a modificar
	 */
	public static Object modificar_correo;
	
	/**
	 * variable utilizada para almacenar la ID del usuario que se va a modificar
	 */
	public static Object id;

	/**
	 * Launch the application.
	 * @param args argumentos autogenerados
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelAdministrador frame = new panelAdministrador();
					frame.setVisible(true);
					refrescarTabla();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public panelAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 65, 142));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 63, 913, 214);
		contentPane.add(scrollPane);
		
		table = new JTable(){
			 
			public boolean isCellEditable(int rowIndex, int colIndex) {
			 
			return false; //DE ESTA MANERA LAS CELDAS DEL JTABLE NO SON EDITABLES
			 
			}
		};
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Contrase\u00F1a", "ID", "Correo"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAgregarUsuario = new JButton("AGREGAR USUARIO");
		btnAgregarUsuario.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnAgregarUsuario.setBounds(11, 288, 169, 33);
		contentPane.add(btnAgregarUsuario);
		
		JButton btnNewButton = new JButton("MODIFICAR USUARIO");
		btnNewButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnNewButton.setBounds(190, 288, 185, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ELIMINAR USUARIO");
		btnNewButton_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		btnNewButton_1.setBounds(385, 288, 175, 33);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(61, 27, 54));
		panel.setBounds(10, 11, 914, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInternetChecker = new JLabel("INTERNET CHECKER");
		lblInternetChecker.setForeground(new Color(172, 65, 142));
		lblInternetChecker.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		lblInternetChecker.setBounds(10, 10, 130, 14);
		panel.add(lblInternetChecker);
		
		JLabel label = new JLabel("SALUDOS, ADMINISTRADOR " + login.nombredeusuario + " !");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(172, 65, 142));
		label.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		label.setBounds(545, 11, 359, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		label_1.setBounds(570, 288, 354, 33);
		contentPane.add(label_1);
		
		refrescarTabla();
	
		/**
		 * Evento .addMouseListener que permitirá al administrador abrir el JPanel correspondiente al registro de usuarios
		 */
		btnAgregarUsuario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				agregarUsuario au = new agregarUsuario();
				au.setVisible(true);
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al administrador abrir el JPanel correspondiente a la modificación de usuarios
		 */
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				int fila_selec = table.getSelectedRow();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					
				if(fila_selec >= 0) {
					
					Vector datos_fila = modelo.getDataVector().elementAt(table.getSelectedRow());
					modificar_usuario = datos_fila.elementAt(0);
					modificar_contraseña = datos_fila.elementAt(1);
					modificar_correo = datos_fila.elementAt(3);
					id = datos_fila.elementAt(2);
					modificarUsuario mu = new modificarUsuario();
					mu.setVisible(true);
					
				}else {
					
					label_1.setText("Selecciona una fila previamente");
					
				}
				
			}
		});
		
		/**
		 * Evento .addMouseListener que permitirá al administrador eliminar usuarios
		 */
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				int fila_selec = table.getSelectedRow();
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				
				if(fila_selec >= 0) {
					
					try {
						
						Vector datos_fila = modelo.getDataVector().elementAt(table.getSelectedRow());
						Object usuario = datos_fila.elementAt(0);
						Object contraseña = datos_fila.elementAt(1);
						Object id = datos_fila.elementAt(2);
						Object correo = datos_fila.elementAt(3);

						String sql = "DELETE FROM Usuarios WHERE Usuario='" + usuario + "' AND Contrasena='" + contraseña +"' AND ID='" + id + "' AND Correo='" + correo + "'";
						conexion = DriverManager.getConnection(url, user, pass);
						stmmt = (Statement) conexion.createStatement();
						psInsertar = conexion.prepareStatement(sql);
						psInsertar.executeUpdate();
						
						modelo.removeRow(fila_selec);
						
					} catch (SQLException exception) {
						// TODO Auto-generated catch block
						exception.printStackTrace();
					}			
					
				}else {
					
					label_1.setText("Selecciona una fila previamente");
					
				}
				
			}
		});
		
	}
	
	/**
	 * Este metodo sirve para rellenar la tabla administradora de los datos correspondientes a los usuarios de la base de datos
	 */
	public static void refrescarTabla() {
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		String sql = "SELECT * FROM Usuarios";
		
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
			
		}catch(Exception e){
		
			System.out.println(e);
			
		}
		
	}//CIERRE METODO
}
