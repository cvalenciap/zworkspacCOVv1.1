package pe.com.covid.dao;

import java.util.List;

import pe.com.covid.dao.base.BaseDao;
import pe.com.covid.model.General;
import pe.com.gmd.util.exception.GmdException;

public interface GeneralDao extends BaseDao<General, Long>{
	
	List<General> listaGeneralTotal() throws GmdException;
	
	General listaGeneral() throws GmdException;
}
