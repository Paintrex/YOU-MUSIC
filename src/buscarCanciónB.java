import org.json.JSONException;
import org.json.JSONObject;

/**
 * Esta clase se encarga de ejecutar todos los metodos necesarios para la obtención de información relevante en la busqueda de canciones.
 * @author Álvaro Bernal Pedret
 */
public class buscarCanciónB {

	public buscarCanciónB() {   }//CONSTRUCTOR BASE
	
	/**
	 * Metodo getNombre(); que se encarga de hacer una peticion al servicio API y obtener el nombre del artista de la canción introducida
	 * @param artist_name lleva el nombre del artista introducido
	 * @param track_name lleva el nombre de la canción introducida
	 * @return el nombre del artista de la canción introducida
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getNombre(String artist_name, String track_name) throws JSONException {
		String name = "";
			
		String txt = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchtrack.php?s="+ artist_name.replace(" ", "_") +"&t=" + track_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(txt); // Le pasamos el String que contiene el JSON
							
		JSONObject cancion = obj.getJSONArray("track").getJSONObject(0);
		
		try {name = cancion.getString("strTrack");} catch(Exception  exception) {name = "No disponible";}
		
		return name;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getAlbum(); que se encarga de hacer una peticion al servicio API y obtener el nombre del álbum al que pertenece dicha canción
	 * @param artist_name lleva el nombre del artista introducido
	 * @param track_name lleva el nombre de la canción introducida
	 * @return el nombre del álbum al que pertenece dicha canción
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getAlbum(String artist_name, String track_name) throws JSONException {
		String album = "";
			
		String txt = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchtrack.php?s="+ artist_name.replace(" ", "_") +"&t=" + track_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(txt); // Le pasamos el String que contiene el JSON
							
		JSONObject cancion = obj.getJSONArray("track").getJSONObject(0);
		
		try {album = cancion.getString("strAlbum");} catch(Exception  exception) {album = "No disponible";}
		
		return album;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getArtista(); que se encarga de hacer una peticion al servicio API y obtener el nombre del artista al que pertenece dicha canción
	 * @param artist_name lleva el nombre del artista introducido
	 * @param track_name lleva el nombre de la canción introducida
	 * @return el nombre del artista al que pertenece dicha canción
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getArtista(String artist_name, String track_name) throws JSONException {
		String artista = "";
			
		String txt = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchtrack.php?s="+ artist_name.replace(" ", "_") +"&t=" + track_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(txt); // Le pasamos el String que contiene el JSON
							
		JSONObject cancion = obj.getJSONArray("track").getJSONObject(0);
		
		try {artista = cancion.getString("strArtist");} catch(Exception  exception) {artista = "No disponible";}
		
		return artista;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getGenero(); que se encarga de hacer una peticion al servicio API y obtener el genero al que pertenece dicha canción
	 * @param artist_name lleva el nombre del artista introducido
	 * @param track_name lleva el nombre de la canción introducida
	 * @return el genero al que pertenece dicha canción
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getGenero(String artist_name, String track_name) throws JSONException {
		String genero = "";
			
		String txt = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchtrack.php?s="+ artist_name.replace(" ", "_") +"&t=" + track_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(txt); // Le pasamos el String que contiene el JSON
							
		JSONObject cancion = obj.getJSONArray("track").getJSONObject(0);
		
		try {genero = cancion.getString("strGenre");} catch(Exception  exception) {genero = "No disponible";}
		
		return genero;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getPuntuación(); que se encarga de hacer una peticion al servicio API y obtener la puntuación que tiene dicha canción en el servidor 
	 * @param artist_name lleva el nombre del artista introducido
	 * @param track_name lleva el nombre de la canción introducida
	 * @return la puntuación que tiene dicha canción en el servidor
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getPuntuacion(String artist_name, String track_name) throws JSONException {
		String puntuacion = "";
			
		String txt = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchtrack.php?s="+ artist_name.replace(" ", "_") +"&t=" + track_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(txt); // Le pasamos el String que contiene el JSON
							
		JSONObject cancion = obj.getJSONArray("track").getJSONObject(0);
		
		try {puntuacion = cancion.getString("intScore");} catch(Exception  exception) {puntuacion = "No disponible";}
		
		return puntuacion;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getDescripción(); que se encarga de hacer una peticion al servicio API y obtener una pequeña descripción de la canción
	 * @param artist_name lleva el nombre del artista introducido
	 * @param track_name lleva el nombre de la canción introducida
	 * @return una pequeña descripción de la canción
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getDescripcion(String artist_name, String track_name) throws JSONException {
		String descripcion = "";
			
		String txt = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/searchtrack.php?s="+ artist_name.replace(" ", "_") +"&t=" + track_name.replace(" ", "_"));
		
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(txt); // Le pasamos el String que contiene el JSON
							
		JSONObject cancion = obj.getJSONArray("track").getJSONObject(0);
		
		try {descripcion = cancion.getString("strDescriptionEN");} catch(Exception  exception) {descripcion = "No disponible";}
		
		if(descripcion == "" || descripcion == null || descripcion == " ") {
			
			descripcion = "No disponible";
			
		}
		
		return descripcion;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getLetra(); que se encarga de hacer una peticion al servicio API y obtener la letra de la canción
	 * @param artist_name lleva el nombre del artista introducido
	 * @param track_name lleva el nombre de la canción introducida
	 * @return la letra de la canción
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getLetra(String artist_name, String track_name) throws JSONException {
		String letra = "";
			
		String peticion_letra = MiClienteREST.request("https://api.lyrics.ovh/v1/" + artist_name.replace(" ", "%20") + "/" + track_name.replace(" ", "%20"));
		
		// Cargamos el JSON (letra canción)
		JSONObject let = new JSONObject(peticion_letra);
		
		try {letra = let.getString("lyrics");} catch(Exception  exception) {letra = "No disponible";}
		
		return letra;
		
	}//CIERRE METODO
	
	/**
	 * Metodo getIMG(); que se encarga de hacer una peticion al servicio API y obtener la URL de la imagen del artista relacionado a la canción solicitada
	 * @param artist_name lleva el nombre del artista introducido
	 * @return la URL de la imagen del artista relacionado a la canción solicitada
	 * @throws JSONException este error se generará cada vez que hayan errores con los datos JSON
	 */
	public static String getIMG(String artist_name) throws JSONException {
		
		String img = "";
				
		String peticion_IMG = MiClienteREST.request("http://www.theaudiodb.com/api/v1/json/1/search.php?s=" + artist_name.replace(" ", "_"));
			
		// Cargamos el JSON en un JSONObject
		JSONObject obj = new JSONObject(peticion_IMG); // Le pasamos el String que contiene el JSON
								
		// Accedemos al objeto "track"
		JSONObject img_info = obj.getJSONArray("artists").getJSONObject(0);
			
		try {img = img_info.getString("strArtistThumb");} catch(Exception  exception) {img = "No disponible";}
			
		return img;
		
	}//CIERRE METODO
	
}//CIERRE CLASE
