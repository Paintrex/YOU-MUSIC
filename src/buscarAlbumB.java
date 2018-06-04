import org.json.JSONException;
import org.json.JSONObject;

/**
 * Esta clase se encarga de ejecutar todos los metodos necesarios para la obtención de información relevante en la busqueda de albumes.
 * @author Álvaro Bernal Pedret
 */
public class buscarAlbumB {

	/**
	 * Metodo getIMG(); que se encarga de hacer una peticion al servicio API y obtener la URL de la imagen del grupo/artista a buscar
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return la URL de la imagen del grupo/artista a buscar
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getIMG(String album_name) throws JSONException {
		
		String img_url = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {img_url = album_info.getString("strAlbumThumb");} catch(Exception  exception) {img_url = "No disponible";}
		
		return img_url;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getAlbum(); que se encarga de hacer una peticion al servicio API y obtener el nombre del álbum 
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return el nombre completo del álbum
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getAlbum(String album_name) throws JSONException {
		
		String nombre_album = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {nombre_album = album_info.getString("strAlbum");} catch(Exception  exception) {nombre_album = "No disponible";}
		
		
		return nombre_album;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getArtista(); que se encarga de hacer una peticion al servicio API y obtener el nombre del artista relacionado a dicho álbum
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return el nombre del artista relacionado al álbum a buscar
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getArtista(String album_name) throws JSONException {
		
		String nombre_artista = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {nombre_artista = album_info.getString("strArtist");} catch(Exception  exception) {nombre_artista = "No disponible";}
		
		return nombre_artista;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getAno(); que se encarga de hacer una peticion al servicio API y obtener el año de lanzamiento de dicho álbum
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return año de lanzamiento de dicho álbum
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getAno(String album_name) throws JSONException {
		
		String ano_lanz = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {ano_lanz = album_info.getString("intYearReleased");} catch(Exception  exception) {ano_lanz = "No disponible";}
		
		return ano_lanz;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getGenero(); que se encarga de hacer una peticion al servicio API y obtener el genero de dicho álbum
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return el genero de dicho álbum
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getGenero(String album_name) throws JSONException {
		
		String genero = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {genero = album_info.getString("strGenre");} catch(Exception  exception) {genero = "No disponible";}
		
		return genero;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getEstilo(); que se encarga de hacer una peticion al servicio API y obtener el estilo de dicho álbum
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return el genero de dicho álbum
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getEstilo(String album_name) throws JSONException {
		
		String estilo = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {estilo = album_info.getString("strStyle");} catch(Exception  exception) {estilo = "No disponible";}
		
		return estilo;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getPuntuacion(); que se encarga de hacer una peticion al servicio API y obtener la puntuación de dicho álbum en el servidor de la API
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return la puntuación que tiene dicho álbum en el servidor de la API
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getPuntuacion(String album_name) throws JSONException {
		
		String puntuacion = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {puntuacion = album_info.getString("intScore");} catch(Exception  exception) {puntuacion = "No disponible";}
		
		return puntuacion;
		
	}//CIERRER METODO
	
	/**
	 * Metodo getDescripcion(); que se encarga de hacer una peticion al servicio API y obtener una pequeña descripción de dicho álbum
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return una pequeña descripción de dicho álbum
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getDescripcion(String album_name) throws JSONException {
		
		String descripcion = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {descripcion = album_info.getString("strDescriptionES");} catch(Exception  exception) {descripcion = album_info.getString("strDescriptionEN");}
		
		return descripcion;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getCancionesAlbum(); que se encarga de hacer una peticion al servicio API y obtener la id del álbum de dicho álbum
	 * @param album_name lleva el nombre del álbum a buscar
	 * @return la id del álbum
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getCancionesAlbum(String album_name) throws JSONException {
		
		String id_album = "";
		
		String album = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchalbum.php?a=" + album_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(album); // Le pasamos el String que contiene el JSON
		
		// Accedemos al objeto "track"
		JSONObject album_info = obj.getJSONArray("album").getJSONObject(0);
		
		try {id_album = album_info.getString("idAlbum");} catch(Exception  exception) {id_album = "No disponible";}		

		return id_album;
	}//CIERRE METODO
	
}//CIERRE CLASE
