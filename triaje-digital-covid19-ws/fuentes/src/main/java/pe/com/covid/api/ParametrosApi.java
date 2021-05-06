package pe.com.covid.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.covid.model.Respuesta;
import pe.com.covid.service.UtilService;
import pe.com.gmd.util.exception.GmdException;

@RestController
@RequestMapping(value = { "/api/parametros" }, method = { RequestMethod.POST }, produces = {
		"application/JSON" }, consumes = { "application/JSON" })
public class ParametrosApi {

	@Autowired
	private UtilService service;

	@PostMapping(path = { "/listar-parametros" }, produces = { "application/json" })
	public ResponseEntity<Respuesta> ObtenerParametrosGC(@RequestBody Map<String, String> requestParm)
			throws GmdException {
		Respuesta resultadoCons = service.ObtenerParametrosGC(requestParm);
		return new ResponseEntity<Respuesta>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = { "/insertar-parametro" }, produces = { "application/json" })
	public ResponseEntity<Respuesta> InsertarParametroGC(@RequestBody Map<String, String> requestParm) throws GmdException {
		Respuesta resultadoCons = service.InsertarParametrosGC(requestParm);
		return new ResponseEntity<Respuesta>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = { "/editar-parametro" }, produces = { "application/json" })
	public ResponseEntity<Respuesta> EditarParametroGC(@RequestBody Map<String, String> requestParm) throws GmdException {
		Respuesta resultadoCons = service.EditarParametrosGC(requestParm);
		return new ResponseEntity<Respuesta>(resultadoCons, HttpStatus.OK);
	}

}
