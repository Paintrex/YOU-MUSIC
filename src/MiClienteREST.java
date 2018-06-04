import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Clase generada para gestionar las conexiones a la API mediante el metodo request
 * @author Álvaro Bernal Pedret
 */
public class MiClienteREST {
	
	// Realiza una petición REST a la dirURL especificada.
	// Devuelve un String con la respuesta a la petición.
	// Si se produce una excepción, muestra el error y devuelve null
	/**
     * Metodo utilizado para gestionar las conexiones a la API y que nos devuelva la información JSON en un String
     * @param dirURL url de la API a conectar
     * @return un string con toda la información JSON en un String
     */
	public static String request(String dirURL) {

		try {
			
			// Creamos una URL y una conexión a URL
			URL url = new URL(dirURL);
			URLConnection urlConn = url.openConnection();

			// Creamos un InputStreamReader & BufferedReader para leer la respuesta
			InputStreamReader isr = new InputStreamReader(urlConn.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			// Mientras el buffer no esté vacio, leemos chars y almacenamos en String
			String txt = "";
			int c;
			while ((c = br.read()) != -1) {
				txt = txt + (char) c;
			}

			// Cerramos el BufferedReader y el InputStreamReader
			br.close();
			isr.close();

			// Devolvemos la respuesta
			return txt;
			
		} catch (Exception e) {
			
			// Mostramos información de la excepción
			System.out.print("Compruebe si hay algún error tipográfico. ");
			
			// Devolvemos null
			return null;
		}
	}

}