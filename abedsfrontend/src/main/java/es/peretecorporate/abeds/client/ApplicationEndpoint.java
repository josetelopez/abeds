package es.peretecorporate.abeds.client;

public class ApplicationEndpoint {

	/** Endpoint de la llamada para consumir el servicio rest controller de usuario*/
	private static String USUARIO = "/usuario";

	/**
	 * END POINTS PATH USUARIO
	 */

	/**
	 * Endpoint para allUsuario
	 * @return String
	 */
	public static String findAllUsuario() {
		//return USUARIO.concat(String.format("?book=%s"));
		return USUARIO.concat(String.format("/allUsuario"));
	}
}
