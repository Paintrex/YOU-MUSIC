import org.json.JSONException;
import org.json.JSONObject;

/**
 * Esta clase se encarga de ejecutar todos los metodos necesarios para la obtención de información relevante en la busqueda de artistas.
 * @author Álvaro Bernal Pedret
 */
public class buscarArtistaB {

	/**
	 * Metodo getPais(); que se encarga de hacer una peticion al servicio API y obtener el pais de nacimiento del artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return el pais de nacimiento del artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getPais(String artist_name) throws JSONException {
		
		String pais_origen = "";
				
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
			
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
			
		try {pais_origen = artist_info.getString("strCountry");} catch(Exception  exception) {pais_origen = "No disponible";}
		
		return pais_origen;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getNombre(); que se encarga de hacer una peticion al servicio API y obtener el nombre completo del artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return el nombre completo del artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getNombre(String artist_name) throws JSONException {
		
		String nombre_artista = "";
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {nombre_artista = artist_info.getString("strArtist");} catch(Exception  exception) {nombre_artista = "No disponible";}
		
		return nombre_artista;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getAnoFormacion(); que se encarga de hacer una peticion al servicio API y obtener el año de formación de la banda/artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return el año de formación de la banda/artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getAnoFormacion(String artist_name) throws JSONException {
		
		String año_formacion = "";
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {año_formacion = artist_info.getString("intFormedYear");} catch(Exception  exception) {año_formacion = "No disponible";}
		
		return año_formacion;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getEstilo(); que se encarga de hacer una peticion al servicio API y obtener el estilo del artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return el estilo del artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getEstilo(String artist_name) throws JSONException {
		
		String estilo = "";
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {estilo = artist_info.getString("strStyle");} catch(Exception  exception) {estilo = "No disponible";}
		
		return estilo;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getGenero(); que se encarga de hacer una peticion al servicio API y obtener el genero del artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return el genero del artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getGenero(String artist_name) throws JSONException {
		
		String genero = "";
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {genero = artist_info.getString("strGenre");} catch(Exception  exception) {genero = "No disponible";}
		
		return genero;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getPaginaOficial(); que se encarga de hacer una peticion al servicio API y obtener la página web oficial del artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return la página web oficial del artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getPaginaOficial(String artist_name) throws JSONException {
		
		String pagina_oficial = "";
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {pagina_oficial = artist_info.getString("strWebsite");} catch(Exception  exception) {pagina_oficial = "No disponible";}
		
		return pagina_oficial;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getPaginaOficial(); que se encarga de hacer una peticion al servicio API y obtener el número de integrantes del grupo/banda
	 * @param artist_name lleva el nombre del artista introducido
	 * @return el número de integrantes del grupo/banda
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getIntegrantes(String artist_name) throws JSONException {
		
		String numero_integrantes;
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {numero_integrantes = artist_info.getString("intMembers");} catch(Exception  exception) {numero_integrantes = "No disponible";}
		
		return numero_integrantes;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getIMG(); que se encarga de hacer una peticion al servicio API y obtener la URL de la imagen del grupo/artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return la URL de la imagen del grupo/artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getIMG(String artist_name) throws JSONException {
		
		String url_img = "";
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {url_img = artist_info.getString("strArtistThumb");} catch(Exception  exception) {url_img = "No disponible";}
		
		return url_img;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getDescripcion(); que se encarga de hacer una peticion al servicio API y obtener una pequeña descripción del artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return una pequeña descripción del artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getDescripcion(String artist_name) throws JSONException {
		
		String descripcion = "";
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {descripcion = artist_info.getString("strBiographyES");} catch(Exception  exception) {descripcion = artist_info.getString("strBiographyEN");}
		
		return descripcion;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getCanciones(); que se encarga de hacer una peticion al servicio API y obtener la id del artista
	 * @param artist_name lleva el nombre del artista introducido
	 * @return la id del artista
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getCanciones(String artist_name) throws JSONException {
		
		String strMusicBrainzID = "";
		
		String peticion_artista = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_artista); // Le pasamos el String que contiene el JSON
						
		// Accedemos al objeto "track"
		JSONObject artist_info = obj.getJSONArray("artists").getJSONObject(0);
		
		try {strMusicBrainzID = artist_info.getString("strMusicBrainzID");} catch(Exception  exception) {strMusicBrainzID = artist_info.getString("No disponible");}
		
		return strMusicBrainzID;
		
	}//CIERRE METODO
	
}//CIERRE CLASE
