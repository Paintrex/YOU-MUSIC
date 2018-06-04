import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;

public class managementDB {
	
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
	 * Metodo utilizado para determinar si la persona que está tratando de iniciar sesión procede con las credenciales introducidas
	 * @param username Nombre de usuario
	 * @param password Contraseña del usuario
	 * @return este metodo devuelve un String "CORRECTO" o "INCORRECTO" dependiendo si las credenciales son correctas o ono
	 * @throws SQLException en el caso de que la sentencia SQL falle 
	 * @throws ClassNotFoundException en el caso de que no se encuentre la clase
	 */
	public static String login(String username, String password) throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT Usuario, Contrasena FROM Usuarios WHERE Usuario ='" + username + "' and Contrasena=MD5('" + password + "')";
		String msg = "";
		try {
		
			con = DriverManager.getConnection(url, user, pass);	
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
	        
	         if(rs.next()) {
	        	 
	        	 msg = "CORRECTO";
	        	 
	         }else {
	        	 
	        	 msg = "INCORRECTO";
	        	 
	         }
	         
		}catch(Exception e) {
			
			System.out.println(e);
		
		}
		
		return msg;
		
	}//CIERRE METODO
	
	/**
	 * Metodo utilizado para saber si el usuario a registrar ya existe en nuestra base de datos
	 * @param username nombre de usuario
	 * @return devuelve "Usuario" o "OK" dependiendo si el usuario a registrar existe o no
	 */
	public static String comprobarUsuario(String username) {
		
		String sql = "SELECT Usuario FROM Usuarios WHERE Usuario ='"+ username + "'";
		String msg = "";
		
		try {
			
			con = DriverManager.getConnection(url, user, pass);	
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
	        
	         if(rs.next()) {
	        	 
	        	 msg = "Usuario";
	        	 
	         }else {
	        	 
	        	 msg = "OK";
	        	 
	         }
	         
		}catch(Exception e) {
			
			System.out.println(e);
		
		}
		
		return msg;
		
	}//CIERRE METODO
	
	/**
	 * Metodo para determinar si el correo a registrar ya existe en nuestra base de datos o no
	 * @param correo correo electronico
	 * @return Este metodo devuelve "Correo" o "OK" dependiendo de si el correo a registrar existe en la base de datos o no
	 */
	public static String comprobarCorreo(String correo) {
		

		String sql = "SELECT Usuario FROM Usuarios WHERE Correo ='"+ correo + "'";
		String msg = "";
		
		try {
			
			con = DriverManager.getConnection(url, user, pass);	
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
	        
	         if(rs.next()) {
	        	 
	        	 msg = "Correo";
	        	 
	         }else {
	        	 
	        	 msg = "OK";
	        	 
	         }
	         
		}catch(Exception e) {
			
			System.out.println(e);
		
		}
		
		return msg;
		
		
	}//CIERRE METODO
	
	/**
	 * Metodo utilizado para agregar usuarios a nuestra base de datos
	 * @param username nombre de usuario
	 * @param password contraseña del usuario
	 * @param correo correo electrónico del usuario
	 */
	public static void insertarUsusarios(String username, String password, String correo) {
		
		String id = "";
		
		Random ran = new Random();
		String alfanumerico = "abcdefghijqlmnopqrstuvwxyz1234567890";
		char ej1;
		
		try {
			
			for(int i = 0; i <= 4; i++) {
				
				int aleatorio = ran.nextInt(36);
				ej1 = alfanumerico.charAt(aleatorio);
				id = id + ej1;
				
			}
			
			String sql = "INSERT into Usuarios (Usuario, Contrasena, ID, Correo) VALUES ('"+ username +"', MD5('" + password + "'), '" + id + "', '" + correo + "')";
			conexion = DriverManager.getConnection(url, user, pass);
			stmmt = (Statement) conexion.createStatement();
			psInsertar = conexion.prepareStatement(sql);
			psInsertar.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}//CIERRE METODO
	
	/**
	 * Metodo utilizado para mostrar el id del usuario que haya iniciado sesión
	 * @param usuario nombre del usuario
	 * @return devuelve un String con el ID del usuario que haya iniciado sesión
	 */
	public static String devolverIDuser(String usuario) {
		String id = "";
		String sql = "SELECT ID FROM Usuarios WHERE usuario='" + usuario + "'";
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				id = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return id;
	}//CIERRE METODO
	
	/**
	 * Metodo utilizado para insertar una canción encontrada a nuestra lista de canciones favoritas
	 * @param id id del usuario 
	 * @param artista nombre del artista a guardar
	 * @param cancion nombre de la canción a guardar
	 */
	public static void insertarFavoritos(String id, String artista, String cancion) {
		
		try {
			
			boolean comprovar = false;
			String sentencia_comprovar = "SELECT Cancion, Artista, ID FROM Canciones WHERE Cancion='" + cancion + "' AND Artista='" + artista + "' AND ID='"+ id +"'";
			
			con = DriverManager.getConnection(url, user, pass);	
			pst = con.prepareStatement(sentencia_comprovar);
			rs = pst.executeQuery();
			
			if(rs.next()) { comprovar = true;} else {comprovar = false;}//COMPRUEBA QUE NO SE DUPLIQUE UNA CANCIÓN EN FAVORITOS
		
			if(comprovar == true) {
				
				favoritosERROR2 ferror2 = new favoritosERROR2();
				ferror2.setVisible(true);
				
			}else {
				
				String sql = "INSERT INTO Canciones (ID, Cancion, Artista) VALUES ('"+ id +"', '" + cancion +"', '" + artista + "')";
				conexion = DriverManager.getConnection(url, user, pass);
				stmmt = (Statement) conexion.createStatement();
				psInsertar = conexion.prepareStatement(sql);
				psInsertar.executeUpdate();
				
			}	
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//CIERRE METODO
	
	/**
	 * Metodo utilizado para modificar los datos de un usuario en el panel administrador
	 * @param username nombre del usuario
	 * @param password contraseña del usuario
	 * @param correo correo electrónico del usuario
	 * @param id_tabla id del usuario seleccionado en la tabla administradora
	 */
	public static void modificarUsusarios(String username, String password, String correo, Object id_tabla) {
		
		try {
					
			String sql = "UPDATE Usuarios SET Usuario='" + username + "', Contrasena=MD5('" + password + "'), Correo='" + correo + "' WHERE ID='" + id_tabla + "'";
			conexion = DriverManager.getConnection(url, user, pass);
			stmmt = (Statement) conexion.createStatement();
			psInsertar = conexion.prepareStatement(sql);
			psInsertar.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}//CIERRE METODO
	
	/**
	 * Metodo utilizado para modificar los datos de un usuario pero en el caso de que la contraseña no se modifique
	 * @param username nombre del usuario
	 * @param password contraseña del usuario
	 * @param correo correo electrónico del usuario
	 * @param id_tabla id del usuario seleccionado en la tabla administradora
	 */
	public static void modificarUsusariosContrasena(String username, String password, String correo, Object id_tabla) {
		
		try {
					
			String sql = "UPDATE Usuarios SET Usuario='" + username + "', Contrasena='" + password + "', Correo='" + correo + "' WHERE ID='" + id_tabla + "'";
			conexion = DriverManager.getConnection(url, user, pass);
			stmmt = (Statement) conexion.createStatement();
			psInsertar = conexion.prepareStatement(sql);
			psInsertar.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}//CIERRE METODO
	
}//CIERRE CLASE
