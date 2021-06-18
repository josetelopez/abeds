package es.peretecorporate.abeds.client;

import java.util.List;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.peretecorporate.abedsbackend.exception.AbedsBackendException;
import com.peretecorporate.abedsbackend.model.Usuario;

import es.peretecorporate.abeds.exception.ServiceRestClientExecption;

@Component
@Controller
public class LoginRestClient extends AbstractRestClient {

	private static final Logger	LOGGER	= LoggerFactory.getLogger(LoginRestClient.class.getName());
	
	private ClientConfig		usuarioClientConfig;

	public LoginRestClient() {
		iniciarClienteConfig();

	}

	public LoginRestClient(String url, String contextPath) {
		super(url, contextPath);
		iniciarClienteConfig();

	}

	/**
	 * Metodo para instanciar la clase ClientConfig
	 */
	public void iniciarClienteConfig() {
		usuarioClientConfig = new ClientConfig();
		usuarioClientConfig.register(Usuario.class);
	}

	/**
	 * Metodo que extrae todos los usuarios.
	 * @return
	 * @throws ServiceRestClientExecption
	 * @throws AbedsBackendException 
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsuarios() throws ServiceRestClientExecption, AbedsBackendException {

		LOGGER.info("GET todos los usuarios");

		WebTarget client = createClient(ApplicationEndpoint.findAllUsuario(), usuarioClientConfig);
		Response response = client.request(MediaType.APPLICATION_JSON).get(Response.class);

		LOGGER.info("Status " + response.getStatus());

		List<Usuario> result = null;
		Integer status = response.getStatus();
		if (Status.OK.getStatusCode() == status) {
			System.out.println(response.getEntity());
			result = (List<Usuario>) response.readEntity(List.class);
		}
		else {
			throw new ServiceRestClientExecption(response.readEntity(String.class), status);
		}
	
		return result;

	}

	public ClientConfig getUsuarioClientConfig() {
		return usuarioClientConfig;
	}

	public void setUsuarioClientConfig(ClientConfig usuarioClientConfig) {
		this.usuarioClientConfig = usuarioClientConfig;
	}

}
