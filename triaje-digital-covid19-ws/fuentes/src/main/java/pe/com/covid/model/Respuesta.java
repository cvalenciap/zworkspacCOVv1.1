package pe.com.covid.model;

import java.io.Serializable;
import java.util.Map;

public class Respuesta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer estadoRespuesta;
	private String mensajeRespuesta;
	private Map<String, Object> parametros;

	public Integer getEstadoRespuesta() {
		return estadoRespuesta;
	}

	public void setEstadoRespuesta(Integer estadoRespuesta) {
		this.estadoRespuesta = estadoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public Map<String, Object> getParametros() {
		return parametros;
	}

	public void setParametros(Map<String, Object> parametros) {
		this.parametros = parametros;
	}

}
