package es.peretecorporate.abeds.controller.auth;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.peretecorporate.abedsbackend.model.Usuario;

import es.peretecorporate.abeds.client.LoginRestClient;
import es.peretecorporate.abeds.exception.ServiceRestClientExecption;

@Controller(value = "login")
@SessionScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	public static final Logger	LOGGER					= LoggerFactory.getLogger(Login.class);
	private static final long	serialVersionUID		= -2543720240048710527L;

	/**  */
	private String				user;

	/** */
	private String				pwd;

	/** */
	private String				msg;

	/**TODO añadir el valor por configuracion properties */
	private static final String	URL_USUARIO				= "http://localhost:8081";
	
	/**TODO añadir el valor por configuracion properties */
	private static final String	CONTEXT_PATH_USUARIO	= "";

	@Autowired
	private LoginRestClient		loginRestClient;

	@PostConstruct
	public void init() {

		this.user = "";
		this.pwd = "";

		loginRestClient = new LoginRestClient(URL_USUARIO, CONTEXT_PATH_USUARIO);

	}

	/**
	 * Metodo para validar usuario y password
	 */
	public void validateUsernamePassword() {

		try {

			List<Usuario> usuario;
			usuario = loginRestClient.findAllUsuarios();

		}
		catch (ServiceRestClientExecption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//			if ("admin".equals(user.trim()) && "admin".equals(pwd.trim())) {
		//				LOGGER.info("login admin successfully ........ ");
		//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user);
		//				FacesContext.getCurrentInstance().getExternalContext().redirect("/views/user/list.xhtml");
		//			} else {
		//				LOGGER.info("login admin failed ........ ");
		//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", "");
		//				FacesContext.getCurrentInstance().addMessage(null,
		//						new FacesMessage(FacesMessage.SEVERITY_WARN, "", ""));
		//				init();
		//			}
	}

	/**
	 * Metodo para cerrar session del usuario logado.
	 */
	public void logout() {

		try {
			init();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", "");
			FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");

		}
		catch (IOException e) {
			e.printStackTrace();
		}

		LOGGER.info("exit admin success ........ ");
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LoginRestClient getLoginRestClient() {
		return loginRestClient;
	}

	public void setLoginRestClient(LoginRestClient loginRestClient) {
		this.loginRestClient = loginRestClient;
	}

}
