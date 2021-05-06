package pe.com.covid.service.impl;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.covid.dao.GeneralDao;
import pe.com.covid.dao.AutenticacionDao;
import pe.com.covid.model.General;
import pe.com.covid.model.Usuario;
import pe.com.covid.model.Respuesta;
import pe.com.covid.service.AutenticacionService;
import pe.com.covid.util.Encriptacion;
import pe.com.covid.util.Util;
import pe.com.gmd.util.exception.GmdException;

import org.springframework.stereotype.Service;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {
		
	@Autowired
	private AutenticacionDao autenticacionDao;
	
	@Autowired
	private GeneralDao generalDao;
	
	private Encriptacion encriptacion;
	private Util util;
	private Respuesta respuesta = new Respuesta();
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Respuesta validarClave(Map<String, String> requestParm) throws GmdException{
		Map<String, Object> mapResultado = new HashMap<String, Object>();
		mapResultado.put("flagRespuesta", "B");
		try {			
			String vCorreo = requestParm.get("correo");
			String vClave = requestParm.get("clave");
			
			Map<String,Object> mapBusqueda = new HashMap<String, Object>();
			mapBusqueda.put("PAR_V_CORREO", vCorreo);
			mapBusqueda.put("PAR_OUT_CURSOR",null);
			autenticacionDao.obtenerUsuario(mapBusqueda);
			List<Usuario> listUsuario = (List<Usuario>) mapBusqueda.get("PAR_OUT_CURSOR");
			
			if(listUsuario.size() != 0) {
				Map<String, Object> hmClave = this.encriptacion.convertirSHA256(vClave);
				String bdClave = listUsuario.get(0).getClave();
				String sClave = (String) hmClave.get("vSALIDA");

				if (bdClave.equals(sClave)) {
					mapResultado.put("idCliente", listUsuario.get(0).getIdUsuario());
				} else {
					respuesta.setMensajeRespuesta("El usuario y/o clave no coinciden");
					respuesta.setEstadoRespuesta(0);
				}
			}
//			
//			
//			Map<String, Object> hmValida = autenticacionDao.validarClave(vCorreo);
//			BigDecimal bdCast = (BigDecimal) hmValida.get("nRESP_SP");
//			mapResultado.put("flagRespuesta", (String) hmValida.get("vFLAG"));
//			respuesta.setMensajeRespuesta((String) hmValida.get("cRESP_SP"));
//			respuesta.setEstadoRespuesta(bdCast.intValueExact());
//			if (respuesta.getEstadoRespuesta() != 0) {
//				Map<String, Object> hmClave = this.encriptacion.convertirSHA256(vClave);
//				String bdClave = (String) hmValida.get("vCLAVE");
//				String sClave = (String) hmClave.get("vSALIDA");
//
//				if (bdClave.equals(sClave)) {
//					mapResultado.put("idCliente", ((BigDecimal) hmValida.get("vID_CLIENTE")).intValue());
//				} else {
//					respuesta.setMensajeRespuesta("El usuario y/o clave no coinciden");
//					respuesta.setEstadoRespuesta(0);
//				}
//			}
		} catch (Exception e) {
			System.out.println("covidAutenticacionServiceImpl.validarClave()");
			System.err.println("Ocurrió un error: " + e);
			respuesta.setMensajeRespuesta("Ocurrió un error: " + e);
			mapResultado.put("flagRespuesta", "B");
			respuesta.setEstadoRespuesta(0);
		}
		respuesta.setParametros(mapResultado);
		return respuesta;
	}

	@Override
	public Respuesta validarCorreoRecupClave(Map<String, String> requestParm) throws GmdException{
		try {
			String vCorreo = requestParm.get("correo");
			Respuesta vMapCorreo = this.util.validaFormatoCorreo(vCorreo);
			respuesta.setMensajeRespuesta(vMapCorreo.getMensajeRespuesta());
			respuesta.setEstadoRespuesta(vMapCorreo.getEstadoRespuesta());

			if (respuesta.getEstadoRespuesta() != 0) {
				Map<String, Object> vMapNombre = autenticacionDao.validarCorreoRecupClave(vCorreo);
				respuesta.setMensajeRespuesta((String) vMapNombre.get("cRESP_SP"));
				respuesta.setEstadoRespuesta(((BigDecimal) vMapNombre.get("nRESP_SP")).intValueExact());
			}
		} catch (Exception e) {
			System.out.println("AutenticacionServiceImpl.validarCorreoRecupClave()");
			System.err.println("Ocurrió un error: " + e);
			respuesta.setMensajeRespuesta("Ocurrió un error: " + e);
			respuesta.setEstadoRespuesta(0);
		}
		return respuesta;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Respuesta actualizarClave(Map<String, String> requestParm) throws GmdException{		
		try {
			String sCorreo = requestParm.get("correo");
			String sClave = requestParm.get("clave");

			Map<String, Object> encriptaClave = this.encriptacion.convertirSHA256(sClave);
			String claveSalida = (String) encriptaClave.get("vSALIDA");
			Map<String, Object> queryResp = autenticacionDao.actualizaClave(sCorreo, claveSalida);
			BigDecimal bdCast = (BigDecimal) queryResp.get("nRESP_SP");

			respuesta.setMensajeRespuesta((String) queryResp.get("cRESP_SP"));
			respuesta.setEstadoRespuesta(bdCast.intValue());
		} catch (Exception e) {
			System.out.println("AutenticacionServiceImpl.actualizarClave()");
			System.err.println("Ocurrió un error: " + e);
			respuesta.setMensajeRespuesta("Ocurrió un error: " + e);
			respuesta.setEstadoRespuesta(0);
		}
		return respuesta;
	}

}