package pe.com.covid.dao.base;

import java.util.List;

import pe.com.gmd.util.exception.GmdException;

public interface BaseDao <E, ID>{
	
	void insertar(E entidad) throws GmdException;

	void actualizar(E entidad) throws GmdException;

	void eliminar(ID id) throws GmdException;

	E obtener(ID id) throws GmdException;

	List<E> listar() throws GmdException;
	
}
