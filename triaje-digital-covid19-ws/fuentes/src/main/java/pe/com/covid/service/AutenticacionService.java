package pe.com.covid.service;

import java.util.Map;

import pe.com.covid.model.Respuesta;
import pe.com.gmd.util.exception.GmdException;

public interface AutenticacionService {

	public Respuesta validarClave(Map<String, String> requestParm) throws GmdException;

	public Respuesta validarCorreoRecupClave(Map<String, String> requestParm) throws GmdException;

	public Respuesta actualizarClave(Map<String, String> requestParm) throws GmdException;

}