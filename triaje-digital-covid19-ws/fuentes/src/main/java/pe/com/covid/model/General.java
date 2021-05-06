package pe.com.covid.model;

import pe.com.covid.model.base.Base;

public class General extends Base{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idGeneral;
	private String desGeneral;
	private String desCorta;
	private String idTipoParametro;
	private String descripcionEstado;
	
	public Integer getIdGeneral() {
		return idGeneral;
	}
	public void setIdGeneral(Integer idGeneral) {
		this.idGeneral = idGeneral;
	}
	public String getDesGeneral() {
		return desGeneral;
	}
	public void setDesGeneral(String desGeneral) {
		this.desGeneral = desGeneral;
	}
	public String getDesCorta() {
		return desCorta;
	}
	public void setDesCorta(String desCorta) {
		this.desCorta = desCorta;
	}
	public String getIdTipoParametro() {
		return idTipoParametro;
	}
	public void setIdTipoParametro(String idTipoParametro) {
		this.idTipoParametro = idTipoParametro;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
}
