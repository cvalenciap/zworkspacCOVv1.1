package pe.com.covid.api;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.com.covid.model.Respuesta;
import pe.com.covid.service.AutenticacionService;
import pe.com.gmd.util.exception.GmdException;

@RestController
@RequestMapping(value = { "/api/autenticacion-usuario/" }, method = { RequestMethod.POST }, produces = {
		"application/JSON" }, consumes = { "application/JSON" })
public class AutenticacionApi {

	@Autowired
	private AutenticacionService service;

	@PostMapping(path = { "/aut-nuevo-usu" }, produces = { "application/json" })
	public ResponseEntity<Respuesta> ValidarClave(@RequestBody Map<String, String> requestParm) throws GmdException {
		Respuesta resultadoCons = service.validarClave(requestParm);
		return new ResponseEntity<Respuesta>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = { "/recuperar-contrasena" }, produces = { "application/json" })
	public ResponseEntity<Respuesta> ValidarCorreoRC(@RequestBody Map<String, String> requestParm) throws GmdException {
		Respuesta resultadoCons = service.validarCorreoRecupClave(requestParm);
		return new ResponseEntity<Respuesta>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = { "/actualizar-contrasena" }, produces = { "application/json" })
	public ResponseEntity<Respuesta> ActualizarContrasena(@RequestBody Map<String, String> requestParm) throws GmdException {
		Respuesta resultadoCons = service.actualizarClave(requestParm);
		return new ResponseEntity<Respuesta>(resultadoCons, HttpStatus.OK);
	}

}