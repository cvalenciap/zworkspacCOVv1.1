package pe.com.covid.service.base;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pe.com.covid.dao.base.BaseDao;
import pe.com.gmd.util.exception.GmdException;

public class BaseServiceImpl<E, ID> implements BaseService<E, ID> {
	
	private BaseDao<E, ID> baseDao;

	@Override
	@Transactional
	public void insertar(E entidad) throws GmdException {
		try {
			baseDao.insertar(entidad);
		} catch (Exception e) {
			throw new GmdException(e);
		}

	}

	@Override
	@Transactional
	public void actualizar(E entidad) throws GmdException {
		try {
			baseDao.actualizar(entidad);
		} catch (Exception e) {
			throw new GmdException(e);
		}
	}

	@Override
	@Transactional
	public void eliminar(ID id) throws GmdException {
		try {
			baseDao.eliminar(id);
		} catch (Exception e) {
			throw new GmdException(e);
		}

	}

	@Override
	public E obtener(ID id) throws GmdException {
		try {
			return baseDao.obtener(id);
		} catch (Exception e) {
			throw new GmdException(e);
		}
	}

	@Override
	public List<E> listar() throws GmdException {
		try {
			return baseDao.listar();
		} catch (Exception e) {
			throw new GmdException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setBase(BaseDao<?, ?> baseDao) {
		this.baseDao = (BaseDao<E, ID>) baseDao;
	}

}
