package pe.com.covid.service;

import java.util.Map;

import pe.com.covid.model.Respuesta;
import pe.com.gmd.util.exception.GmdException;

public interface UtilService {

	Respuesta ObtenerParametrosCategoria(Map<String, String> requestParm) throws GmdException;
	
	Respuesta ObtenerParametrosGC(Map<String, String> requestParm) throws GmdException;
	
	Respuesta InsertarParametrosGC(Map<String, String> requestParm) throws GmdException;
	
	Respuesta EditarParametrosGC(Map<String, String> requestParm) throws GmdException;

}
