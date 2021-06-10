package es.peretecorporate.abeds.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractRestClient {

	private String				url;
	private String				contextPath;

	private static final Logger	LOGGER	= LoggerFactory.getLogger(AbstractRestClient.class.getName());

	public AbstractRestClient(String url, String contextPath) {
		this.url = url;
		this.contextPath = contextPath;
	}

	public AbstractRestClient() {

	}

	protected WebTarget createClient(String path, ClientConfig clientConfig) {
		String assembledPath = assembleEndpoint(path);
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget target = client.target(assembledPath);
		return target;
	}

	private String assembleEndpoint(String path) {
		String endpoint = url.concat(contextPath).concat(path);
		LOGGER.info(String.format("Llamando al endpoint %s", endpoint));
		return endpoint;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

}
