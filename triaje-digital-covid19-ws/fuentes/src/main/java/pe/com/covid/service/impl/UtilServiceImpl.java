package pe.com.covid.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.covid.dao.UtilDao;
import pe.com.covid.model.ParametroGC;
import pe.com.covid.model.Respuesta;
import pe.com.covid.service.UtilService;
import pe.com.gmd.util.exception.GmdException;

@Service
@SuppressWarnings("unchecked")
public class UtilServiceImpl implements UtilService {

	@Autowired
	private UtilDao dao;
	
	private Respuesta respuesta = new Respuesta();

	@Override
	public Respuesta ObtenerParametrosCategoria(Map<String, String> requestParm) throws GmdException{
		Map<String, Object> mapResultado = new HashMap<String, Object>();
		try {
			String categoria = requestParm.get("categoria");
			Map<String, Object> queryResp = this.dao.obtenerParamCategoria(categoria);
						
			BigDecimal bdCast = (BigDecimal) queryResp.get("nRESP_SP");
			int iRespuesta = bdCast.intValueExact();
			if (iRespuesta != 0) {
				for (Map<String, Object> map : (List<Map<String, Object>>) queryResp.get("IO_CURSOR")) {
					mapResultado.put((String) map.get("CLASE"), (String) map.get("VALOR"));
				}
			}
			respuesta.setMensajeRespuesta((String) queryResp.get("cRESP_SP"));
			respuesta.setEstadoRespuesta(iRespuesta);
		} catch (Exception e) {
			System.out.println("COVUtilServiceImpl.ObtenerParametrosCategoria()");
			System.err.println("Ocurrió un error: " + e);
			respuesta.setMensajeRespuesta("Ocurrió un error: " + e);
			respuesta.setEstadoRespuesta(0);
		}
		respuesta.setParametros(mapResultado);
		return respuesta;
	}

	@Override
	public Respuesta ObtenerParametrosGC(Map<String, String> requestParm) throws GmdException{
		Map<String, Object> mapResultado = new HashMap<String, Object>();
		List<ParametroGC> listaParametros = new ArrayList<ParametroGC>();
		try {
			int pageNumber = Integer.parseInt(requestParm.get("page_num"));
			int pageSize = Integer.parseInt(requestParm.get("page_size"));
			String correo = requestParm.get("correo");
			
			Map<String, Object> queryResp = this.dao.obtenerParametrosGC(pageNumber, pageSize, correo);
			BigDecimal bdCast = (BigDecimal) queryResp.get("nRESP_SP");
			int iRespuesta = bdCast.intValueExact();
			if (iRespuesta > 0) {
				for (Map<String, Object> map : (List<Map<String, Object>>) queryResp.get("IO_CURSOR")) {
					ParametroGC parametro = new ParametroGC();
					parametro.setCategoria((String) map.get("categoria"));
					parametro.setClase((String) map.get("clase"));
					parametro.setF_alta((String) map.get("f_alta"));
					parametro.setFlag(((String) map.get("flag")).equals("1") ? true : false);
					parametro.setValor((String) map.get("valor"));
					parametro.setModulo((String) map.get("modulo"));
					listaParametros.add(parametro);
				}
				mapResultado.put("listaParametros", listaParametros);
				mapResultado.put("total", ((BigDecimal) queryResp.get("TOTAL")).intValue());
			}
			respuesta.setMensajeRespuesta((String) queryResp.get("cRESP_SP"));
			respuesta.setEstadoRespuesta(iRespuesta);
		} catch (Exception e) {
			System.out.println("COVUtilServiceImpl.ObtenerParametrosGC()");
			System.err.println("Ocurrió un error: " + e);
			respuesta.setMensajeRespuesta("Ocurrió un error: " + e);
			respuesta.setEstadoRespuesta(0);
		}
		respuesta.setParametros(mapResultado);
		return respuesta;
	}

	@Override
	public Respuesta InsertarParametrosGC(Map<String, String> requestParm) throws GmdException{
		ParametroGC parameter = new ParametroGC();
		Respuesta respuesta = new Respuesta();
		try {
			parameter.setClase(requestParm.get("clase"));
			parameter.setCategoria(requestParm.get("categoria"));
			parameter.setValor(requestParm.get("valor"));
			parameter.setModulo(requestParm.get("modulo"));

			Map<String, Object> queryResp = this.dao.insertarParametrosGC(parameter);
			respuesta.setEstadoRespuesta(((BigDecimal) queryResp.get("nRESP_SP")).intValueExact());
			respuesta.setMensajeRespuesta((String) queryResp.get("cRESP_SP"));
		} catch (Exception e) {
			System.out.println("COVUtilServiceImpl.InsertarParametrosGC()");
			System.err.println("Ocurrió un error: " + e);
			respuesta.setMensajeRespuesta("Ocurrió un error: " + e);
			respuesta.setEstadoRespuesta(0);
		}
		return respuesta;
	}

	@Override
	public Respuesta EditarParametrosGC(Map<String, String> requestParm) throws GmdException{
		ParametroGC parameter = new ParametroGC();
		try {
			parameter.setCategoria(requestParm.get("categoria"));
			parameter.setClase(requestParm.get("clase"));
			parameter.setValor(requestParm.get("valor"));
			parameter.setFlag(Boolean.parseBoolean(requestParm.get("flag")));
			parameter.setModulo(requestParm.get("modulo"));

			Map<String, Object> queryResp = this.dao.editarParametrosGC(parameter);
			respuesta.setEstadoRespuesta(((BigDecimal) queryResp.get("nRESP_SP")).intValueExact());
			respuesta.setMensajeRespuesta((String) queryResp.get("cRESP_SP"));
		} catch (Exception e) {
			System.out.println("COVUtilServiceImpl.EditarParametrosGC()");
			System.err.println("Ocurrió un error: " + e);
			respuesta.setMensajeRespuesta("Ocurrió un error: " + e);
			respuesta.setEstadoRespuesta(0);
		}
		parameter.setClase(requestParm.get("clase"));
		return respuesta;
	}

}
