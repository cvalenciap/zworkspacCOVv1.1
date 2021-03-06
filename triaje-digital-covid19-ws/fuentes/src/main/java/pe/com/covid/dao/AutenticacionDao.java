package pe.com.covid.dao;

import java.util.List;
import java.util.Map;
import pe.com.covid.model.Usuario;

import pe.com.gmd.util.exception.GmdException;

public abstract interface AutenticacionDao {
	
	public abstract Map<String, Object> validarClave(String correo) throws GmdException;

	public abstract Map<String, Object> validarCorreoRecupClave(String correo) throws GmdException;

	public abstract Map<String, Object> actualizaClave(String correo, String clave) throws GmdException;
	
	public abstract Map<String, Object> registrarLog(String correo, int operacion, int suministro) throws GmdException;
	
	List<Usuario> obtenerUsuario(Map<String,Object> usuarioBusqueda) throws GmdException;
	
//	List<Usuario> obtenerUsuario(String correo, Object cursor) throws GmdException;
	
}