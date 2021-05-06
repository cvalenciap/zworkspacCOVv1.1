package pe.com.covid.model;

import pe.com.covid.model.base.Base;

public class ParametroGC extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String categoria;
	private String clase;
	private boolean flag;
	private String f_alta;
	private String valor;
	private String modulo;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getF_alta() {
		return f_alta;
	}

	public void setF_alta(String f_alta) {
		this.f_alta = f_alta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

}
