package pe.com.covid.service.base;

import java.util.List;

import pe.com.covid.dao.base.BaseDao;
import pe.com.gmd.util.exception.GmdException;

public interface BaseService<E, ID> {
	
	void insertar(E entidad) throws GmdException;

	void actualizar(E entidad) throws GmdException;

	void eliminar(ID id) throws GmdException;

	E obtener(ID id) throws GmdException;

	List<E> listar() throws GmdException;

	void setBase(BaseDao<?, ?> baseDao);
	
}
