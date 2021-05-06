package pe.com.covid.dao;

import java.util.Map;

import pe.com.covid.model.ParametroGC;
import pe.com.gmd.util.exception.GmdException;

public abstract interface UtilDao {

	public abstract void enviarCorreo(String to, String subject, String body) throws GmdException;

	public abstract Map<String, Object> obtenerParamCategoria(String categoria) throws GmdException;

	public abstract Map<String, Object> obtenerParametrosGC(int pageNumber, int pageSize, String correo) throws GmdException;

	public abstract Map<String, Object> insertarParametrosGC(ParametroGC parameter) throws GmdException;

	public abstract Map<String, Object> editarParametrosGC(ParametroGC parameter) throws GmdException;

}